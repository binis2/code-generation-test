/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import javax.annotation.processing.Generated;

@Generated(value = "net.binis.codegen.TestPrototype", comments = "TestImpl")
public interface Test extends CompiledWithImplementation {
    String getTitle();
    String getType();

    void setTitle(String title);
    void setType(String type);
}
