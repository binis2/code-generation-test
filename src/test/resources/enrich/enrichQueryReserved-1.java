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
public interface TestReserved {

    static QueryStarter<TestReserved, TestReserved.QuerySelect<TestReserved>, QueryAggregateOperation<QueryOperationFields<TestReserved.QueryAggregate<Number, TestReserved.QuerySelect<Number>>>>, QueryFieldsStart<TestReserved, TestReserved.QuerySelect<TestReserved>>> find() {
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

    interface QueryAggregate<QR, QA> extends QueryExecute<QR>, QueryAggregator<QA, QueryAggregateOperation<QueryOperationFields<TestReserved.QueryAggregate<TestReserved, TestReserved.QuerySelect<Number>>>>> {
    }

    interface QueryFields<QR> extends QueryScript<QR> {
        QR _count(String count);
        QR _delete(String delete);
        QR _ensure(String ensure);
        QR _exists(String exists);
        QR _filter(String filter);
        QR _flush(String flush);
        QR _get(String get);
        QR _hint(String hint);
        QR _lock(String lock);
        QR _page(String page);
        QR _prepare(String prepare);
        QR _projection(String projection);
        QR _reference(String reference);
        QR _remove(String remove);
        QR _top(String top);
        QR _tuple(String tuple);
        QR _tuples(String tuples);
    }

    interface QueryFieldsStart<QR, QS> extends QueryExecute<QR>, QueryWhere<QS>, QueryOperationFields<QueryFieldsStart<QR, QS>> {
    }

    interface QueryFuncs<QR> {
        QueryFunctions<String, QR> _count();
        QueryFunctions<String, QR> _delete();
        QueryFunctions<String, QR> _ensure();
        QueryFunctions<String, QR> _exists();
        QueryFunctions<String, QR> _filter();
        QueryFunctions<String, QR> _flush();
        QueryFunctions<String, QR> _get();
        QueryFunctions<String, QR> _hint();
        QueryFunctions<String, QR> _lock();
        QueryFunctions<String, QR> _page();
        QueryFunctions<String, QR> _prepare();
        QueryFunctions<String, QR> _projection();
        QueryFunctions<String, QR> _reference();
        QueryFunctions<String, QR> _remove();
        QueryFunctions<String, QR> _top();
        QueryFunctions<String, QR> _tuple();
        QueryFunctions<String, QR> _tuples();
    }

    interface QueryName<QS, QO, QR, QF> extends TestReserved.QueryFields<QuerySelectOperation<QS, QO, QR>>, TestReserved.QueryFuncs<QuerySelectOperation<QS, QO, QR>>, QueryFetch<QuerySelectOperation<QS, QO, QR>, QF> {
    }

    interface QueryOperationFields<QR> extends QueryScript<QR> {
        QR _count();
        QR _delete();
        QR _ensure();
        QR _exists();
        QR _filter();
        QR _flush();
        QR _get();
        QR _hint();
        QR _lock();
        QR _page();
        QR _prepare();
        QR _projection();
        QR _reference();
        QR _remove();
        QR _top();
        QR _tuple();
        QR _tuples();
    }

    interface QueryOrder<QR> extends QueryOperationFields<QueryOrderOperation<TestReserved.QueryOrder<QR>, QR>>, QueryExecute<QR>, QueryScript<QueryOrderOperation<TestReserved.QueryOrder<QR>, QR>> {
    }

    interface QuerySelect<QR> extends QueryExecute<QR>, QueryModifiers<TestReserved.QueryName<TestReserved.QuerySelect<QR>, TestReserved.QueryOrder<QR>, QR, TestReserved>>, TestReserved.QueryFields<QuerySelectOperation<TestReserved.QuerySelect<QR>, TestReserved.QueryOrder<QR>, QR>>, TestReserved.QueryFuncs<QuerySelectOperation<TestReserved.QuerySelect<QR>, TestReserved.QueryOrder<QR>, QR>>, QueryOrderStart<QueryOperationFields<QueryOrderOperation<TestReserved.QueryOrder<QR>, QR>>>, QueryBracket<QuerySelect<QR>> {
        QueryCollectionFunctions<String, QuerySelectOperation<TestReserved.QuerySelect<QR>, QueryOperationFields<QueryOrderOperation<TestReserved.QueryOrder<QR>, QR>>, QR>> _list();
        QueryCollectionFunctions<String, QuerySelectOperation<TestReserved.QuerySelect<QR>, QueryOperationFields<QueryOrderOperation<TestReserved.QueryOrder<QR>, QR>>, QR>> _references();
    }
}
