/*Generated code by Binis' code generator.*/
package codegen.map;

import net.binis.codegen.modifier.BaseModifier;
import net.binis.codegen.creator.EntityCreatorModifier;
import net.binis.codegen.annotation.Default;
import javax.annotation.processing.Generated;

@Generated(value = "TestMapPrototype", comments = "TestMapImpl")
@Default("codegen.map.TestMapImpl")
public interface TestMap {

    // region starters
    @SuppressWarnings(value = "unchecked")
    static TestMap.Modify create() {
        return (TestMap.Modify) EntityCreatorModifier.create(TestMap.class).with();
    }
    // endregion

    int getInt1();
    Integer getInt2();
    Long getLong1();
    String getString1();

    boolean isConvert1();

    TestMap.Modify with();

    // region inner classes
    interface Fields<T> {
        T int1(int int1);
        T int2(Integer int2);
        T long1(Long long1);
        T string1(String string1);
        T convert1(boolean convert1);
    }

    interface Modify extends TestMap.Fields<TestMap.Modify>, BaseModifier<TestMap.Modify, TestMap> {
    }
    // endregion
}
