package net.binis.codegen.intf;

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

import net.binis.codegen.Base;
import net.binis.codegen.annotation.Default;
import net.binis.codegen.collection.CodeList;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import net.binis.codegen.creator.EntityCreatorModifier;
import net.binis.codegen.modifier.BaseModifier;

import javax.annotation.processing.Generated;
import java.util.List;

@Generated(value = "AccountEntityPrototype", comments = "AccountEntity")
@Default("net.binis.codegen.impl.AccountEntity")
public interface Account extends Base {

    // region starters
    static Account.Modify create() {
        return (Account.Modify) EntityCreatorModifier.create(Account.class).with();
    }
    // endregion

    String getAccountNumber();
    double getAvailable();
    double getBalance();
    double getPending();
    List<String> getStrings();
    List<Transaction> getTransactions();

    boolean isActive();

    Account.Modify with();

    // region inner classes
    interface EmbeddedModify<T, R> extends BaseModifier<T, R>, Account.Fields<T> {
        T strings(List<String> strings);
        CodeList<String, Account.EmbeddedModify<T, R>> strings();
        T transactions(List<Transaction> transactions);
        EmbeddedCodeCollection<Transaction.EmbeddedCollectionModify<Account.EmbeddedModify<T, R>>, Transaction, Account.EmbeddedModify<T, R>> transactions();
    }

    interface EmbeddedSoloModify<R> extends Account.EmbeddedModify<Account.EmbeddedSoloModify<R>, R> {
    }

    interface Fields<T> extends Base.Fields<T> {
        T accountNumber(String accountNumber);
        T active(boolean active);
        T available(double available);
        T balance(double balance);
        T pending(double pending);
    }

    interface Modify extends EmbeddedModify<Account.Modify, Account> {
    }
    // endregion
}
