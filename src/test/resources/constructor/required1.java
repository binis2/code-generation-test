package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.annotation.type.GenerationStrategy;
import net.binis.codegen.enrich.constructor.RequiredArgsConstructorEnricher;
import net.binis.codegen.mock.CodeGenMatcher;

@CodePrototype(enrichers = RequiredArgsConstructorEnricher.class, strategy = GenerationStrategy.NONE)
public class TestRequired {
    private final Long test;

    private final int testPrimitive;

    private final CodeGenMatcher testObject;

    private final GenerationStrategy testEnum;

    private final Class testClass;

}