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

@Generated(value = "TestMapPrototype", comments = "TestMapImpl")
@Default("codegen.map.TestMapImpl")
public interface TestMap {

    // region starters
    @SuppressWarnings(value = "unchecked")
    static TestMap.Modify create() {
        return (TestMap.Modify) EntityCreatorModifier.create(TestMap.class).with();
    }
    // endregion

    int getInt1();
    Integer getInt2();
    Long getLong1();
    String getString1();

    boolean isConvert1();

    TestMap.Modify with();

    // region inner classes
    interface Fields<T> {
        T int1(int int1);
        T int2(Integer int2);
        T long1(Long long1);
        T string1(String string1);
        T convert1(boolean convert1);
    }

    interface Modify extends TestMap.Fields<TestMap.Modify>, BaseModifier<TestMap.Modify, TestMap> {
    }
    // endregion
}
