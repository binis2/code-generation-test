package net.binis.codegen.test;

import net.binis.codegen.annotation.Default;
import net.binis.codegen.annotation.Embeddable;
import net.binis.codegen.annotation.builder.CodeQueryBuilder;
import net.binis.codegen.annotation.type.EmbeddedModifierType;
import net.binis.codegen.enums.TestEnum;
import net.binis.codegen.intf.Typeable;
import net.binis.codegen.spring.annotation.Joinable;

import jakarta.persistence.Column;

@CodeQueryBuilder
@Embeddable
@Joinable
public interface TestPrototype extends GenericPrototype<TestPayloadPrototype>, Typeable<TestEnum> {

    @Column
    @Default("net.binis.codegen.enums.TestEnum.FIRST")
    TestEnum type();

}
