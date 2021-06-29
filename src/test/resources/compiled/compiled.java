package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.test.prototype.base.CompiledBasePrototype;

@CodePrototype
public interface TestPrototype extends CompiledBasePrototype {

    String title();

}