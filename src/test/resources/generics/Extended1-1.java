/*Generated code by Binis' code generator.*/
package net.binis.codegen.test;

import net.binis.codegen.intf.Payload;
import javax.annotation.processing.Generated;

@Generated(value = "net.binis.codegen.test.GenericPrototype", comments = "GenericImpl")
public interface Generic<T extends Payload> {
    T getPayload();

    void setPayload(T payload);
}
