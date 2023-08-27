package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.annotation.type.GenerationStrategy;
import net.binis.codegen.enrich.InjectionEnricher;

@CodePrototype(enrichers = InjectionEnricher.class, strategy = GenerationStrategy.NONE)
public class TestInjection {
    private final Long test;

}