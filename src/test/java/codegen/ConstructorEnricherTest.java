package codegen;

/*-
 * #%L
 * code-generation-test
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

import net.binis.codegen.annotation.type.GenerationStrategy;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.test.BaseCodeGenElementTest;
import org.junit.jupiter.api.Test;

import static net.binis.codegen.tools.Reflection.getFieldValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ConstructorEnricherTest extends BaseCodeGenElementTest {

    @Test
    void testRequiredEnricher() {
        var cls = testSingle("constructor/required1.java", "net.binis.codegen.TestRequired");
        assertNotNull(cls);
        var inst = CodeFactory.create(cls, 5L, 2, null, GenerationStrategy.NONE, ConstructorEnricherTest.class);
        assertNotNull(inst);
        assertEquals(5L, (Long) getFieldValue(inst, "test"));
    }

    @Test
    void testNoEnricher() {
        var cls = testSingle("constructor/no1.java", "net.binis.codegen.TestNo");
        assertNotNull(cls);
        var inst = CodeFactory.create(cls);
        assertNotNull(inst);
        assertEquals(1L, (Long) getFieldValue(inst, "test"));
    }

    @Test
    void testNotInitializedEnricher() {
        var cls = testSingle("constructor/notInitialized1.java", "net.binis.codegen.TestNotInitialized");
        assertNotNull(cls);
        var inst = CodeFactory.create(cls, 2L, 3L);
        assertNotNull(inst);
        assertEquals(2L, (Long) getFieldValue(inst, "testFinal"));
        assertEquals(3L, (Long) getFieldValue(inst, "testNotFinal"));
        assertEquals(2L, (Long) getFieldValue(inst, "testInitialized"));
    }

    @Test
    void testAllEnricher() {
        var cls = testSingle("constructor/all1.java", "net.binis.codegen.TestAll");
        assertNotNull(cls);
        assertNotNull(cls);
        var inst = CodeFactory.create(cls, 2L, 3L, 4L);
        assertNotNull(inst);
        assertEquals(2L, (Long) getFieldValue(inst, "testFinal"));
        assertEquals(3L, (Long) getFieldValue(inst, "testNotFinal"));
        assertEquals(4L, (Long) getFieldValue(inst, "testInitialized"));
    }

    @Test
    void testWithNested() {
        var cls = testSingle("constructor/nested1.java", "net.binis.codegen.TestWithNested$BaseClass");
        assertNotNull(cls);
        var inst = CodeFactory.create(cls, "test");
        assertNotNull(inst);
        assertEquals("test", getFieldValue(inst, "field"));
    }

    @Test
    void testWithStatic() {
        var cls = testSingle("constructor/static1.java", "net.binis.codegen.TestAll");
        assertNotNull(cls);
        var inst = CodeFactory.create(cls, "test");
        assertNotNull(inst);
        assertEquals("test", getFieldValue(inst, "field"));
    }


}
