package net.binis.codegen.intf;

import javax.annotation.processing.Generated;
import java.time.OffsetDateTime;
import java.io.Serializable;

@Generated(value = "BaseEntityPrototype", comments = "BaseEntity")
public interface BaseInterface extends Serializable, Identifiable {
    <T> T as(Class<T> cls);

    OffsetDateTime getCreated();
    OffsetDateTime getModified();

    interface Fields<T> {
        T id(Long id);
        T modified(OffsetDateTime modified);
    }
}
