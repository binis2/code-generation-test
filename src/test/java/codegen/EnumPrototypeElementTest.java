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

import net.binis.codegen.test.BaseCodeGenElementTest;
import org.junit.jupiter.api.Test;

import static net.binis.codegen.tools.Reflection.*;
import static org.junit.jupiter.api.Assertions.*;

class EnumPrototypeElementTest extends BaseCodeGenElementTest {

    @Test
    void testDefaultMethod() {
        var cls = testSingle("elements/enumPrototype.java", "net.binis.codegen.TestEnumPrototype");
        assertNotNull(cls);
        assertNotNull(findField(cls, "title"));
        assertNotNull(findField(cls, "value"));
        assertNotNull(findField(cls, "flag"));
        assertEquals(1, cls.getDeclaredConstructors().length);
        assertNotNull(findMethod("isFlag", cls));
        assertNotNull(findMethod("getValue", cls));
        assertTrue((Boolean) invoke("isFlag", getFieldValue(findField(cls, "ONE"), cls)));
    }

}
