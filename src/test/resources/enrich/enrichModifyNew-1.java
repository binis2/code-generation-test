/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.spring.BaseEntityModifier;
import net.binis.codegen.modifier.BaseModifier;
import net.binis.codegen.creator.EntityCreatorModifier;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import net.binis.codegen.collection.CodeList;
import net.binis.codegen.annotation.Default;
import javax.annotation.processing.Generated;
import java.util.List;

@Generated(value = "AccountEntityPrototype", comments = "AccountEntity")
@Default("net.binis.codegen.AccountEntity")
public interface Account extends Base {

    // region starters
    static Account.Modify create() {
        return (Account.Modify) EntityCreatorModifier.create(Account.class).with();
    }
    // endregion

    String getAccountNumber();
    double getAvailable();
    double getBalance();
    double getPending();
    List<String> getStrings();
    List<Transaction> getTransactions();

    boolean isActive();

    Account.Modify with();

    // region inner classes
    interface EmbeddedModify<T, R> extends BaseModifier<T, R>, Account.Fields<T> {
        T strings(List<String> strings);
        CodeList<String, Account.EmbeddedModify<T, R>> strings();
        T transactions(List<Transaction> transactions);
        EmbeddedCodeCollection<Transaction.EmbeddedCollectionModify<Account.EmbeddedModify<T, R>>, Transaction, Account.EmbeddedModify<T, R>> transactions();
    }

    interface EmbeddedSoloModify<R> extends Account.EmbeddedModify<Account.EmbeddedSoloModify<R>, R> {
    }

    interface Fields<T> extends Base.Fields<T> {
        T accountNumber(String accountNumber);
        T active(boolean active);
        T available(double available);
        T balance(double balance);
        T pending(double pending);
    }

    interface Modify extends BaseEntityModifier<Account.Modify, Account>, EmbeddedModify<Account.Modify, Account> {
    }
    // endregion
}
