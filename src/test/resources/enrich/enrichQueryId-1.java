/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.spring.query.*;
import net.binis.codegen.creator.EntityCreator;
import net.binis.codegen.annotation.Default;
import javax.annotation.processing.Generated;
import java.util.Optional;
import java.util.List;

@Generated(value = "TestPrototype", comments = "TestImpl")
@Default("net.binis.codegen.TestImpl")
@SuppressWarnings("unchecked")
public interface Test extends Base {

    static QueryStarter<Test, Test.QuerySelect<Test>, QueryAggregateOperation<QueryOperationFields<Test.QueryAggregate<Number, Test.QuerySelect<Number>>>>, QueryFieldsStart<Test, Test.QuerySelect<Test>>, QueryUpdate<Test, Test.QuerySelect<Test>>> find() {
        return (QueryStarter) EntityCreator.create(Test.QuerySelect.class);
    }

    double getAmount();
    String getTitle();

    void setAmount(double amount);
    void setTitle(String title);

    interface QueryAggregate<QR, QA> extends QueryExecute<QR>, QueryAggregator<QA, QueryAggregateOperation<QueryOperationFields<Test.QueryAggregate<Test, Test.QuerySelect<Number>>>>, Test.QueryAggregate<Test, Test.QuerySelect<Number>>> {
    }

    interface QueryFields<QR> extends QueryScript<QR> {
        QR amount(double amount);
        QR id(String id);
        QR title(String title);
    }

    interface QueryFieldsStart<QR, QS> extends QueryExecute<QR>, QueryWhere<QS>, QueryOperationFields<QueryFieldsStart<QR, QS>> {
    }

    interface QueryFuncs<QR> {
        QueryFunctions<Double, QR> amount();
        QueryFunctions<String, QR> id();
        QueryFunctions<String, QR> title();
    }

    interface QueryName<QS, QO, QR, QF> extends Test.QueryFields<QuerySelectOperation<QS, QO, QR>>, Test.QueryFuncs<QuerySelectOperation<QS, QO, QR>>, QueryFetch<QuerySelectOperation<QS, QO, QR>, QF> {
    }

    interface QueryOperationFields<QR> extends QueryScript<QR>, QuerySelf<QR> {
        QR amount();
        QR id();
        QR title();
    }

    interface QueryOrder<QR> extends QueryOperationFields<QueryOrderOperation<Test.QueryOrder<QR>, QR>>, QueryExecute<QR> {
    }

    interface QuerySelect<QR> extends QueryExecute<QR>, QueryModifiers<Test.QueryName<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR, Test>>, Test.QueryFields<QuerySelectOperation<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR>>, Test.QueryFuncs<QuerySelectOperation<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR>>, QueryOrderStart<QueryOperationFields<QueryOrderOperation<Test.QueryOrder<QR>, QR>>>, QueryBracket<QuerySelect<QR>> {
    }

    interface QueryUpdate<QR, QS> extends QueryFields<QueryUpdate<QR, QS>>, QueryWhere<QS>, QueryScript<QueryUpdate<QR, QS>>, UpdatableQuery {
    }
}
