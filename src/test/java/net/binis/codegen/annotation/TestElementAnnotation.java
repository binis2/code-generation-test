package net.binis.codegen.annotation;

import net.binis.codegen.annotation.type.GenerationStrategy;
import net.binis.codegen.enrich.TestElementEnricher;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
@CodePrototype(strategy = GenerationStrategy.NONE, enrichers = TestElementEnricher.class)
public @interface TestElementAnnotation {
}
