package net.binis.codegen.modifier.test;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.enrich.ModifierEnricher;
import net.binis.codegen.options.SuppressSpotBugsWarningOption;

@CodePrototype(enrichers = ModifierEnricher.class, options = SuppressSpotBugsWarningOption.class)
public interface SpotBugsPrototype {
    boolean active();

}