package net.binis.codegen.prototype;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.enrich.handler.CreatorModifierEnricher;
import net.binis.codegen.enrich.handler.ModifierEnricher;
import net.binis.codegen.spring.BaseEntityModifier;

@CodePrototype(
        baseModifierClass = BaseEntityModifier.class,
        enrichers = {ModifierEnricher.class, CreatorModifierEnricher.class})
public interface TestMockEntityPrototype {

    String code();
    String name();
    String description();
    String buttonText();
    String actionLink();

}
