package codegen;

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

import net.binis.codegen.SubModify;
import net.binis.codegen.TestMock;
import net.binis.codegen.TestMockEntity;
import net.binis.codegen.TestModify;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.mock.CodeGenExtension;
import net.binis.codegen.mock.MockPersistenceOperation;
import net.binis.codegen.mock.exception.QueryAlreadyMockedException;
import net.binis.codegen.mock.exception.QueryNotMockedException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Collections;
import java.util.List;

import static net.binis.codegen.mock.CodeGenMatcher.*;
import static net.binis.codegen.mock.CodeGenMock.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(CodeGenExtension.class)
class TestMockFunctions {

    @Test
    void test() {
        assertNotNull(TestMock.create()
                .save()
                .with()
                .merge());
    }

    @Test
    void testQuery() {
        var mockObj = mock(TestModify.class);
        mockQuery(TestModify.find().by().id(5L), mockObj);
        mockJustQuery(TestModify.find().by().title("test"), mockObj);
        mockQuery(TestModify.find().by().title("test").and().id(anyLong()), mockObj);
        mockQuery(TestModify.find().by().subs().contains(any()).and().id(5L), mockObj);
        mockQuery(TestModify.find().by().title(null).and().id(any()), mockObj);

        mockExistsQuery(TestModify.find().by().id(123L)
                .and().subs().join(t ->
                        t.where().id().greater(5L)), true);

        assertTrue(TestModify.find().by().id(123L).and().subs().join(t -> t.where().id().greater(5L)).exists());
        assertEquals(mockObj, TestModify.find().by().id(5L).get().get());
        assertThrows(QueryNotMockedException.class, () -> TestModify.find().by().id(6L).get().get());
        assertEquals(mockObj, TestModify.find().by().title("test2").get().get());
        assertEquals(mockObj, TestModify.find().by().title("test").and().id(5L).get().get());
        assertEquals(mockObj, TestModify.find().by().subs().contains(SubModify.create()).and().id(5L).get().get());
        assertEquals(mockObj, TestModify.find().by().title(null).and().id(5L).get().get());
    }

    @Test
    void testMultiMock() {
        var mockObj = mock(TestModify.class);
        mockQuery(TestModify.find().by().id(5L), mockObj);

        assertThrows(QueryAlreadyMockedException.class, () -> mockQuery(TestModify.find().by().id(5L), mock(TestModify.class)));
        assertEquals(mockObj, TestModify.find().by().id(5L).get().get());
    }

    @Test
    void testMultiResponse() {
        mockCountQuery(TestModify.find().by().id(5L), orderedList(List.of(5L, 0L))).called(times(2)).fails(false);
        mockExistsQuery(TestModify.find().by().id(5L), true);

        assertEquals(5L, TestModify.find().by().id(5L).count());
        assertFalse(TestModify.find().by().id(5L).exists());
    }

    @Test
    void testPersistence() {
        var mock = TestMock.create();
        verify(MockPersistenceOperation.SAVE, mock.done()).called(never());
        verifySave(mock.save()).called(once());
        onSave(mock.done(), () -> mock.name("binis"));
        verifySave(mock.save()).called(twice());

        assertEquals("binis", mock.done().getName());
    }

    @Test
    void testContains() {
        var sub = SubModify.create();
        mockQuery(TestModify.find().by().subs().contains(any()), Collections.emptyList());

        assertTrue(TestModify.find().by().subs().contains(sub).list().isEmpty());
    }

    @Test
    void testEnvelop() {
        mockCreate(TestMockEntity.class);

        CodeFactory.envelopType(TestMock.class, f ->
                f.create().with().name("asd").done(), null);

        assertEquals("asd", TestMock.create().done().getName());
    }

}
