package net.binis.codegen.test;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.enrich.ModifierEnricher;
import net.binis.codegen.intf.*;
import javax.persistence.Transient;

@CodePrototype(enrichers = {ModifierEnricher.class})
public interface TestPrototype extends ExternalInterface<String>, Available, Previewable, Taggable {

    boolean available();

    @Transient
    <T> T tag();


    default String getPreview() {
        return "preview";
    }

}