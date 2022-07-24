/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.spring.query.executor.QueryOrderer;
import net.binis.codegen.spring.query.executor.QueryExecutor;
import net.binis.codegen.spring.query.base.BaseQueryNameImpl;
import net.binis.codegen.spring.query.*;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.creator.EntityCreator;
import javax.annotation.processing.Generated;
import java.util.function.Function;
import java.util.Optional;
import java.util.List;

@Generated(value = "TestPrototype", comments = "Test")
@SuppressWarnings(value = "unchecked")
public class TestImpl extends BaseImpl implements Test {

    protected double amount;

    protected String title;

    {
        CodeFactory.registerType(Test.class, TestImpl::new, null);
        CodeFactory.registerType(Test.QueryName.class, TestQueryNameImpl::new, null);
        CodeFactory.registerType(Test.QuerySelect.class, TestQueryExecutorImpl::new, null);
        CodeFactory.registerType(Test.QueryOperationFields.class, TestQueryExecutorImpl::new, null);
        CodeFactory.registerId(Test.class, "id", String.class);
    }

    public TestImpl() {
        super();
    }

    public double getAmount() {
        return amount;
    }

    public String getTitle() {
        return title;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    protected static class TestQueryExecutorImpl extends QueryExecutor implements Test.QueryUpdate, Test.QuerySelect, Test.QueryFieldsStart {

        protected TestQueryExecutorImpl() {
            super(Test.class, () -> new TestQueryNameImpl(), parent -> parent);
        }

        public QueryAggregateOperation aggregate() {
            return (QueryAggregateOperation) aggregateStart(new TestQueryOrderImpl(this, TestQueryExecutorImpl.this::aggregateIdentifier));
        }

        public QuerySelectOperation amount(double amount) {
            return identifier("amount", amount);
        }

        public QueryFunctions amount() {
            return identifier("amount");
        }

        public QuerySelectOperation id(String id) {
            return identifier("id", id);
        }

        public QueryFunctions id() {
            return identifier("id");
        }

        public Test.QueryOrder order() {
            return (Test.QueryOrder) orderStart(new TestQueryOrderImpl(this, TestQueryExecutorImpl.this::orderIdentifier));
        }

        public QuerySelectOperation title(String title) {
            return identifier("title", title);
        }

        public QueryFunctions title() {
            return identifier("title");
        }

        protected class TestQueryOrderImpl extends QueryOrderer implements Test.QueryOrder, Test.QueryAggregate {

            protected TestQueryOrderImpl(TestQueryExecutorImpl executor, Function<String, Object> func) {
                super(executor, func);
            }

            public QueryOrderOperation amount() {
                return (QueryOrderOperation) func.apply("amount");
            }

            public QueryOrderOperation id() {
                return (QueryOrderOperation) func.apply("id");
            }

            public QueryOrderOperation title() {
                return (QueryOrderOperation) func.apply("title");
            }
        }
    }

    protected static class TestQueryNameImpl extends BaseQueryNameImpl implements Test.QueryName, QueryEmbed {

        public QueryFunctions amount() {
            return executor.identifier("amount");
        }

        public QuerySelectOperation amount(double amount) {
            return executor.identifier("amount", amount);
        }

        public QueryFunctions id() {
            return executor.identifier("id");
        }

        public QuerySelectOperation id(String id) {
            return executor.identifier("id", id);
        }

        public QueryFunctions title() {
            return executor.identifier("title");
        }

        public QuerySelectOperation title(String title) {
            return executor.identifier("title", title);
        }
    }
}
