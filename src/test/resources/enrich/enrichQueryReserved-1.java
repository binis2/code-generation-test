/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.spring.query.*;
import net.binis.codegen.creator.EntityCreator;
import net.binis.codegen.annotation.Default;
import javax.annotation.processing.Generated;
import java.util.Optional;
import java.util.List;

@Generated(value = "TestReservedPrototype", comments = "TestReservedImpl")
@Default("net.binis.codegen.TestReservedImpl")
@SuppressWarnings("unchecked")
public interface TestReserved {

    static QueryStarter<TestReserved, TestReserved.QuerySelect<TestReserved>, QueryAggregateOperation<QueryOperationFields<TestReserved.QueryAggregate<Number, TestReserved.QuerySelect<Number>>>>, QueryFieldsStart<TestReserved, TestReserved.QuerySelect<TestReserved>>, QueryUpdate<TestReserved, TestReserved.QuerySelect<TestReserved>>> find() {
        return (QueryStarter) EntityCreator.create(TestReserved.QuerySelect.class);
    }

    String getCount();
    String getDelete();
    String getEnsure();
    String getExists();
    String getFilter();
    String getFlush();
    String getGet();
    String getHint();
    List<String> getList();
    String getLock();
    String getPage();
    String getPrepare();
    String getProjection();
    String getReference();
    List<String> getReferences();
    String getRemove();
    String getTop();
    String getTuple();
    String getTuples();

    void setCount(String count);
    void setDelete(String delete);
    void setEnsure(String ensure);
    void setExists(String exists);
    void setFilter(String filter);
    void setFlush(String flush);
    void setGet(String get);
    void setHint(String hint);
    void setList(List<String> list);
    void setLock(String lock);
    void setPage(String page);
    void setPrepare(String prepare);
    void setProjection(String projection);
    void setReference(String reference);
    void setReferences(List<String> references);
    void setRemove(String remove);
    void setTop(String top);
    void setTuple(String tuple);
    void setTuples(String tuples);

    interface QueryAggregate<QR, QA> extends QueryExecute<QR>, QueryAggregator<QA, QueryAggregateOperation<QueryOperationFields<TestReserved.QueryAggregate<TestReserved, TestReserved.QuerySelect<Number>>>>, TestReserved.QueryAggregate<TestReserved, TestReserved.QuerySelect<Number>>> {
    }

    interface QueryFields<QR> extends QueryScript<QR> {
        QR count_(String count);
        QR delete_(String delete);
        QR ensure_(String ensure);
        QR exists_(String exists);
        QR filter_(String filter);
        QR flush_(String flush);

        QR get_(String get);

        QR hint_(String hint);
        QR lock_(String lock);
        QR page_(String page);
        QR prepare_(String prepare);
        QR projection_(String projection);
        QR reference_(String reference);
        QR remove_(String remove);
        QR top_(String top);
        QR tuple_(String tuple);
        QR tuples_(String tuples);
    }

    interface QueryFieldsStart<QR, QS> extends QueryExecute<QR>, QueryWhere<QS>, QueryOperationFields<QueryFieldsStart<QR, QS>> {
    }

    interface QueryFuncs<QR> {
        QueryFunctions<String, QR> count_();
        QueryFunctions<String, QR> delete_();
        QueryFunctions<String, QR> ensure_();
        QueryFunctions<String, QR> exists_();
        QueryFunctions<String, QR> filter_();
        QueryFunctions<String, QR> flush_();

        QueryFunctions<String, QR> get_();

        QueryFunctions<String, QR> hint_();
        QueryFunctions<String, QR> lock_();
        QueryFunctions<String, QR> page_();
        QueryFunctions<String, QR> prepare_();
        QueryFunctions<String, QR> projection_();
        QueryFunctions<String, QR> reference_();
        QueryFunctions<String, QR> remove_();
        QueryFunctions<String, QR> top_();
        QueryFunctions<String, QR> tuple_();
        QueryFunctions<String, QR> tuples_();
    }

    interface QueryName<QS, QO, QR, QF> extends TestReserved.QueryFields<QuerySelectOperation<QS, QO, QR>>, TestReserved.QueryFuncs<QuerySelectOperation<QS, QO, QR>>, QueryFetch<QuerySelectOperation<QS, QO, QR>, QF> {
    }

    interface QueryOperationFields<QR> extends QueryScript<QR>, QuerySelf<QR> {
        QR count_();
        QR delete_();
        QR ensure_();
        QR exists_();
        QR filter_();
        QR flush_();

        QR get_();

        QR hint_();
        QR lock_();
        QR page_();
        QR prepare_();
        QR projection_();
        QR reference_();
        QR remove_();
        QR top_();
        QR tuple_();
        QR tuples_();
    }

    interface QueryOrder<QR> extends QueryOperationFields<QueryOrderOperation<TestReserved.QueryOrder<QR>, QR>>, QueryExecute<QR> {
    }

    interface QuerySelect<QR> extends QueryExecute<QR>, QueryModifiers<TestReserved.QueryName<TestReserved.QuerySelect<QR>, TestReserved.QueryOrder<QR>, QR, TestReserved>>, TestReserved.QueryFields<QuerySelectOperation<TestReserved.QuerySelect<QR>, TestReserved.QueryOrder<QR>, QR>>, TestReserved.QueryFuncs<QuerySelectOperation<TestReserved.QuerySelect<QR>, TestReserved.QueryOrder<QR>, QR>>, QueryOrderStart<QueryOperationFields<QueryOrderOperation<TestReserved.QueryOrder<QR>, QR>>>, QueryBracket<QuerySelect<QR>> {
        QueryCollectionFunctions<String, QuerySelectOperation<TestReserved.QuerySelect<QR>, QueryOperationFields<QueryOrderOperation<TestReserved.QueryOrder<QR>, QR>>, QR>> list_();
        QueryCollectionFunctions<String, QuerySelectOperation<TestReserved.QuerySelect<QR>, QueryOperationFields<QueryOrderOperation<TestReserved.QueryOrder<QR>, QR>>, QR>> references_();
    }

    interface QueryUpdate<QR, QS> extends QueryFields<QueryUpdate<QR, QS>>, QueryWhere<QS>, QueryScript<QueryUpdate<QR, QS>>, UpdatableQuery {
    }
}
