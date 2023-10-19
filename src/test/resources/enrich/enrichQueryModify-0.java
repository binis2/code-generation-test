/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.spring.query.executor.QueryOrderer;
import net.binis.codegen.spring.query.executor.QueryExecutor;
import net.binis.codegen.spring.query.base.BaseQueryNameImpl;
import net.binis.codegen.spring.query.*;
import net.binis.codegen.modifier.impl.BaseModifierImpl;
import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.creator.EntityCreator;
import net.binis.codegen.collection.CodeListImpl;
import net.binis.codegen.collection.CodeList;
import javax.annotation.processing.Generated;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.Optional;
import java.util.List;

@Generated(value = "net.binis.codegen.TestPrototype", comments = "Test")
@SuppressWarnings("unchecked")
public class TestImpl implements Test, Modifiable<Test.Modify> {

    protected double amount;

    protected List<Long> items;

    protected Test parent;

    protected Sub sub;

    protected String title;

    {
        CodeFactory.registerType(Test.class, TestImpl::new, null);
        CodeFactory.registerType(Test.QueryName.class, TestQueryNameImpl::new, null);
        CodeFactory.registerType(Test.QuerySelect.class, TestSelectQueryExecutorImpl::new, null);
        CodeFactory.registerType(Test.QueryOperationFields.class, TestFieldsQueryExecutorImpl::new, null);
    }

    public TestImpl() {
    }

    public double getAmount() {
        return amount;
    }

    public List<Long> getItems() {
        return items;
    }

    public Test getParent() {
        return parent;
    }

    public Sub getSub() {
        return sub;
    }

