package codegen.deep;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.annotation.CodePrototypeTemplate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@CodePrototypeTemplate
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.PARAMETER})
@CodePrototype(enrichers = DeepEnricher.class)
public @interface Custom2 {

}
