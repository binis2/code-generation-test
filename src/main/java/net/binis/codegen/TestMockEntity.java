/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import lombok.Data;
import lombok.ToString;
import net.binis.codegen.creator.EntityCreator;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.spring.BaseEntityModifier;
import net.binis.codegen.spring.query.QueryEmbed;
import net.binis.codegen.spring.query.QueryFunctions;
import net.binis.codegen.spring.query.QueryOrderOperation;
import net.binis.codegen.spring.query.QuerySelectOperation;
import net.binis.codegen.spring.query.base.BaseQueryNameImpl;
import net.binis.codegen.spring.query.executor.QueryExecutor;
import net.binis.codegen.spring.query.executor.QueryOrderer;

import javax.persistence.Column;
import javax.swing.*;
import java.time.OffsetDateTime;

@Data
public class TestMockEntity implements TestMock, Modifiable<TestMock.Modify> {

    public static final String TABLE_NAME = "TestMocks";

    private static final long serialVersionUID = -9181869455595661663L;

    protected String actionLink;

    protected String buttonText;

    @ToString.Include
    @Column(nullable = false)
    protected String code;

    protected String description;

    protected String name;

    {
        CodeFactory.registerType(TestMock.QuerySelect.class, TestMockQueryExecutorImpl::new, null);
        CodeFactory.registerType(TestMock.class, TestMockEntity::new, null);
        CodeFactory.registerType(TestMock.QueryName.class, TestMockQueryNameImpl::new, null);
    }

    public TestMockEntity() {
        super();
    }

    public TestMock.Modify with() {
        return new TestMockEntityModifyImpl();
    }

    protected class TestMockEntityModifyImpl extends BaseEntityModifier<TestMock.Modify, TestMock> implements TestMock.Modify {

        protected TestMockEntityModifyImpl() {
            setObject(TestMockEntity.this);
        }

        public TestMock.Modify actionLink(String actionLink) {
            TestMockEntity.this.actionLink = actionLink;
            return this;
        }

        public TestMock.Modify buttonText(String buttonText) {
            TestMockEntity.this.buttonText = buttonText;
            return this;
        }

        public TestMock.Modify code(String code) {
            TestMockEntity.this.code = code;
            return this;
        }

        public TestMock.Modify description(String description) {
            TestMockEntity.this.description = description;
            return this;
        }

        public TestMock done() {
            return TestMockEntity.this;
        }

        public TestMock.Modify name(String name) {
            TestMockEntity.this.name = name;
            return this;
        }
    }

    protected static class TestMockQueryExecutorImpl<QR> extends QueryExecutor<Object, TestMock.QuerySelect<QR>, TestMock.QueryOrder<QR>, QR> implements TestMock.QuerySelect<QR> {

        protected TestMockQueryExecutorImpl() {
            super(TestMock.class);
            order = new TestMockQueryOrderImpl<>(this);
        }

        public QuerySelectOperation<TestMock.QuerySelect<QR>, TestMock.QueryOrder<QR>, QR> actionLink(String actionLink) {
            identifier("actionLink", actionLink);
            return this;
        }

        public QueryFunctions<String, QuerySelectOperation<TestMock.QuerySelect<QR>, TestMock.QueryOrder<QR>, QR>> actionLink() {
            identifier("actionLink");
            return (QueryFunctions) this;
        }

        public QuerySelectOperation<TestMock.QuerySelect<QR>, TestMock.QueryOrder<QR>, QR> buttonText(String buttonText) {
            identifier("buttonText", buttonText);
            return this;
        }

        public QueryFunctions<String, QuerySelectOperation<TestMock.QuerySelect<QR>, TestMock.QueryOrder<QR>, QR>> buttonText() {
            identifier("buttonText");
            return (QueryFunctions) this;
        }

        public QuerySelectOperation<TestMock.QuerySelect<QR>, TestMock.QueryOrder<QR>, QR> code(String code) {
            identifier("code", code);
            return this;
        }

