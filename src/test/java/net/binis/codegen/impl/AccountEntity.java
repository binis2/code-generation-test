/*Generated code by Binis' code generator.*/
package net.binis.codegen.impl;

/*-
 * #%L
 * code-generation-test
 * %%
 * Copyright (C) 2021 - 2022 Binis Belev
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import net.binis.codegen.BaseImpl;
import net.binis.codegen.intf.Account;
import net.binis.codegen.intf.Transaction;
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
        return new AccountEntityModifyImpl(this);
    }
    // endregion

    // region inner classes
    protected class AccountEntityEmbeddedModifyImpl<T, R> extends BaseModifierImpl<T, R> implements Account.EmbeddedModify<T, R> {

        protected AccountEntityEmbeddedModifyImpl(R parent) {
            super(parent);
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
        protected AccountEntityModifyImpl(Account parent) {
            super(parent);
        }
    }

    protected class AccountEntitySoloModifyImpl extends AccountEntityEmbeddedModifyImpl implements Account.EmbeddedSoloModify {

        protected AccountEntitySoloModifyImpl(Object parent) {
            super(parent);
        }
    }
    // endregion
}