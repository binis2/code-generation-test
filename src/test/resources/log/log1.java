package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.annotation.type.GenerationStrategy;
import net.binis.codegen.enrich.LogEnricher;
@CodePrototype(enrichers = LogEnricher.class, strategy = GenerationStrategy.NONE)
public class TestLog {
    public static void test() {
        log.info("Test");
    }

}