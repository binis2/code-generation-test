/*Generated code by Binis' code generator.*/
package net.binis.codegen.test;

import net.binis.codegen.spring.query.*;
import net.binis.codegen.creator.EntityCreator;
import net.binis.codegen.annotation.Default;
import net.binis.codegen.TestExternal;
import javax.annotation.processing.Generated;
import java.util.Optional;
import java.util.List;

@Generated(value = "net.binis.codegen.test.TestPrototype", comments = "TestImpl")
@Default("net.binis.codegen.test.TestImpl")
@SuppressWarnings("unchecked")
public interface Test {

    static QueryStarter<Test, Test.QuerySelect<Test>, QueryAggregateOperation<QueryOperationFields<Test.QueryAggregate<Number, Test.QuerySelect<Number>>>>, QueryFieldsStart<Test, Test.QuerySelect<Test>>, QueryUpdate<Test, Test.QuerySelect<Test>>> find() {
        return (QueryStarter) EntityCreator.create(Test.QuerySelect.class);
    }

    TestExternal getTest();

    void setTest(TestExternal test);

    interface QueryAggregate<QR, QA> extends QueryExecute<QR>, QueryAggregator<QA, QueryAggregateOperation<QueryOperationFields<Test.QueryAggregate<Test, Test.QuerySelect<Number>>>>, Test.QueryAggregate<Test, Test.QuerySelect<Number>>> {
    }

    interface QueryFields<QR> extends QueryScript<QR> {
        QR test(TestExternal test);
    }

    interface QueryFieldsStart<QR, QS> extends QueryExecute<QR>, QueryWhere<QS>, QueryOperationFields<QueryFieldsStart<QR, QS>> {
    }

    interface QueryFuncs<QR> {
    }

    interface QueryName<QS, QO, QR, QF> extends Test.QueryFields<QuerySelectOperation<QS, QO, QR>>, Test.QueryFuncs<QuerySelectOperation<QS, QO, QR>>, QueryFetch<QuerySelectOperation<QS, QO, QR>, QF> {
        TestExternal.QueryName<QS, QO, QR, TestExternal> test();
    }

    interface QueryOperationFields<QR> extends QueryScript<QR>, QuerySelf<QR> {
        TestExternal.QueryOperationFields<QR> test();
    }

    interface QueryOrder<QR> extends QueryOperationFields<QueryOrderOperation<Test.QueryOrder<QR>, QR>>, QueryExecute<QR> {
    }

    interface QuerySelect<QR> extends QueryExecute<QR>, QueryModifiers<Test.QueryName<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR, Test>>, Test.QueryFields<QuerySelectOperation<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR>>, Test.QueryFuncs<QuerySelectOperation<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR>>, QueryOrderStart<QueryOperationFields<QueryOrderOperation<Test.QueryOrder<QR>, QR>>>, QueryBracket<QuerySelect<QR>> {
        TestExternal.QueryName<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR, TestExternal> test();
    }

    interface QueryUpdate<QR, QS> extends QueryFields<QueryUpdate<QR, QS>>, QueryWhere<QS>, QueryScript<QueryUpdate<QR, QS>>, UpdatableQuery {
    }
}
