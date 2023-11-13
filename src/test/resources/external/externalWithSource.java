package net.binis.codegen.test;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.enrich.QueryEnricher;
import net.binis.codegen.prototype.TestExternalPrototype;

@CodePrototype(enrichers = QueryEnricher.class)
public interface TestPrototype {

    TestExternalPrototype test();

}