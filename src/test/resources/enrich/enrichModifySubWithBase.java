package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.intf.Identifiable;
import net.binis.codegen.intf.Taggable;

import javax.persistence.Transient;

@CodePrototype
public interface SubModifyPrototype extends BasePrototype, Taggable, Identifiable {
    String subtitle();
    double subAmount();

    SubModifyPrototype parent();

    @Transient
    <T> T tag();
}