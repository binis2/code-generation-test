/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.spring.query.executor.QueryOrderer;
import net.binis.codegen.spring.query.executor.QueryExecutor;
import net.binis.codegen.spring.query.base.BaseQueryNameImpl;
import net.binis.codegen.spring.query.*;
import net.binis.codegen.modifier.impl.BaseModifierImpl;
import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.enums.TestEnum;
import net.binis.codegen.creator.EntityCreator;
import net.binis.codegen.collection.EmbeddedCodeSetImpl;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import net.binis.codegen.collection.CodeListImpl;
import net.binis.codegen.collection.CodeList;
import javax.annotation.processing.Generated;
import java.util.function.Function;
import java.util.Set;
import java.util.Optional;
import java.util.List;
import java.time.OffsetDateTime;

@Generated(value = "TestModifyPrototype", comments = "TestModify")
public class TestModifyImpl extends BaseImpl implements TestModify, MixModify, Modifiable<TestModify.Modify> {

    // region constants
    public static final String CONST = "const";

    private static final long serialVersionUID = -3805679893678082393L;
    // endregion

    protected double amount;

    protected List<Long> items;

    protected double mixInAmount;

    protected List<Long> mixInItems;

    protected Set<SubModify> mixInSubs;

    protected String mixInTitle;

    protected Set<SubModify> subs;

    protected String title;

    // region constructor & initializer
    {
        CodeFactory.registerType(TestModify.class, TestModifyImpl::new, null);
        CodeFactory.registerType(TestModify.QueryName.class, TestModifyQueryNameImpl::new, null);
        CodeFactory.registerType(TestModify.QuerySelect.class, TestModifyQueryExecutorImpl::new, null);
        CodeFactory.registerType(TestModify.QueryOperationFields.class, TestModifyQueryExecutorImpl::new, null);
        CodeFactory.registerType(MixModify.class, TestModifyImpl::new, null);
        CodeFactory.registerType(MixModify.QueryName.class, TestModifyQueryNameImpl::new, null);
        CodeFactory.registerType(MixModify.QuerySelect.class, MixModifyQueryExecutorImpl::new, null);
        CodeFactory.registerType(MixModify.QueryOperationFields.class, MixModifyQueryExecutorImpl::new, null);
    }

    public TestModifyImpl() {
        super();
    }
    // endregion

    // region getters
    public MixModify.Modify asMixModify() {
        return new MixModifyModifyImpl(this);
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
    // endregion

    // region setters
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
        return new TestModifyModifyImpl(this);
    }
    // endregion

    // region inner classes
    protected static class MixModifyFieldsQueryExecutorImpl extends MixModifyQueryExecutorImpl implements MixModify.QueryFieldsStart, EmbeddedFields {
    }

    protected class MixModifyModifyImpl extends BaseModifierImpl<MixModify.Modify, MixModify> implements MixModify.Modify {

        protected MixModifyModifyImpl(MixModify parent) {
            super(parent);
        }

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

