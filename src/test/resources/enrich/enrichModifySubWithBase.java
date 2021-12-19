package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.intf.Taggable;

import javax.persistence.Transient;

@CodePrototype
public interface SubModifyPrototype extends BasePrototype, Taggable {
    String subtitle();
    double subAmount();

    @Transient
    <T> T tag();
}