package net.binis.codegen.intf;

import net.binis.codegen.annotation.Default;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import net.binis.codegen.creator.EntityCreatorModifier;
import net.binis.codegen.modifier.BaseModifier;
import net.binis.codegen.spring.BaseEntityModifier;

import javax.annotation.processing.Generated;
import java.time.OffsetDateTime;
import java.util.function.Consumer;

@Generated(value = "TransactionEntityPrototype", comments = "TransactionEntity")
@Default("net.binis.codegen.impl.TransactionEntity")
public interface Transaction extends BaseInterface, Taggable {

    // region starters
    static Transaction.Modify create() {
        return (Transaction.Modify) EntityCreatorModifier.create(Transaction.class).with();
    }
    // endregion

    Account getAccount();
    double getAmount();
    Account getCounterparty();
    OffsetDateTime getTimestamp();

    Transaction.Modify with();

    // region inner classes
    interface EmbeddedModify<T, R> extends Transaction.Fields<T>, BaseModifier<T, R> {
        Account.EmbeddedSoloModify<EmbeddedModify<T, R>> account();
    }

    interface Modify extends Transaction.EmbeddedModify<Transaction.Modify, Transaction>, BaseEntityModifier<Transaction.Modify, Transaction> {
        Modify account(Consumer<Account.Modify> init);
    }

    interface EmbeddedCollectionModify<R> extends EmbeddedModify<EmbeddedCollectionModify<R>, R> {
        EmbeddedCodeCollection<Transaction.EmbeddedCollectionModify<R>, Transaction, R> _and();
    }

    interface EmbeddedSoloModify<R> extends EmbeddedModify<EmbeddedSoloModify<R>, R> {
    }

    interface Fields<T> extends BaseInterface.Fields<T> {
        T account(Account account);
        T amount(double amount);
        T counterparty(Account counterparty);
        T description(String description);
        T externalId(String externalId);
        T tag(Object tag);
        T timestamp(OffsetDateTime timestamp);
        T title(String title);
    }

    // endregion
}