        public QueryFunctions<String, QuerySelectOperation<TestMock.QuerySelect<QR>, TestMock.QueryOrder<QR>, QR>> code() {
            identifier("code");
            return (QueryFunctions) this;
        }

        public QuerySelectOperation<TestMock.QuerySelect<QR>, TestMock.QueryOrder<QR>, QR> created(OffsetDateTime created) {
            identifier("created", created);
            return this;
        }

        public QueryFunctions<OffsetDateTime, QuerySelectOperation<TestMock.QuerySelect<QR>, TestMock.QueryOrder<QR>, QR>> created() {
            identifier("created");
            return (QueryFunctions) this;
        }

        public QuerySelectOperation<TestMock.QuerySelect<QR>, TestMock.QueryOrder<QR>, QR> createdBy(String createdBy) {
            identifier("createdBy", createdBy);
            return this;
        }

        public QueryFunctions<String, QuerySelectOperation<TestMock.QuerySelect<QR>, TestMock.QueryOrder<QR>, QR>> createdBy() {
            identifier("createdBy");
            return (QueryFunctions) this;
        }

        public QuerySelectOperation<TestMock.QuerySelect<QR>, TestMock.QueryOrder<QR>, QR> description(String description) {
            identifier("description", description);
            return this;
        }

        public QueryFunctions<String, QuerySelectOperation<TestMock.QuerySelect<QR>, TestMock.QueryOrder<QR>, QR>> description() {
            identifier("description");
            return (QueryFunctions) this;
        }

        public QuerySelectOperation<TestMock.QuerySelect<QR>, TestMock.QueryOrder<QR>, QR> icon(Icon icon) {
            identifier("icon", icon);
            return this;
        }

        public QuerySelectOperation<TestMock.QuerySelect<QR>, TestMock.QueryOrder<QR>, QR> id(Long id) {
            identifier("id", id);
            return this;
        }

        public QueryFunctions<Long, QuerySelectOperation<TestMock.QuerySelect<QR>, TestMock.QueryOrder<QR>, QR>> id() {
            identifier("id");
            return (QueryFunctions) this;
        }

        public TestMock.QueryName<TestMock.QuerySelect<QR>, TestMock.QueryOrder<QR>, QR> lower() {
            doLower();
            var result = new TestMockQueryNameImpl<>();
            result.setParent("u", this);
            return (TestMock.QueryName) result;
        }

        public QuerySelectOperation<TestMock.QuerySelect<QR>, TestMock.QueryOrder<QR>, QR> modified(OffsetDateTime modified) {
            identifier("modified", modified);
            return this;
        }

        public QueryFunctions<OffsetDateTime, QuerySelectOperation<TestMock.QuerySelect<QR>, TestMock.QueryOrder<QR>, QR>> modified() {
            identifier("modified");
            return (QueryFunctions) this;
        }

        public QuerySelectOperation<TestMock.QuerySelect<QR>, TestMock.QueryOrder<QR>, QR> modifiedBy(String modifiedBy) {
            identifier("modifiedBy", modifiedBy);
            return this;
        }

        public QueryFunctions<String, QuerySelectOperation<TestMock.QuerySelect<QR>, TestMock.QueryOrder<QR>, QR>> modifiedBy() {
            identifier("modifiedBy");
            return (QueryFunctions) this;
        }

        public QuerySelectOperation<TestMock.QuerySelect<QR>, TestMock.QueryOrder<QR>, QR> name(String name) {
            identifier("name", name);
            return this;
        }

        public QueryFunctions<String, QuerySelectOperation<TestMock.QuerySelect<QR>, TestMock.QueryOrder<QR>, QR>> name() {
            identifier("name");
            return (QueryFunctions) this;
        }

        public TestMock.QueryName<TestMock.QuerySelect<QR>, TestMock.QueryOrder<QR>, QR> not() {
            doNot();
            var result = new TestMockQueryNameImpl<>();
            result.setParent("u", this);
            return (TestMock.QueryName) result;
        }

