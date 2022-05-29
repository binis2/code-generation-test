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
import net.binis.codegen.spring.query.*;
import net.binis.codegen.spring.modifier.BaseEntityModifier;
import net.binis.codegen.modifier.BaseModifier;
import net.binis.codegen.intf.Taggable;
import net.binis.codegen.enums.TestEnum;
import net.binis.codegen.creator.EntityCreatorModifier;
import net.binis.codegen.creator.EntityCreator;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import net.binis.codegen.annotation.Default;
import javax.annotation.processing.Generated;
import java.util.function.Consumer;
import java.util.Optional;
import java.util.List;
import java.time.OffsetDateTime;

@Generated(value = "TransactionEntityPrototype", comments = "TransactionEntity")
@Default("net.binis.codegen.impl.TransactionEntity")
public interface Transaction extends Base, Taggable {

    // region starters
    static Transaction.Modify create() {
        return (Transaction.Modify) EntityCreatorModifier.create(Transaction.class).with();
    }

    static QueryStarter<Transaction, Transaction.QuerySelect<Transaction>, QueryAggregateOperation<QueryOperationFields<Transaction.QueryAggregate<Number, Transaction.QuerySelect<Number>>>>, QueryFieldsStart<Transaction, Transaction.QuerySelect<Transaction>>, QueryUpdate<Transaction, Transaction.QuerySelect<Transaction>>> find() {
        return (QueryStarter) EntityCreator.create(Transaction.QuerySelect.class);
    }
    // endregion

    Account getAccount();
    double getAmount();
    Account getCounterparty();
    OffsetDateTime getTimestamp();

    Transaction.Modify with();

    // region inner classes
    interface EmbeddedCollectionModify<R> extends Transaction.EmbeddedModify<Transaction.EmbeddedCollectionModify<R>, R> {
        EmbeddedCodeCollection<Transaction.EmbeddedCollectionModify<R>, Transaction, R> _and();
    }

    interface EmbeddedModify<T, R> extends BaseModifier<T, R>, Transaction.Fields<T> {
        Account.EmbeddedSoloModify<EmbeddedModify<T, R>> account();
        Account.EmbeddedSoloModify<EmbeddedModify<T, R>> counterparty();
    }

    interface EmbeddedSoloModify<R> extends Transaction.EmbeddedModify<Transaction.EmbeddedSoloModify<R>, R> {
    }

    interface Fields<T> extends Base.Fields<T> {
        T account(Account account);
        T amount(double amount);
        T counterparty(Account counterparty);
        T tag(Object tag);
        T timestamp(OffsetDateTime timestamp);
    }

    interface Modify extends EmbeddedModify<Transaction.Modify, Transaction>, BaseEntityModifier<Transaction.Modify, Transaction> {
        Modify account(Consumer<Account.Modify> init);
        Modify counterparty(Consumer<Account.Modify> init);
    }

    interface QueryAggregate<QR, QA> extends QueryExecute<QR>, QueryAggregator<QA, QueryAggregateOperation<QueryOperationFields<Transaction.QueryAggregate<Transaction, Transaction.QuerySelect<Number>>>>> {
    }

    interface QueryFields<QR> extends QueryScript<QR>, Transaction.Fields<QR> {
    }

    interface QueryFieldsStart<QR, QS> extends QueryExecute<QR>, QueryWhere<QS>, QueryOperationFields<QueryFieldsStart<QR, QS>> {
    }

    interface QueryFuncs<QR> {
        QueryFunctions<Double, QR> amount();
        QueryFunctions<OffsetDateTime, QR> date();
        QueryFunctions<Long, QR> id();
        QueryFunctions<OffsetDateTime, QR> timestamp();
        QueryFunctions<TestEnum, QR> type();
    }

    interface QueryName<QS, QO, QR, QF> extends Transaction.QueryFields<QuerySelectOperation<QS, QO, QR>>, Transaction.QueryFuncs<QuerySelectOperation<QS, QO, QR>>, QueryFetch<QuerySelectOperation<QS, QO, QR>, QF> {
        Account.QueryName<QS, QO, QR, Account> account();
        Account.QueryName<QS, QO, QR, Account> counterparty();
    }

    interface QueryOperationFields<QR> extends QueryScript<QR>, QuerySelf<QR> {
        Account.QueryOperationFields<QR> account();
        QR amount();
        Account.QueryOperationFields<QR> counterparty();
        QR date();
        QR id();
        QR timestamp();
        QR type();
    }

    interface QueryOrder<QR> extends QueryOperationFields<QueryOrderOperation<Transaction.QueryOrder<QR>, QR>>, QueryExecute<QR> {
    }

    interface QuerySelect<QR> extends QueryExecute<QR>, QueryModifiers<Transaction.QueryName<Transaction.QuerySelect<QR>, Transaction.QueryOrder<QR>, QR, Transaction>>, Transaction.QueryFields<QuerySelectOperation<Transaction.QuerySelect<QR>, Transaction.QueryOrder<QR>, QR>>, Transaction.QueryFuncs<QuerySelectOperation<Transaction.QuerySelect<QR>, Transaction.QueryOrder<QR>, QR>>, QueryOrderStart<QueryOperationFields<QueryOrderOperation<Transaction.QueryOrder<QR>, QR>>>, QueryBracket<QuerySelect<QR>> {
        Account.QueryName<Transaction.QuerySelect<QR>, Transaction.QueryOrder<QR>, QR, Account> account();
        Account.QueryName<Transaction.QuerySelect<QR>, Transaction.QueryOrder<QR>, QR, Account> counterparty();
    }

    interface QueryUpdate<QR, QS> extends QueryFields<QueryUpdate<QR, QS>>, QueryWhere<QS>, QueryScript<QueryUpdate<QR, QS>>, UpdatableQuery {
    }
    // endregion
}
