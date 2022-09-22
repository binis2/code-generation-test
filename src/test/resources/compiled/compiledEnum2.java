package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.annotation.EnumPrototype;
import net.binis.codegen.test.prototype.CompiledEnumPrototype;
import net.binis.codegen.test.prototype.base.CompiledBasePrototype;

@EnumPrototype(mixIn = CompiledEnumPrototype.class, ordinalOffset = 100)
public enum ExtendedCompiledEnumPrototype {

    EXTENDED("extended");

    ExtendedCompiledEnumPrototype(String value) {
        //Do nothing
    }

}