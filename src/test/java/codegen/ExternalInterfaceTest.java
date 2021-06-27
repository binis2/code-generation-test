package codegen;

import net.binis.codegen.generation.core.Helpers;
import net.binis.codegen.test.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExternalInterfaceTest extends BaseTest {

    @BeforeEach
    public void cleanUp() {
        Helpers.cleanUp();
    }

    @Test
    public void test() {
        testSingle("external/external.java", "external/external-0.java", "external/external-1.java");
    }

    @Test
    public void testModifier() {
        testSingle("external/externalModifier.java", "external/externalModifier-0.java", "external/externalModifier-1.java");
    }


}
