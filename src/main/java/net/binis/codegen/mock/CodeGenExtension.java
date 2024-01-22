package net.binis.codegen.mock;

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
import net.binis.codegen.map.MapperFactory;
import net.binis.codegen.spring.query.QueryProcessor;
import org.junit.jupiter.api.extension.*;

import static net.binis.codegen.factory.CodeFactory.cleanAllEnvelopedTypes;
import static net.binis.codegen.mock.CodeGenMock.*;

public class CodeGenExtension implements BeforeAllCallback, BeforeEachCallback, AfterAllCallback, AfterEachCallback {

    @Override
    public void afterEach(ExtensionContext context) {
        if (context.getExecutionException().isEmpty()) {
            mockCheckCalls();
        }
        CodeGenMock.testStop();
        cleanAllEnvelopedTypes();
    }

    @Override
    public void beforeEach(ExtensionContext context) {
        mockQueryClear();
        mockEntityManager();
        CodeGenMock.testStart();
        CodeFactory.create(MapperFactory.class).clearAllMappings();
    }

    @Override
    public void beforeAll(ExtensionContext context) {
        mockContext();
        mockAsyncExecutor();
        mockCodeFactory();
        QueryProcessor.setProcessor(createMockedProcessor());
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        clearCodeFactoryMock();
        cleanEntityManagerMock();
        //TODO: Remove mocked context and executor.
    }

}
