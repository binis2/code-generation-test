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

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import lombok.extern.slf4j.Slf4j;
import net.binis.codegen.enrich.handler.base.BaseEnricher;
import net.binis.codegen.generation.core.interfaces.PrototypeDescription;

import java.util.List;

import static java.lang.reflect.Modifier.PUBLIC;
import static java.lang.reflect.Modifier.STATIC;
import static net.binis.codegen.compiler.utils.ElementMethodUtils.*;

@Slf4j
public class TestAddMethodElementEnricher extends BaseEnricher {
    @Override
    public void enrich(PrototypeDescription<ClassOrInterfaceDeclaration> description) {
        var block = createBlock(createStatement(createStaticMethodInvocation("Application", "run", chainDotsString(description.getDeclaration().getNameAsString() + ".class"))));
        addMethod(description.getElement(), "main", void.class, PUBLIC | STATIC, List.of(createParameter(String[].class, "args")), block);
    }

    @Override
    public int order() {
        return 0;
    }
}
