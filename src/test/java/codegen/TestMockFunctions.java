package codegen;

import net.binis.codegen.TestMock;
import net.binis.codegen.TestMockEntity;
import net.binis.codegen.TestModify;
import net.binis.codegen.TestModifyImpl;
import net.binis.codegen.mock.exception.QueryNotMockedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static net.binis.codegen.mock.CodeGenMock.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class TestMockFunctions {

    @BeforeEach
    public void setUp() {
        mockContextAndEntityManager();
    }

    @Test
    public void test() {
        mockCreate(TestMockEntity.class);
        assertNotNull(TestMock.create().save().with().merge());
    }

    @Test
    public void testQuery() {
        mockCreate(TestModifyImpl.class);
        var mockObj = mock(TestModify.class);
        mockQuery(TestModify.find().by().id(5L), mockObj);
        mockQuery(TestModify.find().by().title("test"), null, mockObj);

        assertEquals(mockObj, TestModify.find().by().id(5L).get().get());
        assertThrows(QueryNotMockedException.class, () -> TestModify.find().by().id(6L).get().get());
        assertEquals(mockObj, TestModify.find().by().title("test2").get().get());
    }
}
