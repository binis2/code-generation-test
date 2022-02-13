package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.annotation.Embeddable;
import net.binis.codegen.enrich.ModifierEnricher;
import net.binis.codegen.intf.Prototypable;

import java.util.List;
import java.util.Set;

@CodePrototype(enrichers = {ModifierEnricher.class})
@Embeddable
public interface TestModifyPrototype {
    String title();
    double amount();
    List<Long> items();
}