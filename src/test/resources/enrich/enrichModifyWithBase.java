package net.binis.codegen;

import net.binis.codegen.annotation.CodeConstant;
import net.binis.codegen.annotation.CodePrototype;

import java.util.List;
import java.util.Set;

@CodePrototype
public interface TestModifyPrototype extends BasePrototype {

    @CodeConstant(isPublic = false)
    long serialVersionUID = -3805679893678082393L;

    String CONST = "const";

    String title();
    double amount();
    List<Long> items();

    Set<SubModifyPrototype> subs();
}