    public String getTitle() {
        return title;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setItems(List<Long> items) {
        this.items = items;
    }

    public void setParent(Test parent) {
        this.parent = parent;
    }

    public void setSub(Sub sub) {
        this.sub = sub;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Test.Modify with() {
        return new TestModifyImpl(this);
    }

    @Generated("QueryEnricher")
    protected static class TestFieldsQueryExecutorImpl extends TestQueryExecutorImpl implements Test.QueryFieldsStart, EmbeddedFields {

        public Test.QueryOperationFields parent() {
            var result = EntityCreator.create(Test.QueryOperationFields.class, "net.binis.codegen.TestImpl");
            ((QueryEmbed) result).setParent("parent", this);
            return result;
        }

        public Sub.QueryOperationFields sub() {
            var result = EntityCreator.create(Sub.QueryOperationFields.class, "net.binis.codegen.SubImpl");
            ((QueryEmbed) result).setParent("sub", this);
            return result;
        }
    }

    @SuppressWarnings("unchecked")
    @Generated("ModifierEnricher")
    protected class TestImplEmbeddedModifyImpl<T, R> extends BaseModifierImpl<T, R> implements Test.EmbeddedModify<T, R> {

        protected TestImplEmbeddedModifyImpl(R parent) {
            super(parent);
        }

        public T amount(double amount) {
            TestImpl.this.amount = amount;
            return (T) this;
        }

        public T items(List<Long> items) {
            TestImpl.this.items = items;
            return (T) this;
        }

        public CodeList items() {
            if (TestImpl.this.items == null) {
                TestImpl.this.items = new java.util.ArrayList<>();
            }
            return new CodeListImpl<>(this, TestImpl.this.items);
        }

        public T parent(Test parent) {
            TestImpl.this.parent = parent;
            return (T) this;
        }

        public Test.EmbeddedSoloModify<Test.EmbeddedModify<T, R>> parent() {
            if (TestImpl.this.parent == null) {
                TestImpl.this.parent = CodeFactory.create(Test.class);
            }
            return CodeFactory.modify(this, TestImpl.this.parent, Test.class);
        }

        public T sub(Sub sub) {
            TestImpl.this.sub = sub;
            return (T) this;
        }

        public Sub.EmbeddedSoloModify<Test.EmbeddedModify<T, R>> sub() {
            if (TestImpl.this.sub == null) {
                TestImpl.this.sub = CodeFactory.create(Sub.class);
            }
            return CodeFactory.modify(this, TestImpl.this.sub, Sub.class);
        }

        public T title(String title) {
            TestImpl.this.title = title;
            return (T) this;
        }
    }

    @SuppressWarnings("unchecked")
    @Generated("ModifierEnricher")
    protected class TestImplSoloModifyImpl extends TestImplEmbeddedModifyImpl implements Test.EmbeddedSoloModify {

        protected TestImplSoloModifyImpl(Object parent) {
            super(parent);
        }
    }

    @Generated("ModifierEnricher")
    @SuppressWarnings("unchecked")
    protected class TestModifyImpl extends TestImplEmbeddedModifyImpl<Test.Modify, Test> implements Test.Modify {

        protected TestModifyImpl(Test parent) {
            super(parent);
        }

        public Test.Modify parent$(Consumer<Test.Modify> init) {
            if (TestImpl.this.parent == null) {
                TestImpl.this.parent = CodeFactory.create(Test.class);
            }
            init.accept(TestImpl.this.parent.with());
            return this;
        }

        public Test.Modify sub$(Consumer<Sub.Modify> init) {
            if (TestImpl.this.sub == null) {
                TestImpl.this.sub = CodeFactory.create(Sub.class);
            }
            init.accept(TestImpl.this.sub.with());
            return this;
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

        public QuerySelectOperation amount(double amount) {
            return $identifier("amount", amount);
        }

        public QueryFunctions amount() {
            return $identifier("amount");
        }

        public QueryCollectionFunctions items() {
            return $identifier("items");
        }

        public Test.QueryOrder order() {
            return (Test.QueryOrder) _orderStart(new TestQueryOrderImpl(this, TestQueryExecutorImpl.this::_orderIdentifier));
        }

        public QuerySelectOperation parent(Test parent) {
            return $identifier("parent", parent);
        }

        public QuerySelectOperation sub(Sub sub) {
            return $identifier("sub", sub);
        }

        public QuerySelectOperation title(String title) {
            return $identifier("title", title);
        }

        public QueryFunctions title() {
            return $identifier("title");
        }

        @Generated("QueryEnricher")
        protected class TestQueryOrderImpl extends QueryOrderer implements Test.QueryOrder, Test.QueryAggregate {

            protected TestQueryOrderImpl(TestQueryExecutorImpl executor, Function<String, Object> func) {
                super(executor, func);
            }

            public QueryOrderOperation amount() {
                return (QueryOrderOperation) func.apply("amount");
            }

            public Test.QueryOperationFields parent() {
                var result = EntityCreator.create(Test.QueryOperationFields.class, "net.binis.codegen.TestImpl");
                ((QueryEmbed) result).setParent("parent", executor);
                return result;
            }

            public Sub.QueryOperationFields sub() {
                var result = EntityCreator.create(Sub.QueryOperationFields.class, "net.binis.codegen.SubImpl");
                ((QueryEmbed) result).setParent("sub", executor);
                return result;
            }

            public QueryOrderOperation title() {
                return (QueryOrderOperation) func.apply("title");
            }
        }
    }

    @Generated("QueryEnricher")
    protected static class TestQueryNameImpl extends BaseQueryNameImpl implements Test.QueryName, QueryEmbed {

        public QueryFunctions amount() {
            return executor.$identifier("amount");
        }

        public QuerySelectOperation amount(double amount) {
            return executor.$identifier("amount", amount);
        }

        public Test.QueryName parent() {
            var result = EntityCreator.create(Test.QueryName.class, "net.binis.codegen.TestImpl");
            ((QueryEmbed) result).setParent("parent", executor);
            return result;
        }

        public QuerySelectOperation parent(Test parent) {
            return executor.$identifier("parent", parent);
        }

        public Sub.QueryName sub() {
            var result = EntityCreator.create(Sub.QueryName.class, "net.binis.codegen.SubImpl");
            ((QueryEmbed) result).setParent("sub", executor);
            return result;
        }

        public QuerySelectOperation sub(Sub sub) {
            return executor.$identifier("sub", sub);
        }

        public QueryFunctions title() {
            return executor.$identifier("title");
        }

        public QuerySelectOperation title(String title) {
            return executor.$identifier("title", title);
        }
    }

    @Generated("QueryEnricher")
    protected static class TestSelectQueryExecutorImpl extends TestQueryExecutorImpl implements Test.QuerySelect {

        public Test.QueryName parent() {
            var result = EntityCreator.create(Test.QueryName.class, "net.binis.codegen.TestImpl");
            ((QueryEmbed) result).setParent("parent", this);
            return result;
        }

        public Sub.QueryName sub() {
            var result = EntityCreator.create(Sub.QueryName.class, "net.binis.codegen.SubImpl");
            ((QueryEmbed) result).setParent("sub", this);
            return result;
        }
    }
}
