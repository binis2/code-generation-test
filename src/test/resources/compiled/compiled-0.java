/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.test.base.CompiledBaseImpl;
import javax.annotation.processing.Generated;

@Generated(value = "TestPrototype", comments = "Test")
public class TestImpl extends CompiledBaseImpl implements Test {

    protected String title;

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
