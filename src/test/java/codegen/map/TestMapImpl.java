/*Generated code by Binis' code generator.*/
package codegen.map;

import net.binis.codegen.modifier.impl.BaseModifierImpl;
import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.factory.CodeFactory;
import javax.annotation.processing.Generated;

@Generated(value = "TestMapPrototype", comments = "TestMap")
public class TestMapImpl implements TestMap, Modifiable<TestMap.Modify> {

    protected int int1;

    protected Integer int2;

    protected Long long1;

    protected String string1;

    protected boolean convert1;

    // region constructor & initializer
    {
        CodeFactory.registerType(TestMap.class, TestMapImpl::new, null);
    }

    public TestMapImpl() {
    }
    // endregion

    // region getters
    public int getInt1() {
        return int1;
    }

    public Integer getInt2() {
        return int2;
    }

    public Long getLong1() {
        return long1;
    }

    public String getString1() {
        return string1;
    }

    @Override
    public boolean isConvert1() {
        return convert1;
    }

    public TestMap.Modify with() {
        return new TestMapModifyImpl(this);
    }
    // endregion

    // region inner classes
    protected class TestMapModifyImpl extends BaseModifierImpl<TestMap.Modify, TestMap> implements TestMap.Modify {

        protected TestMapModifyImpl(TestMap parent) {
            super(parent);
        }

        public TestMap done() {
            return TestMapImpl.this;
        }

        public TestMap.Modify int1(int int1) {
            TestMapImpl.this.int1 = int1;
            return this;
        }

        public TestMap.Modify int2(Integer int2) {
            TestMapImpl.this.int2 = int2;
            return this;
        }

        public TestMap.Modify long1(Long long1) {
            TestMapImpl.this.long1 = long1;
            return this;
        }

        public TestMap.Modify string1(String string1) {
            TestMapImpl.this.string1 = string1;
            return this;
        }

        @Override
        public Modify convert1(boolean convert1) {
            TestMapImpl.this.convert1 = convert1;
            return this;
        }
    }
    // endregion
}
