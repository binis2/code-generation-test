package codegen;

import net.binis.codegen.annotation.DummyAnnotation;
import net.binis.codegen.annotation.TestElementAnnotation;
import net.binis.codegen.generation.core.Structures;
import net.binis.codegen.test.BaseCodeGenElementTest;
import net.binis.codegen.tools.Reflection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ElementsTest extends BaseCodeGenElementTest {

    @BeforeAll
    public static void setup() {
        Structures.registerTemplate(TestElementAnnotation.class);
    }

    @Test
    void testSimple() {
        var loader = testSingle("elements/element1.java");
        var cls = loader.findClass("net.binis.codegen.TestElement");
        assertNotNull(cls);
        var field = Reflection.findField(cls, "id");
        assertNotNull(field);
        assertEquals(1, field.getAnnotations().length);
        assertEquals(DummyAnnotation.class, field.getAnnotations()[0].annotationType());
        var method = Reflection.findMethod("getId", cls);
        assertNotNull(method);
        assertEquals(1, method.getAnnotations().length);
        assertEquals(DummyAnnotation.class, method.getAnnotations()[0].annotationType());
    }


}
