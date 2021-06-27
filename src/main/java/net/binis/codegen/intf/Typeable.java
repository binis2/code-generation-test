package net.binis.codegen.intf;

@FunctionalInterface
public interface Typeable<T extends Enum<?>> {

    T getType();

}
