package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.annotation.type.GenerationStrategy;
import net.binis.codegen.enrich.constructor.AllArgsConstructorEnricher;

@CodePrototype(enrichers = AllArgsConstructorEnricher.class, strategy = GenerationStrategy.NONE)
public class TestAll {
    private final Long testFinal;

    private Long testNotFinal;

    private Long testInitialized = 2L;

}