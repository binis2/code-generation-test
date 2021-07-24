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
import java.util.function.Function;
import java.util.Optional;
import java.util.List;
import java.time.OffsetDateTime;

public class SubModifyImpl extends BaseImpl implements SubModify, Modifiable<SubModify.Modify> {

    protected double subAmount;

    protected String subtitle;

    {
        CodeFactory.registerType(SubModify.QuerySelect.class, SubModifyQueryExecutorImpl::new, null);
        CodeFactory.registerType(SubModify.class, SubModifyImpl::new, null);
        CodeFactory.registerType(SubModify.QueryOrder.class, () -> SubModify.find().aggregate(), null);
        CodeFactory.registerType(SubModify.QueryName.class, SubModifyQueryNameImpl::new, null);
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

    public void setSubAmount(double subAmount) {
        this.subAmount = subAmount;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
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

        public SubModify.Modify type(TestEnum type) {
            SubModifyImpl.this.type = type;
            return this;
        }
    }

    protected static class SubModifyQueryExecutorImpl<QR> extends QueryExecutor<Object, SubModify.QuerySelect<QR>, SubModify.QueryOrder<QR>, QR, QueryAggregateOperation> implements SubModify.QuerySelect<QR> {

        protected SubModifyQueryExecutorImpl() {
            super(SubModify.class);
        }

        public QueryAggregateOperation aggregate() {
            return aggregateStart(new SubModifyQueryOrderImpl<>(this, SubModifyQueryExecutorImpl.this::aggregateIdentifier));
        }

        public QuerySelectOperation<SubModify.QuerySelect<QR>, SubModify.QueryOrder<QR>, QR> date(OffsetDateTime date) {
            return identifier("date", date);
        }

        public QueryFunctions<OffsetDateTime, QuerySelectOperation<SubModify.QuerySelect<QR>, SubModify.QueryOrder<QR>, QR>> date() {
            return (QueryFunctions) identifier("date");
        }

        public QuerySelectOperation<SubModify.QuerySelect<QR>, SubModify.QueryOrder<QR>, QR> id(Long id) {
            return identifier("id", id);
        }

        public QueryFunctions<Long, QuerySelectOperation<SubModify.QuerySelect<QR>, SubModify.QueryOrder<QR>, QR>> id() {
            return (QueryFunctions) identifier("id");
        }

        public SubModify.QueryName<SubModify.QuerySelect<QR>, SubModify.QueryOrder<QR>, QR> lower() {
            doLower();
            var result = new SubModifyQueryNameImpl<>();
            result.setParent(alias, this);
            return (SubModify.QueryName) result;
        }

        public SubModify.QueryName<SubModify.QuerySelect<QR>, SubModify.QueryOrder<QR>, QR> not() {
            doNot();
            var result = new SubModifyQueryNameImpl<>();
            result.setParent(alias, this);
            return (SubModify.QueryName) result;
        }

        public SubModify.QueryOrder<QR> order() {
            return orderStart(new SubModifyQueryOrderImpl<>(this, SubModifyQueryExecutorImpl.this::orderIdentifier));
        }

        public SubModify.QueryName<SubModify.QuerySelect<QR>, SubModify.QueryOrder<QR>, QR> replace(String what, String withWhat) {
            doReplace(what, withWhat);
            var result = new SubModifyQueryNameImpl<>();
            result.setParent(alias, this);
            return (SubModify.QueryName) result;
        }

        public QuerySelectOperation<SubModify.QuerySelect<QR>, SubModify.QueryOrder<QR>, QR> subAmount(double subAmount) {
            return identifier("subAmount", subAmount);
        }

        public QueryFunctions<Double, QuerySelectOperation<SubModify.QuerySelect<QR>, SubModify.QueryOrder<QR>, QR>> subAmount() {
            return (QueryFunctions) identifier("subAmount");
        }

        public SubModify.QueryName<SubModify.QuerySelect<QR>, SubModify.QueryOrder<QR>, QR> substring(int start) {
            doSubstring(start);
            var result = new SubModifyQueryNameImpl<>();
            result.setParent(alias, this);
            return (SubModify.QueryName) result;
        }

        public SubModify.QueryName<SubModify.QuerySelect<QR>, SubModify.QueryOrder<QR>, QR> substring(int start, int len) {
            doSubstring(start, len);
            var result = new SubModifyQueryNameImpl<>();
            result.setParent(alias, this);
            return (SubModify.QueryName) result;
        }

        public QuerySelectOperation<SubModify.QuerySelect<QR>, SubModify.QueryOrder<QR>, QR> subtitle(String subtitle) {
            return identifier("subtitle", subtitle);
        }

        public QueryFunctions<String, QuerySelectOperation<SubModify.QuerySelect<QR>, SubModify.QueryOrder<QR>, QR>> subtitle() {
            return (QueryFunctions) identifier("subtitle");
        }

        public SubModify.QueryName<SubModify.QuerySelect<QR>, SubModify.QueryOrder<QR>, QR> trim() {
            doTrim();
            var result = new SubModifyQueryNameImpl<>();
            result.setParent(alias, this);
            return (SubModify.QueryName) result;
        }

        public QuerySelectOperation<SubModify.QuerySelect<QR>, SubModify.QueryOrder<QR>, QR> type(TestEnum type) {
            return identifier("type", type);
        }

        public QueryFunctions<TestEnum, QuerySelectOperation<SubModify.QuerySelect<QR>, SubModify.QueryOrder<QR>, QR>> type() {
            return (QueryFunctions) identifier("type");
        }

        public SubModify.QueryName<SubModify.QuerySelect<QR>, SubModify.QueryOrder<QR>, QR> upper() {
            doUpper();
            var result = new SubModifyQueryNameImpl<>();
            result.setParent(alias, this);
            return (SubModify.QueryName) result;
        }

        protected class SubModifyQueryOrderImpl<QR> extends QueryOrderer<QR> implements SubModify.QueryOrder<QR>, SubModify.QueryAggregate<QR, Object> {

            protected SubModifyQueryOrderImpl(SubModifyQueryExecutorImpl executor, Function<String, Object> func) {
                super(executor, func);
            }

            public QueryOrderOperation<SubModify.QueryOrder<QR>, QR> date() {
                return (QueryOrderOperation) func.apply("date");
            }

            public QueryOrderOperation<SubModify.QueryOrder<QR>, QR> id() {
                return (QueryOrderOperation) func.apply("id");
            }

            public QueryOrderOperation<SubModify.QueryOrder<QR>, QR> script(String script) {
                return (QueryOrderOperation) SubModifyQueryExecutorImpl.this.script(script);
            }

            public QueryOrderOperation<SubModify.QueryOrder<QR>, QR> subAmount() {
                return (QueryOrderOperation) func.apply("subAmount");
            }

            public QueryOrderOperation<SubModify.QueryOrder<QR>, QR> subtitle() {
                return (QueryOrderOperation) func.apply("subtitle");
            }

            public QueryOrderOperation<SubModify.QueryOrder<QR>, QR> type() {
                return (QueryOrderOperation) func.apply("type");
            }
        }
    }

    protected static class SubModifyQueryNameImpl<QS, QO, QR> extends BaseQueryNameImpl<QuerySelectOperation<QS, QO, QR>> implements SubModify.QueryName<QS, QO, QR>, QueryEmbed {

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

        public QueryFunctions<Double, QuerySelectOperation<QS, QO, QR>> subAmount() {
            return (QueryFunctions) executor.identifier("subAmount");
        }

        public QuerySelectOperation<QS, QO, QR> subAmount(double subAmount) {
            return (QuerySelectOperation) executor.identifier("subAmount", subAmount);
        }

        public QueryFunctions<String, QuerySelectOperation<QS, QO, QR>> subtitle() {
            return (QueryFunctions) executor.identifier("subtitle");
        }

        public QuerySelectOperation<QS, QO, QR> subtitle(String subtitle) {
            return (QuerySelectOperation) executor.identifier("subtitle", subtitle);
        }

        public QueryFunctions<TestEnum, QuerySelectOperation<QS, QO, QR>> type() {
            return (QueryFunctions) executor.identifier("type");
        }

        public QuerySelectOperation<QS, QO, QR> type(TestEnum type) {
            return (QuerySelectOperation) executor.identifier("type", type);
        }
    }
}
