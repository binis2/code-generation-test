package net.binis.codegen.intf;

import net.binis.codegen.annotation.Default;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import net.binis.codegen.creator.EntityCreatorModifier;
import net.binis.codegen.enums.TestEnum;
import net.binis.codegen.modifier.BaseModifier;
import net.binis.codegen.spring.BaseEntityModifier;

import javax.annotation.processing.Generated;
import java.util.List;

@Generated(value = "AccountEntityPrototype", comments = "AccountEntity")
@Default("net.binis.codegen.impl.AccountEntity")
public interface Account extends BaseInterface, Typeable<TestEnum> {

    // region starters
    static Account.Modify create() {
        return (Account.Modify) EntityCreatorModifier.create(Account.class).with();
    }
    // endregion

    String getAccountNumber();
    double getAvailable();
    double getBalance();
    double getPending();
    List<Transaction> getTransactions();

    boolean isActive();

    Modify with();

    // region inner classes
    interface EmbeddedModify<T, R> extends Account.Fields<T>, BaseModifier<T, R> {
        T transactions(List<Transaction> transactions);
        EmbeddedCodeCollection<Transaction.EmbeddedCollectionModify<Account.EmbeddedModify<T, R>>, Transaction, Account.EmbeddedModify<T, R>> transactions();
    }

    interface Modify extends EmbeddedModify<Account.Modify, Account>, BaseEntityModifier<Account.Modify, Account> {
    }

    interface EmbeddedSoloModify<R> extends Account.EmbeddedModify<Account.EmbeddedSoloModify<R>, R> {
    }


//    interface Ret extends Modify<Ret, Account> {
//
//    }

    interface Fields<T> extends BaseInterface.Fields<T> {
        T accountNumber(String accountNumber);
        T active(boolean active);
        T available(double available);
        T balance(double balance);
        T description(String description);
        T externalId(String externalId);
        T name(String name);
        T pending(double pending);
        T type(TestEnum type);
    }

    // endregion
}
