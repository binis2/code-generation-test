package codegen.compiled;

import net.binis.codegen.test.BaseTest;
import org.junit.jupiter.api.Test;

public class BasicCompiledTest extends BaseTest {

    @Test
    public void test() {
        testSingle("compiled/compiled.java", "compiled/compiled-0.java", "compiled/compiled-1.java", 2);
    }

}
