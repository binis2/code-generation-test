package net.binis.codegen;

import net.binis.codegen.annotation.TestAddMethodElementAnnotation;

@TestAddMethodElementAnnotation
public class TestElement {

    public static class Application {
        public static <T> T run(Class<T> cls) {
            throw new RuntimeException("test");
        }
    }

}