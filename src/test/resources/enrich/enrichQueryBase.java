package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;

import jakarta.persistence.Id;

@CodePrototype(base = true)
public interface BasePrototype {
    @Id
    String id();
}