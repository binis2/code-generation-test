/*Generated code by Binis' code generator.*/
package net.binis.codegen.test;

import net.binis.codegen.spring.query.executor.QueryOrderer;
import net.binis.codegen.spring.query.executor.QueryExecutor;
import net.binis.codegen.spring.query.base.BaseQueryNameImpl;
import net.binis.codegen.spring.query.*;
import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.enums.TestEnum;
import net.binis.codegen.creator.EntityCreator;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import javax.persistence.Column;
import javax.annotation.processing.Generated;
import java.util.function.Function;
import java.util.Optional;
import java.util.List;

@Generated(value = "TestPrototype", comments = "Test")
public class TestImpl extends GenericImpl<TestPayload> implements Test, Modifiable<Test.Modify> {

    @Column
    protected TestEnum type = net.binis.codegen.enums.TestEnum.FIRST;

    // region constructor & initializer
    {
        CodeFactory.registerType(Test.QuerySelect.class, TestQueryExecutorImpl::new, null);
        CodeFactory.registerType(Test.QueryOrder.class, () -> Test.find().aggregate(), null);
        CodeFactory.registerType(Test.class, TestImpl::new, (p, v) -> new EmbeddedTestModifyImpl<>(p, (TestImpl) v));
        CodeFactory.registerType(Test.QueryName.class, TestQueryNameImpl::new, null);
    }

    public TestImpl() {
        super();
    }
    // endregion

    // region getters
    public TestEnum getType() {
        return type;
    }

    public Test.Modify with() {
        return new TestModifyImpl();
    }
    // endregion

    // region inner classes
    protected static class EmbeddedTestModifyImpl<T> implements Test.EmbeddedModify<T> {

        protected TestImpl entity;

        protected T parent;

        protected EmbeddedTestModifyImpl(T parent, TestImpl entity) {
            this.parent = parent;
            this.entity = entity;
        }

        public EmbeddedCodeCollection<Test.EmbeddedModify<T>, Test, T> and() {
            return (EmbeddedCodeCollection) parent;
        }

        public Test.EmbeddedModify<T> payload(TestPayload payload) {
            entity.payload = payload;
            return this;
        }

        public Test.EmbeddedModify<T> type(TestEnum type) {
            entity.type = type;
            return this;
        }
    }

    protected class TestModifyImpl implements Test.Modify {

        public Test done() {
            return TestImpl.this;
        }

        public Test.Modify payload(TestPayload payload) {
            TestImpl.this.payload = payload;
            return this;
        }

        public Test.Modify type(TestEnum type) {
            TestImpl.this.type = type;
            return this;
        }
    }

    protected static class TestQueryExecutorImpl extends QueryExecutor implements Test.QuerySelect, Test.QueryFieldsStart {

        protected TestQueryExecutorImpl() {
            super(Test.class, () -> new TestQueryNameImpl());
        }

        public QueryAggregateOperation aggregate() {
            return (QueryAggregateOperation) aggregateStart(new TestQueryOrderImpl(this, TestQueryExecutorImpl.this::aggregateIdentifier));
        }

        public Test.QueryOrder order() {
            return (Test.QueryOrder) orderStart(new TestQueryOrderImpl(this, TestQueryExecutorImpl.this::orderIdentifier));
        }

        public QuerySelectOperation payload(TestPayload payload) {
            return identifier("payload", payload);
        }

        public QueryFunctions payload() {
            return identifier("payload");
        }

        public QuerySelectOperation type(TestEnum type) {
            return identifier("type", type);
        }

        public QueryFunctions type() {
            return identifier("type");
        }

        protected class TestQueryOrderImpl extends QueryOrderer implements Test.QueryOrder, Test.QueryAggregate {

            protected TestQueryOrderImpl(TestQueryExecutorImpl executor, Function<String, Object> func) {
                super(executor, func);
            }

            public QueryOrderOperation payload() {
                return (QueryOrderOperation) func.apply("payload");
            }

            public QueryOrderOperation type() {
                return (QueryOrderOperation) func.apply("type");
            }
        }
    }

    protected static class TestQueryNameImpl extends BaseQueryNameImpl implements Test.QueryName, QueryEmbed {

        public QueryFunctions payload() {
            return executor.identifier("payload");
        }

        public QuerySelectOperation payload(TestPayload payload) {
            return executor.identifier("payload", payload);
        }

        public QueryFunctions type() {
            return executor.identifier("type");
        }

        public QuerySelectOperation type(TestEnum type) {
            return executor.identifier("type", type);
        }
    }
    // endregion
}
