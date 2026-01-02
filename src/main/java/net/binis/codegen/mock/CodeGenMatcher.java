package net.binis.codegen.mock;

/*-
 * #%L
 * code-generation-test
 * %%
 * Copyright (C) 2021 - 2026 Binis Belev
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

import net.binis.codegen.tools.Holder;

import java.util.Arrays;
import java.util.List;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

public class CodeGenMatcher {

    static final ThreadLocal<Boolean> anyMock = ThreadLocal.withInitial(() -> false);

    private CodeGenMatcher() {
        //Do nothing
    }

    public static String anyString() {
        any(String.class);
        return "";
    }

    public static long anyLong() {
        any(Long.class);
        return 0L;
    }

    public static int anyInt() {
        any(Integer.class);
        return 0;
    }

    public static double anyDouble() {
        any(Double.class);
        return 0.0;
    }

    public static float anyFloat() {
        any(Float.class);
        return 0;
    }

    public static <T> T any() {
        anyMock.set(true);
        return null;
    }

    public static <T> T any(Class<T> cls) {
        //ToDo: match classes
        anyMock.set(true);
        return null;
    }

    @SafeVarargs
    public static <T> Supplier<T> ordered(T... list) {
        return orderedList(Arrays.asList(list));
    }

    public static <T> Supplier<T> orderedList(List<T> list) {
        var idx = Holder.of(0);
        return () -> {
            var result = list.get(idx.get());
            idx.set(idx.get() + 1);
            return result;
        };
    }

    public static LongSupplier times(int times) {
        return () -> Integer.toUnsignedLong(times);
    }

    public static LongSupplier never() {
        return () -> 0L;
    }

    public static LongSupplier once() {
        return () -> 1L;
    }

    public static LongSupplier twice() {
        return () -> 2L;
    }

    public static LongSupplier thrice() {
        return () -> 3L;
    }


}
