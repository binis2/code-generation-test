package net.binis.codegen.enrich;

/*-
 * #%L
 * code-generator
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

import lombok.extern.slf4j.Slf4j;
import net.binis.codegen.annotation.DummyAnnotation;
import net.binis.codegen.annotation.TestAnnotationElementAnnotation;
import net.binis.codegen.compiler.utils.ElementAnnotationUtils;
import net.binis.codegen.enrich.handler.base.BaseEnricher;
import net.binis.codegen.generation.core.interfaces.ElementDescription;

@Slf4j
public class TestAnnotationElementEnricher extends BaseEnricher {
    @Override
    public void enrichElement(ElementDescription description) {
        ElementAnnotationUtils.removeAnnotation(description.getElement(), TestAnnotationElementAnnotation.class);
        ElementAnnotationUtils.addAnnotation(description.getElement(), DummyAnnotation.class);
    }

    @Override
    public int order() {
        return 0;
    }
}
