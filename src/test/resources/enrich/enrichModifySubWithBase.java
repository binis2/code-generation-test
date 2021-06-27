package net.binis.codegen;

import net.binis.codegen.enrich.handler.ModifierEnricher;
import net.binis.codegen.annotation.CodePrototype;
import java.util.List;

@CodePrototype
public interface SubModifyPrototype extends BasePrototype {
    String subtitle();
    double subAmount();
}