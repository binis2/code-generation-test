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

import net.binis.codegen.test.BaseCodeGenTest;
import org.junit.jupiter.api.Test;

import static net.binis.codegen.generation.core.Helpers.lookup;

class ExternalPrototypeTest extends BaseCodeGenTest {

    @Test
    void testWithExternalSourcePrototype() {
        lookup.registerExternalLookup(s -> {
            if ("net.binis.codegen.prototype.TestExternalPrototype".equals(s)) {
                return """
                        package net.binis.codegen.prototype;
                                                
                        import net.binis.codegen.annotation.CodePrototype;
                        import net.binis.codegen.enrich.QueryEnricher;
                                            
                        @CodePrototype(enrichers = QueryEnricher.class)
                        public interface TestExternalPrototype {
                            String field();
                        }
                        """;
            }
            return null;
        });
        testSingleSkip("external/externalWithSource.java", "external/externalWithSource-0.java", "external/externalWithSource-1.java", 2, true, true);
    }


}
