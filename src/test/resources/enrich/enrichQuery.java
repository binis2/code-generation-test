package net.binis.codegen;

import net.binis.codegen.SubPrototype;
import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.enrich.QueryEnricher;

import java.util.List;

@CodePrototype(enrichers = {QueryEnricher.class})
public interface Test2Prototype {
    String title();

    double amount();

    List<Long> items();

    Test2Prototype parent();

    SubPrototype sub();
}