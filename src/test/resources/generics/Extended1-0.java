/*Generated code by Binis' code generator.*/
package net.binis.codegen.test;

import net.binis.codegen.intf.Payload;
import javax.annotation.processing.Generated;

@Generated(value = "net.binis.codegen.test.GenericPrototype", comments = "Generic")
public class GenericImpl<T extends Payload> implements Generic<T> {

    protected T payload;

    public GenericImpl() {
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}
