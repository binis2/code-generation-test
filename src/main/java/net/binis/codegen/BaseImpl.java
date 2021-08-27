/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.enums.TestEnum;
import javax.annotation.processing.Generated;
import java.time.OffsetDateTime;

@Generated(value = "BasePrototype", comments = "Base")
public class BaseImpl implements Base {

    protected OffsetDateTime date;

    protected Long id;

    protected TestEnum type;

    public BaseImpl() {
    }

    public OffsetDateTime getDate() {
        return date;
    }

    public Long getId() {
        return id;
    }

    public TestEnum getType() {
        return type;
    }

    public void setDate(OffsetDateTime date) {
        this.date = date;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
