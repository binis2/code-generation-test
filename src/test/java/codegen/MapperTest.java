package codegen;

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

import codegen.map.TestMap;
import codegen.map.TestMap2;
import net.binis.codegen.config.DefaultMappings;
import net.binis.codegen.map.Mapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapperTest {

    @BeforeAll
    static void init() {
        DefaultMappings.initialize();
    }

    @Test
    void testSame() {
        var test = TestMap.create()
                .string1("test")
                .long1(1L)
                .int1(2)
                .done();
        var resultTest = Mapper.map(test, TestMap.class);
        assertNotSame(test, resultTest);
        assertEquals(test.getString1(), resultTest.getString1());
        assertEquals(test.getLong1(), resultTest.getLong1());
        assertEquals(test.getInt1(), resultTest.getInt1());
        assertFalse(resultTest.isConvert1());
    }

    @Test
    void testDifferent() {
        var test = TestMap.create()
                .string1("test")
                .long1(1L)
                .int1(2)
                .convert1(true)
                .done();
        var resultTest = Mapper.map(test, TestMap2.create().done());
        assertEquals(test.getString1(), resultTest.getString1());
        assertEquals((long) test.getLong1(), resultTest.getLong1());
        assertEquals(test.getInt1(), (int) resultTest.getInt1());
        assertNull(test.getInt2());
        assertEquals(0, resultTest.getInt2());
        assertEquals("true", resultTest.getConvert1());
    }

    @Test
    void testMap() {
        var test = TestMap.create()
                .string1("test")
                .long1(1L)
                .int1(2)
                .done();
        var resultTest = TestMap2.create()._map(test).done();
        assertEquals(test.getString1(), resultTest.getString1());
        assertEquals((long) test.getLong1(), resultTest.getLong1());
        assertEquals(test.getInt1(), (int) resultTest.getInt1());
        assertNull(test.getInt2());
        assertEquals(0, resultTest.getInt2());
    }

}
