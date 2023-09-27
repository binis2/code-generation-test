package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.annotation.type.GenerationStrategy;
import net.binis.codegen.enrich.LogEnricher;

@CodePrototype(strategy = GenerationStrategy.NONE, enrichers = LogEnricher.class)
public class Log2 {
}