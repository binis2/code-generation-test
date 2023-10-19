/*Generated code by Binis' code generator.*/
package net.binis.codegen.modifier.test;

import net.binis.codegen.spring.query.executor.QueryOrderer;
import net.binis.codegen.spring.query.executor.QueryExecutor;
import net.binis.codegen.spring.query.base.BaseQueryNameImpl;
import net.binis.codegen.spring.query.*;
import net.binis.codegen.modifier.impl.BaseModifierImpl;
import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.enums.TestEnum;
import net.binis.codegen.creator.EntityCreator;
import javax.annotation.processing.Generated;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.Optional;
import java.util.List;
import java.time.OffsetDateTime;
import jakarta.persistence.Transient;

@Generated(value = "net.binis.codegen.modifier.test.TransactionDetailEntityPrototype", comments = "TransactionDetail")
@SuppressWarnings("unchecked")
public class TransactionDetailEntity extends BaseImpl implements TransactionDetail, Modifiable<TransactionDetail.Modify> {

    protected SubTransaction parented;

    @Transient()
    protected Object tag;

    // region constructor & initializer
    {
        CodeFactory.registerType(TransactionDetail.class, TransactionDetailEntity::new, null);
        CodeFactory.registerType(TransactionDetail.QueryName.class, TransactionDetailQueryNameImpl::new, null);
        CodeFactory.registerType(TransactionDetail.QuerySelect.class, TransactionDetailSelectQueryExecutorImpl::new, null);
        CodeFactory.registerType(TransactionDetail.QueryOperationFields.class, TransactionDetailFieldsQueryExecutorImpl::new, null);
    }

    public TransactionDetailEntity() {
        super();
    }
    // endregion

    // region getters
    public SubTransaction getParented() {
        return parented;
    }

    public Object getTag() {
        return tag;
    }

    public TransactionDetail.Modify with() {
        return new TransactionDetailEntityModifyImpl(this);
    }
    // endregion

    // region inner classes
    @Generated("ModifierEnricher")
    protected class TransactionDetailEntityModifyImpl extends BaseModifierImpl<TransactionDetail.Modify, TransactionDetail> implements TransactionDetail.Modify {

        protected TransactionDetailEntityModifyImpl(TransactionDetail parent) {
            super(parent);
        }

        public TransactionDetail.Modify date(OffsetDateTime date) {
            TransactionDetailEntity.this.date = date;
            return this;
        }

        public TransactionDetail done() {
            return TransactionDetailEntity.this;
        }

        public TransactionDetail.Modify id(Long id) {
            TransactionDetailEntity.this.id = id;
            return this;
        }

        public TransactionDetail.Modify parented(SubTransaction parented) {
            TransactionDetailEntity.this.parented = parented;
            return this;
        }

        public SubTransaction.EmbeddedSoloModify<TransactionDetail.Modify> parented() {
            if (TransactionDetailEntity.this.parented == null) {
                TransactionDetailEntity.this.parented = CodeFactory.create(SubTransaction.class);
            }
            return CodeFactory.modify(this, TransactionDetailEntity.this.parented, SubTransaction.class);
        }

        public TransactionDetail.Modify parented$(Consumer<SubTransaction.Modify> init) {
            if (TransactionDetailEntity.this.parented == null) {
                TransactionDetailEntity.this.parented = CodeFactory.create(SubTransaction.class);
            }
            init.accept(TransactionDetailEntity.this.parented.asSubTransaction());
            return this;
        }

        public TransactionDetail.Modify tag(Object tag) {
            TransactionDetailEntity.this.tag = tag;
            return this;
        }

        public TransactionDetail.Modify type(TestEnum type) {
            TransactionDetailEntity.this.type = type;
            return this;
        }
    }

    @Generated("QueryEnricher")
    protected static class TransactionDetailFieldsQueryExecutorImpl extends TransactionDetailQueryExecutorImpl implements TransactionDetail.QueryFieldsStart, EmbeddedFields {

        public SubTransaction.QueryOperationFields parented() {
            var result = EntityCreator.create(SubTransaction.QueryOperationFields.class, "net.binis.codegen.modifier.test.TransactionEntity");
            ((QueryEmbed) result).setParent("parented", this);
            return result;
        }
    }

