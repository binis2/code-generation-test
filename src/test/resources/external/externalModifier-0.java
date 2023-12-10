/*Generated code by Binis' code generator.*/
package net.binis.codegen.test;

import net.binis.codegen.modifier.impl.BaseModifierImpl;
import net.binis.codegen.modifier.Modifiable;
import javax.annotation.processing.Generated;

@Generated(value = "net.binis.codegen.test.TestPrototype", comments = "Test")
public class TestImpl implements Test, Modifiable<Test.Modify> {

    protected boolean available;

    protected String external;

    protected String key;

    public TestImpl() {
    }

    public String getExternal() {
        return external;
    }

    public String getKey() {
        return key;
    }

    public String getPreview() {
        return "preview";
    }

    public String getTest() {
        return isAvailable() ? "test" : getPreview();
    }

    public String getTest2() {
        return isAvailable() ? getPreview() : getKey();
    }

    public String getTest3() {
        return isAvailable() ? getKey() : getPreview();
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setExternal(String external) {
        this.external = external;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Test.Modify with() {
        return new TestModifyImpl(this);
    }

    @Generated("ModifierEnricher")
    protected class TestModifyImpl extends BaseModifierImpl<Test.Modify, Test> implements Test.Modify {

        protected TestModifyImpl(Test parent) {
            super(parent);
        }

        public Test.Modify available(boolean available) {
            TestImpl.this.available = available;
            return this;
        }

        public Test done() {
            return TestImpl.this;
        }

        public Test.Modify external(String external) {
            TestImpl.this.external = external;
            return this;
        }

        public Test.Modify key(String key) {
            TestImpl.this.key = key;
            return this;
        }
    }
}
