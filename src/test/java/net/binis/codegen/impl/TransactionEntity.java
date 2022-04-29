/*Generated code by Binis' code generator.*/
package net.binis.codegen.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.intf.Account;
import net.binis.codegen.intf.Previewable;
import net.binis.codegen.intf.Transaction;
import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.spring.BaseEntityModifierImpl;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Consumer;

import static java.util.Objects.nonNull;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(onlyExplicitlyIncluded = true)
@SuppressWarnings("unchecked")
public class TransactionEntity extends BaseEntity implements Transaction, Previewable, Modifiable<Transaction.Modify> {

    // region constants
    public static final String TABLE_NAME = "transactions";

    public static final long serialVersionUID = 2023385096577883838L;
    // endregion

    protected Account account;

    @Column(nullable = false)
    protected double amount;

    protected Account counterparty;

    protected String description;

    protected String externalId;

    @Transient
    protected Object tag;

    protected OffsetDateTime timestamp;

    protected String title;

    // region constructor & initializer
    {
        CodeFactory.registerType(Transaction.class, TransactionEntity::new, (p, v) ->
                p instanceof EmbeddedCodeCollection ?
                        ((TransactionEntity) v).new TransactionEntityCollectionModifyImpl(p) :
                        ((TransactionEntity) v).new TransactionEntitySingleModifyImpl(p));
        CodeFactory.registerId(Transaction.class, "id", Long.class);
    }

    public TransactionEntity() {
        super();
    }
    // endregion

    // region getters
    @Transient
    public String getPreview() {
        return this.timestamp.format(DateTimeFormatter.ISO_OFFSET_DATE) + " (" + this.title + " for $" + this.amount + ")" + " -> account: " + (nonNull(this.account) ? ((Previewable) this.account).getPreview() : "no account");
    }
    // endregion

    public Transaction.Modify with() {
        return new TransactionEntityModifyImpl();
    }
    // endregion

    // region inner classes
    protected class TransactionEntityModifyImpl extends TransactionEntityEmbeddedModifyImpl<Transaction.Modify, Transaction> implements Transaction.Modify {

        @Override
        public Modify account(Consumer<Account.Modify> init) {
            if (TransactionEntity.this.account == null) {
                TransactionEntity.this.account = CodeFactory.create(Account.class);
            }

            init.accept(TransactionEntity.this.account.with());

            return this;
        }
    }

    protected class TransactionEntityCollectionModifyImpl extends TransactionEntityEmbeddedModifyImpl implements EmbeddedCollectionModify {
        protected TransactionEntityCollectionModifyImpl(Object parent) {
            super(parent);
        }

        @Override
        public EmbeddedCodeCollection _and() {
            return (EmbeddedCodeCollection) parent;
        }
    }

    protected class TransactionEntitySingleModifyImpl extends TransactionEntityEmbeddedModifyImpl implements EmbeddedSoloModify {
        protected TransactionEntitySingleModifyImpl(Object parent) {
            super(parent);
        }
    }

    protected class TransactionEntityEmbeddedModifyImpl<T, R> extends BaseEntityModifierImpl<T, R> implements Transaction.EmbeddedModify<T, R> {

        protected TransactionEntityEmbeddedModifyImpl(Object parent) {
            this.parent = (R) parent;
        }

        protected TransactionEntityEmbeddedModifyImpl() {
            setObject((R) TransactionEntity.this);
        }

        @Override
        public T account(Account account) {
            TransactionEntity.this.account = account;
            return (T) this;
        }

        public T amount(double amount) {
            TransactionEntity.this.amount = amount;
            return (T) this;
        }

        public T counterparty(Account counterparty) {
            TransactionEntity.this.counterparty = counterparty;
            return (T) this;
        }

        public T description(String description) {
            TransactionEntity.this.description = description;
            return (T) this;
        }

        public T externalId(String externalId) {
            TransactionEntity.this.externalId = externalId;
            return (T) this;
        }

        public T id(Long id) {
            TransactionEntity.this.id = id;
            return (T) this;
        }

        public T modified(OffsetDateTime modified) {
            TransactionEntity.this.modified = modified;
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

        public T title(String title) {
            TransactionEntity.this.title = title;
            return (T) this;
        }

        @Override
        public Account.EmbeddedSoloModify<EmbeddedModify<T, R>> account() {
            if (TransactionEntity.this.account == null) {
                TransactionEntity.this.account = CodeFactory.create(Account.class);
            }
            return CodeFactory.modify(this, TransactionEntity.this.account, Account.class);
        }
    }
    // endregion
}
