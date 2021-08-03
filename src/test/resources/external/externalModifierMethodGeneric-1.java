/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.intf.*;

public interface Test extends ExternalInterface<String>, Available, Previewable, Taggable {

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
