/*Generated code by Binis' code generator.*/
package net.binis.codegen.modifier.test;

import net.binis.codegen.spring.query.*;
import net.binis.codegen.modifier.BaseModifier;
import net.binis.codegen.intf.Taggable;
import net.binis.codegen.enums.TestEnum;
import net.binis.codegen.creator.EntityCreatorModifier;
import net.binis.codegen.creator.EntityCreator;
import net.binis.codegen.annotation.Default;
import javax.annotation.processing.Generated;
import java.util.function.Consumer;
import java.util.Optional;
import java.util.List;
import java.time.OffsetDateTime;

@Generated(value = "SubTransactionEntityPrototype", comments = "SubTransactionEntity")
@Default("net.binis.codegen.modifier.test.TransactionEntity")
public interface SubTransaction extends Taggable, Transaction {
    SubTransaction.Modify asSubTransaction();

    // region starters
    @SuppressWarnings(value = "unchecked")
    static SubTransaction.Modify create() {
        return ((SubTransaction) EntityCreatorModifier.create(SubTransaction.class)).asSubTransaction();
    }

    @SuppressWarnings(value = "unchecked")
    static QueryStarter<SubTransaction, SubTransaction.QuerySelect<SubTransaction>, QueryAggregateOperation<QueryOperationFields<SubTransaction.QueryAggregate<Number, SubTransaction.QuerySelect<Number>>>>, QueryFieldsStart<SubTransaction, SubTransaction.QuerySelect<SubTransaction>>, QueryUpdate<SubTransaction, SubTransaction.QuerySelect<SubTransaction>>> find() {
        return (QueryStarter) EntityCreator.create(SubTransaction.QuerySelect.class);
    }
    // endregion

    Transaction getParent();

    // region inner classes
    interface EmbeddedModify<T, R> extends BaseModifier<T, R>, SubTransaction.Fields<T> {
        Account.EmbeddedSoloModify<EmbeddedModify<T, R>> account();
        Account.EmbeddedSoloModify<EmbeddedModify<T, R>> counterparty();
        Transaction.EmbeddedSoloModify<EmbeddedModify<T, R>> parent();
    }

    interface EmbeddedSoloModify<R> extends SubTransaction.EmbeddedModify<SubTransaction.EmbeddedSoloModify<R>, R> {
    }

    interface Fields<T> extends Transaction.Fields<T> {
        T parent(Transaction parent);
        T tag(Object tag);
    }

    interface Modify extends EmbeddedModify<SubTransaction.Modify, SubTransaction> {
        Modify account$(Consumer<Account.Modify> init);
        Modify counterparty$(Consumer<Account.Modify> init);
        Modify parent$(Consumer<Transaction.Modify> init);
    }

    interface QueryAggregate<QR, QA> extends QueryExecute<QR>, QueryAggregator<QA, QueryAggregateOperation<QueryOperationFields<SubTransaction.QueryAggregate<SubTransaction, SubTransaction.QuerySelect<Number>>>>, SubTransaction.QueryAggregate<SubTransaction, SubTransaction.QuerySelect<Number>>> {
    }

    interface QueryFields<QR> extends QueryScript<QR>, SubTransaction.Fields<QR> {
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

    interface QueryName<QS, QO, QR, QF> extends SubTransaction.QueryFields<QuerySelectOperation<QS, QO, QR>>, SubTransaction.QueryFuncs<QuerySelectOperation<QS, QO, QR>>, QueryFetch<QuerySelectOperation<QS, QO, QR>, QF> {
        Account.QueryName<QS, QO, QR, Account> account();
        Account.QueryName<QS, QO, QR, Account> counterparty();
        Transaction.QueryName<QS, QO, QR, Transaction> parent();
    }

    interface QueryOperationFields<QR> extends QueryScript<QR>, QuerySelf<QR> {
        Account.QueryOperationFields<QR> account();
        QR amount();
        Account.QueryOperationFields<QR> counterparty();
        QR date();
        QR id();
        Transaction.QueryOperationFields<QR> parent();
        QR timestamp();
        QR type();
    }

    interface QueryOrder<QR> extends QueryOperationFields<QueryOrderOperation<SubTransaction.QueryOrder<QR>, QR>>, QueryExecute<QR> {
    }

    interface QuerySelect<QR> extends QueryExecute<QR>, QueryModifiers<SubTransaction.QueryName<SubTransaction.QuerySelect<QR>, SubTransaction.QueryOrder<QR>, QR, SubTransaction>>, SubTransaction.QueryFields<QuerySelectOperation<SubTransaction.QuerySelect<QR>, SubTransaction.QueryOrder<QR>, QR>>, SubTransaction.QueryFuncs<QuerySelectOperation<SubTransaction.QuerySelect<QR>, SubTransaction.QueryOrder<QR>, QR>>, QueryOrderStart<QueryOperationFields<QueryOrderOperation<SubTransaction.QueryOrder<QR>, QR>>>, QueryBracket<QuerySelect<QR>> {
        Account.QueryName<SubTransaction.QuerySelect<QR>, SubTransaction.QueryOrder<QR>, QR, Account> account();
        Account.QueryName<SubTransaction.QuerySelect<QR>, SubTransaction.QueryOrder<QR>, QR, Account> counterparty();
        Transaction.QueryName<SubTransaction.QuerySelect<QR>, SubTransaction.QueryOrder<QR>, QR, Transaction> parent();
    }

    interface QueryUpdate<QR, QS> extends QueryFields<QueryUpdate<QR, QS>>, QueryWhere<QS>, QueryScript<QueryUpdate<QR, QS>>, UpdatableQuery {
    }
    // endregion
}
