/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.spring.query.*;
import net.binis.codegen.creator.EntityCreator;
import javax.annotation.processing.Generated;
import java.util.Optional;
import java.util.List;

@Generated(value = "TestPrototype", comments = "TestImpl")
public interface Test {

    static QueryStarter<Test, Test.QuerySelect<Test>, QueryAggregateOperation<QueryOperationFields<Test.QueryAggregate<Number, Test.QuerySelect<Number>>>>, QueryFieldsStart<Test, Test.QuerySelect<Test>>> find() {
        return (QueryStarter) EntityCreator.create(Test.QuerySelect.class, "net.binis.codegen.TestImpl");
    }

    double getAmount();

    List<Long> getItems();

    Test getParent();

    Sub getSub();

    String getTitle();

    void setAmount(double amount);

    void setItems(List<Long> items);

    void setParent(Test parent);

    void setSub(Sub sub);

    void setTitle(String title);

    interface QueryAggregate<QR, QA> extends QueryExecute<QR>, QueryAggregator<QA, QueryAggregateOperation<QueryOperationFields<Test.QueryAggregate<Test, Test.QuerySelect<Number>>>>> {
    }

    interface QueryFields<QR> extends QueryScript<QR> {

        QR amount(double amount);

        QR parent(Test parent);

        QR sub(Sub sub);

        QR title(String title);
    }

    interface QueryFieldsStart<QR, QS> extends QueryExecute<QR>, QueryWhere<QS>, QueryOperationFields<QueryFieldsStart<QR, QS>> {
    }

    interface QueryFuncs<QR> {

        QueryFunctions<Double, QR> amount();

        QueryFunctions<String, QR> title();
    }

    interface QueryName<QS, QO, QR> extends Test.QueryFields<QuerySelectOperation<QS, QO, QR>>, Test.QueryFuncs<QuerySelectOperation<QS, QO, QR>> {

        Test.QueryName<QS, QO, QR> parent();

        Sub.QueryName<QS, QO, QR> sub();
    }

    interface QueryOperationFields<QR> extends QueryScript<QR> {

        QR amount();

        QR parent();

        QR sub();

        QR title();
    }

    interface QueryOrder<QR> extends QueryOperationFields<QueryOrderOperation<Test.QueryOrder<QR>, QR>>, QueryExecute<QR>, QueryScript<QueryOrderOperation<Test.QueryOrder<QR>, QR>> {
    }

    interface QuerySelect<QR> extends QueryExecute<QR>, QueryModifiers<Test.QueryName<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR>>, Test.QueryFields<QuerySelectOperation<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR>>, Test.QueryFuncs<QuerySelectOperation<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR>>, QueryOrderStart<QueryOperationFields<QueryOrderOperation<Test.QueryOrder<QR>, QR>>>, QueryBracket<QuerySelect<QR>> {

        QueryCollectionFunctions<Long, QuerySelectOperation<Test.QuerySelect<QR>, QueryOperationFields<QueryOrderOperation<Test.QueryOrder<QR>, QR>>, QR>> items();

        Test.QueryName<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR> parent();

        Sub.QueryName<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR> sub();
    }
}
