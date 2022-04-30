/*Generated code by Binis' code generator.*/
package net.binis.codegen.impl;


import net.binis.codegen.BaseImpl;
import net.binis.codegen.intf.Transaction;
import net.binis.codegen.modifier.impl.BaseModifierImpl;
import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.intf.Account;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.enums.TestEnum;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import javax.persistence.Transient;
import javax.annotation.processing.Generated;
import java.util.function.Consumer;
import java.time.OffsetDateTime;

@Generated(value = "TransactionEntityPrototype", comments = "Transaction")
public class TransactionEntity extends BaseImpl implements Transaction, Modifiable<Transaction.Modify> {

    protected Account account;

    protected double amount;

    protected Account counterparty;

    protected Transaction parent;

    @Transient()
    protected Object tag;

    protected OffsetDateTime timestamp;

    // region constructor & initializer
    {
        CodeFactory.registerType(Transaction.class, TransactionEntity::new, (p, v) -> p instanceof EmbeddedCodeCollection ? ((TransactionEntity) v).new TransactionEntityCollectionModifyImpl(p) : ((TransactionEntity) v).new TransactionEntitySoloModifyImpl(p));
    }

    public TransactionEntity() {
        super();
    }
    // endregion

    // region getters
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
        return new TransactionEntityModifyImpl();
    }
    // endregion

    // region inner classes
    protected class TransactionEntityCollectionModifyImpl extends TransactionEntityEmbeddedModifyImpl implements Transaction.EmbeddedCollectionModify {

        protected TransactionEntityCollectionModifyImpl(Object parent) {
            super(parent);
        }

        public EmbeddedCodeCollection _and() {
            return (EmbeddedCodeCollection) parent;
        }
    }

    protected class TransactionEntityEmbeddedModifyImpl<T, R> extends BaseModifierImpl<T, R> implements Transaction.EmbeddedModify<T, R> {

        protected TransactionEntityEmbeddedModifyImpl(Object parent) {
            this.parent = (R) parent;
        }

        protected TransactionEntityEmbeddedModifyImpl() {
            setObject((R) TransactionEntity.this);
        }

        public T account(Account account) {
            TransactionEntity.this.account = account;
            return (T) this;
        }

        public Account.EmbeddedSoloModify<EmbeddedModify<T, R>> account() {
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

        public Account.EmbeddedSoloModify<EmbeddedModify<T, R>> counterparty() {
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

        public Transaction.EmbeddedSoloModify<EmbeddedModify<T, R>> parent() {
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

    protected class TransactionEntityModifyImpl extends TransactionEntityEmbeddedModifyImpl<Transaction.Modify, Transaction> implements Transaction.Modify {

        public Modify account(Consumer<Account.Modify> init) {
            if (TransactionEntity.this.account == null) {
                TransactionEntity.this.account = CodeFactory.create(Account.class);
            }
            init.accept(TransactionEntity.this.account.with());
            return this;
        }

        public Modify counterparty(Consumer<Account.Modify> init) {
            if (TransactionEntity.this.counterparty == null) {
                TransactionEntity.this.counterparty = CodeFactory.create(Account.class);
            }
            init.accept(TransactionEntity.this.counterparty.with());
            return this;
        }

        public Modify parent(Consumer<Transaction.Modify> init) {
            if (TransactionEntity.this.parent == null) {
                TransactionEntity.this.parent = CodeFactory.create(Transaction.class);
            }
            init.accept(TransactionEntity.this.parent.with());
            return this;
        }
    }

    protected class TransactionEntitySoloModifyImpl extends TransactionEntityEmbeddedModifyImpl implements Transaction.EmbeddedSoloModify {

        protected TransactionEntitySoloModifyImpl(Object parent) {
            super(parent);
        }
    }
    // endregion
}
