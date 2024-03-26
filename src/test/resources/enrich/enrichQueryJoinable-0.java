/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.spring.query.executor.QueryOrderer;
import net.binis.codegen.spring.query.executor.QueryExecutor;
import net.binis.codegen.spring.query.base.BaseQueryNameImpl;
import net.binis.codegen.spring.query.*;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.creator.EntityCreator;
import javax.annotation.processing.Generated;
import java.util.function.Function;
import java.util.Optional;
import java.util.Map;
import java.util.List;

@Generated(value = "net.binis.codegen.TestReservedPrototype", comments = "TestReserved")
@SuppressWarnings("unchecked")
public class TestReservedImpl implements TestReserved {

    protected String count;

    protected String delete;

    protected String ensure;

    protected String exists;

    protected String filter;

    protected String flush;

    protected String get;

    protected String hint;

    protected List<String> list;

    protected String lock;

    protected Map<String, TestReserved> map;

    protected String page;

    protected String prepare;

    protected String projection;

    protected String reference;

    protected List<String> references;

    protected String remove;

    protected String top;

    protected String tuple;

    protected String tuples;

    static {
        CodeFactory.registerType(TestReserved.QueryOrder.class, () -> TestReserved.find().aggregate(), null);
        CodeFactory.registerType(TestReserved.class, TestReservedImpl::new, null);
        CodeFactory.registerType(TestReserved.QueryName.class, TestReservedQueryNameImpl::new, null);
        CodeFactory.registerType(TestReserved.QuerySelect.class, TestReservedQueryExecutorImpl::new, null);
        CodeFactory.registerType(TestReserved.QueryOperationFields.class, TestReservedQueryExecutorImpl::new, null);
    }

    public TestReservedImpl() {
    }

    public String getCount() {
        return count;
    }

    public String getDelete() {
        return delete;
    }

    public String getEnsure() {
        return ensure;
    }

    public String getExists() {
        return exists;
    }

    public String getFilter() {
        return filter;
    }

    public String getFlush() {
        return flush;
    }

    public String getGet() {
        return get;
    }

    public String getHint() {
        return hint;
    }

    public List<String> getList() {
        return list;
    }

    public String getLock() {
        return lock;
    }

    public Map<String, TestReserved> getMap() {
        return map;
    }

    public String getPage() {
        return page;
    }

    public String getPrepare() {
        return prepare;
    }

    public String getProjection() {
        return projection;
    }

    public String getReference() {
        return reference;
    }

    public List<String> getReferences() {
        return references;
    }

    public String getRemove() {
        return remove;
    }

    public String getTop() {
        return top;
    }

    public String getTuple() {
        return tuple;
    }

