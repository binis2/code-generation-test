package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.enrich.handler.ModifierEnricher;
import net.binis.codegen.enrich.handler.QueryEnricher;
import net.binis.codegen.enums.TestEnum;
import net.binis.codegen.intf.Typeable;

import java.time.OffsetDateTime;

@CodePrototype(base = true, enrichers = {ModifierEnricher.class}, inheritedEnrichers = {ModifierEnricher.class, QueryEnricher.class})
public interface BasePrototype extends Typeable<TestEnum> {
    Long id();

    OffsetDateTime date();
}