package codegen;

import net.binis.codegen.test.BaseCodeGenElementTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ElementFindTest extends BaseCodeGenElementTest {

    @Test
    void testDeepFind() {
        var cls = testSingle("find/deep1.java", "net.binis.codegen.test.TestDeep");
        assertNotNull(cls);
        for (var method : cls.getDeclaredMethods()) {
            for (var param : method.getParameters()) {
                assertEquals(0, param.getAnnotations().length);
            }
        }
    }

}
