package net.binis.codegen.mock;

/*-
 * #%L
 * code-generation-test
 * %%
 * Copyright (C) 2021 Binis Belev
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import lombok.extern.slf4j.Slf4j;
import net.binis.codegen.exception.GenericCodeGenException;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.mock.exception.CodeGenMockException;
import net.binis.codegen.mock.exception.QueryAlreadyMockedException;
import net.binis.codegen.mock.exception.QueryCallsMismatchException;
import net.binis.codegen.mock.exception.QueryNotMockedException;
import net.binis.codegen.spring.modifier.AsyncEntityModifier;
import net.binis.codegen.spring.modifier.BasePersistenceOperations;
import net.binis.codegen.spring.async.executor.CodeExecutor;
import net.binis.codegen.spring.component.ApplicationContextProvider;
import net.binis.codegen.spring.modifier.impl.AsyncEntityModifierImpl;
import net.binis.codegen.spring.query.*;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManagerFactory;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static net.binis.codegen.tools.Reflection.instantiate;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Slf4j
public class CodeGenMock {

    private static boolean inProgress;

    private CodeGenMock() {
        //Do nothing
    }

    private static QueryProcessor.Processor mockedProcessor;
    private static final Map<String, MockedQueryContextImpl> mockedResponses = new HashMap<>();

    static void testStart() {
        inProgress = true;
    }

    static void testStop() {
        inProgress = false;
    }

    static boolean isTestInProgress() {
        return inProgress;
    }

    public static void mockContext() {
        if (isNull(ApplicationContextProvider.getApplicationContext())) {
            var context = mock(ApplicationContext.class);
            var tm = mock(JpaTransactionManager.class);
            when(context.getBean(eq(JpaTransactionManager.class))).thenReturn(tm);
            when(tm.getEntityManagerFactory()).thenReturn(mock(EntityManagerFactory.class));
            var template = mock(TransactionTemplate.class);
            when(context.getBean(eq(TransactionTemplate.class))).thenReturn(template);
            when(template.execute(any())).then(m -> ((TransactionCallback) m.getArgument(0)).doInTransaction(null));

            ApplicationContextProvider.setAppContext(context);
        }
    }

    public static void mockEntityManager() {
        var entityManager = new MockEntityManager();
        BasePersistenceOperations.setEntityManagerProvider(factory -> entityManager);
    }

    public static void cleanEntityManagerMock() {
        BasePersistenceOperations.setEntityManagerProvider(BasePersistenceOperations.defaultEntityManagerProvider());
    }

    public static void mockAsyncExecutor() {
        new MockAsyncEntityModifierImpl(null);
        CodeExecutor.registerDefaultExecutor(CodeExecutor.syncExecutor());
    }

    public static void mockContextAndEntityManager() {
        mockContext();
        mockEntityManager();
    }

    public static void mockQueryProcessor(BiFunction<String, List<Object>, Object> func) {
        QueryProcessor.setProcessor((executor, manager, query, params, resultType, resultClass, mapClass, isNative, isModifying, pagable, flush, lock, hints, filters) -> func.apply(query, params));
    }

    public static MockedQueryContext mockJustQuery(Printable query, Object returnObject) {
        return mockQuery(query.print(), null, returnObject);
    }

    public static MockedQueryContext mockJustQuery(Printable query, Supplier<Object> returnObject) {
        return mockQuery(query.print(), null, returnObject);
    }

    public static MockedQueryContext mockQuery(Printable query, List<Object> params, Object returnObject) {
        return mockQuery(query.print(), params, returnObject);
    }

    public static MockedQueryContext mockQuery(Printable query, List<Object> params, Supplier<Object> returnObject) {
        return mockQuery(query.print(), params, returnObject);
    }

    public static MockedQueryContext mockQuery(Queryable query, Object returnObject) {
        return mockQuery(query.print(), ((QueryAccessor) query).getParams(), returnObject);
    }

    public static MockedQueryContext mockQuery(Queryable query, Supplier<Object> returnObject) {
        return mockQuery(query.print(), ((QueryAccessor) query).getParams(), returnObject);
    }

    public static MockedQueryContext mockCountQuery(Queryable query, Long count) {
        return mockCountQuery(query, () -> count);
    }

    public static MockedQueryContext mockCountQuery(Queryable query, Supplier<Long> count) {
        var q = query.print();
        if (q.startsWith("select u ")) {
            q = q.replace("select u ", "select count(u) ");
        } else if (q.startsWith("select distinct u ")) {
            q = q.replace("select distinct u ", "select count(distinct u) ");
        } else {
            q = "select count(*) " + q;
        }

        return mockQuery(q, ((QueryAccessor) query).getParams(), count);
    }

    public static MockedQueryContext mockExistsQuery(Queryable query, boolean exists) {
        return mockCountQuery(query, exists ? 1L : 0L);
    }

    public static MockedQueryContext mockExistsQuery(Queryable query, BooleanSupplier exists) {

        Supplier<Long> result = () ->
                exists.getAsBoolean() ? 1L : 0L;

        return mockCountQuery(query, result);
    }

    public static MockedQueryContext mockQuery(String query, Object returnObject) {
        return mockQuery(query, null, returnObject);
    }

    public static MockedQueryContext mockQuery(String query, List<Object> params, Object returnObject) {
        MockedQueryContextImpl.MockedQueryParams result;

        if (isNull(mockedProcessor) || !mockedProcessor.equals(QueryProcessor.getProcessor())) {
            QueryProcessor.setProcessor(createMockedProcessor());
        }

        var mocks = mockedResponses.get(query);

        if (nonNull(mocks)) {
            var mock = findMock(query, params);
            if (mock.isEmpty()) {
                result = MockedQueryContextImpl.MockedQueryParams.builder().parent(mocks).params(params).returnObject(returnObject).build();
                mocks.getMocks().add(result);
            } else {
                result = mock.get();
                if (nonNull(mock.get().getParams())) {
                    if (mock.get().isFails()) {
                        logErrorAlreadyMocked(query, params);
                    } else {
                        logWarning(query, params);
                    }
                }
            }
        } else {
            result = MockedQueryContextImpl.MockedQueryParams.builder().params(params).returnObject(returnObject).build();
            mocks = MockedQueryContextImpl.builder().query(query).mock(result).build();
            result.withParent(mocks);
            mockedResponses.put(query, mocks);
        }

        return result;
    }

    public static void mockCheckCalls() {
        mockedResponses.forEach((key, value) ->
                value.getMocks().stream().filter(mock -> mock.getMatch() != mock.getExpected()).forEach(mock -> {
                    if (mock.isFails()) {
                        logError(key, mock.getParams(), mock.getMatch(), mock.getExpected());
                    } else {
                        logWarning(key, mock.getParams(), mock.getMatch(), mock.getExpected());
                    }
                }));
    }

    public static MockedPersistenceContext verify(MockPersistenceOperation operation, Object obj) {
        var em = BasePersistenceOperations.getEntityManager();
        if (em instanceof MockEntityManager) {
            return MockedPersistenceContextImpl.builder().obj(obj).em((MockEntityManager) em).operation(operation).build();
        } else {
            throw new GenericCodeGenException("Entity manager is not mocked!");
        }
    }

    public static MockedPersistenceContext onSave(Object obj, BiConsumer<MockPersistenceOperation, Object> consumer) {
        return verify(MockPersistenceOperation.SAVE, obj).on(consumer);
    }

    public static MockedPersistenceContext onOperation(MockPersistenceOperation operation, Object obj, Runnable task) {
        return verify(operation, obj).on(task);
    }

    public static MockedPersistenceContext onOperation(MockPersistenceOperation operation, Object obj, Consumer<Object> consumer) {
        return verify(operation, obj).on(consumer);
    }

    public static MockedPersistenceContext onOperation(MockPersistenceOperation operation, Object obj, BiConsumer<MockPersistenceOperation, Object> consumer) {
        return verify(operation, obj).on(consumer);
    }

    public static MockedPersistenceContext onSave(Object obj, Runnable task) {
        return verify(MockPersistenceOperation.SAVE, obj).on(task);
    }

    public static MockedPersistenceContext onSave(Object obj, Consumer<Object> consumer) {
        return verify(MockPersistenceOperation.SAVE, obj).on(consumer);
    }

    public static MockedPersistenceContext onDetach(Object obj, BiConsumer<MockPersistenceOperation, Object> consumer) {
        return verify(MockPersistenceOperation.DETACH, obj).on(consumer);
    }

    public static MockedPersistenceContext onDetach(Object obj, Runnable task) {
        return verify(MockPersistenceOperation.DETACH, obj).on(task);
    }

    public static MockedPersistenceContext onDetach(Object obj, Consumer<Object> consumer) {
        return verify(MockPersistenceOperation.DETACH, obj).on(consumer);
    }

    public static MockedPersistenceContext onRefresh(Object obj, BiConsumer<MockPersistenceOperation, Object> consumer) {
        return verify(MockPersistenceOperation.REFRESH, obj).on(consumer);
    }

    public static MockedPersistenceContext onRefresh(Object obj, Runnable task) {
        return verify(MockPersistenceOperation.REFRESH, obj).on(task);
    }

    public static MockedPersistenceContext onRefresh(Object obj, Consumer<Object> consumer) {
        return verify(MockPersistenceOperation.REFRESH, obj).on(consumer);
    }

    public static MockedPersistenceContext onDelete(Object obj, BiConsumer<MockPersistenceOperation, Object> consumer) {
        return verify(MockPersistenceOperation.DELETE, obj).on(consumer);
    }

    public static MockedPersistenceContext onDelete(Object obj, Runnable task) {
        return verify(MockPersistenceOperation.DELETE, obj).on(task);
    }

    public static MockedPersistenceContext onDelete(Object obj, Consumer<Object> consumer) {
        return verify(MockPersistenceOperation.DELETE, obj).on(consumer);
    }

    public static MockedPersistenceContext onMerge(Object obj, BiConsumer<MockPersistenceOperation, Object> consumer) {
        return verify(MockPersistenceOperation.MERGE, obj).on(consumer);
    }

    public static MockedPersistenceContext onMerge(Object obj, Runnable task) {
        return verify(MockPersistenceOperation.MERGE, obj).on(task);
    }

    public static MockedPersistenceContext onMerge(Object obj, Consumer<Object> consumer) {
        return verify(MockPersistenceOperation.MERGE, obj).on(consumer);
    }

    public static MockedPersistenceContext onFlush(Object obj, BiConsumer<MockPersistenceOperation, Object> consumer) {
        return verify(MockPersistenceOperation.FLUSH, obj).on(consumer);
    }

    public static MockedPersistenceContext onFlush(Object obj, Runnable task) {
        return verify(MockPersistenceOperation.FLUSH, obj).on(task);
    }

    public static MockedPersistenceContext onFlush(Object obj, Consumer<Object> consumer) {
        return verify(MockPersistenceOperation.FLUSH, obj).on(consumer);
    }

    public static MockedPersistenceContext verifySave(Object obj) {
        return verify(MockPersistenceOperation.SAVE, obj);
    }

    public static MockedPersistenceContext verifyDetach(Object obj) {
        return verify(MockPersistenceOperation.DETACH, obj);
    }

    public static MockedPersistenceContext verifyRefresh(Object obj) {
        return verify(MockPersistenceOperation.REFRESH, obj);
    }

    public static MockedPersistenceContext verifyDelete(Object obj) {
        return verify(MockPersistenceOperation.DELETE, obj);
    }

    public static MockedPersistenceContext verifyMerge(Object obj) {
        return verify(MockPersistenceOperation.MERGE, obj);
    }

    public static MockedPersistenceContext verifySaveAndFlush(Object obj) {
        return verify(MockPersistenceOperation.FLUSH, obj);
    }


    public static void mockQueryClear() {
        mockedResponses.clear();
    }

    @SuppressWarnings("unchecked")
    static QueryProcessor.Processor createMockedProcessor() {
        mockedProcessor = (executor, manager, query, params, resultType, resultClass, mapClass, isNative, isModifying, pagable, flush, lock, hints, filters) -> {
            CodeGenMock.checkContext();

            var mock = findMock(query, params);


            if (mock.isEmpty()) {
                logError(query, params);
            }

            var value = mock.get().getReturnObject();
            if (value instanceof Supplier) {
                value = ((Supplier<?>) value).get();
            }

            mock.get().touch();

            switch (resultType) {
                case SINGLE:
                case TUPLE:
                    return Optional.ofNullable(value);
                case COUNT:
                case REMOVE:
                case EXECUTE:
                    return value;
                case LIST:
                case TUPLES:
                    return value instanceof List ? value : List.of(value);
                case PAGE:
                    return value instanceof Page ? value : new PageImpl(value instanceof List ? (List) value : List.of(value), pagable, Integer.MAX_VALUE);
                default:
                    throw new GenericCodeGenException("Unknown query return type!");
            }
        };
        return mockedProcessor;
    }

    private static Optional<MockedQueryContextImpl.MockedQueryParams> findMock(String query, List<Object> params) {
        var mocks = mockedResponses.get(query);
        if (isNull(mocks)) {
            return Optional.empty();
        }

        var mock = mocks.getMocks().stream().filter(p -> paramsEquals(p, params)).findFirst();

        if (mock.isEmpty()) {
            mock = mocks.getMocks().stream().filter(p -> isNull(p.getParams())).findFirst();
        }

        return mock;
    }

    private static boolean paramsEquals(MockedQueryContextImpl.MockedQueryParams pair, List<Object> params) {
        var mockParams = pair.getParams();
        if (nonNull(mockParams) && mockParams.size() == params.size()) {
            for (var i = 0; i < params.size(); i++) {
                if (isNull(mockParams.get(i)) && nonNull(params.get(i)) || !mockParams.get(i).equals(params.get(i)) && !CodeGenMatcher.class.equals(mockParams.get(i))) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }

    private static void logError(String query, List<Object> params) {
        throw new QueryNotMockedException(logText(query, params) + " is not mocked!");
    }

    private static void logErrorAlreadyMocked(String query, List<Object> params) {
        throw new QueryAlreadyMockedException(logText(query, params) + " already mocked!");
    }

    private static void logError(String query, List<Object> params, int match, int expected) {
        throw new QueryCallsMismatchException(logText(query, params) + " calls mismatch! Expected: " + expected + ", Actual: " + match);
    }

    private static void logWarning(String query, List<Object> params) {
        log.warn("{} already mocked!", logText(query, params));
    }

    private static void logWarning(String query, List<Object> params, int match, int expected) {
        log.warn("{} calls mismatch! Expected: {}, Actual: {}", logText(query, params), match, expected);
    }

    private static String logText(String query, List<Object> params) {
        if (nonNull(params)) {
            return "Query '" + query + "' with params [" + params.stream().map(p -> {
                if (CodeGenMatcher.class.equals(p)) {
                    return "any";
                } else {
                    return Objects.toString(p);
                }
            }).map(s -> "(" + s + ")").collect(Collectors.joining(", ")) + "]";
        } else {
            return "Query '" + query + "' with any params";
        }
    }

    public static void mockCreate(Class<?> cls) {
        instantiate(cls);
    }

    public static void checkContext() {
        if (!inProgress) {
            throw new CodeGenMockException("Attribute your test class with '@ExtendWith(CodeGenExtension.class)'");
        }
    }

    public static void mockCodeFactory() {
        UnaryOperator<Object> mock = v -> {
            checkContext();
            if (CodeGenMatcher.anyMock.get()) {
                CodeGenMatcher.anyMock.set(false);
                v = CodeGenMatcher.class;
            }
            return v;
        };

        UnaryOperator<Object> onValue = v -> {
            checkContext();
            if (CodeGenMatcher.anyMock.get()) {
                if (isNull(v)) {
                    v = CodeGenMatcher.class;
                }
                CodeGenMatcher.anyMock.set(false);
            }
            return v;
        };

        CodeFactory.envelopFactory(result -> {
            if (result instanceof MockedQuery) {
                ((MockedQuery) result).setMocked(mock, onValue);
            }
            return result;
        });
    }

    public static void clearCodeFactoryMock() {
        CodeFactory.clearEnvelopingFactory();
    }

    public static class MockAsyncEntityModifierImpl extends AsyncEntityModifierImpl {

        protected MockAsyncEntityModifierImpl(Object parent) {
            super(parent);
        }
    }

}
