package codegen;

/*-
 * #%L
 * code-generation-test
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

import net.binis.codegen.generation.core.Helpers;
import net.binis.codegen.test.BaseTest;
import org.apache.commons.lang3.tuple.Triple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class ModifyEnrichTest extends BaseTest {

    @BeforeEach
    public void cleanUp() {
        Helpers.cleanUp();
    }

    @Test
    void enrichModify() {
        testMulti(List.of(
                Triple.of("enrich/enrichModifySub.java", "enrich/enrichModifySub-0.java", "enrich/enrichModifySub-1.java"),
                Triple.of("enrich/enrichModify.java", "enrich/enrichModify-0.java", "enrich/enrichModify-1.java")
        ));
    }

    @Test
    void enrichModifyWithBase() {
        testMulti(List.of(
                Triple.of("enrich/enrichModifyBase1.java", "enrich/enrichModifyBase1-0.java", "enrich/enrichModifyBase1-1.java"),
                Triple.of("enrich/enrichModifySubWithBase.java", "enrich/enrichModifySubWithBase-0.java", "enrich/enrichModifySubWithBase-1.java"),
                Triple.of("enrich/enrichModifyWithBase.java", "enrich/enrichModifyWithBase-0.java", "enrich/enrichModifyWithBase-1.java")
        ));
    }

    @Test
    void enrichModifyWithBaseAndMixIn() {
        testMulti(List.of(
                Triple.of("enrich/enrichModifyBase1.java", "enrich/enrichModifyBase1-0.java", "enrich/enrichModifyBase1-1.java"),
                Triple.of("enrich/enrichModifySubWithBase.java", "enrich/enrichModifySubWithBase-0.java", "enrich/enrichModifySubWithBase-1.java"),
                Triple.of("enrich/enrichModifyWithBase.java", "enrich/enrichModifyWithBaseAndMixIn-0.java", "enrich/enrichModifyWithBase-1.java"),
                Triple.of("enrich/enrichModifyMixInWithBase.java", null, "enrich/enrichModifyMixInWithBase-1.java")
        ), "./src/main/java/net/binis/codegen");
    }

    @Test
    void enrichModifyWithExtendedPrototype() {
        testMulti(List.of(
                Triple.of("enrich/enrichModifySubWithExtended.java", "enrich/enrichModifySub-0.java", "enrich/enrichModifySub-1.java"),
                Triple.of("enrich/enrichExtended.java", null, "enrich/enrichExtended-1.java"),
                Triple.of("enrich/enrichModifyWithExtended.java", "enrich/enrichModifyWithExtended-0.java", "enrich/enrichModifyWithExtended-1.java")
        ));
    }

    @Test
    void enrichMockEntity() {
        testSingle("enrich/TestMockEntityPrototype.java", "enrich/TestMockEntityPrototype-0.java", "enrich/TestMockEntityPrototype-1.java", "./src/main/java/net/binis/codegen");
    }





}
