package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.enrich.ModifierEnricher;
import net.binis.codegen.enrich.QueryEnricher;

@CodePrototype(enrichers = {QueryEnricher.class, ModifierEnricher.class})
public interface SubPrototype {
    String subtitle();

    double subAmount();
}