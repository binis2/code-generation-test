package codegen;

/*-
 * #%L
 * code-generation-test
 * %%
 * Copyright (C) 2021 - 2023 Binis Belev
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
import net.binis.codegen.tools.Reflection;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static net.binis.codegen.tools.Reflection.invokeStatic;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LogEnricherTest extends BaseCodeGenElementTest {

    @Test
    void testEnricher() {
        var cls = testSingle("log/log1.java", "net.binis.codegen.TestLog");
        assertNotNull(cls);
        var field = Reflection.findField(cls, "log");
        assertNotNull(field);
        assertEquals(Logger.class, field.getType());
        invokeStatic("test", cls);
    }

    @Test
    void testTripleLogUsage() {
        var loader = testMulti("log/double1.java", "log/double2.java", "log/double3.java");
        var log1 = loader.findClass("net.binis.codegen.Log1");
        assertNotNull(log1);
        assertNotNull(Reflection.findField(log1, "log"));
        var log2 = loader.findClass("net.binis.codegen.Log2");
        assertNotNull(log2);
        assertNotNull(Reflection.findField(log2, "log"));
        var log3 = loader.findClass("net.binis.codegen.Log3");
        assertNotNull(log3);
        assertNotNull(Reflection.findField(log3, "log"));
    }

    @Test
    void testCombinedLogAndConstructorEnrichers() {
        var cls = testSingle("log/combined1.java", "net.binis.codegen.TestLog");
        assertNotNull(cls);
        var field = Reflection.findField(cls, "log");
        assertNotNull(field);
        assertEquals(Logger.class, field.getType());
        invokeStatic("test", cls);
    }

    @Test
    void testWtf() {
        var cls = testMulti("log/wtf1.java", "log/wtf2.java");
        assertNotNull(cls);
    }


}
