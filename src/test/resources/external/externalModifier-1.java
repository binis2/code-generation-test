/*Generated code by Binis' code generator.*/
package net.binis.codegen.test;

import net.binis.codegen.intf.Previewable;
import net.binis.codegen.intf.ExternalInterface;
import net.binis.codegen.intf.Available;
import javax.annotation.processing.Generated;

@Generated(value = "TestPrototype", comments = "TestImpl")
public interface Test extends ExternalInterface<String>, Available, Previewable {
    String getKey();
    String getTest();
    String getTest2();
    String getTest3();

    void setKey(String key);

    Test.Modify with();

    interface Fields<T> {
        T available(boolean available);
        T external(String external);
        T key(String key);
    }

    interface Modify extends Test.Fields<Test.Modify> {
        Test done();
    }
}
