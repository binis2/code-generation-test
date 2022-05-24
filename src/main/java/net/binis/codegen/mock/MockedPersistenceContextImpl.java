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

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.LongSupplier;

import static java.util.Objects.nonNull;
import static org.junit.Assert.assertEquals;

@Builder
public class MockedPersistenceContextImpl implements MockedPersistenceContext {

    private Object obj;
    private MockEntityManager em;
    private MockPersistenceOperation operation;

    public MockedPersistenceContext called(LongSupplier times) {
        var expected = times.getAsLong();
        var actual = 0L;
        if (nonNull(obj)) {
            actual = em.calls(operation, obj);
        } else {
            actual = em.calls(operation);
        }
        assertEquals(expected, actual);
        return this;
    }

    @Override
    public MockedPersistenceContext on(Consumer<Object> consumer) {
        em.onOperation(operation, obj, (op, ob) -> consumer.accept(ob));
        return this;
    }

    @Override
    public MockedPersistenceContext on(Runnable task) {
        em.onOperation(operation, obj, (op, ob) -> task.run());
        return this;
    }

    @Override
    public MockedPersistenceContext on(BiConsumer<MockPersistenceOperation, Object> consumer) {
        em.onOperation(operation, obj, consumer);
        return this;
    }

}
