package codegen;

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
