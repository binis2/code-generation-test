/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.spring.query.*;
import net.binis.codegen.modifier.BaseModifier;
import net.binis.codegen.enums.TestEnum;
import net.binis.codegen.creator.EntityCreator;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import net.binis.codegen.collection.CodeList;
import net.binis.codegen.annotation.Default;
import javax.annotation.processing.Generated;
import java.util.Set;
import java.util.Optional;
import java.util.List;
import java.time.OffsetDateTime;

@Generated(value = "TestModifyPrototype", comments = "TestModifyImpl")
@Default("net.binis.codegen.TestModifyImpl")
public interface TestModify extends Base {

    // region starters
    static TestModify create() {
        return EntityCreator.create(TestModify.class);
    }

    static QueryStarter<TestModify, TestModify.QuerySelect<TestModify>, QueryAggregateOperation<QueryOperationFields<TestModify.QueryAggregate<Number, TestModify.QuerySelect<Number>>>>, QueryFieldsStart<TestModify, TestModify.QuerySelect<TestModify>>> find() {
        return (QueryStarter) EntityCreator.create(TestModify.QuerySelect.class);
    }
    // endregion

    double getAmount();
    List<Long> getItems();
    Set<SubModify> getSubs();
    String getTitle();

    void setAmount(double amount);
    void setItems(List<Long> items);
    void setSubs(Set<SubModify> subs);
    void setTitle(String title);

    TestModify.Modify with();

    // region inner classes
    interface Fields<T> extends Base.Fields<T> {
        T amount(double amount);
        T title(String title);
    }

    interface Modify extends TestModify.Fields<TestModify.Modify>, BaseModifier<TestModify.Modify, TestModify> {
        Modify items(List<Long> items);
        CodeList<Long, TestModify.Modify> items();
        Modify subs(Set<SubModify> subs);
        EmbeddedCodeCollection<SubModify.EmbeddedCollectionModify<TestModify.Modify>, SubModify, TestModify.Modify> subs();
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

    interface QueryName<QS, QO, QR, QF> extends TestModify.QueryFields<QuerySelectOperation<QS, QO, QR>>, TestModify.QueryFuncs<QuerySelectOperation<QS, QO, QR>>, QueryFetch<QuerySelectOperation<QS, QO, QR>, QF> {
    }

    interface QueryOperationFields<QR> extends QueryScript<QR>, QuerySelf<QR> {
        QR amount();
        QR date();
        QR id();
        QR title();
        QR type();
    }

    interface QueryOrder<QR> extends QueryOperationFields<QueryOrderOperation<TestModify.QueryOrder<QR>, QR>>, QueryExecute<QR> {
    }

    interface QuerySelect<QR> extends QueryExecute<QR>, QueryModifiers<TestModify.QueryName<TestModify.QuerySelect<QR>, TestModify.QueryOrder<QR>, QR, TestModify>>, TestModify.QueryFields<QuerySelectOperation<TestModify.QuerySelect<QR>, TestModify.QueryOrder<QR>, QR>>, TestModify.QueryFuncs<QuerySelectOperation<TestModify.QuerySelect<QR>, TestModify.QueryOrder<QR>, QR>>, QueryOrderStart<QueryOperationFields<QueryOrderOperation<TestModify.QueryOrder<QR>, QR>>>, QueryBracket<QuerySelect<QR>> {
        QueryCollectionFunctions<Long, QuerySelectOperation<TestModify.QuerySelect<QR>, QueryOperationFields<QueryOrderOperation<TestModify.QueryOrder<QR>, QR>>, QR>> items();
        QueryJoinCollectionFunctions<SubModify, QuerySelectOperation<TestModify.QuerySelect<QR>, QueryOperationFields<QueryOrderOperation<TestModify.QueryOrder<QR>, QR>>, QR>, QueryJoinAggregateOperation<SubModify.QueryOperationFields<SubModify.QueryAggregate<Number, SubModify.QuerySelect<Number>>>, SubModify.QuerySelect<Number>>> subs();
    }
    // endregion
}