        public CodeList items() {
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

        public CodeList mixInItems() {
            if (TestModifyImpl.this.mixInItems == null) {
                TestModifyImpl.this.mixInItems = new java.util.ArrayList<>();
            }
            return new CodeListImpl<>(this, TestModifyImpl.this.mixInItems);
        }

        public MixModify.Modify mixInSubs(Set<SubModify> mixInSubs) {
            TestModifyImpl.this.mixInSubs = mixInSubs;
            return this;
        }

        public EmbeddedCodeCollection mixInSubs() {
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

        public EmbeddedCodeCollection subs() {
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

    protected static class MixModifyQueryExecutorImpl extends QueryExecutor implements MixModify.QueryUpdate, MixModify.QuerySelect, MixModify.QueryFieldsStart {

        protected MixModifyQueryExecutorImpl() {
            super(MixModify.class, () -> new TestModifyQueryNameImpl(), parent -> parent);
        }

        public QueryAggregateOperation aggregate() {
            return (QueryAggregateOperation) aggregateStart(new MixModifyQueryOrderImpl(this, MixModifyQueryExecutorImpl.this::aggregateIdentifier));
        }

        public QuerySelectOperation amount(double amount) {
            return identifier("amount", amount);
        }

        public QueryFunctions amount() {
            return identifier("amount");
        }

        public QuerySelectOperation date(OffsetDateTime date) {
            return identifier("date", date);
        }

        public QueryFunctions date() {
            return identifier("date");
        }

        public QuerySelectOperation id(Long id) {
            return identifier("id", id);
        }

        public QueryFunctions id() {
            return identifier("id");
        }

        public QueryCollectionFunctions items() {
            return identifier("items");
        }

        public QuerySelectOperation mixInAmount(double mixInAmount) {
            return identifier("mixInAmount", mixInAmount);
        }

        public QueryFunctions mixInAmount() {
            return identifier("mixInAmount");
        }

        public QueryCollectionFunctions mixInItems() {
            return identifier("mixInItems");
        }

        public QueryJoinCollectionFunctions mixInSubs() {
            return (QueryJoinCollectionFunctions) joinStart("mixInSubs", SubModify.QueryOrder.class);
        }

        public QuerySelectOperation mixInTitle(String mixInTitle) {
            return identifier("mixInTitle", mixInTitle);
        }

        public QueryFunctions mixInTitle() {
            return identifier("mixInTitle");
        }

        public MixModify.QueryOrder order() {
            return (MixModify.QueryOrder) orderStart(new MixModifyQueryOrderImpl(this, MixModifyQueryExecutorImpl.this::orderIdentifier));
        }

        public QueryJoinCollectionFunctions subs() {
            return (QueryJoinCollectionFunctions) joinStart("subs", SubModify.QueryOrder.class);
        }

        public QuerySelectOperation title(String title) {
            return identifier("title", title);
        }

        public QueryFunctions title() {
            return identifier("title");
        }

        public QuerySelectOperation type(TestEnum type) {
            return identifier("type", type);
        }

        public QueryFunctions type() {
            return identifier("type");
        }

        protected class MixModifyQueryOrderImpl extends QueryOrderer implements MixModify.QueryOrder, MixModify.QueryAggregate {

            protected MixModifyQueryOrderImpl(MixModifyQueryExecutorImpl executor, Function<String, Object> func) {
                super(executor, func);
            }

            public QueryOrderOperation amount() {
                return (QueryOrderOperation) func.apply("amount");
            }

            public QueryOrderOperation date() {
                return (QueryOrderOperation) func.apply("date");
            }

            public QueryOrderOperation id() {
                return (QueryOrderOperation) func.apply("id");
            }

            public QueryOrderOperation mixInAmount() {
                return (QueryOrderOperation) func.apply("mixInAmount");
            }

            public QueryOrderOperation mixInTitle() {
                return (QueryOrderOperation) func.apply("mixInTitle");
            }

            public QueryOrderOperation title() {
                return (QueryOrderOperation) func.apply("title");
            }

            public QueryOrderOperation type() {
                return (QueryOrderOperation) func.apply("type");
            }
        }
    }

    protected static class MixModifySelectQueryExecutorImpl extends MixModifyQueryExecutorImpl implements MixModify.QuerySelect {
    }

    protected class TestModifyModifyImpl extends BaseModifierImpl<TestModify.Modify, TestModify> implements TestModify.Modify {

        protected TestModifyModifyImpl(TestModify parent) {
            super(parent);
        }

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

        public CodeList items() {
            if (TestModifyImpl.this.items == null) {
                TestModifyImpl.this.items = new java.util.ArrayList<>();
            }
            return new CodeListImpl<>(this, TestModifyImpl.this.items);
        }

        public TestModify.Modify subs(Set<SubModify> subs) {
            TestModifyImpl.this.subs = subs;
            return this;
        }

        public EmbeddedCodeCollection subs() {
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

    protected static class TestModifyQueryExecutorImpl extends QueryExecutor implements TestModify.QueryUpdate, TestModify.QuerySelect, TestModify.QueryFieldsStart {

        protected TestModifyQueryExecutorImpl() {
            super(TestModify.class, () -> new TestModifyQueryNameImpl(), parent -> parent);
        }

        public QueryAggregateOperation aggregate() {
            return (QueryAggregateOperation) aggregateStart(new TestModifyQueryOrderImpl(this, TestModifyQueryExecutorImpl.this::aggregateIdentifier));
        }

        public QuerySelectOperation amount(double amount) {
            return identifier("amount", amount);
        }

        public QueryFunctions amount() {
            return identifier("amount");
        }

        public QuerySelectOperation date(OffsetDateTime date) {
            return identifier("date", date);
        }

        public QueryFunctions date() {
            return identifier("date");
        }

        public QuerySelectOperation id(Long id) {
            return identifier("id", id);
        }

        public QueryFunctions id() {
            return identifier("id");
        }

        public QueryCollectionFunctions items() {
            return identifier("items");
        }

        public TestModify.QueryOrder order() {
            return (TestModify.QueryOrder) orderStart(new TestModifyQueryOrderImpl(this, TestModifyQueryExecutorImpl.this::orderIdentifier));
        }

        public QueryJoinCollectionFunctions subs() {
            return (QueryJoinCollectionFunctions) joinStart("subs", SubModify.QueryOrder.class);
        }

        public QuerySelectOperation title(String title) {
            return identifier("title", title);
        }

        public QueryFunctions title() {
            return identifier("title");
        }

        public QuerySelectOperation type(TestEnum type) {
            return identifier("type", type);
        }

        public QueryFunctions type() {
            return identifier("type");
        }

        protected class TestModifyQueryOrderImpl extends QueryOrderer implements TestModify.QueryOrder, TestModify.QueryAggregate {

            protected TestModifyQueryOrderImpl(TestModifyQueryExecutorImpl executor, Function<String, Object> func) {
                super(executor, func);
            }

            public QueryOrderOperation amount() {
                return (QueryOrderOperation) func.apply("amount");
            }

            public QueryOrderOperation date() {
                return (QueryOrderOperation) func.apply("date");
            }

            public QueryOrderOperation id() {
                return (QueryOrderOperation) func.apply("id");
            }

            public QueryOrderOperation title() {
                return (QueryOrderOperation) func.apply("title");
            }

            public QueryOrderOperation type() {
                return (QueryOrderOperation) func.apply("type");
            }
        }
    }

    protected static class TestModifyQueryNameImpl extends BaseQueryNameImpl implements TestModify.QueryName, QueryEmbed, MixModify.QueryName {

        public QueryFunctions amount() {
            return executor.identifier("amount");
        }

        public QuerySelectOperation amount(double amount) {
            return executor.identifier("amount", amount);
        }

        public QueryFunctions date() {
            return executor.identifier("date");
        }

        public QuerySelectOperation date(OffsetDateTime date) {
            return executor.identifier("date", date);
        }

        public QueryFunctions id() {
            return executor.identifier("id");
        }

        public QuerySelectOperation id(Long id) {
            return executor.identifier("id", id);
        }

        public QueryFunctions mixInAmount() {
            return executor.identifier("mixInAmount");
        }

        public QuerySelectOperation mixInAmount(double mixInAmount) {
            return executor.identifier("mixInAmount", mixInAmount);
        }

        public QueryFunctions mixInTitle() {
            return executor.identifier("mixInTitle");
        }

        public QuerySelectOperation mixInTitle(String mixInTitle) {
            return executor.identifier("mixInTitle", mixInTitle);
        }

        public QueryFunctions title() {
            return executor.identifier("title");
        }

        public QuerySelectOperation title(String title) {
            return executor.identifier("title", title);
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
