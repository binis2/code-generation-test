package codegen;

/*-
 * #%L
 * code-generation-test
 * %%
 * Copyright (C) 2021 - 2024 Binis Belev
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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ExternalInterfaceTest extends BaseCodeGenTest {

    @Test
    void test() {
        testSingle("external/external.java", "external/external-0.java", "external/external-1.java");
    }

    @Test
    void testModifier() {
        testSingle("external/externalModifier.java", "external/externalModifier-0.java", "external/externalModifier-1.java");
    }

    @Test
    void testModifierMethodGeneric() {
        testSingle("external/externalModifierMethodGeneric.java", "external/externalModifierMethodGeneric-0.java", "external/externalModifierMethodGeneric-1.java");
    }

    @Test
    void testCompiledPrototypeWithDefaultFunctionOverride() {
        testSingle("compiled/compiledWithDefaultOverride.java", "compiled/compiledWithDefaultOverride-0.java", "compiled/compiledWithDefaultOverride-1.java", 2);
    }

    @Test
    void testCompiledPrototypeWithDefaultFunction() {
        testSingle("compiled/compiledWithDefault.java", "compiled/compiledWithDefault-0.java", "compiled/compiledWithDefault-1.java", 2);
    }

    @Test
    void testCompiledPrototypeWithFieldOverride() {
        testSingle("compiled/compiledWithDefaultWithFieldOverride.java", "compiled/compiledWithDefaultWithFieldOverride-0.java", "compiled/compiledWithDefaultWithFieldOverride-1.java", 2);
    }

    @Test
    void testCompiledPrototypeWithFieldInitialize() {
        testSingle("compiled/compiledWithDefaultWithFieldInitialize.java", "compiled/compiledWithDefaultWithFieldInitialize-0.java", "compiled/compiledWithDefaultWithFieldInitialize-1.java", 2);
    }


}
