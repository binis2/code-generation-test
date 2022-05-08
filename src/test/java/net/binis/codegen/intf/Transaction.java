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
import net.binis.codegen.collection.EmbeddedCodeCollection;
import net.binis.codegen.creator.EntityCreatorModifier;
import net.binis.codegen.modifier.BaseModifier;

import javax.annotation.processing.Generated;
import java.time.OffsetDateTime;
import java.util.function.Consumer;

@Generated(value = "TransactionEntityPrototype", comments = "TransactionEntity")
@Default("net.binis.codegen.impl.TransactionEntity")
public interface Transaction extends Base, Taggable {

    // region starters
    static Transaction.Modify create() {
        return (Transaction.Modify) EntityCreatorModifier.create(Transaction.class).with();
    }
    // endregion

    Account getAccount();
    double getAmount();
    Account getCounterparty();
    Transaction getParent();
    OffsetDateTime getTimestamp();

    Transaction.Modify with();

    // region inner classes
    interface EmbeddedCollectionModify<R> extends Transaction.EmbeddedModify<Transaction.EmbeddedCollectionModify<R>, R> {
        EmbeddedCodeCollection<Transaction.EmbeddedCollectionModify<R>, Transaction, R> _and();
    }

    interface EmbeddedModify<T, R> extends BaseModifier<T, R>, Transaction.Fields<T> {
        Account.EmbeddedSoloModify<EmbeddedModify<T, R>> account();
        Account.EmbeddedSoloModify<EmbeddedModify<T, R>> counterparty();
        Transaction.EmbeddedSoloModify<EmbeddedModify<T, R>> parent();
    }

    interface EmbeddedSoloModify<R> extends Transaction.EmbeddedModify<Transaction.EmbeddedSoloModify<R>, R> {
    }

    interface Fields<T> extends Base.Fields<T> {
        T account(Account account);
        T amount(double amount);
        T counterparty(Account counterparty);
        T parent(Transaction parent);
        T tag(Object tag);
        T timestamp(OffsetDateTime timestamp);
    }

    interface Modify extends EmbeddedModify<Transaction.Modify, Transaction> {
        Modify account(Consumer<Account.Modify> init);
        Modify counterparty(Consumer<Account.Modify> init);
        Modify parent(Consumer<Transaction.Modify> init);
    }
    // endregion
}
