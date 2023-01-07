/*Generated code by Binis' code generator.*/
package codegen.map;

import net.binis.codegen.modifier.BaseModifier;
import net.binis.codegen.creator.EntityCreatorModifier;
import net.binis.codegen.annotation.Default;
import javax.annotation.processing.Generated;

@Generated(value = "TestMap2Prototype", comments = "TestMap2Impl")
@Default("codegen.map.TestMap2Impl")
public interface TestMap2 {

    // region starters
    @SuppressWarnings(value = "unchecked")
    static TestMap2.Modify create() {
        return (TestMap2.Modify) EntityCreatorModifier.create(TestMap2.class).with();
    }
    // endregion

    Integer getInt1();
    int getInt2();
    long getLong1();
    String getString1();

    TestMap2.Modify with();

    // region inner classes
    interface Fields<T> {
        T int1(Integer int1);
        T int2(int int2);
        T long1(long long1);
        T string1(String string1);
    }

    interface Modify extends TestMap2.Fields<TestMap2.Modify>, BaseModifier<TestMap2.Modify, TestMap2> {
    }
    // endregion
}
