package net.binis.codegen.prototype;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.enrich.ModifierEnricher;
import net.binis.codegen.intf.Prototypable;
import net.binis.codegen.prototype.base.ExtendedPrototype;

import java.util.List;
import java.util.Set;

@CodePrototype(enrichers = {ModifierEnricher.class})
public interface TestModifyPrototype extends Prototypable<SubModifyPrototype>, ExtendedPrototype {
    String title();
    double amount();
    List<Long> items();

    Set<SubModifyPrototype> subs();
}