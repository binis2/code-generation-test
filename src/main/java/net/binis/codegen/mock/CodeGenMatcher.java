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

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.time.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import static java.util.Objects.nonNull;

public class CodeGenMatcher {

    private static final Long LONG_VALUE = Long.MAX_VALUE;
    private static final Integer INT_VALUE = Integer.MAX_VALUE;
    private static final Double DOUBLE_VALUE = Double.MAX_VALUE;
    private static final Float FLOAT_VALUE = Float.MAX_VALUE;
    private static final String STRING_VALUE = "Binis.CodeGen.mocked.String";

    private static ThreadLocal<Queue<Class<?>>> mocks = ThreadLocal.withInitial(LinkedBlockingQueue::new);
    private static final Map<Class, Object> valueMap = initMap();

    private static Map<Class, Object> initMap() {
        var result = new HashMap<Class, Object>();
        var instant = Instant.ofEpochMilli(INT_VALUE);
        result.put(String.class, STRING_VALUE);
        result.put(Long.class, LONG_VALUE);
        result.put(Integer.class, INT_VALUE);
        result.put(Double.class, DOUBLE_VALUE);
        result.put(Float.class, FLOAT_VALUE);
        result.put(LocalDate.class, LocalDate.ofInstant(instant, ZoneOffset.UTC));
        result.put(LocalDateTime.class, LocalDateTime.ofInstant(instant, ZoneOffset.UTC));
        result.put(OffsetDateTime.class, instant.atOffset(ZoneOffset.UTC));
        result.put(ZonedDateTime.class, instant.atZone(ZoneOffset.UTC));
        return result;
    }

    public static String anyString() {
        mocks.get().add(String.class);
        return STRING_VALUE;
    }

    public static Long anyLong() {
        mocks.get().add(Long.class);
        return LONG_VALUE;
    }

    public static Integer anyInt() {
        mocks.get().add(Integer.class);
        return INT_VALUE;
    }

    public static Double anyDouble() {
        mocks.get().add(Double.class);
        return DOUBLE_VALUE;
    }

    public static Float anyFloat() {
        mocks.get().add(Float.class);
        return FLOAT_VALUE;
    }

    public static LocalDate anyLocalDate() {
        mocks.get().add(LocalDate.class);
        return (LocalDate) valueMap.get(LocalDate.class);
    }

    public static LocalDateTime anyLocalDateTime() {
        mocks.get().add(LocalDateTime.class);
        return (LocalDateTime) valueMap.get(LocalDateTime.class);
    }

    public static OffsetDateTime anyOffsetDateTime() {
        mocks.get().add(OffsetDateTime.class);
        return (OffsetDateTime) valueMap.get(OffsetDateTime.class);
    }

    public static ZonedDateTime anyZonedDateTime() {
        mocks.get().add(ZonedDateTime.class);
        return (ZonedDateTime) valueMap.get(ZonedDateTime.class);
    }

    public static <T> T any() {
        mocks.get().add(CodeGenMatcher.class);
        return null;
    }

    public <T> boolean checkArgument(T value) {
        var next = mocks.get().peek();
        if (nonNull(value)) {
            var val = valueMap.get(value.getClass());
            if (value.getClass().equals(next) && nonNull(val) && value.equals(val)) {
                mocks.get().poll();
                return true;
            }
        } else {
            if (nonNull(next) && CodeGenMatcher.class.isAssignableFrom(next)) {
                mocks.get().poll();
                return true;
            }
        }
        return false;
    }

    public void clearContext() {
        mocks.get().clear();
    }

    private static final class MockProxy implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return null;
        }

    }

}
