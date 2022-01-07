/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import javax.persistence.Id;
import javax.annotation.processing.Generated;

@Generated(value = "BasePrototype", comments = "Base")
public class BaseImpl implements Base {

    @Id
    protected String id;

    public BaseImpl() {
    }

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
