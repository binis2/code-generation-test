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

@Generated(value = "MixModifyPrototype", comments = "MixModifyImpl")
@Default("net.binis.codegen.TestModifyImpl")
@SuppressWarnings("unchecked")
public interface MixModify extends TestModify {
    MixModify.Modify asMixModify();

    // region starters
    static MixModify create() {
        return EntityCreator.create(MixModify.class);
    }

    static QueryStarter<MixModify, MixModify.QuerySelect<MixModify>, QueryAggregateOperation<QueryOperationFields<MixModify.QueryAggregate<Number, MixModify.QuerySelect<Number>>>>, QueryFieldsStart<MixModify, MixModify.QuerySelect<MixModify>>, QueryUpdate<MixModify, MixModify.QuerySelect<MixModify>>> find() {
        return (QueryStarter) EntityCreator.create(MixModify.QuerySelect.class);
    }
    // endregion

    double getMixInAmount();
    List<Long> getMixInItems();
    Set<SubModify> getMixInSubs();
    String getMixInTitle();

    void setMixInAmount(double mixInAmount);
    void setMixInItems(List<Long> mixInItems);
    void setMixInSubs(Set<SubModify> mixInSubs);
    void setMixInTitle(String mixInTitle);

    // region inner classes
    interface Fields<T> extends TestModify.Fields<T> {
        T mixInAmount(double mixInAmount);
        T mixInTitle(String mixInTitle);
    }

    interface Modify extends MixModify.Fields<MixModify.Modify>, BaseModifier<MixModify.Modify, MixModify> {
        Modify items(List<Long> items);
        CodeList<Long, MixModify.Modify> items();
        Modify mixInItems(List<Long> mixInItems);
        CodeList<Long, MixModify.Modify> mixInItems();
        Modify mixInSubs(Set<SubModify> mixInSubs);
        EmbeddedCodeCollection<SubModify.EmbeddedCollectionModify<MixModify.Modify>, SubModify, MixModify.Modify> mixInSubs();
        Modify subs(Set<SubModify> subs);
        EmbeddedCodeCollection<SubModify.EmbeddedCollectionModify<MixModify.Modify>, SubModify, MixModify.Modify> subs();
    }

    interface QueryAggregate<QR, QA> extends QueryExecute<QR>, QueryAggregator<QA, QueryAggregateOperation<QueryOperationFields<MixModify.QueryAggregate<MixModify, MixModify.QuerySelect<Number>>>>, MixModify.QueryAggregate<MixModify, MixModify.QuerySelect<Number>>> {
    }

    interface QueryFields<QR> extends QueryScript<QR>, MixModify.Fields<QR> {
    }

    interface QueryFieldsStart<QR, QS> extends QueryExecute<QR>, QueryWhere<QS>, QueryOperationFields<QueryFieldsStart<QR, QS>> {
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

    interface QueryName<QS, QO, QR, QF> extends MixModify.QueryFields<QuerySelectOperation<QS, QO, QR>>, MixModify.QueryFuncs<QuerySelectOperation<QS, QO, QR>>, QueryFetch<QuerySelectOperation<QS, QO, QR>, QF> {
    }

    interface QueryOperationFields<QR> extends QueryScript<QR>, QuerySelf<QR> {
        QR amount();
        QR date();
        QR id();
        QR mixInAmount();
        QR mixInTitle();
        QR title();
        QR type();
    }

    interface QueryOrder<QR> extends QueryOperationFields<QueryOrderOperation<MixModify.QueryOrder<QR>, QR>>, QueryExecute<QR> {
    }

    interface QuerySelect<QR> extends QueryExecute<QR>, QueryModifiers<MixModify.QueryName<MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR, MixModify>>, MixModify.QueryFields<QuerySelectOperation<MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR>>, MixModify.QueryFuncs<QuerySelectOperation<MixModify.QuerySelect<QR>, MixModify.QueryOrder<QR>, QR>>, QueryOrderStart<QueryOperationFields<QueryOrderOperation<MixModify.QueryOrder<QR>, QR>>>, QueryBracket<QuerySelect<QR>> {
        QueryCollectionFunctions<Long, QuerySelectOperation<MixModify.QuerySelect<QR>, QueryOperationFields<QueryOrderOperation<MixModify.QueryOrder<QR>, QR>>, QR>> items();
        QueryCollectionFunctions<Long, QuerySelectOperation<MixModify.QuerySelect<QR>, QueryOperationFields<QueryOrderOperation<MixModify.QueryOrder<QR>, QR>>, QR>> mixInItems();
        QueryJoinCollectionFunctions<SubModify, QuerySelectOperation<MixModify.QuerySelect<QR>, QueryOperationFields<QueryOrderOperation<MixModify.QueryOrder<QR>, QR>>, QR>, QueryJoinAggregateOperation<SubModify.QueryOperationFields<SubModify.QueryAggregate<Number, SubModify.QuerySelect<Number>>>, SubModify.QuerySelect<Number>>> mixInSubs();
        QueryJoinCollectionFunctions<SubModify, QuerySelectOperation<MixModify.QuerySelect<QR>, QueryOperationFields<QueryOrderOperation<MixModify.QueryOrder<QR>, QR>>, QR>, QueryJoinAggregateOperation<SubModify.QueryOperationFields<SubModify.QueryAggregate<Number, SubModify.QuerySelect<Number>>>, SubModify.QuerySelect<Number>>> subs();
    }

    interface QueryUpdate<QR, QS> extends QueryFields<QueryUpdate<QR, QS>>, QueryWhere<QS>, QueryScript<QueryUpdate<QR, QS>>, UpdatableQuery {
    }
    // endregion
}
