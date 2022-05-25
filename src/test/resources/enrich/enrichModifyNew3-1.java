/*Generated code by Binis' code generator.*/
package net.binis.codegen.modifier.test;

import net.binis.codegen.modifier.BaseModifier;
import net.binis.codegen.intf.Taggable;
import net.binis.codegen.intf.Account;
import net.binis.codegen.creator.EntityCreatorModifier;
import net.binis.codegen.annotation.Default;
import javax.annotation.processing.Generated;
import java.util.function.Consumer;

@Generated(value = "SubTransactionEntityPrototype", comments = "SubTransactionEntity")
@Default("net.binis.codegen.modifier.test.TransactionEntity")
public interface SubTransaction extends Taggable, Transaction {
    SubTransaction.Modify asSubTransaction();

    // region starters
    static SubTransaction.Modify create() {
        return ((SubTransaction) EntityCreatorModifier.create(SubTransaction.class)).asSubTransaction();
    }
    // endregion

    Transaction getParent();

    // region inner classes
    interface EmbeddedModify<T, R> extends BaseModifier<T, R>, SubTransaction.Fields<T> {
        Account.EmbeddedSoloModify<EmbeddedModify<T, R>> account();
        Account.EmbeddedSoloModify<EmbeddedModify<T, R>> counterparty();
        Transaction.EmbeddedSoloModify<EmbeddedModify<T, R>> parent();
    }

    interface EmbeddedSoloModify<R> extends SubTransaction.EmbeddedModify<SubTransaction.EmbeddedSoloModify<R>, R> {
    }

    interface Fields<T> extends Transaction.Fields<T> {
        T parent(Transaction parent);
        T tag(Object tag);
    }

    interface Modify extends EmbeddedModify<SubTransaction.Modify, SubTransaction> {
        Modify account(Consumer<Account.Modify> init);
        Modify counterparty(Consumer<Account.Modify> init);
        Modify parent(Consumer<Transaction.Modify> init);
    }
    // endregion
}