    public String getTuples() {
        return tuples;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    public void setEnsure(String ensure) {
        this.ensure = ensure;
    }

    public void setExists(String exists) {
        this.exists = exists;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public void setFlush(String flush) {
        this.flush = flush;
    }

    public void setGet(String get) {
        this.get = get;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setLock(String lock) {
        this.lock = lock;
    }

    public void setMap(Map<String, TestReserved> map) {
        this.map = map;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public void setPrepare(String prepare) {
        this.prepare = prepare;
    }

    public void setProjection(String projection) {
        this.projection = projection;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setReferences(List<String> references) {
        this.references = references;
    }

    public void setRemove(String remove) {
        this.remove = remove;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public void setTuple(String tuple) {
        this.tuple = tuple;
    }

    public void setTuples(String tuples) {
        this.tuples = tuples;
    }

    @Generated("QueryEnricher")
    protected static class TestReservedQueryExecutorImpl extends QueryExecutor implements TestReserved.QueryUpdate, TestReserved.QuerySelect, TestReserved.QueryFieldsStart {

        protected TestReservedQueryExecutorImpl() {
            super(TestReserved.class, () -> new TestReservedQueryNameImpl(), parent -> parent);
        }

        public QueryAggregateOperation aggregate() {
            return (QueryAggregateOperation) _aggregateStart(new TestReservedQueryOrderImpl(this, TestReservedQueryExecutorImpl.this::_aggregateIdentifier));
        }

        public QueryFunctions count_() {
            return $identifier("count");
        }

        public QuerySelectOperation count_(String count) {
            return $identifier("count", count);
        }

        public QueryFunctions delete_() {
            return $identifier("delete");
        }

        public QuerySelectOperation delete_(String delete) {
            return $identifier("delete", delete);
        }

        public QueryFunctions ensure_() {
            return $identifier("ensure");
        }

        public QuerySelectOperation ensure_(String ensure) {
            return $identifier("ensure", ensure);
        }

        public QueryFunctions exists_() {
            return $identifier("exists");
        }

        public QuerySelectOperation exists_(String exists) {
            return $identifier("exists", exists);
        }

        public QueryFunctions filter_() {
            return $identifier("filter");
        }

        public QuerySelectOperation filter_(String filter) {
            return $identifier("filter", filter);
        }

        public QueryFunctions flush_() {
            return $identifier("flush");
        }

        public QuerySelectOperation flush_(String flush) {
            return $identifier("flush", flush);
        }

        public QueryFunctions get_() {
            return $identifier("get");
        }

        public QuerySelectOperation get_(String get) {
            return $identifier("get", get);
        }

        public QueryFunctions hint_() {
            return $identifier("hint");
        }

        public QuerySelectOperation hint_(String hint) {
            return $identifier("hint", hint);
        }

        public QueryCollectionFunctions list_() {
            return $identifier("list");
        }

        public QueryFunctions lock_() {
            return $identifier("lock");
        }

        public QuerySelectOperation lock_(String lock) {
            return $identifier("lock", lock);
        }

        public QueryJoinCollectionFunctions map() {
            return (QueryJoinCollectionFunctions) joinStart("map", TestReserved.QueryOrder.class);
        }

        public TestReserved.QueryOrder order() {
            return (TestReserved.QueryOrder) _orderStart(new TestReservedQueryOrderImpl(this, TestReservedQueryExecutorImpl.this::_orderIdentifier));
        }

        public QueryFunctions page_() {
            return $identifier("page");
        }

        public QuerySelectOperation page_(String page) {
            return $identifier("page", page);
        }

        public QueryFunctions prepare_() {
            return $identifier("prepare");
        }

        public QuerySelectOperation prepare_(String prepare) {
            return $identifier("prepare", prepare);
        }

        public QueryFunctions projection_() {
            return $identifier("projection");
        }

        public QuerySelectOperation projection_(String projection) {
            return $identifier("projection", projection);
        }

        public QueryFunctions reference_() {
            return $identifier("reference");
        }

        public QuerySelectOperation reference_(String reference) {
            return $identifier("reference", reference);
        }

        public QueryCollectionFunctions references_() {
            return $identifier("references");
        }

        public QueryFunctions remove_() {
            return $identifier("remove");
        }

        public QuerySelectOperation remove_(String remove) {
            return $identifier("remove", remove);
        }

        public QueryFunctions top_() {
            return $identifier("top");
        }

        public QuerySelectOperation top_(String top) {
            return $identifier("top", top);
        }

        public QueryFunctions tuple_() {
            return $identifier("tuple");
        }

        public QuerySelectOperation tuple_(String tuple) {
            return $identifier("tuple", tuple);
        }

        public QueryFunctions tuples_() {
            return $identifier("tuples");
        }

        public QuerySelectOperation tuples_(String tuples) {
            return $identifier("tuples", tuples);
        }

        @Generated("QueryEnricher")
        protected class TestReservedQueryOrderImpl extends QueryOrderer implements TestReserved.QueryOrder, TestReserved.QueryAggregate {

            protected TestReservedQueryOrderImpl(TestReservedQueryExecutorImpl executor, Function<String, Object> func) {
                super(executor, func);
            }

            public QueryOrderOperation count_() {
                return (QueryOrderOperation) func.apply("count");
            }

            public QueryOrderOperation delete_() {
                return (QueryOrderOperation) func.apply("delete");
            }

            public QueryOrderOperation ensure_() {
                return (QueryOrderOperation) func.apply("ensure");
            }

            public QueryOrderOperation exists_() {
                return (QueryOrderOperation) func.apply("exists");
            }

            public QueryOrderOperation filter_() {
                return (QueryOrderOperation) func.apply("filter");
            }

            public QueryOrderOperation flush_() {
                return (QueryOrderOperation) func.apply("flush");
            }

            public QueryOrderOperation get_() {
                return (QueryOrderOperation) func.apply("get");
            }

            public QueryOrderOperation hint_() {
                return (QueryOrderOperation) func.apply("hint");
            }

            public QueryOrderOperation lock_() {
                return (QueryOrderOperation) func.apply("lock");
            }

            public QueryOrderOperation page_() {
                return (QueryOrderOperation) func.apply("page");
            }

            public QueryOrderOperation prepare_() {
                return (QueryOrderOperation) func.apply("prepare");
            }

            public QueryOrderOperation projection_() {
                return (QueryOrderOperation) func.apply("projection");
            }

            public QueryOrderOperation reference_() {
                return (QueryOrderOperation) func.apply("reference");
            }

            public QueryOrderOperation remove_() {
                return (QueryOrderOperation) func.apply("remove");
            }

            public QueryOrderOperation top_() {
                return (QueryOrderOperation) func.apply("top");
            }

            public QueryOrderOperation tuple_() {
                return (QueryOrderOperation) func.apply("tuple");
            }

            public QueryOrderOperation tuples_() {
                return (QueryOrderOperation) func.apply("tuples");
            }
        }
    }

    @Generated("QueryEnricher")
    protected static class TestReservedQueryNameImpl extends BaseQueryNameImpl implements TestReserved.QueryName, QueryEmbed {

        public QueryFunctions count_() {
            return executor.$identifier("count");
        }

        public QuerySelectOperation count_(String count) {
            return executor.$identifier("count", count);
        }

        public QueryFunctions delete_() {
            return executor.$identifier("delete");
        }

        public QuerySelectOperation delete_(String delete) {
            return executor.$identifier("delete", delete);
        }

        public QueryFunctions ensure_() {
            return executor.$identifier("ensure");
        }

        public QuerySelectOperation ensure_(String ensure) {
            return executor.$identifier("ensure", ensure);
        }

        public QueryFunctions exists_() {
            return executor.$identifier("exists");
        }

        public QuerySelectOperation exists_(String exists) {
            return executor.$identifier("exists", exists);
        }

        public QueryFunctions filter_() {
            return executor.$identifier("filter");
        }

        public QuerySelectOperation filter_(String filter) {
            return executor.$identifier("filter", filter);
        }

        public QueryFunctions flush_() {
            return executor.$identifier("flush");
        }

        public QuerySelectOperation flush_(String flush) {
            return executor.$identifier("flush", flush);
        }

        public QueryFunctions get_() {
            return executor.$identifier("get");
        }

        public QuerySelectOperation get_(String get) {
            return executor.$identifier("get", get);
        }

        public QueryFunctions hint_() {
            return executor.$identifier("hint");
        }

        public QuerySelectOperation hint_(String hint) {
            return executor.$identifier("hint", hint);
        }

        public QueryFunctions lock_() {
            return executor.$identifier("lock");
        }

        public QuerySelectOperation lock_(String lock) {
            return executor.$identifier("lock", lock);
        }

        public QueryFunctions page_() {
            return executor.$identifier("page");
        }

        public QuerySelectOperation page_(String page) {
            return executor.$identifier("page", page);
        }

        public QueryFunctions prepare_() {
            return executor.$identifier("prepare");
        }

        public QuerySelectOperation prepare_(String prepare) {
            return executor.$identifier("prepare", prepare);
        }

        public QueryFunctions projection_() {
            return executor.$identifier("projection");
        }

        public QuerySelectOperation projection_(String projection) {
            return executor.$identifier("projection", projection);
        }

        public QueryFunctions reference_() {
            return executor.$identifier("reference");
        }

        public QuerySelectOperation reference_(String reference) {
            return executor.$identifier("reference", reference);
        }

        public QueryFunctions remove_() {
            return executor.$identifier("remove");
        }

        public QuerySelectOperation remove_(String remove) {
            return executor.$identifier("remove", remove);
        }

        public QueryFunctions top_() {
            return executor.$identifier("top");
        }

        public QuerySelectOperation top_(String top) {
            return executor.$identifier("top", top);
        }

        public QueryFunctions tuple_() {
            return executor.$identifier("tuple");
        }

        public QuerySelectOperation tuple_(String tuple) {
            return executor.$identifier("tuple", tuple);
        }

        public QueryFunctions tuples_() {
            return executor.$identifier("tuples");
        }

        public QuerySelectOperation tuples_(String tuples) {
            return executor.$identifier("tuples", tuples);
        }
    }
}