        public TestMock.QueryOrder<QR> order() {
            orderStart();
            return order;
        }

        public TestMock.QueryName<TestMock.QuerySelect<QR>, TestMock.QueryOrder<QR>, QR> replace(String what, String withWhat) {
            doReplace(what, withWhat);
            var result = new TestMockQueryNameImpl<>();
            result.setParent("u", this);
            return (TestMock.QueryName) result;
        }

        public TestMock.QueryName<TestMock.QuerySelect<QR>, TestMock.QueryOrder<QR>, QR> substring(int start) {
            doSubstring(start);
            var result = new TestMockQueryNameImpl<>();
            result.setParent("u", this);
            return (TestMock.QueryName) result;
        }

        public TestMock.QueryName<TestMock.QuerySelect<QR>, TestMock.QueryOrder<QR>, QR> substring(int start, int len) {
            doSubstring(start, len);
            var result = new TestMockQueryNameImpl<>();
            result.setParent("u", this);
            return (TestMock.QueryName) result;
        }

        public TestMock.QueryName<TestMock.QuerySelect<QR>, TestMock.QueryOrder<QR>, QR> trim() {
            doTrim();
            var result = new TestMockQueryNameImpl<>();
            result.setParent("u", this);
            return (TestMock.QueryName) result;
        }

        public TestMock.QueryName<TestMock.QuerySelect<QR>, TestMock.QueryOrder<QR>, QR> upper() {
            doUpper();
            var result = new TestMockQueryNameImpl<>();
            result.setParent("u", this);
            return (TestMock.QueryName) result;
        }

        protected class TestMockQueryOrderImpl<QR> extends QueryOrderer<QR> implements TestMock.QueryOrder<QR> {

            protected TestMockQueryOrderImpl(TestMockQueryExecutorImpl executor) {
                super(executor);
            }

            public QueryOrderOperation<TestMock.QueryOrder<QR>, QR> actionLink() {
                return (QueryOrderOperation) TestMockQueryExecutorImpl.this.orderIdentifier("actionLink");
            }

            public QueryOrderOperation<TestMock.QueryOrder<QR>, QR> buttonText() {
                return (QueryOrderOperation) TestMockQueryExecutorImpl.this.orderIdentifier("buttonText");
            }

            public QueryOrderOperation<TestMock.QueryOrder<QR>, QR> code() {
                return (QueryOrderOperation) TestMockQueryExecutorImpl.this.orderIdentifier("code");
            }

            public QueryOrderOperation<TestMock.QueryOrder<QR>, QR> created() {
                return (QueryOrderOperation) TestMockQueryExecutorImpl.this.orderIdentifier("created");
            }

            public QueryOrderOperation<TestMock.QueryOrder<QR>, QR> createdBy() {
                return (QueryOrderOperation) TestMockQueryExecutorImpl.this.orderIdentifier("createdBy");
            }

            public QueryOrderOperation<TestMock.QueryOrder<QR>, QR> description() {
                return (QueryOrderOperation) TestMockQueryExecutorImpl.this.orderIdentifier("description");
            }

            public QueryOrderOperation<TestMock.QueryOrder<QR>, QR> icon() {
                return (QueryOrderOperation) TestMockQueryExecutorImpl.this.orderIdentifier("icon");
            }

            public QueryOrderOperation<TestMock.QueryOrder<QR>, QR> id() {
                return (QueryOrderOperation) TestMockQueryExecutorImpl.this.orderIdentifier("id");
            }

            public QueryOrderOperation<TestMock.QueryOrder<QR>, QR> modified() {
                return (QueryOrderOperation) TestMockQueryExecutorImpl.this.orderIdentifier("modified");
            }

            public QueryOrderOperation<TestMock.QueryOrder<QR>, QR> modifiedBy() {
                return (QueryOrderOperation) TestMockQueryExecutorImpl.this.orderIdentifier("modifiedBy");
            }

