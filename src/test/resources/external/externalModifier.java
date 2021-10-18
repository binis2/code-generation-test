package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.enrich.ModifierEnricher;
import net.binis.codegen.intf.Available;
import net.binis.codegen.intf.ExternalInterface;
import net.binis.codegen.intf.Previewable;

@CodePrototype(enrichers = {ModifierEnricher.class})
public interface TestPrototype extends ExternalInterface<String>, Available, Previewable {

    boolean available();

    String key();

    default String getPreview() {
        return "preview";
    }

    default String getTest() {
        return available() ? "test" : getPreview();
    }

    default String getTest2() {
        return available() ? getPreview() : key();
    }

    default String getTest3() {
        return available() ? key() : getPreview();
    }



}