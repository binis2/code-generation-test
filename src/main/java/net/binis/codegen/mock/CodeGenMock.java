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

import jakarta.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;
import net.binis.codegen.async.executor.CodeExecutor;
import net.binis.codegen.async.executor.Executors;
import net.binis.codegen.exception.GenericCodeGenException;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.mock.exception.CodeGenMockException;
import net.binis.codegen.mock.exception.QueryAlreadyMockedException;
import net.binis.codegen.mock.exception.QueryCallsMismatchException;
import net.binis.codegen.mock.exception.QueryNotMockedException;
import net.binis.codegen.spring.component.ApplicationContextProvider;
import net.binis.codegen.spring.modifier.BasePersistenceOperations;
import net.binis.codegen.spring.modifier.impl.AsyncEntityModifierImpl;
import net.binis.codegen.spring.query.*;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static net.binis.codegen.factory.CodeFactory.clearEnvelopingFactory;
import static net.binis.codegen.tools.Reflection.instantiate;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Slf4j
@SuppressWarnings("unchecked")
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
            CodeFactory.registerType(JpaTransactionManager.class, () -> tm);
            CodeFactory.registerType(TransactionTemplate.class, () -> template);
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
        CodeExecutor.registerDefaultExecutor(Executors.syncExecutor());
    }

    public static void mockContextAndEntityManager() {
        mockContext();
        mockEntityManager();
    }

    public static <T> void mockQueryProcessor(BiFunction<String, List<T>, Object> func) {
        QueryProcessor.setProcessor((executor, manager, query, params, resultType, resultClass, mapClass, isNative, isModifying, pagable, flush, lock, hints, filters) -> func.apply(query, (List) params));
    }

    public static MockedQueryContext mockJustQuery(Printable query, Object returnObject) {
        return mockQuery(query.print(), null, returnObject);
    }

    public static <T> MockedQueryContext mockJustQuery(Printable query, Supplier<T> returnObject) {
        return mockQuery(query.print(), null, returnObject);
    }

    public static <T> MockedQueryContext mockQuery(Printable query, List<T> params, Object returnObject) {
        return mockQuery(query.print(), params, returnObject);
    }

    public static <T> MockedQueryContext mockQuery(Printable query, List<T> params, Supplier<T> returnObject) {
        return mockQuery(query.print(), params, returnObject);
    }

    public static <T> MockedQueryContext mockQuery(Queryable query, Object returnObject) {
        return mockQuery(query.print(), ((QueryAccessor) query).getParams(), returnObject);
    }

    public static <T> MockedQueryContext mockQuery(Queryable query, Supplier<T> returnObject) {
        return mockQuery(query.print(), ((QueryAccessor) query).getParams(), returnObject);
    }

    public static <T> MockedQueryContext mockCountQuery(Queryable query, Long count) {
        return mockCountQuery(query, () -> count);
    }

    public static <T> MockedQueryContext mockCountQuery(Queryable query, Supplier<Long> count) {
        var q = (QueryAccessor) query;
        return mockQuery(q.getCountQuery(), q.getParams(), count);
    }

    public static <T> MockedQueryContext mockExistsQuery(Queryable query, boolean exists) {
        var q = (QueryAccessor) query;
        return mockQuery(q.getExistsQuery(), q.getParams(), exists);
    }

    public static <T> MockedQueryContext mockExistsQuery(Queryable query, Supplier<Boolean> exists) {
        var q = (QueryAccessor) query;
        return mockQuery(q.getExistsQuery(), q.getParams(), exists);
    }

    public static <T> MockedQueryContext mockPageQuery(Queryable query, List<T> page) {
        return mockPageQuery(query, 1L, page);
    }

    public static <T> MockedQueryContext mockPageQuery(Queryable query, Supplier<List<T>> pages) {
        return mockPageQuery(query, 1L, pages);
    }

    public static <T> MockedQueryContext mockPageQuery(Queryable query, long count, List<T> page) {
        mockCountQuery(query, count).ignore();
        return mockQuery(query, page);
    }

    public static <T> MockedQueryContext mockPageQuery(Queryable query, long count, Supplier<List<T>> pages) {
        mockCountQuery(query, count).ignore();
        return mockQuery(query, pages);
    }

    public static MockedQueryContext mockDeleteQuery(Queryable query) {
        return mockDeleteQuery(query, 1);
    }

    public static MockedQueryContext mockDeleteQuery(Queryable query, int deleted) {
        return mockDeleteQuery(query, () -> deleted);
    }

    public static MockedQueryContext mockDeleteQuery(Queryable query, Supplier<Integer> deleted) {
        var q = query.print();
        q = "delete " + q.substring(q.indexOf("from"));

        return mockQuery(q, ((QueryAccessor) query).getParams(), deleted);
    }


    public static MockedQueryContext mockQuery(String query, Object returnObject) {
        return mockQuery(query, null, returnObject);
    }

    public static <T> MockedQueryContext mockQuery(String query, List<T> params, Object returnObject) {
        MockedQueryContextImpl.MockedQueryParams result;

        if (isNull(mockedProcessor) || !mockedProcessor.equals(QueryProcessor.getProcessor())) {
            QueryProcessor.setProcessor(createMockedProcessor());
        }

        var mocks = mockedResponses.get(query);

        if (nonNull(mocks)) {
            var mock = findMock(query, params);
            if (mock.isEmpty()) {
                result = MockedQueryContextImpl.MockedQueryParams.builder().parent(mocks).params((List) params).returnObject(returnObject).build();
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
            result = MockedQueryContextImpl.MockedQueryParams.builder().params((List) params).returnObject(returnObject).build();
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
                        if (!mock.isIgnored()) {
                            logWarning(key, mock.getParams(), mock.getMatch(), mock.getExpected());
                        }
                    }
                }));
    }

    protected static <T> T withMockEntityManager(Function<MockEntityManager, T> func) {
        var em = BasePersistenceOperations.getEntityManager();
        if (em instanceof MockEntityManager) {
            return func.apply((MockEntityManager) em);
        } else {
            throw new GenericCodeGenException("Entity manager is not mocked!");
        }
    }

    public static MockedPersistenceContext verify(MockPersistenceOperation operation, Object obj) {
        return withMockEntityManager(em ->
                MockedPersistenceContextImpl.builder().obj(obj).em(em).operation(operation).build());
    }

    public static MockedPersistenceContext verify(MockPersistenceOperation operation) {
        return withMockEntityManager(em ->
                MockedPersistenceContextImpl.builder().em(em).operation(operation).build());
    }

    public static <T> MockedPersistenceContext onOperation(MockPersistenceOperation operation, T obj, Runnable task) {
        return verify(operation, obj).on(task);
    }

    public static <T> MockedPersistenceContext onOperation(MockPersistenceOperation operation, T obj, Consumer<T> consumer) {
        return verify(operation, obj).on((Consumer) consumer);
    }

    public static <T> MockedPersistenceContext onOperation(MockPersistenceOperation operation, T obj, BiConsumer<MockPersistenceOperation, T> consumer) {
        return verify(operation, obj).on((BiConsumer) consumer);
    }

    public static MockedPersistenceContext onOperation(MockPersistenceOperation operation, Runnable task) {
        return verify(operation).on(task);
    }

    public static <T> MockedPersistenceContext onOperation(MockPersistenceOperation operation, Consumer<T> consumer) {
        return verify(operation).on((Consumer) consumer);
    }

    public static <T> MockedPersistenceContext onOperation(MockPersistenceOperation operation, BiConsumer<MockPersistenceOperation, T> consumer) {
        return verify(operation).on((BiConsumer) consumer);
    }

    public static <T> MockedPersistenceContext onSave(T obj, Runnable task) {
        return verify(MockPersistenceOperation.SAVE, obj).on(task);
    }

    public static MockedPersistenceContext onSave(Runnable task) {
        return verify(MockPersistenceOperation.SAVE).on(task);
    }

    public static <T> MockedPersistenceContext onSave(T obj, Consumer<T> consumer) {
        return verify(MockPersistenceOperation.SAVE, obj).on((Consumer) consumer);
    }

    public static <T> MockedPersistenceContext onSave(Consumer<T> consumer) {
        return verify(MockPersistenceOperation.SAVE).on((Consumer) consumer);
    }

    public static <T> MockedPersistenceContext onSave(T obj, BiConsumer<MockPersistenceOperation, T> consumer) {
        return verify(MockPersistenceOperation.SAVE, obj).on((BiConsumer) consumer);
    }

    public static <T> MockedPersistenceContext onSave(BiConsumer<MockPersistenceOperation, T> consumer) {
        return verify(MockPersistenceOperation.SAVE).on((BiConsumer) consumer);
    }

    public static <T> MockedPersistenceContext onDetach(T obj, Runnable task) {
        return verify(MockPersistenceOperation.DETACH, obj).on(task);
    }

    public static MockedPersistenceContext onDetach(Runnable task) {
        return verify(MockPersistenceOperation.DETACH).on(task);
    }

    public static <T> MockedPersistenceContext onDetach(T obj, Consumer<T> consumer) {
        return verify(MockPersistenceOperation.DETACH, obj).on((Consumer) consumer);
    }

    public static <T> MockedPersistenceContext onDetach(Consumer<T> consumer) {
        return verify(MockPersistenceOperation.DETACH).on((Consumer) consumer);
    }

    public static <T> MockedPersistenceContext onDetach(T obj, BiConsumer<MockPersistenceOperation, T> consumer) {
        return verify(MockPersistenceOperation.DETACH, obj).on((BiConsumer) consumer);
    }

    public static <T> MockedPersistenceContext onDetach(BiConsumer<MockPersistenceOperation, T> consumer) {
        return verify(MockPersistenceOperation.DETACH).on((BiConsumer) consumer);
    }

    public static <T> MockedPersistenceContext onRefresh(T obj, Runnable task) {
        return verify(MockPersistenceOperation.REFRESH, obj).on(task);
    }

    public static MockedPersistenceContext onRefresh(Runnable task) {
        return verify(MockPersistenceOperation.REFRESH).on(task);
    }

    public static <T> MockedPersistenceContext onRefresh(T obj, Consumer<T> consumer) {
        return verify(MockPersistenceOperation.REFRESH, obj).on((Consumer) consumer);
    }

    public static <T> MockedPersistenceContext onRefresh(Consumer<T> consumer) {
        return verify(MockPersistenceOperation.REFRESH).on((Consumer) consumer);
    }

    public static <T> MockedPersistenceContext onRefresh(T obj, BiConsumer<MockPersistenceOperation, T> consumer) {
        return verify(MockPersistenceOperation.REFRESH, obj).on((BiConsumer) consumer);
    }

    public static <T> MockedPersistenceContext onRefresh(BiConsumer<MockPersistenceOperation, T> consumer) {
        return verify(MockPersistenceOperation.REFRESH).on((BiConsumer) consumer);
    }

    public static <T> MockedPersistenceContext onDelete(T obj, Runnable task) {
        return verify(MockPersistenceOperation.DELETE, obj).on(task);
    }

    public static MockedPersistenceContext onDelete(Runnable task) {
        return verify(MockPersistenceOperation.DELETE).on(task);
    }

    public static <T> MockedPersistenceContext onDelete(T obj, Consumer<T> consumer) {
        return verify(MockPersistenceOperation.DELETE, obj).on((Consumer) consumer);
    }

    public static <T> MockedPersistenceContext onDelete(Consumer<T> consumer) {
        return verify(MockPersistenceOperation.DELETE).on((Consumer) consumer);
    }

    public static <T> MockedPersistenceContext onDelete(T obj, BiConsumer<MockPersistenceOperation, T> consumer) {
        return verify(MockPersistenceOperation.DELETE, obj).on((BiConsumer) consumer);
    }

    public static <T> MockedPersistenceContext onDelete(BiConsumer<MockPersistenceOperation, T> consumer) {
        return verify(MockPersistenceOperation.DELETE).on((BiConsumer) consumer);
    }

    public static <T> MockedPersistenceContext onMerge(T obj, Runnable task) {
        return verify(MockPersistenceOperation.MERGE, obj).on(task);
    }

    public static <T> MockedPersistenceContext onMerge(Runnable task) {
        return verify(MockPersistenceOperation.MERGE).on(task);
    }

    public static <T> MockedPersistenceContext onMerge(T obj, Consumer<T> consumer) {
        return verify(MockPersistenceOperation.MERGE, obj).on((Consumer) consumer);
    }

    public static <T> MockedPersistenceContext onMerge(Consumer<T> consumer) {
        return verify(MockPersistenceOperation.MERGE).on((Consumer) consumer);
    }

    public static <T> MockedPersistenceContext onMerge(T obj, BiConsumer<MockPersistenceOperation, T> consumer) {
        return verify(MockPersistenceOperation.MERGE, obj).on((BiConsumer) consumer);
    }

    public static <T> MockedPersistenceContext onMerge(BiConsumer<MockPersistenceOperation, T> consumer) {
        return verify(MockPersistenceOperation.MERGE).on((BiConsumer) consumer);
    }

    public static <T> MockedPersistenceContext onFlush(T obj, Runnable task) {
        return verify(MockPersistenceOperation.FLUSH, obj).on(task);
    }

    public static MockedPersistenceContext onFlush(Runnable task) {
        return verify(MockPersistenceOperation.FLUSH).on(task);
    }

    public static <T> MockedPersistenceContext onFlush(T obj, Consumer<T> consumer) {
        return verify(MockPersistenceOperation.FLUSH, obj).on((Consumer) consumer);
    }

    public static <T> MockedPersistenceContext onFlush(Consumer<T> consumer) {
        return verify(MockPersistenceOperation.FLUSH).on((Consumer) consumer);
    }

    public static <T> MockedPersistenceContext onFlush(T obj, BiConsumer<MockPersistenceOperation, T> consumer) {
        return verify(MockPersistenceOperation.FLUSH, obj).on((BiConsumer) consumer);
    }

    public static <T> MockedPersistenceContext onFlush(BiConsumer<MockPersistenceOperation, T> consumer) {
        return verify(MockPersistenceOperation.FLUSH).on((BiConsumer) consumer);
    }

    public static MockedPersistenceContext verifySave(Object obj) {
        return verify(MockPersistenceOperation.SAVE, obj);
    }

    public static MockedPersistenceContext verifySave() {
        return verify(MockPersistenceOperation.SAVE);
    }

    public static MockedPersistenceContext verifyDetach(Object obj) {
        return verify(MockPersistenceOperation.DETACH, obj);
    }

    public static MockedPersistenceContext verifyDetach() {
        return verify(MockPersistenceOperation.DETACH);
    }

    public static MockedPersistenceContext verifyRefresh(Object obj) {
        return verify(MockPersistenceOperation.REFRESH, obj);
    }

    public static MockedPersistenceContext verifyRefresh() {
        return verify(MockPersistenceOperation.REFRESH);
    }

    public static MockedPersistenceContext verifyDelete(Object obj) {
        return verify(MockPersistenceOperation.DELETE, obj);
    }

    public static MockedPersistenceContext verifyDelete() {
        return verify(MockPersistenceOperation.DELETE);
    }

    public static MockedPersistenceContext verifyMerge(Object obj) {
        return verify(MockPersistenceOperation.MERGE, obj);
    }

    public static MockedPersistenceContext verifyMerge() {
        return verify(MockPersistenceOperation.MERGE);
    }

    public static MockedPersistenceContext verifySaveAndFlush(Object obj) {
        return verify(MockPersistenceOperation.FLUSH, obj);
    }

    public static MockedPersistenceContext verifySaveAndFlush() {
        return verify(MockPersistenceOperation.FLUSH);
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
                case REFERENCE:
                case SINGLE:
                case TUPLE:
                    return Optional.ofNullable(value);
                case COUNT:
                case EXISTS:
                case REMOVE:
                case EXECUTE:
                    return value;
                case LIST:
                case TUPLES:
                case REFERENCES:
                    return value instanceof List ? value : List.of(value);
                case PAGE:
                    return value instanceof Page ? value : new PageImpl(value instanceof List ? (List) value : List.of(value), pagable, Integer.MAX_VALUE);
                default:
                    throw new GenericCodeGenException("Unknown query return type!");
            }
        };
        return mockedProcessor;
    }

    private static <T> Optional<MockedQueryContextImpl.MockedQueryParams> findMock(String query, List<T> params) {
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

    private static <T> boolean paramsEquals(MockedQueryContextImpl.MockedQueryParams pair, List<T> params) {
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

    private static <T> void logError(String query, List<T> params) {
        throw new QueryNotMockedException(logText(query, params) + " is not mocked!");
    }

    private static <T> void logErrorAlreadyMocked(String query, List<T> params) {
        throw new QueryAlreadyMockedException(logText(query, params) + " already mocked!");
    }

    private static <T> void logError(String query, List<T> params, int match, int expected) {
        throw new QueryCallsMismatchException(logText(query, params) + " calls mismatch! Expected: " + expected + ", Actual: " + match);
    }

    private static <T> void logWarning(String query, List<T> params) {
        log.warn("{} already mocked!", logText(query, params));
    }

    private static <T> void logWarning(String query, List<T> params, int match, int expected) {
        log.warn("{} calls mismatch! Expected: {}, Actual: {}", logText(query, params), match, expected);
    }

    private static <T> String logText(String query, List<T> params) {
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
            if (result instanceof MockedQuery query) {
                query.setMocked(mock, onValue);
            }
            return result;
        });
    }

    public static void clearCodeFactoryMock() {
        clearEnvelopingFactory();
    }

    public static class MockAsyncEntityModifierImpl extends AsyncEntityModifierImpl {

        protected MockAsyncEntityModifierImpl(Object parent) {
            super(parent);
        }
    }

}
