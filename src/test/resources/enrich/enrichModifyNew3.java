package net.binis.codegen.modifier.test;

import net.binis.codegen.annotation.builder.CodeBuilder;
import net.binis.codegen.impl.AccountEntity;
import net.binis.codegen.intf.Account;
import net.binis.codegen.intf.Taggable;

import java.time.OffsetDateTime;

@CodeBuilder(mixInClass = TransactionEntityPrototype.class)
public interface SubTransactionEntityPrototype extends TransactionEntityPrototype, Taggable {
    TransactionEntityPrototype parent();
}