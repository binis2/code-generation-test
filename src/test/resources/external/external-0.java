/*Generated code by Binis' code generator.*/
package net.binis.codegen.test;

import net.binis.codegen.enums.TestEnum;
import javax.annotation.processing.Generated;

@Generated(value = "net.binis.codegen.test.TestPrototype", comments = "Test")
public class TestImpl implements Test {

    protected boolean available;

    protected String external;

    protected TestEnum type;

    public TestImpl() {
    }

    public String getExternal() {
        return external;
    }

    public TestEnum getType() {
        return type;
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

    public void setType(TestEnum type) {
        this.type = type;
    }
}
