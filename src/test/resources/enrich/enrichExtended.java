package net.binis.codegen.prototype.base;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.prototype.SubModifyPrototype;

@CodePrototype(generateImplementation = false, interfaceSetters = false)
public interface ExtendedPrototype {
    SubModifyPrototype extended();
}