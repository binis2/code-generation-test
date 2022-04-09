package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.annotation.Default;
import net.binis.codegen.annotation.Initialize;
import net.binis.codegen.prototype.CompiledWithImplementationPrototype;

@CodePrototype
@Initialize(field = "type", expression = "\"asd\"", imports = {"net.binis.codegen.annotation.CodeAnnotation"})
public interface TestPrototype extends CompiledWithImplementationPrototype {

    String title();

}