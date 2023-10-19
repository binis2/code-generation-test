/*Generated code by Binis' code generator.*/
package net.binis.codegen.modifier.test;

import net.binis.codegen.spring.query.executor.QueryOrderer;
import net.binis.codegen.spring.query.executor.QueryExecutor;
import net.binis.codegen.spring.query.base.BaseQueryNameImpl;
import net.binis.codegen.spring.query.*;
import net.binis.codegen.spring.modifier.impl.BaseEntityModifierImpl;
import net.binis.codegen.modifier.impl.BaseModifierImpl;
import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.enums.TestEnum;
import net.binis.codegen.creator.EntityCreator;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import javax.annotation.processing.Generated;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.Optional;
import java.util.List;
import java.time.OffsetDateTime;
import jakarta.persistence.Transient;

@Generated(value = "net.binis.codegen.modifier.test.TransactionEntityPrototype", comments = "Transaction")
@SuppressWarnings("unchecked")
public class TransactionEntity extends BaseImpl implements Transaction, SubTransaction, Modifiable<Transaction.Modify> {

    protected Account account;

    protected double amount;

    protected Account counterparty;

    protected Transaction parent;

    @Transient()
    protected Object tag;

    protected OffsetDateTime timestamp;

    // region constructor & initializer
    {
        CodeFactory.registerType(Transaction.class, TransactionEntity::new, (p, v, r) -> p instanceof EmbeddedCodeCollection ? ((TransactionEntity) v).new TransactionEntityCollectionModifyImpl(p) : ((TransactionEntity) v).new TransactionEntitySoloModifyImpl(p));
        CodeFactory.registerType(Transaction.QueryName.class, TransactionQueryNameImpl::new, null);
        CodeFactory.registerType(Transaction.QuerySelect.class, TransactionSelectQueryExecutorImpl::new, null);
        CodeFactory.registerType(Transaction.QueryOperationFields.class, TransactionFieldsQueryExecutorImpl::new, null);
        CodeFactory.registerType(Transaction.QueryOrder.class, () -> Transaction.find().aggregate(), null);
        CodeFactory.registerType(SubTransaction.class, TransactionEntity::new, (p, v, r) -> ((TransactionEntity) v).new SubTransactionEntitySoloModifyImpl(p));
        CodeFactory.registerType(SubTransaction.QueryName.class, TransactionQueryNameImpl::new, null);
        CodeFactory.registerType(SubTransaction.QuerySelect.class, SubTransactionSelectQueryExecutorImpl::new, null);
        CodeFactory.registerType(SubTransaction.QueryOperationFields.class, SubTransactionFieldsQueryExecutorImpl::new, null);
    }

    public TransactionEntity() {
        super();
    }
    // endregion

    // region getters
    public SubTransaction.Modify asSubTransaction() {
        return new SubTransactionEntityModifyImpl(this);
    }

    public Account getAccount() {
        return account;
    }

    public double getAmount() {
        return amount;
    }

    public Account getCounterparty() {
        return counterparty;
    }

    public Transaction getParent() {
        return parent;
    }

