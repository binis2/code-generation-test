package net.binis.codegen.modifier.test;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.enrich.CreatorModifierEnricher;
import net.binis.codegen.enrich.ModifierEnricher;
import net.binis.codegen.enrich.QueryEnricher;
import net.binis.codegen.enrich.RegionEnricher;
import net.binis.codegen.enums.TestEnum;
import net.binis.codegen.intf.Typeable;

import java.time.OffsetDateTime;

@CodePrototype(base = true, enrichers = {ModifierEnricher.class}, inheritedEnrichers = {ModifierEnricher.class, CreatorModifierEnricher.class, RegionEnricher.class, QueryEnricher.class})
public interface BasePrototype extends Typeable<TestEnum> {
    Long id();

    OffsetDateTime date();
}