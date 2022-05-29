package net.binis.codegen.modifier.test;

import net.binis.codegen.annotation.builder.CodeBuilder;
import net.binis.codegen.intf.Taggable;
import net.binis.codegen.spring.modifier.BaseEntityModifier;

import java.time.OffsetDateTime;

@CodeBuilder(baseModifierClass = BaseEntityModifier.class)
public interface TransactionEntityPrototype extends BasePrototype, Taggable {
    AccountEntityPrototype account();
    double amount();
    AccountEntityPrototype counterparty();
    OffsetDateTime timestamp();
}