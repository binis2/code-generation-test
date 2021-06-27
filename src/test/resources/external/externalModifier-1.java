/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.intf.Previewable;
import net.binis.codegen.intf.ExternalInterface;
import net.binis.codegen.intf.Available;

public interface Test extends ExternalInterface<String>, Available, Previewable {

    Test.Modify with();

    interface Fields<T> {

        T available(boolean available);

        T external(String external);
    }

    interface Modify extends Test.Fields<Test.Modify> {

        Test done();
    }
}
