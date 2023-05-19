package net.binis.codegen;

import lombok.extern.slf4j.Slf4j;
import net.binis.codegen.annotation.TestElementAnnotation;

@Slf4j
public class TestElement {

    @TestElementAnnotation
    private Long id;

    @TestElementAnnotation
    public Long getId() {
        return id;
    }

}