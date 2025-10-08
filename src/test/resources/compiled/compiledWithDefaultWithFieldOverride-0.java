/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import javax.annotation.processing.Generated;
import jakarta.persistence.OneToOne;

@Generated(value = "net.binis.codegen.TestPrototype", comments = "Test")
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

    public void setTitle(String title) {
        this.title = title;
    }
}
