/*Generated code by Binis' code generator.*/
package net.binis.codegen;

/*-
 * #%L
 * code-generation-test
 * %%
 * Copyright (C) 2021 - 2026 Binis Belev
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

import net.binis.codegen.spring.query.*;
import net.binis.codegen.creator.EntityCreator;
import net.binis.codegen.annotation.Default;
import javax.annotation.processing.Generated;
import java.util.Optional;
import java.util.List;

@Generated(value = "net.binis.codegen.Test2Prototype", comments = "Test2Impl")
@Default("net.binis.codegen.Test2Impl")
@SuppressWarnings("unchecked")
public interface Test2 {

    static QueryStarter<Test2, Test2.QuerySelect<Test2>, QueryAggregateOperation<QueryOperationFields<Test2.QueryAggregate<Number, Test2.QuerySelect<Number>>>>, QueryFieldsStart<Test2, Test2.QuerySelect<Test2>>, QueryUpdate<Test2, Test2.QuerySelect<Test2>>> find() {
        return (QueryStarter) EntityCreator.create(Test2.QuerySelect.class);
    }

    double getAmount();
    List<Long> getItems();
    Test2 getParent();
    Sub getSub();
    String getTitle();

    void setAmount(double amount);
    void setItems(List<Long> items);
    void setParent(Test2 parent);
    void setSub(Sub sub);
    void setTitle(String title);

    interface QueryAggregate<QR, QA> extends QueryExecute<QR>, QueryAggregator<QA, QueryAggregateOperation<QueryOperationFields<Test2.QueryAggregate<Test2, Test2.QuerySelect<Number>>>>, Test2.QueryAggregate<Test2, Test2.QuerySelect<Number>>> {
    }

    interface QueryFields<QR> extends QueryScript<QR> {
        QR amount(double amount);
        QR parent(Test2 parent);
        QR sub(Sub sub);
        QR title(String title);
    }

    interface QueryFieldsStart<QR, QS> extends QueryExecute<QR>, QueryWhere<QS>, QueryOperationFields<QueryFieldsStart<QR, QS>> {
    }

    interface QueryFuncs<QR> {
        QueryFunctions<Double, QR> amount();
        QueryFunctions<String, QR> title();
    }

    interface QueryName<QS, QO, QR, QF> extends Test2.QueryFields<QuerySelectOperation<QS, QO, QR>>, Test2.QueryFuncs<QuerySelectOperation<QS, QO, QR>>, QueryFetch<QuerySelectOperation<QS, QO, QR>, QF> {
        Test2.QueryName<QS, QO, QR, Test2> parent();
        Sub.QueryName<QS, QO, QR, Sub> sub();
    }

    interface QueryOperationFields<QR> extends QueryScript<QR>, QuerySelf<QR> {
        QR amount();
        Test2.QueryOperationFields<QR> parent();
        Sub.QueryOperationFields<QR> sub();
        QR title();
    }

    interface QueryOrder<QR> extends QueryOperationFields<QueryOrderOperation<Test2.QueryOrder<QR>, QR>>, QueryExecute<QR> {
    }

    interface QuerySelect<QR> extends QueryExecute<QR>, QueryModifiers<Test2.QueryName<Test2.QuerySelect<QR>, Test2.QueryOrder<QR>, QR, Test2>>, Test2.QueryFields<QuerySelectOperation<Test2.QuerySelect<QR>, Test2.QueryOrder<QR>, QR>>, Test2.QueryFuncs<QuerySelectOperation<Test2.QuerySelect<QR>, Test2.QueryOrder<QR>, QR>>, QueryOrderStart<QueryOperationFields<QueryOrderOperation<Test2.QueryOrder<QR>, QR>>>, QueryBracket<QuerySelect<QR>> {
        QueryCollectionFunctions<Long, QuerySelectOperation<Test2.QuerySelect<QR>, QueryOperationFields<QueryOrderOperation<Test2.QueryOrder<QR>, QR>>, QR>> items();
        Test2.QueryName<Test2.QuerySelect<QR>, Test2.QueryOrder<QR>, QR, Test2> parent();
        Sub.QueryName<Test2.QuerySelect<QR>, Test2.QueryOrder<QR>, QR, Sub> sub();
    }

    interface QueryUpdate<QR, QS> extends QueryFields<QueryUpdate<QR, QS>>, QueryWhere<QS>, QueryScript<QueryUpdate<QR, QS>>, UpdatableQuery {
    }
}
