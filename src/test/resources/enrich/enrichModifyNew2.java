package net.binis.codegen;

import net.binis.codegen.annotation.builder.CodeBuilder;
import net.binis.codegen.intf.Account;
import net.binis.codegen.intf.Taggable;

import java.time.OffsetDateTime;

@CodeBuilder
public interface TransactionEntityPrototype extends BasePrototype, Taggable {
    Account account();
    double amount();
    AccountEntityPrototype counterparty();
    TransactionEntityPrototype parent();
    OffsetDateTime timestamp();
}