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

import net.binis.codegen.*;
import net.binis.codegen.mock.exception.QueryNotMockedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static net.binis.codegen.mock.CodeGenMatcher.any;
import static net.binis.codegen.mock.CodeGenMatcher.anyLong;
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
        mockCreate(SubModifyImpl.class);

        var mockObj = mock(TestModify.class);
        mockQuery(TestModify.find().by().id(5L), mockObj);
        mockJustQuery(TestModify.find().by().title("test"), mockObj);
        mockQuery(TestModify.find().by().title("test").and().id(anyLong()), mockObj);
        mockQuery(TestModify.find().by().subs().contains(any()).and().id(5L), mockObj);
        mockQuery(TestModify.find().by().title(null).and().id(any()), mockObj);

        mockExistsQuery(TestModify.find().by().id(123L)
                .and().subs().join(t ->
                        t.where().id().greater(5L)), true);

        assertEquals(true, TestModify.find().by().id(123L).and().subs().join(t -> t.where().id().greater(5L)).exists());
        assertEquals(mockObj, TestModify.find().by().id(5L).get().get());
        assertThrows(QueryNotMockedException.class, () -> TestModify.find().by().id(6L).get().get());
        assertEquals(mockObj, TestModify.find().by().title("test2").get().get());
        assertEquals(mockObj, TestModify.find().by().title("test").and().id(5L).get().get());
        assertEquals(mockObj, TestModify.find().by().subs().contains(SubModify.create()).and().id(5L).get().get());
        assertEquals(mockObj, TestModify.find().by().title(null).and().id(5L).get().get());

    }

    @Test
    public void testMockContext() {
        mockContext();
    }
}
