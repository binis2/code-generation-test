/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.spring.query.executor.QueryOrderer;
import net.binis.codegen.spring.query.executor.QueryExecutor;
import net.binis.codegen.spring.query.base.BaseQueryNameImpl;
import net.binis.codegen.spring.query.*;
import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.creator.EntityCreator;
import net.binis.codegen.collection.CodeListImpl;
import net.binis.codegen.collection.CodeList;
import java.util.function.Function;
import java.util.Optional;
import java.util.List;

public class TestImpl implements Test, Modifiable<Test.Modify> {

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

    public Test.Modify with() {
        return new TestModifyImpl();
    }

    protected class TestModifyImpl implements Test.Modify {

        public Test.Modify amount(double amount) {
            TestImpl.this.amount = amount;
            return this;
        }

        public Test done() {
            return TestImpl.this;
        }

        public Test.Modify items(List<Long> items) {
            TestImpl.this.items = items;
            return this;
        }

        public CodeList<Long, Test.Modify> items() {
            if (TestImpl.this.items == null) {
                TestImpl.this.items = new java.util.ArrayList<>();
            }
            return new CodeListImpl<>(this, TestImpl.this.items);
        }

        public Test.Modify parent(Test parent) {
            TestImpl.this.parent = parent;
            return this;
        }

        public Test.Modify sub(Sub sub) {
            TestImpl.this.sub = sub;
            return this;
        }

        public Test.Modify title(String title) {
            TestImpl.this.title = title;
            return this;
        }
    }

    protected static class TestQueryExecutorImpl extends QueryExecutor implements Test.QuerySelect {

        protected TestQueryExecutorImpl() {
            super(Test.class);
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

        public QueryCollectionFunctions items() {
            return identifier("items");
        }

        public Test.QueryName lower() {
            doLower();
            var result = new TestQueryNameImpl();
            result.setParent(alias, this);
            return result;
        }

        public Test.QueryName not() {
            doNot();
            var result = new TestQueryNameImpl();
            result.setParent(alias, this);
            return result;
        }

        public Test.QueryOrder order() {
            return (Test.QueryOrder) orderStart(new TestQueryOrderImpl(this, TestQueryExecutorImpl.this::orderIdentifier));
        }

        public QuerySelectOperation parent(Test parent) {
            return identifier("parent", parent);
        }

        public Test.QueryName parent() {
            var result = EntityCreator.create(Test.QueryName.class);
            ((QueryEmbed) result).setParent("parent", this);
            return result;
        }

        public Test.QueryName replace(String what, String withWhat) {
            doReplace(what, withWhat);
            var result = new TestQueryNameImpl();
            result.setParent(alias, this);
            return result;
        }

        public QuerySelectOperation sub(Sub sub) {
            return identifier("sub", sub);
        }

        public Sub.QueryName sub() {
            var result = EntityCreator.create(Sub.QueryName.class);
            ((QueryEmbed) result).setParent("sub", this);
            return result;
        }

        public Test.QueryName substring(int start) {
            doSubstring(start);
            var result = new TestQueryNameImpl();
            result.setParent(alias, this);
            return result;
        }

        public Test.QueryName substring(int start, int len) {
            doSubstring(start, len);
            var result = new TestQueryNameImpl();
            result.setParent(alias, this);
            return result;
        }

        public QuerySelectOperation title(String title) {
            return identifier("title", title);
        }

        public QueryFunctions title() {
            return identifier("title");
        }

        public Test.QueryName trim() {
            doTrim();
            var result = new TestQueryNameImpl();
            result.setParent(alias, this);
            return result;
        }

        public Test.QueryName upper() {
            doUpper();
            var result = new TestQueryNameImpl();
            result.setParent(alias, this);
            return result;
        }

        protected class TestQueryOrderImpl extends QueryOrderer implements Test.QueryOrder, Test.QueryAggregate {

            protected TestQueryOrderImpl(TestQueryExecutorImpl executor, Function<String, Object> func) {
                super(executor, func);
            }

            public QueryOrderOperation amount() {
                return (QueryOrderOperation) func.apply("amount");
            }

            public QueryOrderOperation parent() {
                return (QueryOrderOperation) func.apply("parent");
            }

            public QueryOrderOperation script(String script) {
                return (QueryOrderOperation) TestQueryExecutorImpl.this.script(script);
            }

            public QueryOrderOperation sub() {
                return (QueryOrderOperation) func.apply("sub");
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

        public Test.QueryName parent() {
            var result = EntityCreator.create(Test.QueryName.class);
            ((QueryEmbed) result).setParent("parent", executor);
            return result;
        }

        public QuerySelectOperation parent(Test parent) {
            return executor.identifier("parent", parent);
        }

        public Sub.QueryName sub() {
            var result = EntityCreator.create(Sub.QueryName.class);
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
}
