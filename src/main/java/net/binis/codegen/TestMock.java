/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.creator.EntityCreator;
import net.binis.codegen.creator.EntityCreatorModifier;
import net.binis.codegen.spring.query.*;

import java.time.OffsetDateTime;
import java.util.function.Function;

public interface TestMock {

    static TestMock.Modify create() {
        return (TestMock.Modify) EntityCreatorModifier.create(TestMock.class).with();
    }

    static QueryStarter<TestMock, TestMock.QuerySelect<TestMock>> find() {
        return (QueryStarter) EntityCreator.create(TestMock.QuerySelect.class);
    }

    String getActionLink();

    String getButtonText();

    String getCode();

    String getDescription();

    String getName();

    TestMock.Modify with();

    interface Fields<T> {

        T actionLink(String actionLink);

        T buttonText(String buttonText);

        T code(String code);

        T description(String description);

        T name(String name);
    }

    interface Modify extends TestMock.Fields<TestMock.Modify> {

        TestMock delete();

        TestMock done();

        TestMock merge();

        TestMock refresh();

        TestMock save();

        TestMock saveAndFlush();

        TestMock transaction(Function<TestMock.Modify, TestMock> function);
    }

    interface QueryFields<QR> extends QueryScript<QR>, TestMock.Fields<QR> {

        QR created(OffsetDateTime created);

        QR createdBy(String createdBy);

        QR modifiedBy(String modifiedBy);
    }

    interface QueryFuncs<QR> {

        QueryFunctions<String, QR> actionLink();

        QueryFunctions<String, QR> buttonText();

        QueryFunctions<String, QR> code();

        QueryFunctions<OffsetDateTime, QR> created();

        QueryFunctions<String, QR> createdBy();

        QueryFunctions<String, QR> description();

        QueryFunctions<Long, QR> id();

        QueryFunctions<OffsetDateTime, QR> modified();

        QueryFunctions<String, QR> modifiedBy();

        QueryFunctions<String, QR> name();
    }

    interface QueryName<QS, QO, QR> extends TestMock.QueryFields<QuerySelectOperation<QS, QO, QR>>, TestMock.QueryFuncs<QuerySelectOperation<QS, QO, QR>> {

    }

    interface QueryOrder<QR> extends QueryExecute<QR>, QueryScript<QueryOrderOperation<TestMock.QueryOrder<QR>, QR>> {

        QueryOrderOperation<TestMock.QueryOrder<QR>, QR> actionLink();

        QueryOrderOperation<TestMock.QueryOrder<QR>, QR> buttonText();

        QueryOrderOperation<TestMock.QueryOrder<QR>, QR> code();

        QueryOrderOperation<TestMock.QueryOrder<QR>, QR> created();

        QueryOrderOperation<TestMock.QueryOrder<QR>, QR> createdBy();

        QueryOrderOperation<TestMock.QueryOrder<QR>, QR> description();

        QueryOrderOperation<TestMock.QueryOrder<QR>, QR> id();

        QueryOrderOperation<TestMock.QueryOrder<QR>, QR> modified();

        QueryOrderOperation<TestMock.QueryOrder<QR>, QR> modifiedBy();

        QueryOrderOperation<TestMock.QueryOrder<QR>, QR> name();
    }

    interface QuerySelect<QR> extends QueryExecute<QR>, QueryModifiers<TestMock.QueryName<TestMock.QuerySelect<QR>, TestMock.QueryOrder<QR>, QR>>, TestMock.QueryFields<QuerySelectOperation<TestMock.QuerySelect<QR>, TestMock.QueryOrder<QR>, QR>>, TestMock.QueryFuncs<QuerySelectOperation<TestMock.QuerySelect<QR>, TestMock.QueryOrder<QR>, QR>> {

        TestMock.QueryOrder<QR> order();
    }
}
