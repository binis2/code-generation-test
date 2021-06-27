package net.binis.codegen;

import net.binis.codegen.enrich.handler.QueryEnricher;
import net.binis.codegen.annotation.CodePrototype;
import java.util.List;

@CodePrototype(enrichers = {QueryEnricher.class})
public interface SubPrototype {
    String subtitle();

    double subAmount();
}