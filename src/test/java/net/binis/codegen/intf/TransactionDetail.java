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
import net.binis.codegen.creator.EntityCreator;
import net.binis.codegen.creator.EntityCreatorModifier;
import net.binis.codegen.enums.TestEnum;
import net.binis.codegen.modifier.BaseModifier;
import net.binis.codegen.spring.query.*;

import javax.annotation.processing.Generated;
import java.time.OffsetDateTime;
import java.util.function.Consumer;

@Generated(value = "TransactionDetailEntityPrototype", comments = "TransactionDetailEntity")
@Default("net.binis.codegen.impl.TransactionDetailEntity")
public interface TransactionDetail extends Base, Taggable {

    // region starters
    static TransactionDetail.Modify create() {
        return (TransactionDetail.Modify) EntityCreatorModifier.create(TransactionDetail.class).with();
    }

    static QueryStarter<TransactionDetail, TransactionDetail.QuerySelect<TransactionDetail>, QueryAggregateOperation<QueryOperationFields<TransactionDetail.QueryAggregate<Number, TransactionDetail.QuerySelect<Number>>>>, QueryFieldsStart<TransactionDetail, TransactionDetail.QuerySelect<TransactionDetail>>, QueryUpdate<TransactionDetail, TransactionDetail.QuerySelect<TransactionDetail>>> find() {
        return (QueryStarter) EntityCreator.create(TransactionDetail.QuerySelect.class);
    }
    // endregion

    SubTransaction getParent();

    TransactionDetail.Modify with();

    // region inner classes
    interface Fields<T> extends Base.Fields<T> {
        T parent(SubTransaction parent);
        T tag(Object tag);
    }

    interface Modify extends TransactionDetail.Fields<TransactionDetail.Modify>, BaseModifier<TransactionDetail.Modify, TransactionDetail> {
        SubTransaction.EmbeddedSoloModify<Modify> parent();
        Modify parent(Consumer<SubTransaction.Modify> init);
    }

    interface QueryAggregate<QR, QA> extends QueryExecute<QR>, QueryAggregator<QA, QueryAggregateOperation<QueryOperationFields<TransactionDetail.QueryAggregate<TransactionDetail, TransactionDetail.QuerySelect<Number>>>>> {
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
    }

    interface QueryOperationFields<QR> extends QueryScript<QR>, QuerySelf<QR> {
        QR date();
        QR id();
        SubTransaction.QueryOperationFields<QR> parent();
        QR type();
    }

    interface QueryOrder<QR> extends QueryOperationFields<QueryOrderOperation<TransactionDetail.QueryOrder<QR>, QR>>, QueryExecute<QR> {
    }

    interface QuerySelect<QR> extends QueryExecute<QR>, QueryModifiers<TransactionDetail.QueryName<TransactionDetail.QuerySelect<QR>, TransactionDetail.QueryOrder<QR>, QR, TransactionDetail>>, TransactionDetail.QueryFields<QuerySelectOperation<TransactionDetail.QuerySelect<QR>, TransactionDetail.QueryOrder<QR>, QR>>, TransactionDetail.QueryFuncs<QuerySelectOperation<TransactionDetail.QuerySelect<QR>, TransactionDetail.QueryOrder<QR>, QR>>, QueryOrderStart<QueryOperationFields<QueryOrderOperation<TransactionDetail.QueryOrder<QR>, QR>>>, QueryBracket<QuerySelect<QR>> {
    }

    interface QueryUpdate<QR, QS> extends QueryFields<QueryUpdate<QR, QS>>, QueryWhere<QS>, QueryScript<QueryUpdate<QR, QS>>, UpdatableQuery {
    }
    // endregion
}
