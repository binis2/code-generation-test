/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.spring.query.*;
import net.binis.codegen.creator.EntityCreator;
import java.util.Optional;
import java.util.List;

public interface Sub {

    static QueryStarter<Sub, Sub.QuerySelect<Sub>> find() {
        return (QueryStarter) EntityCreator.create(Sub.QuerySelect.class);
    }

    double getSubAmount();

    String getSubtitle();

    void setSubAmount(double subAmount);

    void setSubtitle(String subtitle);

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

    interface QueryOrder<QR> extends QueryExecute<QR>, QueryScript<QueryOrderOperation<Sub.QueryOrder<QR>, QR>> {

        QueryOrderOperation<Sub.QueryOrder<QR>, QR> subAmount();

        QueryOrderOperation<Sub.QueryOrder<QR>, QR> subtitle();
    }

    interface QuerySelect<QR> extends QueryExecute<QR>, QueryModifiers<Sub.QueryName<Sub.QuerySelect<QR>, Sub.QueryOrder<QR>, QR>>, Sub.QueryFields<QuerySelectOperation<Sub.QuerySelect<QR>, Sub.QueryOrder<QR>, QR>>, Sub.QueryFuncs<QuerySelectOperation<Sub.QuerySelect<QR>, Sub.QueryOrder<QR>, QR>> {

        Sub.QueryOrder<QR> order();
    }
}
