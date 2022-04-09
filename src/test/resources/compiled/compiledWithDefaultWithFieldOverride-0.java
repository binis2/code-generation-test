/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import javax.persistence.OneToOne;
import javax.annotation.processing.Generated;

@Generated(value = "TestPrototype", comments = "Test")
public class TestImpl extends CompiledWithImplementationImpl implements Test {

    protected String title;

    @OneToOne(cascade = {})
    protected String type = "asd";

    public TestImpl() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }
}
