/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.intf.Typeable;
import net.binis.codegen.enums.TestEnum;
import javax.annotation.processing.Generated;
import java.time.OffsetDateTime;

@Generated(value = "BasePrototype", comments = "BaseImpl")
public interface Base extends Typeable<TestEnum> {
    OffsetDateTime getDate();
    Long getId();

    void setDate(OffsetDateTime date);
    void setId(Long id);

    interface Fields<T> {
        T date(OffsetDateTime date);
        T id(Long id);
        T type(TestEnum type);
    }
}
