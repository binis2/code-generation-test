/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.spring.query.executor.QueryOrderer;
import net.binis.codegen.spring.query.executor.QueryExecutor;
import net.binis.codegen.spring.query.base.BaseQueryNameImpl;
import net.binis.codegen.spring.query.*;
import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.enums.TestEnum;
import net.binis.codegen.creator.EntityCreator;
import net.binis.codegen.collection.EmbeddedCodeSetImpl;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import net.binis.codegen.collection.CodeListImpl;
import net.binis.codegen.collection.CodeList;
import java.util.function.Function;
import java.util.Set;
import java.util.Optional;
import java.util.List;
import java.time.OffsetDateTime;

public class TestModifyImpl extends BaseImpl implements TestModify, MixModify, Modifiable<TestModify.Modify> {

    protected double amount;

    protected List<Long> items;

    protected double mixInAmount;

    protected List<Long> mixInItems;

    protected Set<SubModify> mixInSubs;

    protected String mixInTitle;

    protected Set<SubModify> subs;

    protected String title;

    {
        CodeFactory.registerType(TestModify.QuerySelect.class, TestModifyQueryExecutorImpl::new, null);
        CodeFactory.registerType(TestModify.class, TestModifyImpl::new, null);
        CodeFactory.registerType(TestModify.QueryName.class, TestModifyQueryNameImpl::new, null);
        CodeFactory.registerType(MixModify.QuerySelect.class, MixModifyQueryExecutorImpl::new, null);
        CodeFactory.registerType(MixModify.class, TestModifyImpl::new, null);
        CodeFactory.registerType(MixModify.QueryName.class, TestModifyQueryNameImpl::new, null);
    }

    public TestModifyImpl() {
        super();
    }

    public MixModify.Modify asMixModify() {
        return new MixModifyModifyImpl();
    }

    public double getAmount() {
        return amount;
    }

    public List<Long> getItems() {
        return items;
    }

    public double getMixInAmount() {
        return mixInAmount;
    }

    public List<Long> getMixInItems() {
        return mixInItems;
    }

    public Set<SubModify> getMixInSubs() {
        return mixInSubs;
    }

    public String getMixInTitle() {
        return mixInTitle;
    }

