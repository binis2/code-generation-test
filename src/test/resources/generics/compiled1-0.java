/*Generated code by Binis' code generator.*/
package net.binis.codegen.test.generics;

import javax.annotation.processing.Generated;

@Generated(value = "net.binis.codegen.test.generics.GenericsTestPrototype", comments = "GenericsTest")
public class GenericsTestImpl implements GenericsTest {

    protected Object test;

    public GenericsTestImpl() {
    }

    public <T> T generic() {
        return (T) getTest();
    }

    public Object getTest() {
        return test;
    }

    public Object nonGeneric() {
        return getTest();
    }

    public void setTest(Object test) {
        this.test = test;
    }
}
