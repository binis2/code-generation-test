/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import javax.annotation.processing.Generated;

@Generated(value = "net.binis.codegen.TestPrototype", comments = "Test")
public class TestImpl implements Test {

    protected boolean test = true;

    protected String title;

    public TestImpl() {
    }

    public String getTitle() {
        return title;
    }

    public boolean isTest() {
        return test;
    }

    public boolean isTestable() {
        return this.test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
