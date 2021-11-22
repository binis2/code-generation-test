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
import net.binis.codegen.mock.exception.QueryNotMockedException;
import net.binis.codegen.spring.AsyncEntityModifier;
import net.binis.codegen.spring.BasePersistenceOperations;
import net.binis.codegen.spring.async.AsyncExecutor;
import net.binis.codegen.spring.async.executor.CodeExecutor;
import net.binis.codegen.spring.component.ApplicationContextProvider;
import net.binis.codegen.spring.query.*;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManagerFactory;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
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

    private CodeGenMock() {
    }

    private static QueryProcessor.Processor mockedProcessor;
    private static final Map<String, List<Pair<List<Object>, Object>>> mockedResponses = new HashMap<>();

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

    public static void mockAsyncExecutor() {
        instantiate(AsyncEntityModifier.class);
        CodeFactory.forceRegisterType(AsyncExecutor.class, CodeFactory.singleton(CodeExecutor.syncExecutor()), null);
    }

    public static void mockContextAndEntityManager() {
        mockContext();
        mockEntityManager();
    }

    public static void mockQueryProcessor(BiFunction<String, List<Object>, Object> func) {
        QueryProcessor.setProcessor((executor, manager, query, params, resultType, resultClass, mapClass, isNative, isModifying, pagable, flush, lock, hints, filters) -> func.apply(query, params));
    }

    public static void mockJustQuery(Printable query, Object returnObject) {
        mockQuery(query.print(), null, returnObject);
    }

    public static void mockJustQuery(Printable query, Supplier<Object> returnObject) {
        mockQuery(query.print(), null, returnObject);
    }

    public static void mockQuery(Printable query, List<Object> params, Object returnObject) {
        mockQuery(query.print(), params, returnObject);
    }

    public static void mockQuery(Printable query, List<Object> params, Supplier<Object> returnObject) {
        mockQuery(query.print(), params, returnObject);
    }

    public static void mockQuery(Queryable query, Object returnObject) {
        mockQuery(query.print(), ((QueryAccessor) query).getParams(), returnObject);
    }

    public static void mockQuery(Queryable query, Supplier<Object> returnObject) {
        mockQuery(query.print(), ((QueryAccessor) query).getParams(), returnObject);
    }

    public static void mockCountQuery(Queryable query, Long count) {
        mockCountQuery(query, () -> count);
    }

    public static void mockCountQuery(Queryable query, Supplier<Long> count) {
        var q = query.print();
        if (q.startsWith("select u ")) {
            q = q.replace("select u ", "select count(*) ");
        } else {
            q = "select count(*) " + q;
        }

        mockQuery(q, ((QueryAccessor) query).getParams(), count);
    }

    public static void mockExistsQuery(Queryable query, boolean exists) {
        mockCountQuery(query, exists ? 1L : 0L);
    }

    public static void mockExistsQuery(Queryable query, Supplier<Boolean> exists) {

        Supplier<Long> result = () ->
                exists.get() ? 1L : 0L;

        mockCountQuery(query, result);
    }

    public static void mockQuery(String query, Object returnObject) {
        mockQuery(query, null, returnObject);
    }

    public static void mockQuery(String query, List<Object> params, Object returnObject) {
        if (isNull(mockedProcessor) || !mockedProcessor.equals(QueryProcessor.getProcessor())) {
            QueryProcessor.setProcessor(createMockedProcessor());
        }

        var mocks = mockedResponses.get(query);

        if (nonNull(mocks)) {
            var mock = findMock(query, params);
            if (mock.isEmpty()) {
                mocks.add(Pair.of(params, returnObject));
            } else {
                if (nonNull(mock.get().getLeft()) && !(mock.get().getRight() instanceof Supplier)) {
                    logWarning(query, params);
                }
            }
        } else {
            mockedResponses.put(query, new ArrayList<>(Collections.singletonList(Pair.of(params, returnObject))));
        }

    }

    public static void mockQueryClear() {
        mockedResponses.clear();
    }

    private static QueryProcessor.Processor createMockedProcessor() {
        mockedProcessor = (executor, manager, query, params, resultType, resultClass, mapClass, isNative, isModifying, pagable, flush, lock, hints, filters) -> {
            Optional<Pair<List<Object>, Object>> mock = findMock(query, params);

            if (mock.isEmpty()) {
                logError(query, params);
            }

            var value = mock.get().getRight();
            if (value instanceof Supplier) {
                value = ((Supplier<?>) value).get();
            }
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

    private static Optional<Pair<List<Object>, Object>> findMock(String query, List<Object> params) {
        var mocks = mockedResponses.get(query);
        if (isNull(mocks)) {
            return Optional.empty();
        }

        var mock = mocks.stream().filter(p -> paramsEquals(p, params)).findFirst();

        if (mock.isEmpty()) {
            mock = mocks.stream().filter(p -> isNull(p.getLeft())).findFirst();
        }

        return mock;
    }

    private static boolean paramsEquals(Pair<List<Object>, Object> pair, List<Object> params) {
        var mockParams = pair.getLeft();
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

    private static void logWarning(String query, List<Object> params) {
        log.warn("{} already mocked!", logText(query, params));
    }

    private static String logText(String query, List<Object> params) {
        return "Query '" + query + "' with params [" + params.stream().map(Object::toString).map(s -> "(" + s + ")").collect(Collectors.joining(", ")) + "]";
    }


    public static void mockCreate(Class<?> cls) {
        instantiate(cls);
        findMocks(cls);
    }

    private static void findMocks(Class<?> cls) {
        findMock(cls);

        for (var i : cls.getInterfaces()) {
            findMocks(i);
        }

        for (var c : cls.getClasses()) {
            findMocks(c);
        }
    }

    private static void findMock(Class<?> i) {
        UnaryOperator<Object> mock = v -> {
            if (CodeGenMatcher.anyMock.get()) {
                CodeGenMatcher.anyMock.set(false);
                v = CodeGenMatcher.class;
            }
            return v;
        };

        UnaryOperator<Object> onValue = v -> {
            if (isNull(v) && CodeGenMatcher.anyMock.get()) {
                v = CodeGenMatcher.class;
                CodeGenMatcher.anyMock.set(false);
            }
            return v;
        };

        var factory = CodeFactory.lookup(i);
        if (nonNull(factory)) {
            CodeFactory.envelopType(i, f -> {
                var result = f.create();
                if (result instanceof MockedQuery) {
                    ((MockedQuery) result).setMocked(mock, onValue);
                }
                return result;
            }, (f, p, v) -> {
                var result = f.create(p, v);
                if (result instanceof MockedQuery) {
                    ((MockedQuery) result).setMocked(mock, onValue);
                }
                return result;
            });
        }
    }

}
