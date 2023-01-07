/*Generated code by Binis' code generator.*/
package codegen.map;

import net.binis.codegen.modifier.impl.BaseModifierImpl;
import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.factory.CodeFactory;
import javax.annotation.processing.Generated;

@Generated(value = "TestMap2Prototype", comments = "TestMap2")
public class TestMap2Impl implements TestMap2, Modifiable<TestMap2.Modify> {

    protected Integer int1;

    protected int int2;

    protected long long1;

    protected String string1;

    // region constructor & initializer
    {
        CodeFactory.registerType(TestMap2.class, TestMap2Impl::new, null);
    }

    public TestMap2Impl() {
    }
    // endregion

    // region getters
    public Integer getInt1() {
        return int1;
    }

    public int getInt2() {
        return int2;
    }

    public long getLong1() {
        return long1;
    }

    public String getString1() {
        return string1;
    }

    public TestMap2.Modify with() {
        return new TestMap2ModifyImpl(this);
    }
    // endregion

    // region inner classes
    protected class TestMap2ModifyImpl extends BaseModifierImpl<TestMap2.Modify, TestMap2> implements TestMap2.Modify {

        protected TestMap2ModifyImpl(TestMap2 parent) {
            super(parent);
        }

        public TestMap2 done() {
            return TestMap2Impl.this;
        }

        public TestMap2.Modify int1(Integer int1) {
            TestMap2Impl.this.int1 = int1;
            return this;
        }

        public TestMap2.Modify int2(int int2) {
            TestMap2Impl.this.int2 = int2;
            return this;
        }

        public TestMap2.Modify long1(long long1) {
            TestMap2Impl.this.long1 = long1;
            return this;
        }

        public TestMap2.Modify string1(String string1) {
            TestMap2Impl.this.string1 = string1;
            return this;
        }
    }
    // endregion
}
