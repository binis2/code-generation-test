/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.spring.query.executor.QueryOrderer;
import net.binis.codegen.spring.query.executor.QueryExecutor;
import net.binis.codegen.spring.query.base.BaseQueryNameImpl;
import net.binis.codegen.spring.query.*;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.creator.EntityCreator;
import java.util.function.Function;
import java.util.Optional;
import java.util.List;

public class TestImpl implements Test {

    protected double amount;

    protected List<Long> items;

    protected Test parent;

    protected Sub sub;

    protected String title;

    {
        CodeFactory.registerType(Test.QuerySelect.class, TestQueryExecutorImpl::new, null);
        CodeFactory.registerType(Test.class, TestImpl::new, null);
        CodeFactory.registerType(Test.QueryName.class, TestQueryNameImpl::new, null);
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

    protected static class TestQueryExecutorImpl<QR> extends QueryExecutor<Object, Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR, QueryAggregateOperation> implements Test.QuerySelect<QR> {

        protected TestQueryExecutorImpl() {
            super(Test.class);
        }

        public QueryAggregateOperation aggregate() {
            return aggregateStart(new TestQueryOrderImpl<>(this, TestQueryExecutorImpl.this::aggregateIdentifier));
        }

        public QuerySelectOperation<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR> amount(double amount) {
            return identifier("amount", amount);
        }

        public QueryFunctions<Double, QuerySelectOperation<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR>> amount() {
            identifier("amount");
            return (QueryFunctions) this;
        }

        public QueryCollectionFunctions<Long, QuerySelectOperation<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR>> items() {
            return (QueryCollectionFunctions) identifier("items");
        }

        public Test.QueryName<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR> lower() {
            doLower();
            var result = new TestQueryNameImpl<>();
            result.setParent("u", this);
            return (Test.QueryName) result;
        }

        public Test.QueryName<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR> not() {
            doNot();
            var result = new TestQueryNameImpl<>();
            result.setParent("u", this);
            return (Test.QueryName) result;
        }

        public Test.QueryOrder<QR> order() {
            return orderStart(new TestQueryOrderImpl<>(this, TestQueryExecutorImpl.this::orderIdentifier));
        }

        public QuerySelectOperation<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR> parent(Test parent) {
            return identifier("parent", parent);
        }

        public Test.QueryName<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR> parent() {
            var result = EntityCreator.create(Test.QueryName.class);
            ((QueryEmbed) result).setParent("parent", this);
            return result;
        }

        public Test.QueryName<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR> replace(String what, String withWhat) {
            doReplace(what, withWhat);
            var result = new TestQueryNameImpl<>();
            result.setParent("u", this);
            return (Test.QueryName) result;
        }

        public QuerySelectOperation<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR> sub(Sub sub) {
            return identifier("sub", sub);
        }

        public Sub.QueryName<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR> sub() {
            var result = EntityCreator.create(Sub.QueryName.class);
            ((QueryEmbed) result).setParent("sub", this);
            return result;
        }

        public Test.QueryName<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR> substring(int start) {
            doSubstring(start);
            var result = new TestQueryNameImpl<>();
            result.setParent("u", this);
            return (Test.QueryName) result;
        }

        public Test.QueryName<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR> substring(int start, int len) {
            doSubstring(start, len);
            var result = new TestQueryNameImpl<>();
            result.setParent("u", this);
            return (Test.QueryName) result;
        }

        public QuerySelectOperation<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR> title(String title) {
            return identifier("title", title);
        }

        public QueryFunctions<String, QuerySelectOperation<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR>> title() {
            identifier("title");
            return (QueryFunctions) this;
        }

        public Test.QueryName<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR> trim() {
            doTrim();
            var result = new TestQueryNameImpl<>();
            result.setParent("u", this);
            return (Test.QueryName) result;
        }

        public Test.QueryName<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR> upper() {
            doUpper();
            var result = new TestQueryNameImpl<>();
            result.setParent("u", this);
            return (Test.QueryName) result;
        }

        protected class TestQueryOrderImpl<QR> extends QueryOrderer<QR> implements Test.QueryOrder<QR>, Test.QueryAggregate<QR, Object> {

            protected TestQueryOrderImpl(TestQueryExecutorImpl executor, Function<String, Object> func) {
                super(executor, func);
            }

            public QueryOrderOperation<Test.QueryOrder<QR>, QR> amount() {
                return (QueryOrderOperation) func.apply("amount");
            }

            public QueryOrderOperation<Test.QueryOrder<QR>, QR> parent() {
                return (QueryOrderOperation) func.apply("parent");
            }

            public QueryOrderOperation<Test.QueryOrder<QR>, QR> script(String script) {
                return (QueryOrderOperation) TestQueryExecutorImpl.this.script(script);
            }

            public QueryOrderOperation<Test.QueryOrder<QR>, QR> sub() {
                return (QueryOrderOperation) func.apply("sub");
            }

            public QueryOrderOperation<Test.QueryOrder<QR>, QR> title() {
                return (QueryOrderOperation) func.apply("title");
            }
        }
    }

    protected static class TestQueryNameImpl<QS, QO, QR> extends BaseQueryNameImpl<QuerySelectOperation<QS, QO, QR>> implements Test.QueryName<QS, QO, QR>, QueryEmbed {

        public QueryFunctions<Double, QuerySelectOperation<QS, QO, QR>> amount() {
            return (QueryFunctions) executor.identifier("amount");
        }

        public QuerySelectOperation<QS, QO, QR> amount(double amount) {
            return (QuerySelectOperation) executor.identifier("amount", amount);
        }

        public Test.QueryName<QS, QO, QR> parent() {
            var result = EntityCreator.create(Test.QueryName.class);
            ((QueryEmbed) result).setParent("parent", executor);
            return result;
        }

        public QuerySelectOperation<QS, QO, QR> parent(Test parent) {
            return (QuerySelectOperation) executor.identifier("parent", parent);
        }

        public Sub.QueryName<QS, QO, QR> sub() {
            var result = EntityCreator.create(Sub.QueryName.class);
            ((QueryEmbed) result).setParent("sub", executor);
            return result;
        }

        public QuerySelectOperation<QS, QO, QR> sub(Sub sub) {
            return (QuerySelectOperation) executor.identifier("sub", sub);
        }

        public QueryFunctions<String, QuerySelectOperation<QS, QO, QR>> title() {
            return (QueryFunctions) executor.identifier("title");
        }

        public QuerySelectOperation<QS, QO, QR> title(String title) {
            return (QuerySelectOperation) executor.identifier("title", title);
        }
    }
}
