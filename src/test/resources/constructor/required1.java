package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.annotation.type.GenerationStrategy;
import net.binis.codegen.enrich.constructor.RequiredArgsConstructorEnricher;

@CodePrototype(enrichers = RequiredArgsConstructorEnricher.class, strategy = GenerationStrategy.NONE)
public class TestRequired {
    private final Long test;

}