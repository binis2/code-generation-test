package codegen;

import net.binis.codegen.TestMock;
import net.binis.codegen.TestMockEntity;
import org.junit.Test;

import static net.binis.codegen.mock.CodeGenMock.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestMockFunctions {

    @Test
    public void test() {
        mockContextAndEntityManager();
        mockCreate(TestMockEntity.class);

        assertNotNull(TestMock.create().save().with().merge());
    }
}
