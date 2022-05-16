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

@Generated(value = "SubPrototype", comments = "Sub")
public class SubImpl implements Sub {

    protected double subAmount;

    protected String subtitle;

    {
        CodeFactory.registerType(Sub.class, SubImpl::new, null);
        CodeFactory.registerType(Sub.QueryName.class, SubQueryNameImpl::new, null);
        CodeFactory.registerType(Sub.QuerySelect.class, SubQueryExecutorImpl::new, null);
        CodeFactory.registerType(Sub.QueryOperationFields.class, SubQueryExecutorImpl::new, null);
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

    protected static class SubQueryExecutorImpl extends QueryExecutor implements Sub.QuerySelect, Sub.QueryFieldsStart {

        protected SubQueryExecutorImpl() {
            super(Sub.class, () -> new SubQueryNameImpl(), parent -> parent);
        }

        public QueryAggregateOperation aggregate() {
            return (QueryAggregateOperation) aggregateStart(new SubQueryOrderImpl(this, SubQueryExecutorImpl.this::aggregateIdentifier));
        }

        public Sub.QueryOrder order() {
            return (Sub.QueryOrder) orderStart(new SubQueryOrderImpl(this, SubQueryExecutorImpl.this::orderIdentifier));
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

        protected class SubQueryOrderImpl extends QueryOrderer implements Sub.QueryOrder, Sub.QueryAggregate {

            protected SubQueryOrderImpl(SubQueryExecutorImpl executor, Function<String, Object> func) {
                super(executor, func);
            }

            public QueryOrderOperation subAmount() {
                return (QueryOrderOperation) func.apply("subAmount");
            }

            public QueryOrderOperation subtitle() {
                return (QueryOrderOperation) func.apply("subtitle");
            }
        }
    }

    protected static class SubQueryNameImpl extends BaseQueryNameImpl implements Sub.QueryName, QueryEmbed {

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
    }
}
