/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.annotation.CodeAnnotation;
import javax.annotation.processing.Generated;

@Generated(value = "net.binis.codegen.TestPrototype", comments = "Test")
public class TestImpl extends CompiledWithImplementationImpl implements Test {

    protected String title;

    public TestImpl() {
        super();
        this.type = "asd";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
