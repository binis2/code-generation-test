package net.binis.codegen;

import net.binis.codegen.enrich.handler.ModifierEnricher;
import net.binis.codegen.annotation.CodePrototype;
import java.util.List;

@CodePrototype(enrichers = {ModifierEnricher.class})
public interface SubModifyPrototype {
    String subtitle();
    double subAmount();
}