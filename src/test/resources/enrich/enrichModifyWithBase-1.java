/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.spring.query.*;
import net.binis.codegen.enums.TestEnum;
import net.binis.codegen.creator.EntityCreator;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import net.binis.codegen.collection.CodeList;
import java.util.Set;
import java.util.Optional;
import java.util.List;
import java.time.OffsetDateTime;

public interface TestModify extends Base {

    static QueryStarter<TestModify, TestModify.QuerySelect<TestModify>> find() {
        return (QueryStarter) EntityCreator.create(TestModify.QuerySelect.class);
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

    interface QueryFields<QR> extends QueryScript<QR>, TestModify.Fields<QR> {

        QR items(Long in);

        QR subs(SubModify in);
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

    interface QueryOrder<QR> extends QueryExecute<QR>, QueryScript<QueryOrderOperation<TestModify.QueryOrder<QR>, QR>> {

        QueryOrderOperation<TestModify.QueryOrder<QR>, QR> amount();

        QueryOrderOperation<TestModify.QueryOrder<QR>, QR> date();

        QueryOrderOperation<TestModify.QueryOrder<QR>, QR> id();

        QueryOrderOperation<TestModify.QueryOrder<QR>, QR> title();

        QueryOrderOperation<TestModify.QueryOrder<QR>, QR> type();
    }

    interface QuerySelect<QR> extends QueryExecute<QR>, QueryModifiers<TestModify.QueryName<TestModify.QuerySelect<QR>, TestModify.QueryOrder<QR>, QR>>, TestModify.QueryFields<QuerySelectOperation<TestModify.QuerySelect<QR>, TestModify.QueryOrder<QR>, QR>>, TestModify.QueryFuncs<QuerySelectOperation<TestModify.QuerySelect<QR>, TestModify.QueryOrder<QR>, QR>> {

        TestModify.QueryOrder<QR> order();
    }
}
