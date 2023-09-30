package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.annotation.type.GenerationStrategy;
import net.binis.codegen.enrich.constructor.AllArgsConstructorEnricher;
import net.binis.codegen.enrich.constructor.NoArgsConstructorEnricher;

@CodePrototype(strategy = GenerationStrategy.NONE, enrichers = AllArgsConstructorEnricher.class)
public class TestWithNested {

    @CodePrototype(strategy = GenerationStrategy.NONE, enrichers = AllArgsConstructorEnricher.class)
    protected static class BaseClass {

        protected final String field;
    }

}
