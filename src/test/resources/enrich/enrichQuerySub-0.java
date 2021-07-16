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

public class SubImpl implements Sub {

    protected double subAmount;

    protected String subtitle;

    {
        CodeFactory.registerType(Sub.QuerySelect.class, SubQueryExecutorImpl::new, null);
        CodeFactory.registerType(Sub.class, SubImpl::new, null);
        CodeFactory.registerType(Sub.QueryName.class, SubQueryNameImpl::new, null);
    }

    public SubImpl() {
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

    protected static class SubQueryExecutorImpl<QR> extends QueryExecutor<Object, Sub.QuerySelect<QR>, Sub.QueryOrder<QR>, QR, QueryAggregateOperation> implements Sub.QuerySelect<QR> {

        protected SubQueryExecutorImpl() {
            super(Sub.class);
        }

        public QueryAggregateOperation aggregate() {
            return aggregateStart(new SubQueryOrderImpl<>(this, SubQueryExecutorImpl.this::aggregateIdentifier));
        }

        public Sub.QueryName<Sub.QuerySelect<QR>, Sub.QueryOrder<QR>, QR> lower() {
            doLower();
            var result = new SubQueryNameImpl<>();
            result.setParent("u", this);
            return (Sub.QueryName) result;
        }

        public Sub.QueryName<Sub.QuerySelect<QR>, Sub.QueryOrder<QR>, QR> not() {
            doNot();
            var result = new SubQueryNameImpl<>();
            result.setParent("u", this);
            return (Sub.QueryName) result;
        }

        public Sub.QueryOrder<QR> order() {
            return orderStart(new SubQueryOrderImpl<>(this, SubQueryExecutorImpl.this::orderIdentifier));
        }

        public Sub.QueryName<Sub.QuerySelect<QR>, Sub.QueryOrder<QR>, QR> replace(String what, String withWhat) {
            doReplace(what, withWhat);
            var result = new SubQueryNameImpl<>();
            result.setParent("u", this);
            return (Sub.QueryName) result;
        }

        public QuerySelectOperation<Sub.QuerySelect<QR>, Sub.QueryOrder<QR>, QR> subAmount(double subAmount) {
            return identifier("subAmount", subAmount);
        }

        public QueryFunctions<Double, QuerySelectOperation<Sub.QuerySelect<QR>, Sub.QueryOrder<QR>, QR>> subAmount() {
            identifier("subAmount");
            return (QueryFunctions) this;
        }

        public Sub.QueryName<Sub.QuerySelect<QR>, Sub.QueryOrder<QR>, QR> substring(int start) {
            doSubstring(start);
            var result = new SubQueryNameImpl<>();
            result.setParent("u", this);
            return (Sub.QueryName) result;
        }

        public Sub.QueryName<Sub.QuerySelect<QR>, Sub.QueryOrder<QR>, QR> substring(int start, int len) {
            doSubstring(start, len);
            var result = new SubQueryNameImpl<>();
            result.setParent("u", this);
            return (Sub.QueryName) result;
        }

        public QuerySelectOperation<Sub.QuerySelect<QR>, Sub.QueryOrder<QR>, QR> subtitle(String subtitle) {
            return identifier("subtitle", subtitle);
        }

        public QueryFunctions<String, QuerySelectOperation<Sub.QuerySelect<QR>, Sub.QueryOrder<QR>, QR>> subtitle() {
            identifier("subtitle");
            return (QueryFunctions) this;
        }

        public Sub.QueryName<Sub.QuerySelect<QR>, Sub.QueryOrder<QR>, QR> trim() {
            doTrim();
            var result = new SubQueryNameImpl<>();
            result.setParent("u", this);
            return (Sub.QueryName) result;
        }

        public Sub.QueryName<Sub.QuerySelect<QR>, Sub.QueryOrder<QR>, QR> upper() {
            doUpper();
            var result = new SubQueryNameImpl<>();
            result.setParent("u", this);
            return (Sub.QueryName) result;
        }

        protected class SubQueryOrderImpl<QR> extends QueryOrderer<QR> implements Sub.QueryOrder<QR>, Sub.QueryAggregate<QR, Object> {

            protected SubQueryOrderImpl(SubQueryExecutorImpl executor, Function<String, Object> func) {
                super(executor, func);
            }

            public QueryOrderOperation<Sub.QueryOrder<QR>, QR> script(String script) {
                return (QueryOrderOperation) SubQueryExecutorImpl.this.script(script);
            }

            public QueryOrderOperation<Sub.QueryOrder<QR>, QR> subAmount() {
                return (QueryOrderOperation) func.apply("subAmount");
            }

            public QueryOrderOperation<Sub.QueryOrder<QR>, QR> subtitle() {
                return (QueryOrderOperation) func.apply("subtitle");
            }
        }
    }

    protected static class SubQueryNameImpl<QS, QO, QR> extends BaseQueryNameImpl<QuerySelectOperation<QS, QO, QR>> implements Sub.QueryName<QS, QO, QR>, QueryEmbed {

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
    }
}
