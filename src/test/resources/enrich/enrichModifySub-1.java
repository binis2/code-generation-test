/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.modifier.BaseModifier;
import net.binis.codegen.intf.Prototypable;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import javax.annotation.processing.Generated;
import java.util.function.Consumer;

@Generated(value = "net.binis.codegen.SubModifyPrototype", comments = "SubModifyImpl")
public interface SubModify extends Prototypable<SubModify> {
    double getSubAmount();
    String getSubtitle();

    void setSubAmount(double subAmount);
    void setSubtitle(String subtitle);

    SubModify.Modify with();

    interface EmbeddedCollectionModify<R> extends SubModify.EmbeddedModify<SubModify.EmbeddedCollectionModify<R>, R> {
        EmbeddedCodeCollection<SubModify.EmbeddedCollectionModify<R>, SubModify, R> _and();
    }

    interface EmbeddedModify<T, R> extends BaseModifier<T, R>, SubModify.Fields<T> {
        SubModify.EmbeddedSoloModify<EmbeddedModify<T, R>> prototype();
    }

    interface EmbeddedSoloModify<R> extends SubModify.EmbeddedModify<SubModify.EmbeddedSoloModify<R>, R> {
    }

    interface Fields<T> {
        T prototype(SubModify prototype);
        T subAmount(double subAmount);
        T subtitle(String subtitle);
    }

    interface Modify extends EmbeddedModify<SubModify.Modify, SubModify> {
        Modify prototype$(Consumer<SubModify.Modify> init);
    }
}
