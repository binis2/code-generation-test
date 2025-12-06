package net.binis.codegen.mock;

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
