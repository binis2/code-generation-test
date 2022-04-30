package net.binis.codegen.modifier.test;

import net.binis.codegen.test.TestExecutor;

import java.util.Comparator;

import static org.junit.Assert.*;

public class Execute extends TestExecutor {

    @Override
    public boolean execute() {
        var account = Account.create()
                .transactions()
                    ._sort(Comparator.comparingDouble(Transaction::getAmount))
                .done()
        .done();

        assertTrue(account.getTransactions().isEmpty());

        account = Account.create()
                .transactions()
                    ._add()
                        .amount(5.0)
                .done()
        .done();

        assertEquals(1, account.getTransactions().size());

        account = Account.create()
                .transactions()
                    ._add()
                        .amount(5.0)
                    ._and()
                    ._add()
                        .amount(4.0)
                    ._and()
                    ._sort(Comparator.comparingDouble(Transaction::getAmount))
                .done()
        .done();

        assertEquals(2, account.getTransactions().size());
        assertEquals(4.0, account.getTransactions().get(0).getAmount(), 0);

        var transaction = Transaction.create()
                .account()
                    .active(true)
                    .accountNumber("1234")
                    .balance(6.0)
                .done()
        .done();

        assertTrue(transaction.getAccount().isActive());
        assertEquals("1234", transaction.getAccount().getAccountNumber());

        account = Account.create()
                .transactions()
                    ._add(t -> t
                            .amount(5)
                            .id(1L))
                .done()
        .done();

        assertEquals(1, account.getTransactions().size());

        transaction = Transaction.create()
                .account(a -> a
                        .active(true)
                        .accountNumber("1234")
                        .balance(6.0))
                .done();

        assertTrue(transaction.getAccount().isActive());
        assertEquals("1234", transaction.getAccount().getAccountNumber());

        account = Account.create()
                .strings()
                    .add("asd")
                    .add("fgh")
                    ._if(true, l -> l.add("jkl"))
                .done()
        .done();
        assertEquals(3, account.getStrings().size());

        return true;
    }
}