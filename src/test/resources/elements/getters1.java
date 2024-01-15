package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.annotation.type.GenerationStrategy;
import net.binis.codegen.enrich.field.GetterEnricher;
import net.binis.codegen.enrich.field.SetterEnricher;

@CodePrototype(strategy = GenerationStrategy.NONE, enrichers = {GetterEnricher.class, SetterEnricher.class})
public class TestElement {

    private Long id;

    private boolean flag;


}