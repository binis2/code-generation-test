/*Generated code by Binis' code generator.*/
package net.binis.codegen.impl;

/*-
 * #%L
 * code-generation-test
 * %%
 * Copyright (C) 2021 - 2024 Binis Belev
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

import net.binis.codegen.collection.CodeList;
import net.binis.codegen.collection.CodeListImpl;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import net.binis.codegen.collection.EmbeddedCodeListImpl;
import net.binis.codegen.enums.TestEnum;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.intf.Account;
import net.binis.codegen.intf.Transaction;
import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.spring.modifier.impl.BaseEntityModifierImpl;
import net.binis.codegen.spring.query.*;
import net.binis.codegen.spring.query.base.BaseQueryNameImpl;
import net.binis.codegen.spring.query.executor.QueryExecutor;
import net.binis.codegen.spring.query.executor.QueryOrderer;

import javax.annotation.processing.Generated;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.function.Function;

@Generated(value = "AccountEntityPrototype", comments = "Account")
@SuppressWarnings("unchecked")
public class AccountEntity extends BaseEntity implements Account, Modifiable<Account.Modify> {

    protected String accountNumber;

    protected boolean active;

    protected double available;

    protected double balance;

    protected double pending;

    protected List<String> strings;

    protected List<Transaction> transactions;

    // region constructor & initializer
    static {
        CodeFactory.registerType(Account.class, AccountEntity::new, (p, v, r) -> ((AccountEntity) v).new AccountEntitySoloModifyImpl(p));
        CodeFactory.registerType(Account.QueryName.class, AccountQueryNameImpl::new, null);
        CodeFactory.registerType(Account.QuerySelect.class, AccountQueryExecutorImpl::new, null);
        CodeFactory.registerType(Account.QueryOperationFields.class, AccountQueryExecutorImpl::new, null);
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
    protected class AccountEntityEmbeddedModifyImpl<T, R> extends BaseEntityModifierImpl<T, R> implements Account.EmbeddedModify<T, R> {

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

    protected static class AccountQueryExecutorImpl extends QueryExecutor implements Account.QueryUpdate, Account.QuerySelect, Account.QueryFieldsStart {

        protected AccountQueryExecutorImpl() {
            super(Account.class, () -> new AccountQueryNameImpl(), parent -> parent);
        }

        public QuerySelectOperation accountNumber(String accountNumber) {
            return $identifier("accountNumber", accountNumber);
        }

        public QueryFunctions accountNumber() {
            return $identifier("accountNumber");
        }

        public QuerySelectOperation active(boolean active) {
            return $identifier("active", active);
        }

        public QueryFunctions active() {
            return $identifier("active");
        }

        public QueryAggregateOperation aggregate() {
            return (QueryAggregateOperation) _aggregateStart(new AccountQueryOrderImpl(this, AccountQueryExecutorImpl.this::_aggregateIdentifier));
        }

        public QuerySelectOperation available(double available) {
            return $identifier("available", available);
        }

        public QueryFunctions available() {
            return $identifier("available");
        }

        public QuerySelectOperation balance(double balance) {
            return $identifier("balance", balance);
        }

        public QueryFunctions balance() {
            return $identifier("balance");
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

        public Account.QueryOrder order() {
            return (Account.QueryOrder) _orderStart(new AccountQueryOrderImpl(this, AccountQueryExecutorImpl.this::_orderIdentifier));
        }

        public QuerySelectOperation pending(double pending) {
            return $identifier("pending", pending);
        }

        public QueryFunctions pending() {
            return $identifier("pending");
        }

        public QueryCollectionFunctions strings() {
            return $identifier("strings");
        }

        public QueryJoinCollectionFunctions transactions() {
            return (QueryJoinCollectionFunctions) joinStart("transactions", Transaction.QueryOrder.class);
        }

        public QuerySelectOperation type(TestEnum type) {
            return $identifier("type", type);
        }

        public QueryFunctions type() {
            return $identifier("type");
        }

        protected class AccountQueryOrderImpl extends QueryOrderer implements Account.QueryOrder, Account.QueryAggregate {

            protected AccountQueryOrderImpl(AccountQueryExecutorImpl executor, Function<String, Object> func) {
                super(executor, func);
            }

            public QueryOrderOperation accountNumber() {
                return (QueryOrderOperation) func.apply("accountNumber");
            }

            public QueryOrderOperation active() {
                return (QueryOrderOperation) func.apply("active");
            }

            public QueryOrderOperation available() {
                return (QueryOrderOperation) func.apply("available");
            }

            public QueryOrderOperation balance() {
                return (QueryOrderOperation) func.apply("balance");
            }

            public QueryOrderOperation date() {
                return (QueryOrderOperation) func.apply("date");
            }

            public QueryOrderOperation id() {
                return (QueryOrderOperation) func.apply("id");
            }

            public QueryOrderOperation pending() {
                return (QueryOrderOperation) func.apply("pending");
            }

            public QueryOrderOperation type() {
                return (QueryOrderOperation) func.apply("type");
            }
        }
    }

    protected static class AccountQueryNameImpl extends BaseQueryNameImpl implements Account.QueryName, QueryEmbed {

        public QueryFunctions accountNumber() {
            return executor.$identifier("accountNumber");
        }

        public QuerySelectOperation accountNumber(String accountNumber) {
            return executor.$identifier("accountNumber", accountNumber);
        }

        public QueryFunctions active() {
            return executor.$identifier("active");
        }

        public QuerySelectOperation active(boolean active) {
            return executor.$identifier("active", active);
        }

        public QueryFunctions available() {
            return executor.$identifier("available");
        }

        public QuerySelectOperation available(double available) {
            return executor.$identifier("available", available);
        }

        public QueryFunctions balance() {
            return executor.$identifier("balance");
        }

        public QuerySelectOperation balance(double balance) {
            return executor.$identifier("balance", balance);
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

        public QueryFunctions pending() {
            return executor.$identifier("pending");
        }

        public QuerySelectOperation pending(double pending) {
            return executor.$identifier("pending", pending);
        }

        public QueryFunctions type() {
            return executor.$identifier("type");
        }

        public QuerySelectOperation type(TestEnum type) {
            return executor.$identifier("type", type);
        }
    }
    // endregion
}
