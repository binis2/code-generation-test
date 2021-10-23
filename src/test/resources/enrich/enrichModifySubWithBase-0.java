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
import net.binis.codegen.collection.EmbeddedCodeCollection;
import javax.persistence.Transient;
import javax.annotation.processing.Generated;
import java.util.function.Function;
import java.util.Optional;
import java.util.List;
import java.time.OffsetDateTime;

@Generated(value = "SubModifyPrototype", comments = "SubModify")
public class SubModifyImpl extends BaseImpl implements SubModify, Modifiable<SubModify.Modify> {

    protected double subAmount;

    protected String subtitle;

    @Transient
    protected Object tag;

    {
        CodeFactory.registerType(SubModify.QuerySelect.class, SubModifyQueryExecutorImpl::new, null);
        CodeFactory.registerType(SubModify.class, SubModifyImpl::new, (p, v) -> new EmbeddedSubModifyModifyImpl<>(p, (SubModifyImpl) v));
        CodeFactory.registerType(SubModify.QueryName.class, SubModifyQueryNameImpl::new, null);
        CodeFactory.registerType(SubModify.QueryOrder.class, () -> SubModify.find().aggregate(), null);
    }

    public SubModifyImpl() {
        super();
    }

    public double getSubAmount() {
        return subAmount;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public Object getTag() {
        return tag;
    }

    public void setSubAmount(double subAmount) {
        this.subAmount = subAmount;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setTag(Object tag) {
        this.tag = tag;
    }

    public SubModify.Modify with() {
        return new SubModifyModifyImpl();
    }

    protected static class EmbeddedSubModifyModifyImpl<T> implements SubModify.EmbeddedModify<T> {

        protected SubModifyImpl entity;

        protected T parent;

        protected EmbeddedSubModifyModifyImpl(T parent, SubModifyImpl entity) {
            this.parent = parent;
            this.entity = entity;
        }

        public EmbeddedCodeCollection<SubModify.EmbeddedModify<T>, SubModify, T> and() {
            return (EmbeddedCodeCollection) parent;
        }

        public SubModify.EmbeddedModify<T> date(OffsetDateTime date) {
            entity.date = date;
            return this;
        }

        public SubModify.EmbeddedModify<T> id(Long id) {
            entity.id = id;
            return this;
        }

        public SubModify.EmbeddedModify<T> subAmount(double subAmount) {
            entity.subAmount = subAmount;
            return this;
        }

        public SubModify.EmbeddedModify<T> subtitle(String subtitle) {
            entity.subtitle = subtitle;
            return this;
        }

        public SubModify.EmbeddedModify<T> tag(Object tag) {
            entity.tag = tag;
            return this;
        }

        public SubModify.EmbeddedModify<T> type(TestEnum type) {
            entity.type = type;
            return this;
        }
    }

    protected class SubModifyModifyImpl implements SubModify.Modify {

        public SubModify.Modify date(OffsetDateTime date) {
            SubModifyImpl.this.date = date;
            return this;
        }

        public SubModify done() {
            return SubModifyImpl.this;
        }

        public SubModify.Modify id(Long id) {
            SubModifyImpl.this.id = id;
            return this;
        }

        public SubModify.Modify subAmount(double subAmount) {
            SubModifyImpl.this.subAmount = subAmount;
            return this;
        }

        public SubModify.Modify subtitle(String subtitle) {
            SubModifyImpl.this.subtitle = subtitle;
            return this;
        }

        public SubModify.Modify tag(Object tag) {
            SubModifyImpl.this.tag = tag;
            return this;
        }

        public SubModify.Modify type(TestEnum type) {
            SubModifyImpl.this.type = type;
            return this;
        }
    }

    protected static class SubModifyQueryExecutorImpl extends QueryExecutor implements SubModify.QuerySelect, SubModify.QueryFieldsStart {

        protected SubModifyQueryExecutorImpl() {
            super(SubModify.class, () -> new SubModifyQueryNameImpl());
        }

        public QueryAggregateOperation aggregate() {
            return (QueryAggregateOperation) aggregateStart(new SubModifyQueryOrderImpl(this, SubModifyQueryExecutorImpl.this::aggregateIdentifier));
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

        public SubModify.QueryOrder order() {
            return (SubModify.QueryOrder) orderStart(new SubModifyQueryOrderImpl(this, SubModifyQueryExecutorImpl.this::orderIdentifier));
        }

        public QuerySelectOperation subAmount(double subAmount) {
            return identifier("subAmount", subAmount);
        }

        public QueryFunctions subAmount() {
            return identifier("subAmount");
        }

        public QuerySelectOperation subtitle(String subtitle) {
            return identifier("subtitle", subtitle);
        }

        public QueryFunctions subtitle() {
            return identifier("subtitle");
        }

        public QuerySelectOperation tag(Object tag) {
            return identifier("tag", tag);
        }

        public QuerySelectOperation type(TestEnum type) {
            return identifier("type", type);
        }

        public QueryFunctions type() {
            return identifier("type");
        }

        protected class SubModifyQueryOrderImpl extends QueryOrderer implements SubModify.QueryOrder, SubModify.QueryAggregate {

            protected SubModifyQueryOrderImpl(SubModifyQueryExecutorImpl executor, Function<String, Object> func) {
                super(executor, func);
            }

            public QueryOrderOperation date() {
                return (QueryOrderOperation) func.apply("date");
            }

            public QueryOrderOperation id() {
                return (QueryOrderOperation) func.apply("id");
            }

            public QueryOrderOperation subAmount() {
                return (QueryOrderOperation) func.apply("subAmount");
            }

            public QueryOrderOperation subtitle() {
                return (QueryOrderOperation) func.apply("subtitle");
            }

            public QueryOrderOperation type() {
                return (QueryOrderOperation) func.apply("type");
            }
        }
    }

    protected static class SubModifyQueryNameImpl extends BaseQueryNameImpl implements SubModify.QueryName, QueryEmbed {

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

        public QueryFunctions subAmount() {
            return executor.identifier("subAmount");
        }

        public QuerySelectOperation subAmount(double subAmount) {
            return executor.identifier("subAmount", subAmount);
        }

        public QueryFunctions subtitle() {
            return executor.identifier("subtitle");
        }

        public QuerySelectOperation subtitle(String subtitle) {
            return executor.identifier("subtitle", subtitle);
        }

        public QuerySelectOperation tag(Object tag) {
            return executor.identifier("tag", tag);
        }

        public QueryFunctions type() {
            return executor.identifier("type");
        }

        public QuerySelectOperation type(TestEnum type) {
            return executor.identifier("type", type);
        }
    }
}
