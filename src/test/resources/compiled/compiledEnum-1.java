/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.test.CompiledEnum;
import net.binis.codegen.objects.base.enumeration.CodeEnum;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.annotation.Default;
import javax.annotation.processing.Generated;

@Generated(value = "net.binis.codegen.ExtendedCompiledEnumPrototype", comments = "CompiledEnumImpl")
@net.binis.codegen.annotation.Generated(by = "net.binis.codegen.ExtendedCompiledEnumPrototype")
@Default("net.binis.codegen.test.CompiledEnumImpl")
public interface ExtendedCompiledEnum extends CodeEnum {

    static final CompiledEnum EXTENDED = CodeFactory.initializeEnumValue(CompiledEnum.class, "EXTENDED", 2, "extended");

    static final CompiledEnum KNOWN = CompiledEnum.KNOWN;

    static final CompiledEnum UNKNOWN = CompiledEnum.UNKNOWN;

    static CompiledEnum valueOf(String name) {
        return CodeFactory.enumValueOf(CompiledEnum.class, name);
    }

    static CompiledEnum valueOf(int ordinal) {
        return CodeFactory.enumValueOf(CompiledEnum.class, ordinal);
    }

    static CompiledEnum[] values() {
        return CodeFactory.enumValues(CompiledEnum.class);
    }
}
