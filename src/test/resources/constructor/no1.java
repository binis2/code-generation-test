package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.annotation.type.GenerationStrategy;
import net.binis.codegen.enrich.constructor.NoArgsConstructorEnricher;

@CodePrototype(enrichers = NoArgsConstructorEnricher.class, strategy = GenerationStrategy.NONE)
public class TestNo {
    private Long test = 1L;

}