    public Set<SubModify> getSubs() {
        return subs;
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

    public void setMixInAmount(double mixInAmount) {
        this.mixInAmount = mixInAmount;
    }

    public void setMixInItems(List<Long> mixInItems) {
        this.mixInItems = mixInItems;
    }

    public void setMixInSubs(Set<SubModify> mixInSubs) {
        this.mixInSubs = mixInSubs;
    }

    public void setMixInTitle(String mixInTitle) {
        this.mixInTitle = mixInTitle;
    }

    public void setSubs(Set<SubModify> subs) {
        this.subs = subs;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TestModify.Modify with() {
        return new TestModifyModifyImpl();
    }

    protected class MixModifyModifyImpl implements MixModify.Modify {

        public MixModify.Modify amount(double amount) {
            TestModifyImpl.this.amount = amount;
            return this;
        }

        public MixModify.Modify date(OffsetDateTime date) {
            TestModifyImpl.this.date = date;
            return this;
        }

        public MixModify done() {
            return TestModifyImpl.this;
        }

        public MixModify.Modify id(Long id) {
            TestModifyImpl.this.id = id;
            return this;
        }

        public MixModify.Modify items(List<Long> items) {
            TestModifyImpl.this.items = items;
            return this;
        }

        public CodeList<Long, MixModify.Modify> items() {
            if (TestModifyImpl.this.items == null) {
                TestModifyImpl.this.items = new java.util.ArrayList<>();
            }
            return new CodeListImpl<>(this, TestModifyImpl.this.items);
        }

        public MixModify.Modify mixInAmount(double mixInAmount) {
            TestModifyImpl.this.mixInAmount = mixInAmount;
            return this;
        }

        public MixModify.Modify mixInItems(List<Long> mixInItems) {
            TestModifyImpl.this.mixInItems = mixInItems;
            return this;
        }

        public CodeList<Long, MixModify.Modify> mixInItems() {
            if (TestModifyImpl.this.mixInItems == null) {
                TestModifyImpl.this.mixInItems = new java.util.ArrayList<>();
            }
            return new CodeListImpl<>(this, TestModifyImpl.this.mixInItems);
        }

        public MixModify.Modify mixInSubs(Set<SubModify> mixInSubs) {
            TestModifyImpl.this.mixInSubs = mixInSubs;
            return this;
        }

        public EmbeddedCodeCollection<SubModify.EmbeddedModify<SubModify.Modify>, SubModify, MixModify.Modify> mixInSubs() {
            if (TestModifyImpl.this.mixInSubs == null) {
                TestModifyImpl.this.mixInSubs = new java.util.HashSet<>();
            }
            return new EmbeddedCodeSetImpl<>(this, TestModifyImpl.this.mixInSubs, SubModify.class);
        }

        public MixModify.Modify mixInTitle(String mixInTitle) {
            TestModifyImpl.this.mixInTitle = mixInTitle;
            return this;
        }

        public MixModify.Modify subs(Set<SubModify> subs) {
            TestModifyImpl.this.subs = subs;
            return this;
        }

        public EmbeddedCodeCollection<SubModify.EmbeddedModify<SubModify.Modify>, SubModify, MixModify.Modify> subs() {
            if (TestModifyImpl.this.subs == null) {
                TestModifyImpl.this.subs = new java.util.HashSet<>();
            }
            return new EmbeddedCodeSetImpl<>(this, TestModifyImpl.this.subs, SubModify.class);
        }

        public MixModify.Modify title(String title) {
            TestModifyImpl.this.title = title;
            return this;
        }

        public MixModify.Modify type(TestEnum type) {
            TestModifyImpl.this.type = type;
            return this;
        }
    }

    protected static class MixModifyQueryExecutorImpl<QR> extends QueryExecutor<Object, MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR, QueryAggregateOperation> implements MixModify.QuerySelect<QR> {

        protected MixModifyQueryExecutorImpl() {
            super(MixModify.class);
        }

        public QueryAggregateOperation aggregate() {
            return aggregateStart(new MixModifyQueryOrderImpl<>(this, MixModifyQueryExecutorImpl.this::aggregateIdentifier));
        }

        public QuerySelectOperation<MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR> amount(double amount) {
            return identifier("amount", amount);
        }

        public QueryFunctions<Double, QuerySelectOperation<MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR>> amount() {
            return (QueryFunctions) identifier("amount");
        }

        public QuerySelectOperation<MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR> date(OffsetDateTime date) {
            return identifier("date", date);
        }

        public QueryFunctions<OffsetDateTime, QuerySelectOperation<MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR>> date() {
            return (QueryFunctions) identifier("date");
        }

        public QuerySelectOperation<MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR> id(Long id) {
            return identifier("id", id);
        }

        public QueryFunctions<Long, QuerySelectOperation<MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR>> id() {
            return (QueryFunctions) identifier("id");
        }

        public QueryCollectionFunctions<Long, QuerySelectOperation<MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR>> items() {
            return (QueryCollectionFunctions) identifier("items");
        }

        public MixModify.QueryName<MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR> lower() {
            doLower();
            var result = new TestModifyQueryNameImpl<>();
            result.setParent(alias, this);
            return (MixModify.QueryName) result;
        }

        public QuerySelectOperation<MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR> mixInAmount(double mixInAmount) {
            return identifier("mixInAmount", mixInAmount);
        }

        public QueryFunctions<Double, QuerySelectOperation<MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR>> mixInAmount() {
            return (QueryFunctions) identifier("mixInAmount");
        }

        public QueryCollectionFunctions<Long, QuerySelectOperation<MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR>> mixInItems() {
            return (QueryCollectionFunctions) identifier("mixInItems");
        }

        public QueryCollectionFunctions<SubModify, QuerySelectOperation<MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR>> mixInSubs() {
            return (QueryCollectionFunctions) identifier("mixInSubs");
        }

        public QuerySelectOperation<MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR> mixInTitle(String mixInTitle) {
            return identifier("mixInTitle", mixInTitle);
        }

        public QueryFunctions<String, QuerySelectOperation<MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR>> mixInTitle() {
            return (QueryFunctions) identifier("mixInTitle");
        }

        public MixModify.QueryName<MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR> not() {
            doNot();
            var result = new TestModifyQueryNameImpl<>();
            result.setParent(alias, this);
            return (MixModify.QueryName) result;
        }

        public MixModify.QueryOrder<QR> order() {
            return orderStart(new MixModifyQueryOrderImpl<>(this, MixModifyQueryExecutorImpl.this::orderIdentifier));
        }

        public MixModify.QueryName<MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR> replace(String what, String withWhat) {
            doReplace(what, withWhat);
            var result = new TestModifyQueryNameImpl<>();
            result.setParent(alias, this);
            return (MixModify.QueryName) result;
        }

        public QueryCollectionFunctions<SubModify, QuerySelectOperation<MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR>> subs() {
            return (QueryCollectionFunctions) identifier("subs");
        }

        public MixModify.QueryName<MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR> substring(int start) {
            doSubstring(start);
            var result = new TestModifyQueryNameImpl<>();
            result.setParent(alias, this);
            return (MixModify.QueryName) result;
        }

        public MixModify.QueryName<MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR> substring(int start, int len) {
            doSubstring(start, len);
            var result = new TestModifyQueryNameImpl<>();
            result.setParent(alias, this);
            return (MixModify.QueryName) result;
        }

        public QuerySelectOperation<MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR> title(String title) {
            return identifier("title", title);
        }

        public QueryFunctions<String, QuerySelectOperation<MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR>> title() {
            return (QueryFunctions) identifier("title");
        }

        public MixModify.QueryName<MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR> trim() {
            doTrim();
            var result = new TestModifyQueryNameImpl<>();
            result.setParent(alias, this);
            return (MixModify.QueryName) result;
        }

        public QuerySelectOperation<MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR> type(TestEnum type) {
            return identifier("type", type);
        }

        public QueryFunctions<TestEnum, QuerySelectOperation<MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR>> type() {
            return (QueryFunctions) identifier("type");
        }

        public MixModify.QueryName<MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR> upper() {
            doUpper();
            var result = new TestModifyQueryNameImpl<>();
            result.setParent(alias, this);
            return (MixModify.QueryName) result;
        }

        protected class MixModifyQueryOrderImpl<QR> extends QueryOrderer<QR> implements MixModify.QueryOrder<QR>, MixModify.QueryAggregate<QR, Object> {

            protected MixModifyQueryOrderImpl(MixModifyQueryExecutorImpl executor, Function<String, Object> func) {
                super(executor, func);
            }

            public QueryOrderOperation<MixModify.QueryOrder<QR>, QR> amount() {
                return (QueryOrderOperation) func.apply("amount");
            }

            public QueryOrderOperation<MixModify.QueryOrder<QR>, QR> date() {
                return (QueryOrderOperation) func.apply("date");
            }

            public QueryOrderOperation<MixModify.QueryOrder<QR>, QR> id() {
                return (QueryOrderOperation) func.apply("id");
            }

            public QueryOrderOperation<MixModify.QueryOrder<QR>, QR> mixInAmount() {
                return (QueryOrderOperation) func.apply("mixInAmount");
            }

            public QueryOrderOperation<MixModify.QueryOrder<QR>, QR> mixInTitle() {
                return (QueryOrderOperation) func.apply("mixInTitle");
            }

            public QueryOrderOperation<MixModify.QueryOrder<QR>, QR> script(String script) {
                return (QueryOrderOperation) MixModifyQueryExecutorImpl.this.script(script);
            }

            public QueryOrderOperation<MixModify.QueryOrder<QR>, QR> title() {
                return (QueryOrderOperation) func.apply("title");
            }

            public QueryOrderOperation<MixModify.QueryOrder<QR>, QR> type() {
                return (QueryOrderOperation) func.apply("type");
            }
        }
    }

    protected class TestModifyModifyImpl implements TestModify.Modify {

        public TestModify.Modify amount(double amount) {
            TestModifyImpl.this.amount = amount;
            return this;
        }

        public TestModify.Modify date(OffsetDateTime date) {
            TestModifyImpl.this.date = date;
            return this;
        }

        public TestModify done() {
            return TestModifyImpl.this;
        }

        public TestModify.Modify id(Long id) {
            TestModifyImpl.this.id = id;
            return this;
        }

        public TestModify.Modify items(List<Long> items) {
            TestModifyImpl.this.items = items;
            return this;
        }

        public CodeList<Long, TestModify.Modify> items() {
            if (TestModifyImpl.this.items == null) {
                TestModifyImpl.this.items = new java.util.ArrayList<>();
            }
            return new CodeListImpl<>(this, TestModifyImpl.this.items);
        }

        public TestModify.Modify subs(Set<SubModify> subs) {
            TestModifyImpl.this.subs = subs;
            return this;
        }

        public EmbeddedCodeCollection<SubModify.EmbeddedModify<SubModify.Modify>, SubModify, TestModify.Modify> subs() {
            if (TestModifyImpl.this.subs == null) {
                TestModifyImpl.this.subs = new java.util.HashSet<>();
            }
            return new EmbeddedCodeSetImpl<>(this, TestModifyImpl.this.subs, SubModify.class);
        }

        public TestModify.Modify title(String title) {
            TestModifyImpl.this.title = title;
            return this;
        }

        public TestModify.Modify type(TestEnum type) {
            TestModifyImpl.this.type = type;
            return this;
        }
    }

    protected static class TestModifyQueryExecutorImpl<QR> extends QueryExecutor<Object, TestModify.QuerySelect<QR>, TestModify.QueryOrder<QR>, QR, QueryAggregateOperation> implements TestModify.QuerySelect<QR> {

        protected TestModifyQueryExecutorImpl() {
            super(TestModify.class);
        }

        public QueryAggregateOperation aggregate() {
            return aggregateStart(new TestModifyQueryOrderImpl<>(this, TestModifyQueryExecutorImpl.this::aggregateIdentifier));
        }

        public QuerySelectOperation<TestModify.QuerySelect<QR>, TestModify.QueryOrder<QR>, QR> amount(double amount) {
            return identifier("amount", amount);
        }

        public QueryFunctions<Double, QuerySelectOperation<TestModify.QuerySelect<QR>, TestModify.QueryOrder<QR>, QR>> amount() {
            return (QueryFunctions) identifier("amount");
        }

        public QuerySelectOperation<TestModify.QuerySelect<QR>, TestModify.QueryOrder<QR>, QR> date(OffsetDateTime date) {
            return identifier("date", date);
        }

        public QueryFunctions<OffsetDateTime, QuerySelectOperation<TestModify.QuerySelect<QR>, TestModify.QueryOrder<QR>, QR>> date() {
            return (QueryFunctions) identifier("date");
        }

        public QuerySelectOperation<TestModify.QuerySelect<QR>, TestModify.QueryOrder<QR>, QR> id(Long id) {
            return identifier("id", id);
        }

        public QueryFunctions<Long, QuerySelectOperation<TestModify.QuerySelect<QR>, TestModify.QueryOrder<QR>, QR>> id() {
            return (QueryFunctions) identifier("id");
        }

        public QueryCollectionFunctions<Long, QuerySelectOperation<TestModify.QuerySelect<QR>, TestModify.QueryOrder<QR>, QR>> items() {
            return (QueryCollectionFunctions) identifier("items");
        }

        public TestModify.QueryName<TestModify.QuerySelect<QR>, TestModify.QueryOrder<QR>, QR> lower() {
            doLower();
            var result = new TestModifyQueryNameImpl<>();
            result.setParent(alias, this);
            return (TestModify.QueryName) result;
        }

        public TestModify.QueryName<TestModify.QuerySelect<QR>, TestModify.QueryOrder<QR>, QR> not() {
            doNot();
            var result = new TestModifyQueryNameImpl<>();
            result.setParent(alias, this);
            return (TestModify.QueryName) result;
        }

        public TestModify.QueryOrder<QR> order() {
            return orderStart(new TestModifyQueryOrderImpl<>(this, TestModifyQueryExecutorImpl.this::orderIdentifier));
        }

        public TestModify.QueryName<TestModify.QuerySelect<QR>, TestModify.QueryOrder<QR>, QR> replace(String what, String withWhat) {
            doReplace(what, withWhat);
            var result = new TestModifyQueryNameImpl<>();
            result.setParent(alias, this);
            return (TestModify.QueryName) result;
        }

        public QueryCollectionFunctions<SubModify, QuerySelectOperation<TestModify.QuerySelect<QR>, TestModify.QueryOrder<QR>, QR>> subs() {
            return (QueryCollectionFunctions) identifier("subs");
        }

        public TestModify.QueryName<TestModify.QuerySelect<QR>, TestModify.QueryOrder<QR>, QR> substring(int start) {
            doSubstring(start);
            var result = new TestModifyQueryNameImpl<>();
            result.setParent(alias, this);
            return (TestModify.QueryName) result;
        }

        public TestModify.QueryName<TestModify.QuerySelect<QR>, TestModify.QueryOrder<QR>, QR> substring(int start, int len) {
            doSubstring(start, len);
            var result = new TestModifyQueryNameImpl<>();
            result.setParent(alias, this);
            return (TestModify.QueryName) result;
        }

        public QuerySelectOperation<TestModify.QuerySelect<QR>, TestModify.QueryOrder<QR>, QR> title(String title) {
            return identifier("title", title);
        }

        public QueryFunctions<String, QuerySelectOperation<TestModify.QuerySelect<QR>, TestModify.QueryOrder<QR>, QR>> title() {
            return (QueryFunctions) identifier("title");
        }

        public TestModify.QueryName<TestModify.QuerySelect<QR>, TestModify.QueryOrder<QR>, QR> trim() {
            doTrim();
            var result = new TestModifyQueryNameImpl<>();
            result.setParent(alias, this);
            return (TestModify.QueryName) result;
        }

        public QuerySelectOperation<TestModify.QuerySelect<QR>, TestModify.QueryOrder<QR>, QR> type(TestEnum type) {
            return identifier("type", type);
        }

        public QueryFunctions<TestEnum, QuerySelectOperation<TestModify.QuerySelect<QR>, TestModify.QueryOrder<QR>, QR>> type() {
            return (QueryFunctions) identifier("type");
        }

        public TestModify.QueryName<TestModify.QuerySelect<QR>, TestModify.QueryOrder<QR>, QR> upper() {
            doUpper();
            var result = new TestModifyQueryNameImpl<>();
            result.setParent(alias, this);
            return (TestModify.QueryName) result;
        }

        protected class TestModifyQueryOrderImpl<QR> extends QueryOrderer<QR> implements TestModify.QueryOrder<QR>, TestModify.QueryAggregate<QR, Object> {

            protected TestModifyQueryOrderImpl(TestModifyQueryExecutorImpl executor, Function<String, Object> func) {
                super(executor, func);
            }

            public QueryOrderOperation<TestModify.QueryOrder<QR>, QR> amount() {
                return (QueryOrderOperation) func.apply("amount");
            }

            public QueryOrderOperation<TestModify.QueryOrder<QR>, QR> date() {
                return (QueryOrderOperation) func.apply("date");
            }

            public QueryOrderOperation<TestModify.QueryOrder<QR>, QR> id() {
                return (QueryOrderOperation) func.apply("id");
            }

            public QueryOrderOperation<TestModify.QueryOrder<QR>, QR> script(String script) {
                return (QueryOrderOperation) TestModifyQueryExecutorImpl.this.script(script);
            }

            public QueryOrderOperation<TestModify.QueryOrder<QR>, QR> title() {
                return (QueryOrderOperation) func.apply("title");
            }

            public QueryOrderOperation<TestModify.QueryOrder<QR>, QR> type() {
                return (QueryOrderOperation) func.apply("type");
            }
        }
    }

    protected static class TestModifyQueryNameImpl<QS, QO, QR> extends BaseQueryNameImpl<QuerySelectOperation<QS, QO, QR>> implements TestModify.QueryName<QS, QO, QR>, QueryEmbed, MixModify.QueryName<QS, QO, QR> {

        public QueryFunctions<Double, QuerySelectOperation<QS, QO, QR>> amount() {
            return (QueryFunctions) executor.identifier("amount");
        }

        public QuerySelectOperation<QS, QO, QR> amount(double amount) {
            return (QuerySelectOperation) executor.identifier("amount", amount);
        }

        public QueryFunctions<OffsetDateTime, QuerySelectOperation<QS, QO, QR>> date() {
            return (QueryFunctions) executor.identifier("date");
        }

        public QuerySelectOperation<QS, QO, QR> date(OffsetDateTime date) {
            return (QuerySelectOperation) executor.identifier("date", date);
        }

        public QueryFunctions<Long, QuerySelectOperation<QS, QO, QR>> id() {
            return (QueryFunctions) executor.identifier("id");
        }

        public QuerySelectOperation<QS, QO, QR> id(Long id) {
            return (QuerySelectOperation) executor.identifier("id", id);
        }

        public QueryFunctions<Double, QuerySelectOperation<QS, QO, QR>> mixInAmount() {
            return (QueryFunctions) executor.identifier("mixInAmount");
        }

        public QuerySelectOperation<QS, QO, QR> mixInAmount(double mixInAmount) {
            return (QuerySelectOperation) executor.identifier("mixInAmount", mixInAmount);
        }

        public QueryFunctions<String, QuerySelectOperation<QS, QO, QR>> mixInTitle() {
            return (QueryFunctions) executor.identifier("mixInTitle");
        }

        public QuerySelectOperation<QS, QO, QR> mixInTitle(String mixInTitle) {
            return (QuerySelectOperation) executor.identifier("mixInTitle", mixInTitle);
        }

        public QueryFunctions<String, QuerySelectOperation<QS, QO, QR>> title() {
            return (QueryFunctions) executor.identifier("title");
        }

        public QuerySelectOperation<QS, QO, QR> title(String title) {
            return (QuerySelectOperation) executor.identifier("title", title);
        }

        public QueryFunctions<TestEnum, QuerySelectOperation<QS, QO, QR>> type() {
            return (QueryFunctions) executor.identifier("type");
        }

        public QuerySelectOperation<QS, QO, QR> type(TestEnum type) {
            return (QuerySelectOperation) executor.identifier("type", type);
        }
    }
}
