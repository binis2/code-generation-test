/*Generated code by Binis' code generator.*/
package net.binis.codegen.test;

import net.binis.codegen.intf.*;
import javax.annotation.processing.Generated;

@Generated(value = "TestPrototype", comments = "TestImpl")
public interface Test extends ExternalInterface<String>, Available, Previewable, Taggable {
    <T> void setTag(T tag);

    Test.Modify with();

    interface Fields<T> {
        T available(boolean available);
        T external(String external);
        T tag(Object tag);
    }

    interface Modify extends Test.Fields<Test.Modify> {
        Test done();
    }
}
