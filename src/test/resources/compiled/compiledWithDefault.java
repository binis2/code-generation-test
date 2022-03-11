package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.prototype.CompiledPrototype;

@CodePrototype
public interface TestPrototype extends CompiledPrototype {

    String title();

    default boolean isTestable() {
        return test();
    }

}