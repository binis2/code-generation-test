/*Generated code by Binis' code generator.*/
package codegen.map;

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

import net.binis.codegen.modifier.BaseModifier;
import net.binis.codegen.creator.EntityCreatorModifier;
import net.binis.codegen.annotation.Default;
import javax.annotation.processing.Generated;

@Generated(value = "TestMap2Prototype", comments = "TestMap2Impl")
@Default("codegen.map.TestMap2Impl")
public interface TestMap2 {

    // region starters
    @SuppressWarnings(value = "unchecked")
    static TestMap2.Modify create() {
        return (TestMap2.Modify) EntityCreatorModifier.create(TestMap2.class).with();
    }
    // endregion

    Integer getInt1();
    int getInt2();
    long getLong1();
    String getString1();
    String getConvert1();

    TestMap2.Modify with();

    // region inner classes
    interface Fields<T> {
        T int1(Integer int1);
        T int2(int int2);
        T long1(long long1);
        T string1(String string1);
        T convert1(String convert1);
    }

    interface Modify extends TestMap2.Fields<TestMap2.Modify>, BaseModifier<TestMap2.Modify, TestMap2> {
    }
    // endregion
}
