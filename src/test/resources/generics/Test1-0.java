/*Generated code by Binis' code generator.*/
package net.binis.codegen.test;

import net.binis.codegen.spring.query.executor.QueryOrderer;
import net.binis.codegen.spring.query.executor.QueryExecutor;
import net.binis.codegen.spring.query.base.BaseQueryNameImpl;
import net.binis.codegen.spring.query.*;
import net.binis.codegen.spring.modifier.impl.BaseEntityModifierImpl;
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
@SuppressWarnings(value = "unchecked")
public class TestImpl extends GenericImpl<TestPayload> implements Test, Modifiable<Test.Modify> {

    @Column
    protected TestEnum type = net.binis.codegen.enums.TestEnum.FIRST;

    // region constructor & initializer
    {
        CodeFactory.registerType(Test.QueryOrder.class, () -> Test.find().aggregate(), null);
        CodeFactory.registerType(Test.class, TestImpl::new, (p, v, r) -> p instanceof EmbeddedCodeCollection ? ((TestImpl) v).new TestImplCollectionModifyImpl(p) : ((TestImpl) v).new TestImplSoloModifyImpl(p));
        CodeFactory.registerType(Test.QueryName.class, TestQueryNameImpl::new, null);
        CodeFactory.registerType(Test.QuerySelect.class, TestQueryExecutorImpl::new, null);
        CodeFactory.registerType(Test.QueryOperationFields.class, TestQueryExecutorImpl::new, null);
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
        return new TestModifyImpl(this);
    }
    // endregion

    // region inner classes
    protected class TestImplCollectionModifyImpl extends TestImplEmbeddedModifyImpl implements Test.EmbeddedCollectionModify {

        protected TestImplCollectionModifyImpl(Object parent) {
            super(parent);
        }

        public EmbeddedCodeCollection _and() {
            return (EmbeddedCodeCollection) parent;
        }
    }

    protected class TestImplEmbeddedModifyImpl<T, R> extends BaseEntityModifierImpl<T, R> implements Test.EmbeddedModify<T, R> {

        protected TestImplEmbeddedModifyImpl(R parent) {
            super(parent);
        }

        public T payload(TestPayload payload) {
            TestImpl.this.payload = payload;
            return (T) this;
        }

        public T type(TestEnum type) {
            TestImpl.this.type = type;
            return (T) this;
        }
    }

    protected class TestImplSoloModifyImpl extends TestImplEmbeddedModifyImpl implements Test.EmbeddedSoloModify {

        protected TestImplSoloModifyImpl(Object parent) {
            super(parent);
        }
    }

    protected class TestModifyImpl extends TestImplEmbeddedModifyImpl<Test.Modify, Test> implements Test.Modify {

        protected TestModifyImpl(Test parent) {
            super(parent);
        }
    }

    protected static class TestQueryExecutorImpl extends QueryExecutor implements Test.QueryUpdate, Test.QuerySelect, Test.QueryFieldsStart {

        protected TestQueryExecutorImpl() {
            super(Test.class, () -> new TestQueryNameImpl(), parent -> parent);
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
