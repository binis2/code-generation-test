package net.binis.codegen;

import net.binis.codegen.enrich.handler.ModifierEnricher;
import net.binis.codegen.annotation.CodePrototype;

import javax.persistence.Transient;
import java.util.List;

import net.binis.codegen.intf.Taggable;

@CodePrototype
public interface SubModifyPrototype extends BasePrototype, Taggable {
    String subtitle();
    double subAmount();

    @Transient
    <T> T tag();
}