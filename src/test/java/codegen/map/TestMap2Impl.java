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

import net.binis.codegen.modifier.impl.BaseModifierImpl;
import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.factory.CodeFactory;
import javax.annotation.processing.Generated;

@Generated(value = "TestMap2Prototype", comments = "TestMap2")
public class TestMap2Impl implements TestMap2, Modifiable<TestMap2.Modify> {

    protected Integer int1;

    protected int int2;

    protected long long1;

    protected String string1;

    private String convert1;

    // region constructor & initializer
    {
        CodeFactory.registerType(TestMap2.class, TestMap2Impl::new, null);
    }

    public TestMap2Impl() {
    }
    // endregion

    // region getters
    public Integer getInt1() {
        return int1;
    }

    public int getInt2() {
        return int2;
    }

    public long getLong1() {
        return long1;
    }

    public String getString1() {
        return string1;
    }

    @Override
    public String getConvert1() {
        return convert1;
    }

    public TestMap2.Modify with() {
        return new TestMap2ModifyImpl(this);
    }
    // endregion

    // region inner classes
    protected class TestMap2ModifyImpl extends BaseModifierImpl<TestMap2.Modify, TestMap2> implements TestMap2.Modify {

        protected TestMap2ModifyImpl(TestMap2 parent) {
            super(parent);
        }

        public TestMap2 done() {
            return TestMap2Impl.this;
        }

        public TestMap2.Modify int1(Integer int1) {
            TestMap2Impl.this.int1 = int1;
            return this;
        }

        public TestMap2.Modify int2(int int2) {
            TestMap2Impl.this.int2 = int2;
            return this;
        }

        public TestMap2.Modify long1(long long1) {
            TestMap2Impl.this.long1 = long1;
            return this;
        }

        public TestMap2.Modify string1(String string1) {
            TestMap2Impl.this.string1 = string1;
            return this;
        }

        @Override
        public Modify convert1(String convert1) {
            TestMap2Impl.this.convert1 = convert1;
            return this;
        }
    }
    // endregion
}
