package net.binis.codegen;

import net.binis.codegen.annotation.TestTryCatchFinallyElementAnnotation;

public class TestElement {

    private int test;

    @TestTryCatchFinallyElementAnnotation
    public void run() {
        throw new RuntimeException("test");
    }

    public void run1() {
        try {
            throw new RuntimeException("test");
        } catch (Exception e) {
            test++;
        } finally {
            test++;
        }
    }

}