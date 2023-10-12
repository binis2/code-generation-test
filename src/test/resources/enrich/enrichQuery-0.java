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

@Generated(value = "net.binis.codegen.Test2Prototype", comments = "Test2")
@SuppressWarnings("unchecked")
public class Test2Impl implements Test2 {

    protected double amount;

    protected List<Long> items;

    protected Test2 parent;

    protected Sub sub;

    protected String title;

    {
        CodeFactory.registerType(Test2.class, Test2Impl::new, null);
        CodeFactory.registerType(Test2.QueryName.class, Test2QueryNameImpl::new, null);
        CodeFactory.registerType(Test2.QuerySelect.class, Test2SelectQueryExecutorImpl::new, null);
        CodeFactory.registerType(Test2.QueryOperationFields.class, Test2FieldsQueryExecutorImpl::new, null);
    }

    public Test2Impl() {
    }

    public double getAmount() {
        return amount;
    }

    public List<Long> getItems() {
        return items;
    }

    public Test2 getParent() {
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

    public void setParent(Test2 parent) {
        this.parent = parent;
    }

    public void setSub(Sub sub) {
        this.sub = sub;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Generated("QueryEnricher")
    protected static class Test2FieldsQueryExecutorImpl extends Test2QueryExecutorImpl implements Test2.QueryFieldsStart, EmbeddedFields {

        public Test2.QueryOperationFields parent() {
            var result = EntityCreator.create(Test2.QueryOperationFields.class, "net.binis.codegen.Test2Impl");
            ((QueryEmbed) result).setParent("parent", this);
            return result;
        }

        public Sub.QueryOperationFields sub() {
            var result = EntityCreator.create(Sub.QueryOperationFields.class, "net.binis.codegen.SubImpl");
            ((QueryEmbed) result).setParent("sub", this);
            return result;
        }
    }

    @Generated("QueryEnricher")
    protected static abstract class Test2QueryExecutorImpl extends QueryExecutor implements Test2.QueryUpdate {

        protected Test2QueryExecutorImpl() {
            super(Test2.class, () -> new Test2QueryNameImpl(), parent -> {
                var result = new Test2FieldsQueryExecutorImpl();
                result.parent = (QueryExecutor) parent;
                return result;
            });
        }

        public QueryAggregateOperation aggregate() {
            return (QueryAggregateOperation) aggregateStart(new Test2QueryOrderImpl(this, Test2QueryExecutorImpl.this::aggregateIdentifier));
        }

        public QuerySelectOperation amount(double amount) {
            return identifier("amount", amount);
        }

        public QueryFunctions amount() {
            return identifier("amount");
        }

        public QueryCollectionFunctions items() {
            return identifier("items");
        }

        public Test2.QueryOrder order() {
            return (Test2.QueryOrder) orderStart(new Test2QueryOrderImpl(this, Test2QueryExecutorImpl.this::orderIdentifier));
        }

        public QuerySelectOperation parent(Test2 parent) {
            return identifier("parent", parent);
        }

        public QuerySelectOperation sub(Sub sub) {
            return identifier("sub", sub);
        }

        public QuerySelectOperation title(String title) {
            return identifier("title", title);
        }

        public QueryFunctions title() {
            return identifier("title");
        }

        @Generated("QueryEnricher")
        protected class Test2QueryOrderImpl extends QueryOrderer implements Test2.QueryOrder, Test2.QueryAggregate {

            protected Test2QueryOrderImpl(Test2QueryExecutorImpl executor, Function<String, Object> func) {
                super(executor, func);
            }

            public QueryOrderOperation amount() {
                return (QueryOrderOperation) func.apply("amount");
            }

            public Test2.QueryOperationFields parent() {
                var result = EntityCreator.create(Test2.QueryOperationFields.class, "net.binis.codegen.Test2Impl");
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
    protected static class Test2QueryNameImpl extends BaseQueryNameImpl implements Test2.QueryName, QueryEmbed {

        public QueryFunctions amount() {
            return executor.identifier("amount");
        }

        public QuerySelectOperation amount(double amount) {
            return executor.identifier("amount", amount);
        }

        public Test2.QueryName parent() {
            var result = EntityCreator.create(Test2.QueryName.class, "net.binis.codegen.Test2Impl");
            ((QueryEmbed) result).setParent("parent", executor);
            return result;
        }

        public QuerySelectOperation parent(Test2 parent) {
            return executor.identifier("parent", parent);
        }

        public Sub.QueryName sub() {
            var result = EntityCreator.create(Sub.QueryName.class, "net.binis.codegen.SubImpl");
            ((QueryEmbed) result).setParent("sub", executor);
            return result;
        }

        public QuerySelectOperation sub(Sub sub) {
            return executor.identifier("sub", sub);
        }

        public QueryFunctions title() {
            return executor.identifier("title");
        }

        public QuerySelectOperation title(String title) {
            return executor.identifier("title", title);
        }
    }

    @Generated("QueryEnricher")
    protected static class Test2SelectQueryExecutorImpl extends Test2QueryExecutorImpl implements Test2.QuerySelect {

        public Test2.QueryName parent() {
            var result = EntityCreator.create(Test2.QueryName.class, "net.binis.codegen.Test2Impl");
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
