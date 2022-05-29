package net.binis.codegen.modifier.test;

import net.binis.codegen.annotation.builder.CodeBuilder;
import net.binis.codegen.intf.Taggable;

@CodeBuilder(mixInClass = TransactionEntityPrototype.class)
public interface SubTransactionEntityPrototype extends TransactionEntityPrototype, Taggable {
    TransactionEntityPrototype parent();
}