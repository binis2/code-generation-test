package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.annotation.type.GenerationStrategy;
import net.binis.codegen.enrich.LogEnricher;
import net.binis.codegen.enrich.constructor.RequiredArgsConstructorEnricher;

@CodePrototype(enrichers = {RequiredArgsConstructorEnricher.class, LogEnricher.class}, strategy = GenerationStrategy.NONE)
public class TestLog {
    private final TestLog test;
    public static void test() {
        log.info("Test");
    }

}