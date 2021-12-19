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

import net.binis.codegen.Sub;
import net.binis.codegen.mock.exception.CodeGenMockException;
import org.junit.jupiter.api.Test;

import static net.binis.codegen.mock.CodeGenMock.mockContext;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TestMockContext {

    @Test
    void testWithContext() {
        mockContext();
        assertThrows(CodeGenMockException.class, () -> Sub.find().by().subtitle("").get());
    }

}
