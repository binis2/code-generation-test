package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;

import java.util.ArrayList;
import java.util.List;

@CodePrototype(generateImplementation = false, interfaceSetters = false)
public interface RuleablePrototype {

    List<String> rules();

    RuleablePrototype parent();

    default List<String> getRules(Class<?> cls) {
        return rules().stream().map(r -> cls.getCanonicalName() + r).toList();
    }

    default List<String> getRules(String s) {
        var result = new ArrayList<String>();
        result.addAll(rules());
        result.addAll(parent().rules());
        return result;
    }

}
