package net.binis.codegen;

import net.binis.codegen.annotation.builder.CodeBuilder;
import net.binis.codegen.spring.BaseEntityModifier;

import java.util.List;

@CodeBuilder(baseModifierClass = BaseEntityModifier.class)
public interface AccountEntityPrototype extends BasePrototype {
    String accountNumber();
    double available();
    double balance();
    double pending();
    List<TransactionEntityPrototype> transactions();
    List<String> strings();
    boolean active();
}