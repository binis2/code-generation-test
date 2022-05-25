/*Generated code by Binis' code generator.*/
package net.binis.codegen.modifier.test;

import net.binis.codegen.modifier.BaseModifier;
import net.binis.codegen.intf.Taggable;
import net.binis.codegen.creator.EntityCreatorModifier;
import net.binis.codegen.annotation.Default;
import javax.annotation.processing.Generated;
import java.util.function.Consumer;

@Generated(value = "TransactionDetailEntityPrototype", comments = "TransactionDetailEntity")
@Default("net.binis.codegen.modifier.test.TransactionDetailEntity")
public interface TransactionDetail extends Base, Taggable {

    // region starters
    static TransactionDetail.Modify create() {
        return (TransactionDetail.Modify) EntityCreatorModifier.create(TransactionDetail.class).with();
    }
    // endregion

    SubTransaction getParent();

    TransactionDetail.Modify with();

    // region inner classes
    interface Fields<T> extends Base.Fields<T> {
        T parent(SubTransaction parent);
        T tag(Object tag);
    }

    interface Modify extends TransactionDetail.Fields<TransactionDetail.Modify>, BaseModifier<TransactionDetail.Modify, TransactionDetail> {
        SubTransaction.EmbeddedSoloModify<Modify> parent();
        Modify parent(Consumer<SubTransaction.Modify> init);
    }
    // endregion
}
