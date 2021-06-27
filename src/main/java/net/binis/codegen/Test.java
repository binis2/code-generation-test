/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.spring.query.*;
import net.binis.codegen.creator.EntityCreator;
import java.util.Optional;
import java.util.List;

public interface Test {

    static QueryStarter<Test, Test.QuerySelect<Test>> find() {
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

    interface QueryFields<QR> extends QueryScript<QR> {

        QR amount(double amount);

        QR items(Long in);

        QR parent(Test parent);

        QR sub(Sub sub);

        QR title(String title);
    }

    interface QueryFuncs<QR> {

        QueryFunctions<Double, QR> amount();

        QueryFunctions<String, QR> title();
    }

    interface QueryName<QS, QO, QR> extends Test.QueryFields<QuerySelectOperation<QS, QO, QR>>, Test.QueryFuncs<QuerySelectOperation<QS, QO, QR>> {

        Test.QueryName<QS, QO, QR> parent();

        Sub.QueryName<QS, QO, QR> sub();
    }

    interface QueryOrder<QR> extends QueryExecute<QR>, QueryScript<QueryOrderOperation<Test.QueryOrder<QR>, QR>> {

        QueryOrderOperation<Test.QueryOrder<QR>, QR> amount();

        QueryOrderOperation<Test.QueryOrder<QR>, QR> parent();

        QueryOrderOperation<Test.QueryOrder<QR>, QR> sub();

        QueryOrderOperation<Test.QueryOrder<QR>, QR> title();
    }

    interface QuerySelect<QR> extends QueryExecute<QR>, QueryModifiers<Test.QueryName<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR>>, Test.QueryFields<QuerySelectOperation<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR>>, Test.QueryFuncs<QuerySelectOperation<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR>> {

        Test.QueryOrder<QR> order();

        Test.QueryName<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR> parent();

        Sub.QueryName<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR> sub();
    }
}
