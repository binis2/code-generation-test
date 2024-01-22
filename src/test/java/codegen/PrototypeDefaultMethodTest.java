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

import net.binis.codegen.annotation.CodeImplementation;
import net.binis.codegen.test.BaseCodeGenElementTest;
import net.binis.codegen.tools.Reflection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PrototypeDefaultMethodTest extends BaseCodeGenElementTest {

    @Test
    void testDefaultMethod() {
        var cls = testSingle("elements/defaultMethod1.java", "net.binis.codegen.RuleablePrototype");
        assertNotNull(cls);
        var method = Reflection.findMethod("getRules", cls, Class.class);
        assertNotNull(method);
        var ann = method.getAnnotation(CodeImplementation.class);
        assertNotNull(ann);
        assertEquals("return getRules().stream().map(r -> cls.getCanonicalName() + r).toList();", ann.value());
        method = Reflection.findMethod("getRules", cls, String.class);
        assertNotNull(method);
        ann = method.getAnnotation(CodeImplementation.class);
        assertNotNull(ann);
        assertEquals("var result = new ArrayList<String>();\r\n" +
                    "    result.addAll(getRules());\r\n" +
                    "    result.addAll(getParent().getRules());\r\n" +
                    "    return result;", ann.value());
    }

}
