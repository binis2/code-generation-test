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
import net.binis.codegen.enums.TestEnum;
import net.binis.codegen.creator.EntityCreator;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import net.binis.codegen.collection.CodeList;
import javax.annotation.processing.Generated;
import java.util.Set;
import java.util.Optional;
import java.util.List;
import java.time.OffsetDateTime;

@Generated(value = "TestModifyPrototype", comments = "TestModifyImpl")
public interface TestModify extends Base {

    static TestModify create() {
        return EntityCreator.create(TestModify.class, "net.binis.codegen.TestModifyImpl");
    }

    static QueryStarter<TestModify, TestModify.QuerySelect<TestModify>, QueryAggregateOperation<QueryOperationFields<TestModify.QueryAggregate<Number, TestModify.QuerySelect<Number>>>>, QueryFieldsStart<TestModify, TestModify.QuerySelect<TestModify>>> find() {
        return (QueryStarter) EntityCreator.create(TestModify.QuerySelect.class, "net.binis.codegen.TestModifyImpl");
    }

    double getAmount();

    List<Long> getItems();

    Set<SubModify> getSubs();

    String getTitle();

    void setAmount(double amount);

    void setItems(List<Long> items);

    void setSubs(Set<SubModify> subs);

    void setTitle(String title);

    TestModify.Modify with();

    interface Fields<T> extends Base.Fields<T> {

        T amount(double amount);

        T title(String title);
    }

    interface Modify extends TestModify.Fields<TestModify.Modify> {

        TestModify done();

        Modify items(List<Long> items);

        CodeList<Long, Modify> items();

        Modify subs(Set<SubModify> subs);

        EmbeddedCodeCollection<SubModify.EmbeddedModify<SubModify.Modify>, SubModify, Modify> subs();
    }

    interface QueryAggregate<QR, QA> extends QueryExecute<QR>, QueryAggregator<QA, QueryAggregateOperation<QueryOperationFields<TestModify.QueryAggregate<TestModify, TestModify.QuerySelect<Number>>>>> {
    }

    interface QueryFields<QR> extends QueryScript<QR>, TestModify.Fields<QR> {
    }

    interface QueryFieldsStart<QR, QS> extends QueryExecute<QR>, QueryWhere<QS>, QueryOperationFields<QueryFieldsStart<QR, QS>> {
    }

    interface QueryFuncs<QR> {

        QueryFunctions<Double, QR> amount();

        QueryFunctions<OffsetDateTime, QR> date();

        QueryFunctions<Long, QR> id();

        QueryFunctions<String, QR> title();

        QueryFunctions<TestEnum, QR> type();
    }

    interface QueryName<QS, QO, QR> extends TestModify.QueryFields<QuerySelectOperation<QS, QO, QR>>, TestModify.QueryFuncs<QuerySelectOperation<QS, QO, QR>> {
    }

    interface QueryOperationFields<QR> extends QueryScript<QR> {

        QR amount();

        QR date();

        QR id();

        QR title();

        QR type();
    }

    interface QueryOrder<QR> extends QueryOperationFields<QueryOrderOperation<TestModify.QueryOrder<QR>, QR>>, QueryExecute<QR>, QueryScript<QueryOrderOperation<TestModify.QueryOrder<QR>, QR>> {
    }

    interface QuerySelect<QR> extends QueryExecute<QR>, QueryModifiers<TestModify.QueryName<TestModify.QuerySelect<QR>, TestModify.QueryOrder<QR>, QR>>, TestModify.QueryFields<QuerySelectOperation<TestModify.QuerySelect<QR>, TestModify.QueryOrder<QR>, QR>>, TestModify.QueryFuncs<QuerySelectOperation<TestModify.QuerySelect<QR>, TestModify.QueryOrder<QR>, QR>>, QueryOrderStart<QueryOperationFields<QueryOrderOperation<TestModify.QueryOrder<QR>, QR>>>, QueryBracket<QuerySelect<QR>> {

        QueryCollectionFunctions<Long, QuerySelectOperation<TestModify.QuerySelect<QR>, QueryOperationFields<QueryOrderOperation<TestModify.QueryOrder<QR>, QR>>, QR>> items();

        QueryJoinCollectionFunctions<SubModify, QuerySelectOperation<TestModify.QuerySelect<QR>, QueryOperationFields<QueryOrderOperation<TestModify.QueryOrder<QR>, QR>>, QR>, QueryJoinAggregateOperation<SubModify.QueryOperationFields<SubModify.QueryAggregate<Number, SubModify.QuerySelect<Number>>>, SubModify.QuerySelect<Number>>> subs();
    }
}
