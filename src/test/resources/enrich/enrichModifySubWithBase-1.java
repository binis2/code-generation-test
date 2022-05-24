/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.spring.query.*;
import net.binis.codegen.modifier.BaseModifier;
import net.binis.codegen.intf.Taggable;
import net.binis.codegen.intf.Identifiable;
import net.binis.codegen.enums.TestEnum;
import net.binis.codegen.creator.EntityCreator;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import net.binis.codegen.annotation.Default;
import javax.annotation.processing.Generated;
import java.util.function.Consumer;
import java.util.Optional;
import java.util.List;
import java.time.OffsetDateTime;

@Generated(value = "SubModifyPrototype", comments = "SubModifyImpl")
@Default("net.binis.codegen.SubModifyImpl")
public interface SubModify extends Base, Taggable, Identifiable {

    // region starters
    static SubModify create() {
        return EntityCreator.create(SubModify.class);
    }

    static QueryStarter<SubModify, SubModify.QuerySelect<SubModify>, QueryAggregateOperation<QueryOperationFields<SubModify.QueryAggregate<Number, SubModify.QuerySelect<Number>>>>, QueryFieldsStart<SubModify, SubModify.QuerySelect<SubModify>>, QueryUpdate<SubModify, SubModify.QuerySelect<SubModify>>> find() {
        return (QueryStarter) EntityCreator.create(SubModify.QuerySelect.class);
    }
    // endregion

    SubModify getParent();
    double getSubAmount();
    String getSubtitle();

    void setParent(SubModify parent);
    void setSubAmount(double subAmount);
    void setSubtitle(String subtitle);
    <T> void setTag(T tag);

    SubModify.Modify with();

    // region inner classes
    interface EmbeddedCollectionModify<R> extends SubModify.EmbeddedModify<SubModify.EmbeddedCollectionModify<R>, R> {
        EmbeddedCodeCollection<SubModify.EmbeddedCollectionModify<R>, SubModify, R> _and();
    }

    interface EmbeddedModify<T, R> extends BaseModifier<T, R>, SubModify.Fields<T> {
        SubModify.EmbeddedSoloModify<EmbeddedModify<T, R>> parent();
    }

    interface EmbeddedSoloModify<R> extends SubModify.EmbeddedModify<SubModify.EmbeddedSoloModify<R>, R> {
    }

    interface Fields<T> extends Base.Fields<T> {
        T parent(SubModify parent);
        T subAmount(double subAmount);
        T subtitle(String subtitle);
        T tag(Object tag);
    }

    interface Modify extends EmbeddedModify<SubModify.Modify, SubModify> {
        Modify parent(Consumer<SubModify.Modify> init);
    }

    interface QueryAggregate<QR, QA> extends QueryExecute<QR>, QueryAggregator<QA, QueryAggregateOperation<QueryOperationFields<SubModify.QueryAggregate<SubModify, SubModify.QuerySelect<Number>>>>> {
    }

    interface QueryFields<QR> extends QueryScript<QR>, SubModify.Fields<QR> {
    }

    interface QueryFieldsStart<QR, QS> extends QueryExecute<QR>, QueryWhere<QS>, QueryOperationFields<QueryFieldsStart<QR, QS>> {
    }

    interface QueryFuncs<QR> {
        QueryFunctions<OffsetDateTime, QR> date();
        QueryFunctions<Long, QR> id();
        QueryFunctions<Double, QR> subAmount();
        QueryFunctions<String, QR> subtitle();
        QueryFunctions<TestEnum, QR> type();
    }

    interface QueryName<QS, QO, QR, QF> extends SubModify.QueryFields<QuerySelectOperation<QS, QO, QR>>, SubModify.QueryFuncs<QuerySelectOperation<QS, QO, QR>>, QueryFetch<QuerySelectOperation<QS, QO, QR>, QF> {
        SubModify.QueryName<QS, QO, QR, SubModify> parent();
    }

    interface QueryOperationFields<QR> extends QueryScript<QR>, QuerySelf<QR> {
        QR date();
        QR id();
        SubModify.QueryOperationFields<QR> parent();
        QR subAmount();
        QR subtitle();
        QR type();
    }

    interface QueryOrder<QR> extends QueryOperationFields<QueryOrderOperation<SubModify.QueryOrder<QR>, QR>>, QueryExecute<QR> {
    }

    interface QuerySelect<QR> extends QueryExecute<QR>, QueryModifiers<SubModify.QueryName<SubModify.QuerySelect<QR>, SubModify.QueryOrder<QR>, QR, SubModify>>, SubModify.QueryFields<QuerySelectOperation<SubModify.QuerySelect<QR>, SubModify.QueryOrder<QR>, QR>>, SubModify.QueryFuncs<QuerySelectOperation<SubModify.QuerySelect<QR>, SubModify.QueryOrder<QR>, QR>>, QueryOrderStart<QueryOperationFields<QueryOrderOperation<SubModify.QueryOrder<QR>, QR>>>, QueryBracket<QuerySelect<QR>> {
        SubModify.QueryName<SubModify.QuerySelect<QR>, SubModify.QueryOrder<QR>, QR, SubModify> parent();
    }

    interface QueryUpdate<QR, QS> extends QueryFields<QueryUpdate<QR, QS>>, QueryWhere<QS>, QueryScript<QueryUpdate<QR, QS>>, UpdatableQuery {
    }
    // endregion
}