    public Object getTag() {
        return tag;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public Transaction.Modify with() {
        return new TransactionEntityModifyImpl(this);
    }
    // endregion

    // region inner classes
    @SuppressWarnings("unchecked")
    @Generated("ModifierEnricher")
    protected class SubTransactionEntityEmbeddedModifyImpl<T, R> extends BaseModifierImpl<T, R> implements SubTransaction.EmbeddedModify<T, R> {

        protected SubTransactionEntityEmbeddedModifyImpl(R parent) {
            super(parent);
        }

        public T account(Account account) {
            TransactionEntity.this.account = account;
            return (T) this;
        }

        public Account.EmbeddedSoloModify<SubTransaction.EmbeddedModify<T, R>> account() {
            if (TransactionEntity.this.account == null) {
                TransactionEntity.this.account = CodeFactory.create(Account.class);
            }
            return CodeFactory.modify(this, TransactionEntity.this.account, Account.class);
        }

        public T amount(double amount) {
            TransactionEntity.this.amount = amount;
            return (T) this;
        }

        public T counterparty(Account counterparty) {
            TransactionEntity.this.counterparty = counterparty;
            return (T) this;
        }

        public Account.EmbeddedSoloModify<SubTransaction.EmbeddedModify<T, R>> counterparty() {
            if (TransactionEntity.this.counterparty == null) {
                TransactionEntity.this.counterparty = CodeFactory.create(Account.class);
            }
            return CodeFactory.modify(this, TransactionEntity.this.counterparty, Account.class);
        }

        public T date(OffsetDateTime date) {
            TransactionEntity.this.date = date;
            return (T) this;
        }

        public T id(Long id) {
            TransactionEntity.this.id = id;
            return (T) this;
        }

        public T parent(Transaction parent) {
            TransactionEntity.this.parent = parent;
            return (T) this;
        }

        public Transaction.EmbeddedSoloModify<SubTransaction.EmbeddedModify<T, R>> parent() {
            if (TransactionEntity.this.parent == null) {
                TransactionEntity.this.parent = CodeFactory.create(Transaction.class);
            }
            return CodeFactory.modify(this, TransactionEntity.this.parent, Transaction.class);
        }

        public T tag(Object tag) {
            TransactionEntity.this.tag = tag;
            return (T) this;
        }

        public T timestamp(OffsetDateTime timestamp) {
            TransactionEntity.this.timestamp = timestamp;
            return (T) this;
        }

        public T type(TestEnum type) {
            TransactionEntity.this.type = type;
            return (T) this;
        }
    }

    @Generated("ModifierEnricher")
    @SuppressWarnings("unchecked")
    protected class SubTransactionEntityModifyImpl extends SubTransactionEntityEmbeddedModifyImpl<SubTransaction.Modify, SubTransaction> implements SubTransaction.Modify {

        protected SubTransactionEntityModifyImpl(SubTransaction parent) {
            super(parent);
        }

        public SubTransaction.Modify account$(Consumer<Account.Modify> init) {
            if (TransactionEntity.this.account == null) {
                TransactionEntity.this.account = CodeFactory.create(Account.class);
            }
            init.accept(TransactionEntity.this.account.with());
            return this;
        }

        public SubTransaction.Modify counterparty$(Consumer<Account.Modify> init) {
            if (TransactionEntity.this.counterparty == null) {
                TransactionEntity.this.counterparty = CodeFactory.create(Account.class);
            }
            init.accept(TransactionEntity.this.counterparty.with());
            return this;
        }

        public SubTransaction.Modify parent$(Consumer<Transaction.Modify> init) {
            if (TransactionEntity.this.parent == null) {
                TransactionEntity.this.parent = CodeFactory.create(Transaction.class);
            }
            init.accept(TransactionEntity.this.parent.with());
            return this;
        }
    }

    @SuppressWarnings("unchecked")
    @Generated("ModifierEnricher")
    protected class SubTransactionEntitySoloModifyImpl extends SubTransactionEntityEmbeddedModifyImpl implements SubTransaction.EmbeddedSoloModify {

        protected SubTransactionEntitySoloModifyImpl(Object parent) {
            super(parent);
        }
    }

    @Generated("QueryEnricher")
    protected static class SubTransactionFieldsQueryExecutorImpl extends SubTransactionQueryExecutorImpl implements SubTransaction.QueryFieldsStart, EmbeddedFields {

        public Account.QueryOperationFields account() {
            var result = EntityCreator.create(Account.QueryOperationFields.class, "net.binis.codegen.modifier.test.AccountEntity");
            ((QueryEmbed) result).setParent("account", this);
            return result;
        }

        public Account.QueryOperationFields counterparty() {
            var result = EntityCreator.create(Account.QueryOperationFields.class, "net.binis.codegen.modifier.test.AccountEntity");
            ((QueryEmbed) result).setParent("counterparty", this);
            return result;
        }

        public Transaction.QueryOperationFields parent() {
            var result = EntityCreator.create(Transaction.QueryOperationFields.class, "net.binis.codegen.modifier.test.TransactionEntity");
            ((QueryEmbed) result).setParent("parent", this);
            return result;
        }
    }

    @Generated("QueryEnricher")
    protected static abstract class SubTransactionQueryExecutorImpl extends QueryExecutor implements SubTransaction.QueryUpdate {

        protected SubTransactionQueryExecutorImpl() {
            super(SubTransaction.class, () -> new TransactionQueryNameImpl(), parent -> {
                var result = new SubTransactionFieldsQueryExecutorImpl();
                result.parent = (QueryExecutor) parent;
                return result;
            });
        }

        public QuerySelectOperation account(Account account) {
            return $identifier("account", account);
        }

        public QueryAggregateOperation aggregate() {
            return (QueryAggregateOperation) _aggregateStart(new SubTransactionQueryOrderImpl(this, SubTransactionQueryExecutorImpl.this::_aggregateIdentifier));
        }

        public QuerySelectOperation amount(double amount) {
            return $identifier("amount", amount);
        }

        public QueryFunctions amount() {
            return $identifier("amount");
        }

        public QuerySelectOperation counterparty(Account counterparty) {
            return $identifier("counterparty", counterparty);
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

        public SubTransaction.QueryOrder order() {
            return (SubTransaction.QueryOrder) _orderStart(new SubTransactionQueryOrderImpl(this, SubTransactionQueryExecutorImpl.this::_orderIdentifier));
        }

        public QuerySelectOperation parent(Transaction parent) {
            return $identifier("parent", parent);
        }

        public QuerySelectOperation tag(Object tag) {
            return $identifier("tag", tag);
        }

        public QuerySelectOperation timestamp(OffsetDateTime timestamp) {
            return $identifier("timestamp", timestamp);
        }

        public QueryFunctions timestamp() {
            return $identifier("timestamp");
        }

        public QuerySelectOperation type(TestEnum type) {
            return $identifier("type", type);
        }

        public QueryFunctions type() {
            return $identifier("type");
        }

        @Generated("QueryEnricher")
        protected class SubTransactionQueryOrderImpl extends QueryOrderer implements SubTransaction.QueryOrder, SubTransaction.QueryAggregate {

            protected SubTransactionQueryOrderImpl(SubTransactionQueryExecutorImpl executor, Function<String, Object> func) {
                super(executor, func);
            }

            public Account.QueryOperationFields account() {
                var result = EntityCreator.create(Account.QueryOperationFields.class, "net.binis.codegen.modifier.test.AccountEntity");
                ((QueryEmbed) result).setParent("account", executor);
                return result;
            }

            public QueryOrderOperation amount() {
                return (QueryOrderOperation) func.apply("amount");
            }

            public Account.QueryOperationFields counterparty() {
                var result = EntityCreator.create(Account.QueryOperationFields.class, "net.binis.codegen.modifier.test.AccountEntity");
                ((QueryEmbed) result).setParent("counterparty", executor);
                return result;
            }

            public QueryOrderOperation date() {
                return (QueryOrderOperation) func.apply("date");
            }

            public QueryOrderOperation id() {
                return (QueryOrderOperation) func.apply("id");
            }

            public Transaction.QueryOperationFields parent() {
                var result = EntityCreator.create(Transaction.QueryOperationFields.class, "net.binis.codegen.modifier.test.TransactionEntity");
                ((QueryEmbed) result).setParent("parent", executor);
                return result;
            }

            public QueryOrderOperation timestamp() {
                return (QueryOrderOperation) func.apply("timestamp");
            }

            public QueryOrderOperation type() {
                return (QueryOrderOperation) func.apply("type");
            }
        }
    }

    @Generated("QueryEnricher")
    protected static class SubTransactionSelectQueryExecutorImpl extends SubTransactionQueryExecutorImpl implements SubTransaction.QuerySelect {

        public Account.QueryName account() {
            var result = EntityCreator.create(Account.QueryName.class, "net.binis.codegen.modifier.test.AccountEntity");
            ((QueryEmbed) result).setParent("account", this);
            return result;
        }

        public Account.QueryName counterparty() {
            var result = EntityCreator.create(Account.QueryName.class, "net.binis.codegen.modifier.test.AccountEntity");
            ((QueryEmbed) result).setParent("counterparty", this);
            return result;
        }

        public Transaction.QueryName parent() {
            var result = EntityCreator.create(Transaction.QueryName.class, "net.binis.codegen.modifier.test.TransactionEntity");
            ((QueryEmbed) result).setParent("parent", this);
            return result;
        }
    }

    @SuppressWarnings("unchecked")
    @Generated("ModifierEnricher")
    protected class TransactionEntityCollectionModifyImpl extends TransactionEntityEmbeddedModifyImpl implements Transaction.EmbeddedCollectionModify {

        protected TransactionEntityCollectionModifyImpl(Object parent) {
            super(parent);
        }

        public EmbeddedCodeCollection _and() {
            return (EmbeddedCodeCollection) parent;
        }
    }

    @SuppressWarnings("unchecked")
    @Generated("ModifierEnricher")
    protected class TransactionEntityEmbeddedModifyImpl<T, R> extends BaseEntityModifierImpl<T, R> implements Transaction.EmbeddedModify<T, R> {

        protected TransactionEntityEmbeddedModifyImpl(R parent) {
            super(parent);
        }

        public T account(Account account) {
            TransactionEntity.this.account = account;
            return (T) this;
        }

        public Account.EmbeddedSoloModify<Transaction.EmbeddedModify<T, R>> account() {
            if (TransactionEntity.this.account == null) {
                TransactionEntity.this.account = CodeFactory.create(Account.class);
            }
            return CodeFactory.modify(this, TransactionEntity.this.account, Account.class);
        }

        public T amount(double amount) {
            TransactionEntity.this.amount = amount;
            return (T) this;
        }

        public T counterparty(Account counterparty) {
            TransactionEntity.this.counterparty = counterparty;
            return (T) this;
        }

        public Account.EmbeddedSoloModify<Transaction.EmbeddedModify<T, R>> counterparty() {
            if (TransactionEntity.this.counterparty == null) {
                TransactionEntity.this.counterparty = CodeFactory.create(Account.class);
            }
            return CodeFactory.modify(this, TransactionEntity.this.counterparty, Account.class);
        }

        public T date(OffsetDateTime date) {
            TransactionEntity.this.date = date;
            return (T) this;
        }

        public T id(Long id) {
            TransactionEntity.this.id = id;
            return (T) this;
        }

        public T tag(Object tag) {
            TransactionEntity.this.tag = tag;
            return (T) this;
        }

        public T timestamp(OffsetDateTime timestamp) {
            TransactionEntity.this.timestamp = timestamp;
            return (T) this;
        }

        public T type(TestEnum type) {
            TransactionEntity.this.type = type;
            return (T) this;
        }
    }

    @Generated("ModifierEnricher")
    @SuppressWarnings("unchecked")
    protected class TransactionEntityModifyImpl extends TransactionEntityEmbeddedModifyImpl<Transaction.Modify, Transaction> implements Transaction.Modify {

        protected TransactionEntityModifyImpl(Transaction parent) {
            super(parent);
        }

        public Transaction.Modify account$(Consumer<Account.Modify> init) {
            if (TransactionEntity.this.account == null) {
                TransactionEntity.this.account = CodeFactory.create(Account.class);
            }
            init.accept(TransactionEntity.this.account.with());
            return this;
        }

        public Transaction.Modify counterparty$(Consumer<Account.Modify> init) {
            if (TransactionEntity.this.counterparty == null) {
                TransactionEntity.this.counterparty = CodeFactory.create(Account.class);
            }
            init.accept(TransactionEntity.this.counterparty.with());
            return this;
        }
    }

    @SuppressWarnings("unchecked")
    @Generated("ModifierEnricher")
    protected class TransactionEntitySoloModifyImpl extends TransactionEntityEmbeddedModifyImpl implements Transaction.EmbeddedSoloModify {

        protected TransactionEntitySoloModifyImpl(Object parent) {
            super(parent);
        }
    }

    @Generated("QueryEnricher")
    protected static class TransactionFieldsQueryExecutorImpl extends TransactionQueryExecutorImpl implements Transaction.QueryFieldsStart, EmbeddedFields {

        public Account.QueryOperationFields account() {
            var result = EntityCreator.create(Account.QueryOperationFields.class, "net.binis.codegen.modifier.test.AccountEntity");
            ((QueryEmbed) result).setParent("account", this);
            return result;
        }

        public Account.QueryOperationFields counterparty() {
            var result = EntityCreator.create(Account.QueryOperationFields.class, "net.binis.codegen.modifier.test.AccountEntity");
            ((QueryEmbed) result).setParent("counterparty", this);
            return result;
        }
    }

    @Generated("QueryEnricher")
    protected static abstract class TransactionQueryExecutorImpl extends QueryExecutor implements Transaction.QueryUpdate {

        protected TransactionQueryExecutorImpl() {
            super(Transaction.class, () -> new TransactionQueryNameImpl(), parent -> {
                var result = new TransactionFieldsQueryExecutorImpl();
                result.parent = (QueryExecutor) parent;
                return result;
            });
        }

        public QuerySelectOperation account(Account account) {
            return $identifier("account", account);
        }

        public QueryAggregateOperation aggregate() {
            return (QueryAggregateOperation) _aggregateStart(new TransactionQueryOrderImpl(this, TransactionQueryExecutorImpl.this::_aggregateIdentifier));
        }

        public QuerySelectOperation amount(double amount) {
            return $identifier("amount", amount);
        }

        public QueryFunctions amount() {
            return $identifier("amount");
        }

        public QuerySelectOperation counterparty(Account counterparty) {
            return $identifier("counterparty", counterparty);
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

        public Transaction.QueryOrder order() {
            return (Transaction.QueryOrder) _orderStart(new TransactionQueryOrderImpl(this, TransactionQueryExecutorImpl.this::_orderIdentifier));
        }

        public QuerySelectOperation tag(Object tag) {
            return $identifier("tag", tag);
        }

        public QuerySelectOperation timestamp(OffsetDateTime timestamp) {
            return $identifier("timestamp", timestamp);
        }

        public QueryFunctions timestamp() {
            return $identifier("timestamp");
        }

        public QuerySelectOperation type(TestEnum type) {
            return $identifier("type", type);
        }

        public QueryFunctions type() {
            return $identifier("type");
        }

        @Generated("QueryEnricher")
        protected class TransactionQueryOrderImpl extends QueryOrderer implements Transaction.QueryOrder, Transaction.QueryAggregate {

            protected TransactionQueryOrderImpl(TransactionQueryExecutorImpl executor, Function<String, Object> func) {
                super(executor, func);
            }

            public Account.QueryOperationFields account() {
                var result = EntityCreator.create(Account.QueryOperationFields.class, "net.binis.codegen.modifier.test.AccountEntity");
                ((QueryEmbed) result).setParent("account", executor);
                return result;
            }

            public QueryOrderOperation amount() {
                return (QueryOrderOperation) func.apply("amount");
            }

            public Account.QueryOperationFields counterparty() {
                var result = EntityCreator.create(Account.QueryOperationFields.class, "net.binis.codegen.modifier.test.AccountEntity");
                ((QueryEmbed) result).setParent("counterparty", executor);
                return result;
            }

            public QueryOrderOperation date() {
                return (QueryOrderOperation) func.apply("date");
            }

            public QueryOrderOperation id() {
                return (QueryOrderOperation) func.apply("id");
            }

            public QueryOrderOperation timestamp() {
                return (QueryOrderOperation) func.apply("timestamp");
            }

            public QueryOrderOperation type() {
                return (QueryOrderOperation) func.apply("type");
            }
        }
    }

    @Generated("QueryEnricher")
    protected static class TransactionQueryNameImpl extends BaseQueryNameImpl implements Transaction.QueryName, QueryEmbed, SubTransaction.QueryName {

        public Account.QueryName account() {
            var result = EntityCreator.create(Account.QueryName.class, "net.binis.codegen.modifier.test.AccountEntity");
            ((QueryEmbed) result).setParent("account", executor);
            return result;
        }

        public QuerySelectOperation account(Account account) {
            return executor.$identifier("account", account);
        }

        public QueryFunctions amount() {
            return executor.$identifier("amount");
        }

        public QuerySelectOperation amount(double amount) {
            return executor.$identifier("amount", amount);
        }

        public Account.QueryName counterparty() {
            var result = EntityCreator.create(Account.QueryName.class, "net.binis.codegen.modifier.test.AccountEntity");
            ((QueryEmbed) result).setParent("counterparty", executor);
            return result;
        }

        public QuerySelectOperation counterparty(Account counterparty) {
            return executor.$identifier("counterparty", counterparty);
        }

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

        public Transaction.QueryName parent() {
            var result = EntityCreator.create(Transaction.QueryName.class, "net.binis.codegen.modifier.test.TransactionEntity");
            ((QueryEmbed) result).setParent("parent", executor);
            return result;
        }

        public QuerySelectOperation parent(Transaction parent) {
            return executor.$identifier("parent", parent);
        }

        public QuerySelectOperation tag(Object tag) {
            return executor.$identifier("tag", tag);
        }

        public QueryFunctions timestamp() {
            return executor.$identifier("timestamp");
        }

        public QuerySelectOperation timestamp(OffsetDateTime timestamp) {
            return executor.$identifier("timestamp", timestamp);
        }

        public QueryFunctions type() {
            return executor.$identifier("type");
        }

        public QuerySelectOperation type(TestEnum type) {
            return executor.$identifier("type", type);
        }
    }

    @Generated("QueryEnricher")
    protected static class TransactionSelectQueryExecutorImpl extends TransactionQueryExecutorImpl implements Transaction.QuerySelect {

        public Account.QueryName account() {
            var result = EntityCreator.create(Account.QueryName.class, "net.binis.codegen.modifier.test.AccountEntity");
            ((QueryEmbed) result).setParent("account", this);
            return result;
        }

        public Account.QueryName counterparty() {
            var result = EntityCreator.create(Account.QueryName.class, "net.binis.codegen.modifier.test.AccountEntity");
            ((QueryEmbed) result).setParent("counterparty", this);
            return result;
        }
    }
    // endregion
}
