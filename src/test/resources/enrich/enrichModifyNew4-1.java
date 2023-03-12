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

@Generated(value = "net.binis.codegen.modifier.test.TransactionDetailEntityPrototype", comments = "TransactionDetailEntity")
@Default("net.binis.codegen.modifier.test.TransactionDetailEntity")
@SuppressWarnings("unchecked")
public interface TransactionDetail extends Base, Taggable {

    // region starters
    static TransactionDetail.Modify create() {
        return (TransactionDetail.Modify) EntityCreatorModifier.create(TransactionDetail.class).with();
    }

    static QueryStarter<TransactionDetail, TransactionDetail.QuerySelect<TransactionDetail>, QueryAggregateOperation<QueryOperationFields<TransactionDetail.QueryAggregate<Number, TransactionDetail.QuerySelect<Number>>>>, QueryFieldsStart<TransactionDetail, TransactionDetail.QuerySelect<TransactionDetail>>, QueryUpdate<TransactionDetail, TransactionDetail.QuerySelect<TransactionDetail>>> find() {
        return (QueryStarter) EntityCreator.create(TransactionDetail.QuerySelect.class);
    }
    // endregion

    SubTransaction getParented();

    TransactionDetail.Modify with();

    // region inner classes
    interface Fields<T> extends Base.Fields<T> {
        T parented(SubTransaction parented);
        T tag(Object tag);
    }

    interface Modify extends TransactionDetail.Fields<TransactionDetail.Modify>, BaseModifier<TransactionDetail.Modify, TransactionDetail> {
        SubTransaction.EmbeddedSoloModify<Modify> parented();
        Modify parented$(Consumer<SubTransaction.Modify> init);
    }

    interface QueryAggregate<QR, QA> extends QueryExecute<QR>, QueryAggregator<QA, QueryAggregateOperation<QueryOperationFields<TransactionDetail.QueryAggregate<TransactionDetail, TransactionDetail.QuerySelect<Number>>>>, TransactionDetail.QueryAggregate<TransactionDetail, TransactionDetail.QuerySelect<Number>>> {
    }

    interface QueryFields<QR> extends QueryScript<QR>, TransactionDetail.Fields<QR> {
    }

    interface QueryFieldsStart<QR, QS> extends QueryExecute<QR>, QueryWhere<QS>, QueryOperationFields<QueryFieldsStart<QR, QS>> {
    }

    interface QueryFuncs<QR> {
        QueryFunctions<OffsetDateTime, QR> date();
        QueryFunctions<Long, QR> id();
        QueryFunctions<TestEnum, QR> type();
    }

    interface QueryName<QS, QO, QR, QF> extends TransactionDetail.QueryFields<QuerySelectOperation<QS, QO, QR>>, TransactionDetail.QueryFuncs<QuerySelectOperation<QS, QO, QR>>, QueryFetch<QuerySelectOperation<QS, QO, QR>, QF> {
        SubTransaction.QueryName<QS, QO, QR, SubTransaction> parented();
    }

    interface QueryOperationFields<QR> extends QueryScript<QR>, QuerySelf<QR> {
        QR date();
        QR id();
        SubTransaction.QueryOperationFields<QR> parented();
        QR type();
    }

    interface QueryOrder<QR> extends QueryOperationFields<QueryOrderOperation<TransactionDetail.QueryOrder<QR>, QR>>, QueryExecute<QR> {
    }

    interface QuerySelect<QR> extends QueryExecute<QR>, QueryModifiers<TransactionDetail.QueryName<TransactionDetail.QuerySelect<QR>, TransactionDetail.QueryOrder<QR>, QR, TransactionDetail>>, TransactionDetail.QueryFields<QuerySelectOperation<TransactionDetail.QuerySelect<QR>, TransactionDetail.QueryOrder<QR>, QR>>, TransactionDetail.QueryFuncs<QuerySelectOperation<TransactionDetail.QuerySelect<QR>, TransactionDetail.QueryOrder<QR>, QR>>, QueryOrderStart<QueryOperationFields<QueryOrderOperation<TransactionDetail.QueryOrder<QR>, QR>>>, QueryBracket<QuerySelect<QR>> {
        SubTransaction.QueryName<TransactionDetail.QuerySelect<QR>, TransactionDetail.QueryOrder<QR>, QR, SubTransaction> parented();
    }

    interface QueryUpdate<QR, QS> extends QueryFields<QueryUpdate<QR, QS>>, QueryWhere<QS>, QueryScript<QueryUpdate<QR, QS>>, UpdatableQuery {
    }
    // endregion
}
