package net.binis.codegen.modifier.test;

import net.binis.codegen.annotation.builder.CodeBuilder;
import net.binis.codegen.impl.AccountEntity;
import net.binis.codegen.intf.Account;
import net.binis.codegen.intf.Taggable;

import java.time.OffsetDateTime;

@CodeBuilder
public interface TransactionEntityPrototype extends BasePrototype, Taggable {
    AccountEntityPrototype account();
    double amount();
    AccountEntityPrototype counterparty();
    TransactionEntityPrototype parent();
    OffsetDateTime timestamp();
}