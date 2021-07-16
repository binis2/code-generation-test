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

public interface MixModify extends TestModify {

    MixModify.Modify asMixModify();

    static QueryStarter<MixModify, MixModify.QuerySelect<MixModify>, QueryAggregateOperation<QueryOperationFields<MixModify.QueryAggregate<Number, MixModify.QuerySelect<Number>>>>> find() {
        return (QueryStarter) EntityCreator.create(MixModify.QuerySelect.class);
    }

    double getMixInAmount();

    List<Long> getMixInItems();

    Set<SubModify> getMixInSubs();

    String getMixInTitle();

    void setMixInAmount(double mixInAmount);

    void setMixInItems(List<Long> mixInItems);

    void setMixInSubs(Set<SubModify> mixInSubs);

    void setMixInTitle(String mixInTitle);

    interface Fields<T> extends TestModify.Fields<T> {

        T mixInAmount(double mixInAmount);

        T mixInTitle(String mixInTitle);
    }

    interface Modify extends MixModify.Fields<MixModify.Modify> {

        MixModify done();

        Modify items(List<Long> items);

        CodeList<Long, Modify> items();

        Modify mixInItems(List<Long> mixInItems);

        CodeList<Long, Modify> mixInItems();

        Modify mixInSubs(Set<SubModify> mixInSubs);

        EmbeddedCodeCollection<SubModify.EmbeddedModify<SubModify.Modify>, SubModify, Modify> mixInSubs();

        Modify subs(Set<SubModify> subs);

        EmbeddedCodeCollection<SubModify.EmbeddedModify<SubModify.Modify>, SubModify, Modify> subs();
    }

    interface QueryAggregate<QR, QA> extends QueryExecute<QR>, QueryAggregator<QA, QueryAggregateOperation<QueryOperationFields<MixModify.QueryAggregate<MixModify, MixModify.QuerySelect<Number>>>>> {
    }

    interface QueryFields<QR> extends QueryScript<QR>, MixModify.Fields<QR> {
    }

    interface QueryFuncs<QR> {

        QueryFunctions<Double, QR> amount();

        QueryFunctions<OffsetDateTime, QR> date();

        QueryFunctions<Long, QR> id();

        QueryFunctions<Double, QR> mixInAmount();

        QueryFunctions<String, QR> mixInTitle();

        QueryFunctions<String, QR> title();

        QueryFunctions<TestEnum, QR> type();
    }

    interface QueryName<QS, QO, QR> extends MixModify.QueryFields<QuerySelectOperation<QS, QO, QR>>, MixModify.QueryFuncs<QuerySelectOperation<QS, QO, QR>> {
    }

    interface QueryOperationFields<QR> {

        QR amount();

        QR date();

        QR id();

        QR mixInAmount();

        QR mixInTitle();

        QR title();

        QR type();
    }

    interface QueryOrder<QR> extends QueryOperationFields<QueryOrderOperation<MixModify.QueryOrder<QR>, QR>>, QueryExecute<QR>, QueryScript<QueryOrderOperation<MixModify.QueryOrder<QR>, QR>> {
    }

    interface QuerySelect<QR> extends QueryExecute<QR>, QueryModifiers<MixModify.QueryName<MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR>>, MixModify.QueryFields<QuerySelectOperation<MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR>>, MixModify.QueryFuncs<QuerySelectOperation<MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR>> {

        QueryCollectionFunctions<Long, QuerySelectOperation<MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR>> items();

        QueryCollectionFunctions<Long, QuerySelectOperation<MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR>> mixInItems();

        QueryCollectionFunctions<SubModify, QuerySelectOperation<MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR>> mixInSubs();

        MixModify.QueryOrder<QR> order();

        QueryCollectionFunctions<SubModify, QuerySelectOperation<MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR>> subs();
    }
}
