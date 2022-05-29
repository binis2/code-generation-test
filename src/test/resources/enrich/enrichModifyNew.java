package net.binis.codegen.modifier.test;

import codegen.modifier.TestModifier;
import net.binis.codegen.annotation.builder.CodeBuilder;

import java.util.List;

@CodeBuilder(baseModifierClass = TestModifier.class)
public interface AccountEntityPrototype extends BasePrototype {
    String accountNumber();
    double available();
    double balance();
    double pending();
    List<TransactionEntityPrototype> transactions();
    List<String> strings();
    boolean active();
}