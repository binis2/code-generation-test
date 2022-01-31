/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.spring.query.*;
import net.binis.codegen.creator.EntityCreator;
import net.binis.codegen.collection.CodeList;
import net.binis.codegen.annotation.Default;
import javax.annotation.processing.Generated;
import java.util.Optional;
import java.util.List;

@Generated(value = "TestPrototype", comments = "TestImpl")
@Default("net.binis.codegen.TestImpl")
public interface Test {

    static QueryStarter<Test, Test.QuerySelect<Test>, QueryAggregateOperation<QueryOperationFields<Test.QueryAggregate<Number, Test.QuerySelect<Number>>>>, QueryFieldsStart<Test, Test.QuerySelect<Test>>> find() {
        return (QueryStarter) EntityCreator.create(Test.QuerySelect.class);
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

    Test.Modify with();

    interface Fields<T> {
        T amount(double amount);
        T parent(Test parent);
        T sub(Sub sub);
        T title(String title);
    }

    interface Modify extends Test.Fields<Test.Modify> {
        Test done();
        Modify items(List<Long> items);
        CodeList<Long, Modify> items();
    }

    interface QueryAggregate<QR, QA> extends QueryExecute<QR>, QueryAggregator<QA, QueryAggregateOperation<QueryOperationFields<Test.QueryAggregate<Test, Test.QuerySelect<Number>>>>> {
    }

    interface QueryFields<QR> extends QueryScript<QR>, Test.Fields<QR> {
    }

    interface QueryFieldsStart<QR, QS> extends QueryExecute<QR>, QueryWhere<QS>, QueryOperationFields<QueryFieldsStart<QR, QS>> {
    }

    interface QueryFuncs<QR> {
        QueryFunctions<Double, QR> amount();
        QueryFunctions<String, QR> title();
    }

    interface QueryName<QS, QO, QR, QF> extends Test.QueryFields<QuerySelectOperation<QS, QO, QR>>, Test.QueryFuncs<QuerySelectOperation<QS, QO, QR>>, QueryFetch<QuerySelectOperation<QS, QO, QR>, QF> {
        Test.QueryName<QS, QO, QR, Test> parent();
        Sub.QueryName<QS, QO, QR, Sub> sub();
    }

    interface QueryOperationFields<QR> extends QueryScript<QR> {
        QR amount();
        QR parent();
        QR sub();
        QR title();
    }

    interface QueryOrder<QR> extends QueryOperationFields<QueryOrderOperation<Test.QueryOrder<QR>, QR>>, QueryExecute<QR>, QueryScript<QueryOrderOperation<Test.QueryOrder<QR>, QR>> {
    }

    interface QuerySelect<QR> extends QueryExecute<QR>, QueryModifiers<Test.QueryName<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR, Test>>, Test.QueryFields<QuerySelectOperation<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR>>, Test.QueryFuncs<QuerySelectOperation<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR>>, QueryOrderStart<QueryOperationFields<QueryOrderOperation<Test.QueryOrder<QR>, QR>>>, QueryBracket<QuerySelect<QR>> {
        QueryCollectionFunctions<Long, QuerySelectOperation<Test.QuerySelect<QR>, QueryOperationFields<QueryOrderOperation<Test.QueryOrder<QR>, QR>>, QR>> items();
        Test.QueryName<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR, Test> parent();
        Sub.QueryName<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR, Sub> sub();
    }
}
