package net.binis.codegen.mock;

/*-
 * #%L
 * code-generation-test
 * %%
 * Copyright (C) 2021 - 2025 Binis Belev
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

import net.binis.codegen.async.AsyncExecutor;
import net.binis.codegen.async.executor.impl.AsyncExecutorImpl;
import net.binis.codegen.factory.CodeFactory;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class TestAsyncExecutor<T> extends AsyncExecutorImpl<T> {

    public static void mockExecutor() {
        CodeFactory.registerType(AsyncExecutor.class, TestAsyncExecutor::new);
    }

    @Override
    protected CompletableFuture<T> internalExecute(Supplier<T> supplier) {
        var result = super.internalExecute(supplier);
        result.join();
        return result;
    }
}
