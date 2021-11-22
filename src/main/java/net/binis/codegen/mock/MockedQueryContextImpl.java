package net.binis.codegen.mock;

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

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Singular;

import java.util.List;
import java.util.function.LongSupplier;

@Builder
class MockedQueryContextImpl {

    @Getter
    private String query;

    @Getter
    @Singular
    private List<MockedQueryParams> mocks;

    @Data
    @Builder
    static class MockedQueryParams implements MockedQueryContext {
        private MockedQueryContextImpl parent;
        private List<Object> params;
        private Object returnObject;
        @Builder.Default
        private int match = 0;
        @Builder.Default
        private int expected = 1;
        @Builder.Default
        private boolean fails = true;


        void touch() {
            match++;
        }

        void withParent(MockedQueryContextImpl parent) {
            this.parent = parent;
        }

        @Override
        public String getQuery() {
            return parent.getQuery();
        }

        @Override
        public MockedQueryContext called(LongSupplier times) {
            expected = Math.toIntExact(times.getAsLong());
            return this;
        }

        @Override
        public MockedQueryContext fails(boolean fails) {
            this.fails = fails;
            return this;
        }
    }

}