    @Generated("QueryEnricher")
    protected static abstract class TransactionDetailQueryExecutorImpl extends QueryExecutor implements TransactionDetail.QueryUpdate {

        protected TransactionDetailQueryExecutorImpl() {
            super(TransactionDetail.class, () -> new TransactionDetailQueryNameImpl(), parent -> {
                var result = new TransactionDetailFieldsQueryExecutorImpl();
                result.parent = (QueryExecutor) parent;
                return result;
            });
        }

        public QueryAggregateOperation aggregate() {
            return (QueryAggregateOperation) _aggregateStart(new TransactionDetailQueryOrderImpl(this, TransactionDetailQueryExecutorImpl.this::_aggregateIdentifier));
        }

        public QuerySelectOperation date(OffsetDateTime date) {
            return $identifier("date", date);
        }

        public QueryFunctions date() {
            return $identifier("date");
        }

        public QuerySelectOperation id(Long id) {
            return $identifier("id", id);
        }

        public QueryFunctions id() {
            return $identifier("id");
        }

        public TransactionDetail.QueryOrder order() {
            return (TransactionDetail.QueryOrder) _orderStart(new TransactionDetailQueryOrderImpl(this, TransactionDetailQueryExecutorImpl.this::_orderIdentifier));
        }

        public QuerySelectOperation parented(SubTransaction parented) {
            return $identifier("parented", parented);
        }

        public QuerySelectOperation tag(Object tag) {
            return $identifier("tag", tag);
        }

        public QuerySelectOperation type(TestEnum type) {
            return $identifier("type", type);
        }

        public QueryFunctions type() {
            return $identifier("type");
        }

        @Generated("QueryEnricher")
        protected class TransactionDetailQueryOrderImpl extends QueryOrderer implements TransactionDetail.QueryOrder, TransactionDetail.QueryAggregate {

            protected TransactionDetailQueryOrderImpl(TransactionDetailQueryExecutorImpl executor, Function<String, Object> func) {
                super(executor, func);
            }

            public QueryOrderOperation date() {
                return (QueryOrderOperation) func.apply("date");
            }

            public QueryOrderOperation id() {
                return (QueryOrderOperation) func.apply("id");
            }

            public SubTransaction.QueryOperationFields parented() {
                var result = EntityCreator.create(SubTransaction.QueryOperationFields.class, "net.binis.codegen.modifier.test.TransactionEntity");
                ((QueryEmbed) result).setParent("parented", executor);
                return result;
            }

            public QueryOrderOperation type() {
                return (QueryOrderOperation) func.apply("type");
            }
        }
    }

    @Generated("QueryEnricher")
    protected static class TransactionDetailQueryNameImpl extends BaseQueryNameImpl implements TransactionDetail.QueryName, QueryEmbed {

        public QueryFunctions date() {
            return executor.$identifier("date");
        }

        public QuerySelectOperation date(OffsetDateTime date) {
            return executor.$identifier("date", date);
        }

        public QueryFunctions id() {
            return executor.$identifier("id");
        }

        public QuerySelectOperation id(Long id) {
            return executor.$identifier("id", id);
        }

        public SubTransaction.QueryName parented() {
            var result = EntityCreator.create(SubTransaction.QueryName.class, "net.binis.codegen.modifier.test.TransactionEntity");
            ((QueryEmbed) result).setParent("parented", executor);
            return result;
        }

        public QuerySelectOperation parented(SubTransaction parented) {
            return executor.$identifier("parented", parented);
        }

        public QuerySelectOperation tag(Object tag) {
            return executor.$identifier("tag", tag);
        }

        public QueryFunctions type() {
            return executor.$identifier("type");
        }

        public QuerySelectOperation type(TestEnum type) {
            return executor.$identifier("type", type);
        }
    }

    @Generated("QueryEnricher")
    protected static class TransactionDetailSelectQueryExecutorImpl extends TransactionDetailQueryExecutorImpl implements TransactionDetail.QuerySelect {

        public SubTransaction.QueryName parented() {
            var result = EntityCreator.create(SubTransaction.QueryName.class, "net.binis.codegen.modifier.test.TransactionEntity");
            ((QueryEmbed) result).setParent("parented", this);
            return result;
        }
    }
    // endregion
}
