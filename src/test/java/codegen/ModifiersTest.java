package codegen;

/*-
 * #%L
 * code-generator
 * %%
 * Copyright (C) 2021 Binis Belev
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import lombok.extern.slf4j.Slf4j;
import net.binis.codegen.generation.core.Helpers;
import net.binis.codegen.intf.Account;
import net.binis.codegen.intf.Transaction;
import net.binis.codegen.test.BaseTest;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Slf4j
public class ModifiersTest extends BaseTest {

    @Before
    public void cleanUp() {
        Helpers.cleanUp();
    }

    @Test
    public void test() {
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
                        .externalId("asdasd")
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
                    .externalId("asd")
                .done()
        .done();

        assertTrue(transaction.getAccount().isActive());
        assertEquals("1234", transaction.getAccount().getAccountNumber());

        account = Account.create()
                .transactions()
                    ._add(t -> t
                            .amount(5)
                            .description("desc"))
                .done()
        .done();

        assertEquals(1, account.getTransactions().size());

        transaction = Transaction.create()
                .account(a -> a
                    .active(true)
                    .accountNumber("1234")
                    .externalId("asd"))
                .done();

        assertTrue(transaction.getAccount().isActive());
        assertEquals("1234", transaction.getAccount().getAccountNumber());

    }

}
