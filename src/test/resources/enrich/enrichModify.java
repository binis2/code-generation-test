package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.enrich.handler.ModifierEnricher;

import java.util.List;
import java.util.Set;

@CodePrototype(enrichers = {ModifierEnricher.class})
public interface TestModifyPrototype {
    String title();
    double amount();
    List<Long> items();

    Set<SubModifyPrototype> subs();
}