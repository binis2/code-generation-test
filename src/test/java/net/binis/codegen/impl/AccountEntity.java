/*Generated code by Binis' code generator.*/
package net.binis.codegen.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import net.binis.codegen.collection.EmbeddedCodeListImpl;
import net.binis.codegen.enums.TestEnum;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.intf.Account;
import net.binis.codegen.intf.Previewable;
import net.binis.codegen.intf.Transaction;
import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.spring.BaseEntityModifierImpl;
import org.springframework.data.annotation.Transient;

import javax.annotation.processing.Generated;
import java.time.OffsetDateTime;
import java.util.List;

@Generated(value = "AccountEntityPrototype", comments = "Account")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(onlyExplicitlyIncluded = true)
@SuppressWarnings("unchecked")
public class AccountEntity extends BaseEntity implements Account, Previewable, Modifiable<Account.Modify> {

    // region constants
    public static final String TABLE_NAME = "accounts";

    private static final long serialVersionUID = -640283484493905851L;
    // endregion

    protected String accountNumber;

    protected boolean active = true;

    protected double available;

    protected double balance;
    protected String description;

    protected String externalId;

    protected String name;

    protected double pending;

    protected List<Transaction> transactions;

    protected TestEnum type = TestEnum.FIRST;

    // region constructor & initializer
    {
        CodeFactory.registerType(Account.class, AccountEntity::new, (p, v) ->
                ((AccountEntity) v).new AccountEntitySingleModifyImpl(p));
        CodeFactory.registerId(Account.class, "id", Long.class);
    }

    public AccountEntity() {
        super();
    }
    // endregion

    // region getters
    @Transient
    public String getPreview() {
        return getName() + " [" + this.accountNumber + "]";
    }

    public Account.Modify with() {
        return new AccountEntityModifyImpl();
    }
    // endregion

    // region inner classes
    protected class AccountEntityModifyImpl extends AccountEntityEmbeddedModifyImpl<Account.Modify, Account> implements Account.Modify {
    }

    protected class AccountEntitySingleModifyImpl extends AccountEntity.AccountEntityEmbeddedModifyImpl implements Account.EmbeddedSoloModify {
        protected AccountEntitySingleModifyImpl(Object parent) {
            super(parent);
        }
    }

    protected class AccountEntityEmbeddedModifyImpl<T, R> extends BaseEntityModifierImpl<T, R> implements Account.EmbeddedModify<T, R> {

        protected AccountEntityEmbeddedModifyImpl(Object parent) {
            this.parent = (R) parent;
        }

        protected AccountEntityEmbeddedModifyImpl() {
            setObject((R) AccountEntity.this);
        }

        public T accountNumber(String accountNumber) {
            AccountEntity.this.accountNumber = accountNumber;
            return (T) this;
        }

        public T active(boolean active) {
            AccountEntity.this.active = active;
            return (T) this;
        }

        public T available(double available) {
            AccountEntity.this.available = available;
            return (T) this;
        }

        public T balance(double balance) {
            AccountEntity.this.balance = balance;
            return (T) this;
        }

        public T description(String description) {
            AccountEntity.this.description = description;
            return (T) this;
        }

        public T externalId(String externalId) {
            AccountEntity.this.externalId = externalId;
            return (T) this;
        }

        public T id(Long id) {
            AccountEntity.this.id = id;
            return (T) this;
        }

        public T modified(OffsetDateTime modified) {
            AccountEntity.this.modified = modified;
            return (T) this;
        }

        public T name(String name) {
            AccountEntity.this.name = name;
            return (T) this;
        }

        public T pending(double pending) {
            AccountEntity.this.pending = pending;
            return (T) this;
        }

        public T transactions(List<Transaction> transactions) {
            AccountEntity.this.transactions = transactions;
            return (T) this;
        }

        public EmbeddedCodeCollection transactions() {
            if (AccountEntity.this.transactions == null) {
                AccountEntity.this.transactions = new java.util.ArrayList<>();
            }
            return new EmbeddedCodeListImpl<>(this, AccountEntity.this.transactions, Transaction.class);
        }

        public T type(TestEnum type) {
            AccountEntity.this.type = type;
            return (T) this;
        }

    }

    // endregion
}
