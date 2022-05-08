/*Generated code by Binis' code generator.*/
package net.binis.codegen.modifier.test;

import net.binis.codegen.modifier.impl.BaseModifierImpl;
import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.enums.TestEnum;
import net.binis.codegen.collection.EmbeddedCodeListImpl;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import net.binis.codegen.collection.CodeListImpl;
import net.binis.codegen.collection.CodeList;
import javax.annotation.processing.Generated;
import java.util.List;
import java.time.OffsetDateTime;

@Generated(value = "AccountEntityPrototype", comments = "Account")
public class AccountEntity extends BaseImpl implements Account, Modifiable<Account.Modify> {

    protected String accountNumber;

    protected boolean active;

    protected double available;

    protected double balance;

    protected double pending;

    protected List<String> strings;

    protected List<Transaction> transactions;

    // region constructor & initializer
    {
        CodeFactory.registerType(Account.class, AccountEntity::new, (p, v) -> ((AccountEntity) v).new AccountEntitySoloModifyImpl(p));
    }

    public AccountEntity() {
        super();
    }
    // endregion

    // region getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAvailable() {
        return available;
    }

    public double getBalance() {
        return balance;
    }

    public double getPending() {
        return pending;
    }

    public List<String> getStrings() {
        return strings;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public boolean isActive() {
        return active;
    }

    public Account.Modify with() {
        return new AccountEntityModifyImpl();
    }
    // endregion

    // region inner classes
    protected class AccountEntityEmbeddedModifyImpl<T, R> extends BaseModifierImpl<T, R> implements Account.EmbeddedModify<T, R> {

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

        public T date(OffsetDateTime date) {
            AccountEntity.this.date = date;
            return (T) this;
        }

        public T id(Long id) {
            AccountEntity.this.id = id;
            return (T) this;
        }

        public T pending(double pending) {
            AccountEntity.this.pending = pending;
            return (T) this;
        }

        public T strings(List<String> strings) {
            AccountEntity.this.strings = strings;
            return (T) this;
        }

        public CodeList strings() {
            if (AccountEntity.this.strings == null) {
                AccountEntity.this.strings = new java.util.ArrayList<>();
            }
            return new CodeListImpl<>(this, AccountEntity.this.strings);
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

    protected class AccountEntityModifyImpl extends AccountEntityEmbeddedModifyImpl<Account.Modify, Account> implements Account.Modify {
    }

    protected class AccountEntitySoloModifyImpl extends AccountEntityEmbeddedModifyImpl implements Account.EmbeddedSoloModify {

        protected AccountEntitySoloModifyImpl(Object parent) {
            super(parent);
        }
    }
    // endregion
}
