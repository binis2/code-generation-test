package codegen;

/*-
 * #%L
 * code-generation-test
 * %%
 * Copyright (C) 2021 - 2022 Binis Belev
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
import net.binis.codegen.test.BaseCodeGenTest;
import org.apache.commons.lang3.tuple.Triple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class GenericsTest extends BaseCodeGenTest {

    @BeforeEach
    public void cleanUp() {
        Helpers.cleanUp();
    }

    @Test
    void testGenericsWithBaseAndPrototype() {
        testMulti(List.of(
                Triple.of("generics/Extended1.java", "generics/Extended1-0.java", "generics/Extended1-1.java"),
                Triple.of("generics/Prototype1.java", "generics/Prototype1-0.java", "generics/Prototype1-1.java"),
                Triple.of("generics/Test1.java", "generics/Test1-0.java", "generics/Test1-1.java")
        ));
    }

}
