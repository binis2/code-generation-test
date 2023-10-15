package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.annotation.type.GenerationStrategy;
import net.binis.codegen.enrich.LogEnricher;
import net.binis.codegen.enrich.constructor.RequiredArgsConstructorEnricher;
import codegen.annotation.Log;

@CodePrototype(strategy = GenerationStrategy.NONE, enrichers = RequiredArgsConstructorEnricher.class)
@Log
public class TestElement {

    private final String test;

}