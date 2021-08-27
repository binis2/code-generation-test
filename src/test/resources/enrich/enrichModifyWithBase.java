package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;

import java.util.List;
import java.util.Set;

@CodePrototype
public interface TestModifyPrototype extends BasePrototype {
    String title();
    double amount();
    List<Long> items();

    Set<SubModifyPrototype> subs();
}