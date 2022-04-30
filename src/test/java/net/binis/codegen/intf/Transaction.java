package net.binis.codegen.intf;

import net.binis.codegen.Base;
import net.binis.codegen.modifier.BaseModifier;
import net.binis.codegen.intf.Taggable;
import net.binis.codegen.intf.Account;
import net.binis.codegen.creator.EntityCreatorModifier;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import net.binis.codegen.annotation.Default;
import javax.annotation.processing.Generated;
import java.util.function.Consumer;
import java.time.OffsetDateTime;

@Generated(value = "TransactionEntityPrototype", comments = "TransactionEntity")
@Default("net.binis.codegen.impl.TransactionEntity")
public interface Transaction extends Base, Taggable {

    // region starters
    static Transaction.Modify create() {
        return (Transaction.Modify) EntityCreatorModifier.create(Transaction.class).with();
    }
    // endregion

    Account getAccount();
    double getAmount();
    Account getCounterparty();
    Transaction getParent();
    OffsetDateTime getTimestamp();

    Transaction.Modify with();

    // region inner classes
    interface EmbeddedCollectionModify<R> extends Transaction.EmbeddedModify<Transaction.EmbeddedCollectionModify<R>, R> {
        EmbeddedCodeCollection<Transaction.EmbeddedCollectionModify<R>, Transaction, R> _and();
    }

    interface EmbeddedModify<T, R> extends BaseModifier<T, R>, Transaction.Fields<T> {
        Account.EmbeddedSoloModify<EmbeddedModify<T, R>> account();
        Account.EmbeddedSoloModify<EmbeddedModify<T, R>> counterparty();
        Transaction.EmbeddedSoloModify<EmbeddedModify<T, R>> parent();
    }

    interface EmbeddedSoloModify<R> extends Transaction.EmbeddedModify<Transaction.EmbeddedSoloModify<R>, R> {
    }

    interface Fields<T> extends Base.Fields<T> {
        T account(Account account);
        T amount(double amount);
        T counterparty(Account counterparty);
        T parent(Transaction parent);
        T tag(Object tag);
        T timestamp(OffsetDateTime timestamp);
    }

    interface Modify extends EmbeddedModify<Transaction.Modify, Transaction> {
        Modify account(Consumer<Account.Modify> init);
        Modify counterparty(Consumer<Account.Modify> init);
        Modify parent(Consumer<Transaction.Modify> init);
    }
    // endregion
}
