/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.modifier.Modifiable;

public class TestImpl implements Test, Modifiable<Test.Modify> {

    protected boolean available;

    protected String external;

    public TestImpl() {
    }

    public String getExternal() {
        return external;
    }

    public String getPreview() {
        return "preview";
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Test.Modify with() {
        return new TestModifyImpl();
    }

    protected class TestModifyImpl implements Test.Modify {

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
    }
}
