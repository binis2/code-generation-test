package net.binis.codegen.prototype.base;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.enrich.handler.ModifierEnricher;
import net.binis.codegen.intf.Prototypable;
import net.binis.codegen.prototype.SubModifyPrototype;

@CodePrototype(generateImplementation = false, interfaceSetters = false)
public interface ExtendedPrototype {
    SubModifyPrototype extended();
}