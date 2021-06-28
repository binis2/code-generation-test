package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.enrich.handler.ModifierEnricher;
import net.binis.codegen.intf.ExternalInterface;
import net.binis.codegen.intf.Available;
import net.binis.codegen.intf.Previewable;
import net.binis.codegen.intf.Prototypable;

@CodePrototype(enrichers = {ModifierEnricher.class})
public interface TestPrototype extends ExternalInterface<String>, Available, Previewable {

    boolean available();

    default String getPreview() {
        return "preview";
    }

}