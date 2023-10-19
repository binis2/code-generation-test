package codegen;

/*-
 * #%L
 * code-generation-test
 * %%
 * Copyright (C) 2021 - 2023 Binis Belev
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

import net.binis.codegen.annotation.*;
import net.binis.codegen.generation.core.Structures;
import net.binis.codegen.test.BaseCodeGenElementTest;
import net.binis.codegen.tools.Reflection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static net.binis.codegen.tools.Reflection.findMethod;
import static net.binis.codegen.tools.Reflection.invokeStaticWithException;
import static org.junit.jupiter.api.Assertions.*;

public class ElementsTest extends BaseCodeGenElementTest {

    @BeforeAll
    public static void setup() {
        Structures.registerTemplate(TestAnnotationElementAnnotation.class);
        Structures.registerTemplate(TestAddMethodElementAnnotation.class);
        Structures.registerTemplate(TestAddMethod2ElementAnnotation.class);
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

    @Test
    void testDefaultMethodInheritance() {
        var cls = testSingle("elements/elementDefaultMethodInheritance1.java", "net.binis.codegen.prototype.CompiledWithImplementationPrototype");
        assertNotNull(cls);
        var method = Reflection.findMethod("isTestable", cls);
        assertNotNull(method);
        var ann = method.getAnnotations();
        assertEquals(1, ann.length);
        if (ann[0] instanceof CodeImplementation a) {
            assertEquals("return !this.test;", a.value());
        } else {
            fail("Annotation is not CodeImplementation");
        }

        var same = Reflection.findMethod("isSame", cls, boolean.class);
        assertNotNull(same);
        ann = same.getAnnotations();
        assertEquals(1, ann.length);
        if (ann[0] instanceof CodeImplementation a) {
            assertEquals("return bool == this.test;", a.value());
        } else {
            fail("Annotation is not CodeImplementation");
        }

        same = Reflection.findMethod("isSame", cls, cls);
        assertNotNull(same);
        ann = same.getAnnotations();
        assertEquals(1, ann.length);
        if (ann[0] instanceof CodeImplementation a) {
            assertEquals("return other.test == this.test;", a.value());
        } else {
            fail("Annotation is not CodeImplementation");
        }
    }

    @Test
    void testAddMethod() {
        var cls = testSingle("elements/elementAddMethod1.java", "net.binis.codegen.TestElement");
        assertNotNull(cls);

        var main = findMethod("main", cls, String[].class);
        assertNotNull(main);

        assertThrows(RuntimeException.class, () -> invokeStaticWithException(main, (Object) new String[] {}));
    }

    @Test
    void testAddMethod2() {
        var cls = testSingle("elements/elementAddMethod2.java", "net.binis.codegen.TestElement");
        assertNotNull(cls);

        var main = findMethod("main", cls, String[].class);
        assertNotNull(main);

        assertThrows(RuntimeException.class, () -> invokeStaticWithException(main, (Object) new String[] {}));
    }

    @Test
    void testMultiAnnotations() {
        var loader = testSingle("elements/multi1.java");
        var cls = loader.findClass("net.binis.codegen.TestElement");
        assertNotNull(cls);
        assertNotNull(Reflection.findField(cls, "log"));
        assertNotNull(Reflection.findConstructor(cls, String.class));
    }

}
