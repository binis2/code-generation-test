/*Generated code by Binis' code generator.*/
package net.binis.codegen;

/*-
 * #%L
 * code-generation-test
 * %%
 * Copyright (C) 2021 Binis Belev
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
import java.util.Optional;
import java.util.List;

public interface Sub {

    static QueryStarter<Sub, Sub.QuerySelect<Sub>, QueryAggregateOperation<QueryOperationFields<Sub.QueryAggregate<Number, Sub.QuerySelect<Number>>>>> find() {
        return (QueryStarter) EntityCreator.create(Sub.QuerySelect.class);
    }

    double getSubAmount();

    String getSubtitle();

    void setSubAmount(double subAmount);

    void setSubtitle(String subtitle);

    interface QueryAggregate<QR, QA> extends QueryExecute<QR>, QueryAggregator<QA, QueryAggregateOperation<QueryOperationFields<Sub.QueryAggregate<Sub, Sub.QuerySelect<Number>>>>> {
    }

    interface QueryFields<QR> extends QueryScript<QR> {

        QR subAmount(double subAmount);

        QR subtitle(String subtitle);
    }

    interface QueryFuncs<QR> {

        QueryFunctions<Double, QR> subAmount();

        QueryFunctions<String, QR> subtitle();
    }

    interface QueryName<QS, QO, QR> extends Sub.QueryFields<QuerySelectOperation<QS, QO, QR>>, Sub.QueryFuncs<QuerySelectOperation<QS, QO, QR>> {
    }

    interface QueryOperationFields<QR> extends QueryScript<QR> {

        QR subAmount();

        QR subtitle();
    }

    interface QueryOrder<QR> extends QueryOperationFields<QueryOrderOperation<Sub.QueryOrder<QR>, QR>>, QueryExecute<QR>, QueryScript<QueryOrderOperation<Sub.QueryOrder<QR>, QR>> {
    }

    interface QuerySelect<QR> extends QueryExecute<QR>, QueryModifiers<Sub.QueryName<Sub.QuerySelect<QR>, Sub.QueryOrder<QR>, QR>>, Sub.QueryFields<QuerySelectOperation<Sub.QuerySelect<QR>, Sub.QueryOrder<QR>, QR>>, Sub.QueryFuncs<QuerySelectOperation<Sub.QuerySelect<QR>, Sub.QueryOrder<QR>, QR>>, QueryOrderStart<QueryOperationFields<QueryOrderOperation<Sub.QueryOrder<QR>, QR>>> {
    }
}
