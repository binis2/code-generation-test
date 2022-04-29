/*Generated code by Binis' code generator.*/
package net.binis.codegen.impl;

import lombok.ToString;
import net.binis.codegen.intf.BaseInterface;
import org.springframework.data.annotation.LastModifiedBy;

import javax.annotation.processing.Generated;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.OffsetDateTime;

@Generated(value = "BaseEntityPrototype", comments = "BaseInterface")
@MappedSuperclass
@Access(AccessType.FIELD)
public class BaseEntity implements BaseInterface {

    private static final long serialVersionUID = 2715722432365286225L;

    protected OffsetDateTime created;

    protected String createdBy;

    @Id
    @ToString.Include
    protected Long id;

    protected OffsetDateTime modified;

    protected String modifiedBy;

    public BaseEntity() {
    }

    public <T> T as(Class<T> cls) {
        return cls.cast(this);
    }

    public OffsetDateTime getCreated() {
        return created;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Long getId() {
        return id;
    }

    public OffsetDateTime getModified() {
        return modified;
    }

    @LastModifiedBy
    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setCreated(OffsetDateTime created) {
        this.created = created;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setModified(OffsetDateTime modified) {
        this.modified = modified;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
