package net.binis.codegen.modifier.test;

import net.binis.codegen.annotation.builder.CodeBuilder;
import net.binis.codegen.intf.Taggable;

@CodeBuilder
public interface TransactionDetailEntityPrototype extends BasePrototype, Taggable {
    SubTransactionEntityPrototype parented();
}