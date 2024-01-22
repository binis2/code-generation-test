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

import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.test.BaseCodeGenElementTest;
import org.junit.jupiter.api.Test;

import static net.binis.codegen.tools.Reflection.*;
import static org.junit.jupiter.api.Assertions.*;

class GettersElementTest extends BaseCodeGenElementTest {

    @Test
    void testDefaultMethod() {
        var cls = testSingle("elements/getters1.java", "net.binis.codegen.TestElement");
        assertNotNull(cls);
        var flag = findMethod("isFlag", cls);
        var id = findMethod("getId", cls);
        var sflag = findMethod("setFlag", cls, boolean.class);
        var sid = findMethod("setId", cls, Long.class);

        assertNotNull(flag);
        assertNotNull(id);
        assertNotNull(sflag);
        assertNotNull(sid);
        var inst = CodeFactory.create(cls);
        invoke(sflag, inst, true);
        assertTrue((Boolean) invoke(flag, inst));
    }

}
