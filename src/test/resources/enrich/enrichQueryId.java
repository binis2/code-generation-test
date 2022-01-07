package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.enrich.QueryEnricher;

@CodePrototype(enrichers = {QueryEnricher.class})
public interface TestPrototype extends BasePrototype {

    String title();
    double amount();

}