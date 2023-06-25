package net.binis.codegen;

import lombok.extern.slf4j.Slf4j;
import net.binis.codegen.annotation.TestAnnotationElementAnnotation;

@Slf4j
public class TestElement {

    @TestAnnotationElementAnnotation
    private Long id;

    @TestAnnotationElementAnnotation
    public Long getId() {
        return id;
    }

}