package net.binis.codegen.modifier.test;

import net.binis.codegen.annotation.builder.CodeBuilder;

import java.util.List;

@CodeBuilder
public interface AccountEntityPrototype extends BasePrototype {
    String accountNumber();
    double available();
    double balance();
    double pending();
    List<TransactionEntityPrototype> transactions();
    List<String> strings();
    boolean active();
}