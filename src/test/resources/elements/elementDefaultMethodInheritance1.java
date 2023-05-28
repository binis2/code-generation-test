package net.binis.codegen.prototype;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.annotation.Default;

@CodePrototype
public interface CompiledWithImplementationPrototype {

    @Default("true")
    boolean test();

    default boolean isTestable() {
        return !test();
    }

    default boolean isSame(boolean bool) {
        return bool == test();
    }

    default boolean isSame(CompiledWithImplementationPrototype other) {
        return other.test() == test();
    }

}
