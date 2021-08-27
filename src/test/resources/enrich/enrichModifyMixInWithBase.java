package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;

import java.util.List;
import java.util.Set;

@CodePrototype(mixInClass = TestModifyPrototype.class)
public interface MixModifyPrototype extends TestModifyPrototype {
    String mixInTitle();
    double mixInAmount();
    List<Long> mixInItems();

    Set<SubModifyPrototype> mixInSubs();
}