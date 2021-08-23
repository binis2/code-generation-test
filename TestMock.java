/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.creator.EntityCreatorModifier;
import javax.annotation.processing.Generated;
import java.util.function.Function;

@Generated(value = "TestMockEntityPrototype", comments = "TestMockEntity")
public interface TestMock {

    static TestMock.Modify create() {
        return (TestMock.Modify) EntityCreatorModifier.create(TestMock.class).with();
    }

    String getActionLink();

    String getButtonText();

    String getCode();

    String getDescription();

    String getName();

    void setActionLink(String actionLink);

    void setButtonText(String buttonText);

    void setCode(String code);

    void setDescription(String description);

    void setName(String name);

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
}
