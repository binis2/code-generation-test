package codegen;

/*-
 * #%L
 * code-generator
 * %%
 * Copyright (C) 2021 - 2026 Binis Belev
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
import net.binis.codegen.enums.TestEnum;
import net.binis.codegen.generation.core.Helpers;
import net.binis.codegen.intf.Account;
import net.binis.codegen.intf.Transaction;
import net.binis.codegen.mock.CodeGenExtension;
import net.binis.codegen.test.BaseCodeGenTest;
import org.apache.commons.lang3.tuple.Triple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Comparator;
import java.util.List;

import static net.binis.codegen.mock.CodeGenMatcher.once;
import static net.binis.codegen.mock.CodeGenMock.verifySave;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@ExtendWith(CodeGenExtension.class)
class ModifiersTest extends BaseCodeGenTest {

    @Test
    void testGenerate() {
        testMultiExecute(List.of(
                Triple.of("enrich/enrichModifyBase2.java", "enrich/enrichModifyBase2-0.java", "enrich/enrichModifyBase2-1.java"),
                Triple.of("enrich/enrichModifyNew.java", "enrich/enrichModifyNew-0.java", "enrich/enrichModifyNew-1.java"),
                Triple.of("enrich/enrichModifyNew2.java", "enrich/enrichModifyNew2-0.java", "enrich/enrichModifyNew2-1.java"),
                Triple.of("enrich/enrichModifyNew3.java", null, "enrich/enrichModifyNew3-1.java"),
                Triple.of("enrich/enrichModifyNew4.java", "enrich/enrichModifyNew4-0.java", "enrich/enrichModifyNew4-1.java")
        ), "enrich/enrichModifyNewExecute.java");
    }

    @Test
    void testSpotBugsSuppression() {
        testSingle("enrich/spotbugs1.java", "enrich/spotbugs1-0.java", "enrich/spotbugs1-1.java", 1, true);
    }

    @Test
    void test() {
        var account = Account.create()
                .transactions()
                ._sort(Comparator.comparingDouble(Transaction::getAmount))
                .done()
                .strings()
                    .add("asd")
                    ._if(true, m -> m.add("asd2"))
                .done()
        .save();

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
                        .type(TestEnum.FIRST)
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
                    ._add$(t -> t
                            .amount(5)
                            .id(5L))
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

        verifySave().called(once());
        verifySave(Account.class).called(once());
    }

}
