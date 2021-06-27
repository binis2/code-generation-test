package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.enrich.handler.ModifierEnricher;
import net.binis.codegen.enums.TestEnum;
import net.binis.codegen.intf.ExternalInterface;
import net.binis.codegen.intf.Available;
import net.binis.codegen.intf.Typeable;

@CodePrototype
public interface TestPrototype extends ExternalInterface<String>, Available, Typeable<TestEnum> {
}