/*Generated code by Binis' code generator.*/
package net.binis.codegen.test;

import net.binis.codegen.spring.query.executor.QueryOrderer;
import net.binis.codegen.spring.query.executor.QueryExecutor;
import net.binis.codegen.spring.query.base.BaseQueryNameImpl;
import net.binis.codegen.spring.query.*;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.creator.EntityCreator;
import net.binis.codegen.TestExternal;
import javax.annotation.processing.Generated;
import java.util.function.Function;
import java.util.Optional;
import java.util.List;

@Generated(value = "net.binis.codegen.test.TestPrototype", comments = "Test")
@SuppressWarnings("unchecked")
public class TestImpl implements Test {

    protected TestExternal test;

    {
        CodeFactory.registerType(Test.class, TestImpl::new, null);
        CodeFactory.registerType(Test.QueryName.class, TestQueryNameImpl::new, null);
        CodeFactory.registerType(Test.QuerySelect.class, TestSelectQueryExecutorImpl::new, null);
        CodeFactory.registerType(Test.QueryOperationFields.class, TestFieldsQueryExecutorImpl::new, null);
    }

    public TestImpl() {
    }

    public TestExternal getTest() {
        return test;
    }

    public void setTest(TestExternal test) {
        this.test = test;
    }

    @Generated("QueryEnricher")
    protected static class TestFieldsQueryExecutorImpl extends TestQueryExecutorImpl implements Test.QueryFieldsStart, EmbeddedFields {

        public TestExternal.QueryOperationFields test() {
            var result = EntityCreator.create(TestExternal.QueryOperationFields.class, "net.binis.codegen.TestExternalImpl");
            ((QueryEmbed) result).setParent("test", this);
            return result;
        }
    }

    @Generated("QueryEnricher")
    protected static abstract class TestQueryExecutorImpl extends QueryExecutor implements Test.QueryUpdate {

        protected TestQueryExecutorImpl() {
            super(Test.class, () -> new TestQueryNameImpl(), parent -> {
                var result = new TestFieldsQueryExecutorImpl();
                result.parent = (QueryExecutor) parent;
                return result;
            });
        }

        public QueryAggregateOperation aggregate() {
            return (QueryAggregateOperation) _aggregateStart(new TestQueryOrderImpl(this, TestQueryExecutorImpl.this::_aggregateIdentifier));
        }

        public Test.QueryOrder order() {
            return (Test.QueryOrder) _orderStart(new TestQueryOrderImpl(this, TestQueryExecutorImpl.this::_orderIdentifier));
        }

        public QuerySelectOperation test(TestExternal test) {
            return $identifier("test", test);
        }

        @Generated("QueryEnricher")
        protected class TestQueryOrderImpl extends QueryOrderer implements Test.QueryOrder, Test.QueryAggregate {

            protected TestQueryOrderImpl(TestQueryExecutorImpl executor, Function<String, Object> func) {
                super(executor, func);
            }

            public TestExternal.QueryOperationFields test() {
                var result = EntityCreator.create(TestExternal.QueryOperationFields.class, "net.binis.codegen.TestExternalImpl");
                ((QueryEmbed) result).setParent("test", executor);
                return result;
            }
        }
    }

    @Generated("QueryEnricher")
    protected static class TestQueryNameImpl extends BaseQueryNameImpl implements Test.QueryName, QueryEmbed {

        public TestExternal.QueryName test() {
            var result = EntityCreator.create(TestExternal.QueryName.class, "net.binis.codegen.TestExternalImpl");
            ((QueryEmbed) result).setParent("test", executor);
            return result;
        }

        public QuerySelectOperation test(TestExternal test) {
            return executor.$identifier("test", test);
        }
    }

    @Generated("QueryEnricher")
    protected static class TestSelectQueryExecutorImpl extends TestQueryExecutorImpl implements Test.QuerySelect {

        public TestExternal.QueryName test() {
            var result = EntityCreator.create(TestExternal.QueryName.class, "net.binis.codegen.TestExternalImpl");
            ((QueryEmbed) result).setParent("test", this);
            return result;
        }
    }
}
