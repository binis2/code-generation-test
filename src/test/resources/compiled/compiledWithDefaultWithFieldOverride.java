package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.annotation.Default;
import net.binis.codegen.prototype.CompiledWithImplementationPrototype;

@CodePrototype
public interface TestPrototype extends CompiledWithImplementationPrototype {

    @Default("\"asd\"")
    String type();

    String title();

}