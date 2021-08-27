package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.enrich.CreatorEnricher;
import net.binis.codegen.enrich.ModifierEnricher;
import net.binis.codegen.enrich.QueryEnricher;
import net.binis.codegen.enums.TestEnum;
import net.binis.codegen.intf.Typeable;

import java.time.OffsetDateTime;

@CodePrototype(base = true, enrichers = {ModifierEnricher.class}, inheritedEnrichers = {ModifierEnricher.class, QueryEnricher.class, CreatorEnricher.class})
public interface BasePrototype extends Typeable<TestEnum> {
    Long id();

    OffsetDateTime date();
}