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
import java.util.List;

@Generated(value = "TestReservedPrototype", comments = "TestReserved")
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

    protected String page;

    protected String prepare;

    protected String projection;

    protected String reference;

    protected List<String> references;

    protected String remove;

    protected String top;

    protected String tuple;

    protected String tuples;

    {
        CodeFactory.registerType(TestReserved.QuerySelect.class, TestReservedQueryExecutorImpl::new, null);
        CodeFactory.registerType(TestReserved.class, TestReservedImpl::new, null);
        CodeFactory.registerType(TestReserved.QueryName.class, TestReservedQueryNameImpl::new, null);
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

    protected static class TestReservedQueryExecutorImpl extends QueryExecutor implements TestReserved.QuerySelect, TestReserved.QueryFieldsStart {

        protected TestReservedQueryExecutorImpl() {
            super(TestReserved.class, () -> new TestReservedQueryNameImpl());
        }

        public QuerySelectOperation _count(String count) {
            return identifier("count", count);
        }

        public QueryFunctions _count() {
            return identifier("count");
        }

        public QuerySelectOperation _delete(String delete) {
            return identifier("delete", delete);
        }

        public QueryFunctions _delete() {
            return identifier("delete");
        }

        public QuerySelectOperation _ensure(String ensure) {
            return identifier("ensure", ensure);
        }

        public QueryFunctions _ensure() {
            return identifier("ensure");
        }

        public QuerySelectOperation _exists(String exists) {
            return identifier("exists", exists);
        }

        public QueryFunctions _exists() {
            return identifier("exists");
        }

        public QuerySelectOperation _filter(String filter) {
            return identifier("filter", filter);
        }

        public QueryFunctions _filter() {
            return identifier("filter");
        }

        public QuerySelectOperation _flush(String flush) {
            return identifier("flush", flush);
        }

        public QueryFunctions _flush() {
            return identifier("flush");
        }

        public QuerySelectOperation _get(String get) {
            return identifier("get", get);
        }

        public QueryFunctions _get() {
            return identifier("get");
        }

        public QuerySelectOperation _hint(String hint) {
            return identifier("hint", hint);
        }

        public QueryFunctions _hint() {
            return identifier("hint");
        }

        public QueryCollectionFunctions _list() {
            return identifier("list");
        }

        public QuerySelectOperation _lock(String lock) {
            return identifier("lock", lock);
        }

        public QueryFunctions _lock() {
            return identifier("lock");
        }

        public QuerySelectOperation _page(String page) {
            return identifier("page", page);
        }

        public QueryFunctions _page() {
            return identifier("page");
        }

        public QuerySelectOperation _prepare(String prepare) {
            return identifier("prepare", prepare);
        }

        public QueryFunctions _prepare() {
            return identifier("prepare");
        }

        public QuerySelectOperation _projection(String projection) {
            return identifier("projection", projection);
        }

        public QueryFunctions _projection() {
            return identifier("projection");
        }

        public QuerySelectOperation _reference(String reference) {
            return identifier("reference", reference);
        }

        public QueryFunctions _reference() {
            return identifier("reference");
        }

        public QueryCollectionFunctions _references() {
            return identifier("references");
        }

        public QuerySelectOperation _remove(String remove) {
            return identifier("remove", remove);
        }

        public QueryFunctions _remove() {
            return identifier("remove");
        }

        public QuerySelectOperation _top(String top) {
            return identifier("top", top);
        }

        public QueryFunctions _top() {
            return identifier("top");
        }

        public QuerySelectOperation _tuple(String tuple) {
            return identifier("tuple", tuple);
        }

        public QueryFunctions _tuple() {
            return identifier("tuple");
        }

        public QuerySelectOperation _tuples(String tuples) {
            return identifier("tuples", tuples);
        }

        public QueryFunctions _tuples() {
            return identifier("tuples");
        }

        public QueryAggregateOperation aggregate() {
            return (QueryAggregateOperation) aggregateStart(new TestReservedQueryOrderImpl(this, TestReservedQueryExecutorImpl.this::aggregateIdentifier));
        }

        public TestReserved.QueryOrder order() {
            return (TestReserved.QueryOrder) orderStart(new TestReservedQueryOrderImpl(this, TestReservedQueryExecutorImpl.this::orderIdentifier));
        }

        protected class TestReservedQueryOrderImpl extends QueryOrderer implements TestReserved.QueryOrder, TestReserved.QueryAggregate {

            protected TestReservedQueryOrderImpl(TestReservedQueryExecutorImpl executor, Function<String, Object> func) {
                super(executor, func);
            }

            public QueryOrderOperation _count() {
                return (QueryOrderOperation) func.apply("count");
            }

            public QueryOrderOperation _delete() {
                return (QueryOrderOperation) func.apply("delete");
            }

            public QueryOrderOperation _ensure() {
                return (QueryOrderOperation) func.apply("ensure");
            }

            public QueryOrderOperation _exists() {
                return (QueryOrderOperation) func.apply("exists");
            }

            public QueryOrderOperation _filter() {
                return (QueryOrderOperation) func.apply("filter");
            }

            public QueryOrderOperation _flush() {
                return (QueryOrderOperation) func.apply("flush");
            }

            public QueryOrderOperation _get() {
                return (QueryOrderOperation) func.apply("get");
            }

            public QueryOrderOperation _hint() {
                return (QueryOrderOperation) func.apply("hint");
            }

            public QueryOrderOperation _lock() {
                return (QueryOrderOperation) func.apply("lock");
            }

            public QueryOrderOperation _page() {
                return (QueryOrderOperation) func.apply("page");
            }

            public QueryOrderOperation _prepare() {
                return (QueryOrderOperation) func.apply("prepare");
            }

            public QueryOrderOperation _projection() {
                return (QueryOrderOperation) func.apply("projection");
            }

            public QueryOrderOperation _reference() {
                return (QueryOrderOperation) func.apply("reference");
            }

            public QueryOrderOperation _remove() {
                return (QueryOrderOperation) func.apply("remove");
            }

            public QueryOrderOperation _top() {
                return (QueryOrderOperation) func.apply("top");
            }

            public QueryOrderOperation _tuple() {
                return (QueryOrderOperation) func.apply("tuple");
            }

            public QueryOrderOperation _tuples() {
                return (QueryOrderOperation) func.apply("tuples");
            }
        }
    }

    protected static class TestReservedQueryNameImpl extends BaseQueryNameImpl implements TestReserved.QueryName, QueryEmbed {

        public QueryFunctions _count() {
            return executor.identifier("count");
        }

        public QuerySelectOperation _count(String count) {
            return executor.identifier("count", count);
        }

        public QueryFunctions _delete() {
            return executor.identifier("delete");
        }

        public QuerySelectOperation _delete(String delete) {
            return executor.identifier("delete", delete);
        }

        public QueryFunctions _ensure() {
            return executor.identifier("ensure");
        }

        public QuerySelectOperation _ensure(String ensure) {
            return executor.identifier("ensure", ensure);
        }

        public QueryFunctions _exists() {
            return executor.identifier("exists");
        }

        public QuerySelectOperation _exists(String exists) {
            return executor.identifier("exists", exists);
        }

        public QueryFunctions _filter() {
            return executor.identifier("filter");
        }

        public QuerySelectOperation _filter(String filter) {
            return executor.identifier("filter", filter);
        }

        public QueryFunctions _flush() {
            return executor.identifier("flush");
        }

        public QuerySelectOperation _flush(String flush) {
            return executor.identifier("flush", flush);
        }

        public QueryFunctions _get() {
            return executor.identifier("get");
        }

        public QuerySelectOperation _get(String get) {
            return executor.identifier("get", get);
        }

        public QueryFunctions _hint() {
            return executor.identifier("hint");
        }

        public QuerySelectOperation _hint(String hint) {
            return executor.identifier("hint", hint);
        }

        public QueryFunctions _lock() {
            return executor.identifier("lock");
        }

        public QuerySelectOperation _lock(String lock) {
            return executor.identifier("lock", lock);
        }

        public QueryFunctions _page() {
            return executor.identifier("page");
        }

        public QuerySelectOperation _page(String page) {
            return executor.identifier("page", page);
        }

        public QueryFunctions _prepare() {
            return executor.identifier("prepare");
        }

        public QuerySelectOperation _prepare(String prepare) {
            return executor.identifier("prepare", prepare);
        }

        public QueryFunctions _projection() {
            return executor.identifier("projection");
        }

        public QuerySelectOperation _projection(String projection) {
            return executor.identifier("projection", projection);
        }

        public QueryFunctions _reference() {
            return executor.identifier("reference");
        }

        public QuerySelectOperation _reference(String reference) {
            return executor.identifier("reference", reference);
        }

        public QueryFunctions _remove() {
            return executor.identifier("remove");
        }

        public QuerySelectOperation _remove(String remove) {
            return executor.identifier("remove", remove);
        }

        public QueryFunctions _top() {
            return executor.identifier("top");
        }

        public QuerySelectOperation _top(String top) {
            return executor.identifier("top", top);
        }

        public QueryFunctions _tuple() {
            return executor.identifier("tuple");
        }

        public QuerySelectOperation _tuple(String tuple) {
            return executor.identifier("tuple", tuple);
        }

        public QueryFunctions _tuples() {
            return executor.identifier("tuples");
        }

        public QuerySelectOperation _tuples(String tuples) {
            return executor.identifier("tuples", tuples);
        }
    }
}
