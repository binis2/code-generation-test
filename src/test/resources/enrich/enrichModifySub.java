package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.enrich.ModifierEnricher;
import net.binis.codegen.intf.Prototypable;

@CodePrototype(enrichers = {ModifierEnricher.class})
public interface SubModifyPrototype extends Prototypable<SubModifyPrototype> {
    String subtitle();
    double subAmount();
}