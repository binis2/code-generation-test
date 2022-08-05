/*Generated code by Binis' code generator.*/
package net.binis.codegen.test;

import net.binis.codegen.spring.query.*;
import net.binis.codegen.spring.modifier.BaseEntityModifier;
import net.binis.codegen.modifier.BaseModifier;
import net.binis.codegen.intf.Typeable;
import net.binis.codegen.enums.TestEnum;
import net.binis.codegen.creator.EntityCreatorModifier;
import net.binis.codegen.creator.EntityCreator;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import net.binis.codegen.annotation.Default;
import javax.annotation.processing.Generated;
import java.util.Optional;
import java.util.List;

@Generated(value = "TestPrototype", comments = "TestImpl")
@Default("net.binis.codegen.test.TestImpl")
public interface Test extends Generic<TestPayload>, Typeable<TestEnum> {

    // region starters
    @SuppressWarnings(value = "unchecked")
    static Test.Modify create() {
        return (Test.Modify) EntityCreatorModifier.create(Test.class).with();
    }

    @SuppressWarnings(value = "unchecked")
    static QueryStarter<Test, Test.QuerySelect<Test>, QueryAggregateOperation<QueryOperationFields<Test.QueryAggregate<Number, Test.QuerySelect<Number>>>>, QueryFieldsStart<Test, Test.QuerySelect<Test>>, QueryUpdate<Test, Test.QuerySelect<Test>>> find() {
        return (QueryStarter) EntityCreator.create(Test.QuerySelect.class);
    }
    // endregion

    Test.Modify with();

    // region inner classes
    interface EmbeddedCollectionModify<R> extends Test.EmbeddedModify<Test.EmbeddedCollectionModify<R>, R> {
        EmbeddedCodeCollection<Test.EmbeddedCollectionModify<R>, Test, R> _and();
    }

    interface EmbeddedModify<T, R> extends BaseModifier<T, R>, Test.Fields<T> {
    }

    interface EmbeddedSoloModify<R> extends Test.EmbeddedModify<Test.EmbeddedSoloModify<R>, R> {
    }

    interface Fields<T> {
        T payload(TestPayload payload);
        T type(TestEnum type);
    }

    interface Modify extends EmbeddedModify<Test.Modify, Test>, BaseEntityModifier<Test.Modify, Test> {
    }

    interface QueryAggregate<QR, QA> extends QueryExecute<QR>, QueryAggregator<QA, QueryAggregateOperation<QueryOperationFields<Test.QueryAggregate<Test, Test.QuerySelect<Number>>>>, Test.QueryAggregate<Test, Test.QuerySelect<Number>>> {
    }

    interface QueryFields<QR> extends QueryScript<QR>, Test.Fields<QR> {
    }

    interface QueryFieldsStart<QR, QS> extends QueryExecute<QR>, QueryWhere<QS>, QueryOperationFields<QueryFieldsStart<QR, QS>> {
    }

    interface QueryFuncs<QR> {
        QueryFunctions<TestPayload, QR> payload();
        QueryFunctions<TestEnum, QR> type();
    }

    interface QueryName<QS, QO, QR, QF> extends Test.QueryFields<QuerySelectOperation<QS, QO, QR>>, Test.QueryFuncs<QuerySelectOperation<QS, QO, QR>>, QueryFetch<QuerySelectOperation<QS, QO, QR>, QF> {
    }

    interface QueryOperationFields<QR> extends QueryScript<QR>, QuerySelf<QR> {
        QR payload();
        QR type();
    }

    interface QueryOrder<QR> extends QueryOperationFields<QueryOrderOperation<Test.QueryOrder<QR>, QR>>, QueryExecute<QR> {
    }

    interface QuerySelect<QR> extends QueryExecute<QR>, QueryModifiers<Test.QueryName<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR, Test>>, Test.QueryFields<QuerySelectOperation<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR>>, Test.QueryFuncs<QuerySelectOperation<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR>>, QueryOrderStart<QueryOperationFields<QueryOrderOperation<Test.QueryOrder<QR>, QR>>>, QueryBracket<QuerySelect<QR>> {
    }

    interface QueryUpdate<QR, QS> extends QueryFields<QueryUpdate<QR, QS>>, QueryWhere<QS>, QueryScript<QueryUpdate<QR, QS>>, UpdatableQuery {
    }
    // endregion
}
