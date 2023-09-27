package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.annotation.type.GenerationStrategy;
import net.binis.codegen.enrich.constructor.NotInitializedArgsConstructorEnricher;

@CodePrototype(enrichers = NotInitializedArgsConstructorEnricher.class, strategy = GenerationStrategy.NONE)
public class TestNotInitialized {
    private final Long testFinal;

    private Long testNotFinal;

    private Long testInitialized = 2L;

}