            public QueryOrderOperation<TestMock.QueryOrder<QR>, QR> name() {
                return (QueryOrderOperation) TestMockQueryExecutorImpl.this.orderIdentifier("name");
            }

            public QueryOrderOperation<TestMock.QueryOrder<QR>, QR> script(String script) {
                return (QueryOrderOperation) TestMockQueryExecutorImpl.this.script(script);
            }
        }
    }

    protected static class TestMockQueryNameImpl<QS, QO, QR> extends BaseQueryNameImpl<QuerySelectOperation<QS, QO, QR>> implements TestMock.QueryName<QS, QO, QR>, QueryEmbed {

        public QueryFunctions<String, QuerySelectOperation<QS, QO, QR>> actionLink() {
            return (QueryFunctions) executor.identifier("actionLink");
        }

        public QuerySelectOperation<QS, QO, QR> actionLink(String actionLink) {
            return (QuerySelectOperation) executor.identifier("actionLink", actionLink);
        }

        public QueryFunctions<String, QuerySelectOperation<QS, QO, QR>> buttonText() {
            return (QueryFunctions) executor.identifier("buttonText");
        }

        public QuerySelectOperation<QS, QO, QR> buttonText(String buttonText) {
            return (QuerySelectOperation) executor.identifier("buttonText", buttonText);
        }

        public QueryFunctions<String, QuerySelectOperation<QS, QO, QR>> code() {
            return (QueryFunctions) executor.identifier("code");
        }

        public QuerySelectOperation<QS, QO, QR> code(String code) {
            return (QuerySelectOperation) executor.identifier("code", code);
        }

        public QueryFunctions<OffsetDateTime, QuerySelectOperation<QS, QO, QR>> created() {
            return (QueryFunctions) executor.identifier("created");
        }

        public QuerySelectOperation<QS, QO, QR> created(OffsetDateTime created) {
            return (QuerySelectOperation) executor.identifier("created", created);
        }

        public QueryFunctions<String, QuerySelectOperation<QS, QO, QR>> createdBy() {
            return (QueryFunctions) executor.identifier("createdBy");
        }

        public QuerySelectOperation<QS, QO, QR> createdBy(String createdBy) {
            return (QuerySelectOperation) executor.identifier("createdBy", createdBy);
        }

        public QueryFunctions<String, QuerySelectOperation<QS, QO, QR>> description() {
            return (QueryFunctions) executor.identifier("description");
        }

        public QuerySelectOperation<QS, QO, QR> description(String description) {
            return (QuerySelectOperation) executor.identifier("description", description);
        }

        public QueryFunctions<Long, QuerySelectOperation<QS, QO, QR>> id() {
            return (QueryFunctions) executor.identifier("id");
        }

        public QuerySelectOperation<QS, QO, QR> id(Long id) {
            return (QuerySelectOperation) executor.identifier("id", id);
        }

        public QueryFunctions<OffsetDateTime, QuerySelectOperation<QS, QO, QR>> modified() {
            return (QueryFunctions) executor.identifier("modified");
        }

        public QuerySelectOperation<QS, QO, QR> modified(OffsetDateTime modified) {
            return (QuerySelectOperation) executor.identifier("modified", modified);
        }

        public QueryFunctions<String, QuerySelectOperation<QS, QO, QR>> modifiedBy() {
            return (QueryFunctions) executor.identifier("modifiedBy");
        }

        public QuerySelectOperation<QS, QO, QR> modifiedBy(String modifiedBy) {
            return (QuerySelectOperation) executor.identifier("modifiedBy", modifiedBy);
        }

        public QueryFunctions<String, QuerySelectOperation<QS, QO, QR>> name() {
            return (QueryFunctions) executor.identifier("name");
        }

        public QuerySelectOperation<QS, QO, QR> name(String name) {
            return (QuerySelectOperation) executor.identifier("name", name);
        }
    }
}
