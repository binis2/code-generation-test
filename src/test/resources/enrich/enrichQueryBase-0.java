/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import javax.annotation.processing.Generated;
import jakarta.persistence.Id;

@Generated(value = "net.binis.codegen.BasePrototype", comments = "Base")
public class BaseImpl implements Base {

    @Id
    protected String id;

    public BaseImpl() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
