package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.enrich.handler.ModifierEnricher;
import net.binis.codegen.intf.*;

@CodePrototype(enrichers = {ModifierEnricher.class})
public interface TestPrototype extends ExternalInterface<String>, Available, Previewable, Taggable {

    boolean available();

    default String getPreview() {
        return "preview";
    }

}