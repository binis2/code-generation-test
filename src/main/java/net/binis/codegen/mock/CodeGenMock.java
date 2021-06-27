package net.binis.codegen.mock;

import net.binis.codegen.spring.BasePersistenceOperations;
import net.binis.codegen.spring.component.ApplicationContextProvider;
import net.binis.codegen.spring.query.QueryProcessor;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import static java.util.Objects.isNull;
import static net.binis.codegen.tools.Reflection.instantiate;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CodeGenMock {

    private CodeGenMock() {
    }

    private static QueryProcessor.Processor mockedProcessor;
    private static Map<String, Object> mockedResponses = new HashMap<>();

    public static void mockContext() {
        var context = mock(ApplicationContext.class);
        var tm = mock(JpaTransactionManager.class);
        when(context.getBean(eq(JpaTransactionManager.class))).thenReturn(tm);
        when(tm.getEntityManagerFactory()).thenReturn(mock(EntityManagerFactory.class));
        var template = mock(TransactionTemplate.class);
        when(context.getBean(eq(TransactionTemplate.class))).thenReturn(template);
        when(template.execute(any())).then(m -> ((TransactionCallback) m.getArgument(0)).doInTransaction(null));

        ApplicationContextProvider.setAppContext(context);
    }

    public static void mockEntityManager() {
        var entityManager = new MockEntityManager();
        BasePersistenceOperations.setEntityManagerProvider((factory) -> entityManager);
    }

    public static void mockContextAndEntityManager() {
        mockContext();
        mockEntityManager();
    }

    public static void mockQueryProcessor(BiFunction<String, List<Object>, Object> func) {
        QueryProcessor.setProcessor((manager, query, params, resultType, resultClass, mapClass, isNative, isModifying, pagable, flush, lock, hints) -> func.apply(query, params));
    }

    public static void mockQuery(String query, Object returnObject) {
        if (isNull(mockedProcessor) || !mockedProcessor.equals(QueryProcessor.getProcessor())) {
            QueryProcessor.setProcessor(createMockedProcessor());
        }

        mockedResponses.put(query, returnObject);

    }

    private static QueryProcessor.Processor createMockedProcessor() {
        mockedProcessor = (manager, query, params, resultType, resultClass, mapClass, isNative, isModifying, pagable, flush, lock, hints) -> {
            var response = mockedResponses.get(query);
            if (isNull(response)) {
                System.out.println("Query '" + query + "' is not mocked!");
            }

            return response;
        };
        return mockedProcessor;
    }

    public static void mockCreate(Class<?> cls) {
        instantiate(cls);
    }

}
