/*Generated code by Binis' code generator.*/
package net.binis.codegen.modifier.test;

import net.binis.codegen.spring.query.*;
import net.binis.codegen.modifier.BaseModifier;
import net.binis.codegen.enums.TestEnum;
import net.binis.codegen.creator.EntityCreatorModifier;
import net.binis.codegen.creator.EntityCreator;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import net.binis.codegen.collection.CodeList;
import net.binis.codegen.annotation.Default;
import javax.annotation.processing.Generated;
import java.util.Optional;
import java.util.List;
import java.time.OffsetDateTime;
import codegen.modifier.TestModifier;

@Generated(value = "net.binis.codegen.modifier.test.AccountEntityPrototype", comments = "AccountEntity")
@Default("net.binis.codegen.modifier.test.AccountEntity")
@SuppressWarnings("unchecked")
public interface Account extends Base {

    // region starters
    static Account.Modify create() {
        return (Account.Modify) EntityCreatorModifier.create(Account.class).with();
    }

    static QueryStarter<Account, Account.QuerySelect<Account>, QueryAggregateOperation<QueryOperationFields<Account.QueryAggregate<Number, Account.QuerySelect<Number>>>>, QueryFieldsStart<Account, Account.QuerySelect<Account>>, QueryUpdate<Account, Account.QuerySelect<Account>>> find() {
        return (QueryStarter) EntityCreator.create(Account.QuerySelect.class);
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
        CodeList<String, T> strings();
        T strings(List<String> strings);
        EmbeddedCodeCollection<Transaction.EmbeddedCollectionModify<Account.EmbeddedModify<T, R>>, Transaction, T> transactions();
        T transactions(List<Transaction> transactions);
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

    interface Modify extends EmbeddedModify<Account.Modify, Account>, TestModifier<Account.Modify, Account> {
    }

    interface QueryAggregate<QR, QA> extends QueryExecute<QR>, QueryAggregator<QA, QueryAggregateOperation<QueryOperationFields<Account.QueryAggregate<Account, Account.QuerySelect<Number>>>>, Account.QueryAggregate<Account, Account.QuerySelect<Number>>> {
    }

    interface QueryFields<QR> extends QueryScript<QR>, Account.Fields<QR> {
    }

    interface QueryFieldsStart<QR, QS> extends QueryExecute<QR>, QueryWhere<QS>, QueryOperationFields<QueryFieldsStart<QR, QS>> {
    }

    interface QueryFuncs<QR> {
        QueryFunctions<String, QR> accountNumber();
        QueryFunctions<Boolean, QR> active();
        QueryFunctions<Double, QR> available();
        QueryFunctions<Double, QR> balance();
        QueryFunctions<OffsetDateTime, QR> date();
        QueryFunctions<Long, QR> id();
        QueryFunctions<Double, QR> pending();
        QueryFunctions<TestEnum, QR> type();
    }

    interface QueryName<QS, QO, QR, QF> extends Account.QueryFields<QuerySelectOperation<QS, QO, QR>>, Account.QueryFuncs<QuerySelectOperation<QS, QO, QR>>, QueryFetch<QuerySelectOperation<QS, QO, QR>, QF> {
    }

    interface QueryOperationFields<QR> extends QueryScript<QR>, QuerySelf<QR> {
        QR accountNumber();
        QR active();
        QR available();
        QR balance();
        QR date();
        QR id();
        QR pending();
        QR type();
    }

    interface QueryOrder<QR> extends QueryOperationFields<QueryOrderOperation<Account.QueryOrder<QR>, QR>>, QueryExecute<QR> {
    }

    interface QuerySelect<QR> extends QueryExecute<QR>, QueryModifiers<Account.QueryName<Account.QuerySelect<QR>, Account.QueryOrder<QR>, QR, Account>>, Account.QueryFields<QuerySelectOperation<Account.QuerySelect<QR>, Account.QueryOrder<QR>, QR>>, Account.QueryFuncs<QuerySelectOperation<Account.QuerySelect<QR>, Account.QueryOrder<QR>, QR>>, QueryOrderStart<QueryOperationFields<QueryOrderOperation<Account.QueryOrder<QR>, QR>>>, QueryBracket<QuerySelect<QR>> {
        QueryCollectionFunctions<String, QuerySelectOperation<Account.QuerySelect<QR>, QueryOperationFields<QueryOrderOperation<Account.QueryOrder<QR>, QR>>, QR>> strings();
        QueryJoinCollectionFunctions<Transaction, QuerySelectOperation<Account.QuerySelect<QR>, QueryOperationFields<QueryOrderOperation<Account.QueryOrder<QR>, QR>>, QR>, QueryJoinAggregateOperation<Transaction.QueryOperationFields<Transaction.QueryAggregate<Number, Transaction.QuerySelect<Number>>>, Transaction.QuerySelect<Number>>> transactions();
    }

    interface QueryUpdate<QR, QS> extends QueryFields<QueryUpdate<QR, QS>>, QueryWhere<QS>, QueryScript<QueryUpdate<QR, QS>>, UpdatableQuery {
    }
    // endregion
}
