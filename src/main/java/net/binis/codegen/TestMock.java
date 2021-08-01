/*Generated code by Binis' code generator.*/
package net.binis.codegen;

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

import net.binis.codegen.creator.EntityCreatorModifier;
import java.util.function.Function;

public interface TestMock {

    static TestMock.Modify create() {
        return (TestMock.Modify) EntityCreatorModifier.create(TestMock.class).with();
    }

    String getActionLink();

    String getButtonText();

    String getCode();

    String getDescription();

    String getName();

    void setActionLink(String actionLink);

    void setButtonText(String buttonText);

    void setCode(String code);

    void setDescription(String description);

    void setName(String name);

    TestMock.Modify with();

    interface Fields<T> {

        T actionLink(String actionLink);

        T buttonText(String buttonText);

        T code(String code);

        T description(String description);

        T name(String name);
    }

    interface Modify extends TestMock.Fields<TestMock.Modify> {

        TestMock delete();

        TestMock done();

        TestMock merge();

        TestMock refresh();

        TestMock save();

        TestMock saveAndFlush();

        TestMock transaction(Function<TestMock.Modify, TestMock> function);
    }
}
