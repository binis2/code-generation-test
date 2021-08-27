package net.binis.codegen;

import net.binis.codegen.SubPrototype;
import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.enrich.ModifierEnricher;
import net.binis.codegen.enrich.QueryEnricher;

import java.util.List;

@CodePrototype(enrichers = {QueryEnricher.class, ModifierEnricher.class})
public interface TestPrototype {
    String title();

    double amount();

    List<Long> items();

    TestPrototype parent();

    SubPrototype sub();
}