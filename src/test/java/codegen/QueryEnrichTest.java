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
import net.binis.codegen.generation.core.Helpers;
import net.binis.codegen.test.BaseTest;
import org.apache.commons.lang3.tuple.Triple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static net.binis.codegen.mock.CodeGenMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueryEnrichTest extends BaseTest {

    @BeforeEach
    public void cleanUp() {
        Helpers.cleanUp();
    }

    @Test
    public void enrichQuery() {
        //testSingle("enrich/enrichQuery.java", "enrich/enrichQuery-0.java", "enrich/enrichQuery-1.java");
        testMulti(List.of(
                Triple.of("enrich/enrichQuerySub.java", "enrich/enrichQuerySub-0.java", "enrich/enrichQuerySub-1.java"),
                Triple.of("enrich/enrichQuery.java", "enrich/enrichQuery-0.java", "enrich/enrichQuery-1.java")
        ), "./src/main/java/net/binis/codegen");
    }

    @Test
    public void enrichQueryModifier() {
        testMulti(List.of(
                Triple.of("enrich/enrichQueryModifySub.java", "enrich/enrichQueryModifySub-0.java", "enrich/enrichQueryModifySub-1.java"),
                Triple.of("enrich/enrichQueryModify.java", "enrich/enrichQueryModify-0.java", "enrich/enrichQueryModify-1.java")
        ));
    }


    @Test
    public void enrichQueryTest() {
        mockContext();
        mockCreate(TestImpl.class);
        mockCreate(SubImpl.class);

        mockCreate(TestModifyImpl.class);
        mockCreate(SubModifyImpl.class);

        checkQuery("from net.binis.codegen.Sub u where (u.subAmount = ?1)", List.of(5.9),
                () -> net.binis.codegen.Sub.find().by().subAmount(5.9).get());

        checkQuery("from net.binis.codegen.Test u where (u.parent.parent.parent.title = ?1)", List.of("asd"),
                () -> net.binis.codegen.Test.find().by().parent().parent().parent().title().equal("asd").get());

        checkQuery("from net.binis.codegen.Test u where (u.title = ?1)", List.of("asd"),
                () -> net.binis.codegen.Test.find().by().title("asd").get());

        checkQuery("from net.binis.codegen.Test u where (u.title = ?1) order by  u.title", List.of("asd"),
                () -> net.binis.codegen.Test.find().by().title("asd").order().title().get());

        checkQuery("from net.binis.codegen.Test u where (u.title = ?1) order by  u.title asc", List.of("asd"),
                () -> net.binis.codegen.Test.find().by().title("asd").order().title().asc().get());

        checkQuery("from net.binis.codegen.Test u where (u.title = ?1) order by  u.title asc, u.title desc", List.of("asd"),
                () -> net.binis.codegen.Test.find().by().title("asd").order().title().asc().title().desc().get());

        checkQuery("from net.binis.codegen.Test u  order by  u.title", Collections.emptyList(),
                () -> net.binis.codegen.Test.find().by().order().title().get());

        checkQuery("from net.binis.codegen.Test u  order by  u.title asc, u.amount desc", Collections.emptyList(),
                () -> net.binis.codegen.Test.find().by().order().title().asc().amount().desc().get());

        checkQuery("from net.binis.codegen.Test u where not  (u.title like ?1)", List.of("%asd"),
                () -> net.binis.codegen.Test.find().by().not().title().like("%asd").get());

        checkQuery("select count(*) from net.binis.codegen.Test u ", Collections.emptyList(), 0L,
                () -> net.binis.codegen.Test.find().by().count());

        checkQuery("from net.binis.codegen.Test u where (u.parent.title = ?1)", List.of("asd"),
                () -> net.binis.codegen.Test.find().by().parent().title("asd").get());

        checkQuery("from net.binis.codegen.Test u where (u.parent.title = ?1) or  (u.title = ?2)", List.of("asd", "asd"),
                () -> net.binis.codegen.Test.find().by().parent().title("asd").or().title().equal("asd").get());

        checkQuery("from net.binis.codegen.Test u where (u.sub.subtitle = ?1)", List.of("asd"),
                () -> net.binis.codegen.Test.find().by().sub().subtitle("asd").get());

        checkQuery("from net.binis.codegen.Test u where (u.parent.sub.subtitle = ?1)", List.of("asd"),
                () -> net.binis.codegen.Test.find().by().parent().sub().subtitle("asd").get());

        checkQuery("from net.binis.codegen.Test u where (u.parent.parent.sub.subtitle = ?1)", List.of("asd"),
                () -> net.binis.codegen.Test.find().by().parent().parent().sub().subtitle().equal("asd").get());

        checkQuery("from net.binis.codegen.Test u where (u.parent is null)", Collections.emptyList(),
                () -> net.binis.codegen.Test.find().by().parent(null).get());

        checkQuery("from net.binis.codegen.Test u where (lower(u.title) like ?1)", List.of("%asd"),
                () -> net.binis.codegen.Test.find().by().lower().title().like("%asd").get());

        checkQuery("from net.binis.codegen.Test u where (lower(u.title) = ?1)", List.of("asd"),
                () -> net.binis.codegen.Test.find().by().lower().title("asd").get());

        checkQuery("from net.binis.codegen.Test u where (lower(u.parent.parent.title) = ?1)", List.of("asd"),
                () -> net.binis.codegen.Test.find().by().lower().parent().parent().title("asd").get());

        checkQuery("from net.binis.codegen.Test u where (substr(u.parent.parent.title, ?1) = ?2)", List.of(5, "asd"),
                () -> net.binis.codegen.Test.find().by().substring(5).parent().parent().title("asd").get());

        checkQuery("from net.binis.codegen.Test u where (substr(u.parent.parent.title, ?1, ?2) = ?3)", List.of(5, 10, "asd"),
                () -> net.binis.codegen.Test.find().by().substring(5, 10).parent().parent().title("asd").get());

        checkQuery("from net.binis.codegen.Test u where (trim(u.parent.parent.title) = ?1)", List.of("asd"),
                () -> net.binis.codegen.Test.find().by().trim().parent().parent().title("asd").get());

        checkQuery("from net.binis.codegen.Test u where (replace(u.parent.parent.title, ?1, ?2) = ?3)", List.of("some", "someother", "asd"),
                () -> net.binis.codegen.Test.find().by().replace("some", "someother").parent().parent().title("asd").get());

        checkQuery("from net.binis.codegen.Test u where (length(u.parent.parent.title) > ?1)", List.of(5L),
                () -> net.binis.codegen.Test.find().by().parent().parent().title().length().greater(5L).get());

        checkQuery("delete from net.binis.codegen.Test u where (length(u.parent.parent.title) > ?1)", List.of(5L),
                () -> net.binis.codegen.Test.find().by().parent().parent().title().length().greater(5L).delete());

        checkQuery("from net.binis.codegen.Test u where (title = ?1)", List.of("asd"),
                () -> net.binis.codegen.Test.find().query("from net.binis.codegen.Test u where (title = ?1)").params(List.of("asd")).get());

        checkQuery("from net.binis.codegen.Test u where (title = ?1)", List.of("asd"),
                () -> net.binis.codegen.Test.find().query("from net.binis.codegen.Test u where (title = ?1)").param("asd").get());

        checkQuery("from net.binis.codegen.Test u  order by  title ", Collections.emptyList(),
                () -> net.binis.codegen.Test.find().by().order().script("title").get());

        checkQuery("from net.binis.codegen.Test u where length(title) > 5  and  (u.amount > 10)  order by  title ", Collections.emptyList(),
                () -> net.binis.codegen.Test.find().by().script("length(title) > 5").and().amount().script("> 10").order().script("title").get());

        checkQuery("from net.binis.codegen.Test u where (u.amount = ?1) and  (length(u.parent.parent.title) > ?2)", List.of(5.0, 5L),
                () -> net.binis.codegen.Test.find().by(true, query -> query.amount(5).and()).parent().parent().title().length().greater(5L).get());

        checkQuery("from net.binis.codegen.Test u where (length(u.parent.parent.title) > ?1)", List.of(5L),
                () -> net.binis.codegen.Test.find().by(false, query -> query.amount(5).and()).parent().parent().title().length().greater(5L).get());

        checkQuery("from net.binis.codegen.Test u where (length(u.parent.parent.title) > ?1) and  (u.amount = ?2)", List.of(5L, 5.0),
                () -> net.binis.codegen.Test.find().by().parent().parent().title().length().greater(5L)
                        ._if(true, query -> query.and().amount(5))
                        ._else(query -> query.and().amount(6))
                        .get());

        checkQuery("from net.binis.codegen.Test u where (length(u.parent.parent.title) > ?1) and  (u.amount = ?2)", List.of(5L, 6.0),
                () -> net.binis.codegen.Test.find().by().parent().parent().title().length().greater(5L)._if(false, query -> query.and().amount(5))._else(query -> query.and().amount(6)).get());

        checkQuery("select avg(u.subAmount) from net.binis.codegen.Sub u where (u.subAmount = ?1)", List.of(5.0),
                () -> net.binis.codegen.Sub.find().aggregate().avg().subAmount().where().subAmount(5).get());

        checkQuery("from net.binis.codegen.Test u where (?1 member of u.items) and  (?2 not member of u.items) and  (u.items is not empty) and  (u.items is empty)", List.of(5L, 6L),
                () -> net.binis.codegen.Test.find().by().items().contains(5L).and().items().notContains(6L).and().items().isNotEmpty().and().items().isEmpty().get());

        checkQuery("from net.binis.codegen.Test u where (?1 member of u.items)", List.of(5L),
                () -> net.binis.codegen.Test.find().by().items().contains(5L).get());

        checkQuery("from net.binis.codegen.Test u ", Collections.emptyList(),
                () -> net.binis.codegen.Test.find().by().title().in(Collections.emptyList()).get());

        checkQuery("from net.binis.codegen.Test u where (u.amount = ?1) ", List.of(5.0),
                () -> net.binis.codegen.Test.find().by().amount(5.0).and().title().in(Collections.emptyList()).get());

        checkQuery("from net.binis.codegen.Test u where (u.amount = ?1)", List.of(5.0),
                () -> net.binis.codegen.Test.find().by().title().in(Collections.emptyList()).and().amount(5.0).get());

        checkQuery("from net.binis.codegen.Test u where  (u.amount = ?1) and  (u.sub.subAmount = ?2)", List.of(5.0, 6.0),
                () -> net.binis.codegen.Test.find().by().not().title().in(Collections.emptyList()).and().amount(5.0).and().sub().subAmount(6.0).get());

        checkQuery("from net.binis.codegen.Test u where (u.sub.subAmount = ?1) and   (u.amount = ?2) and  (u.sub.subAmount = ?3)", List.of(6.0, 5.0, 6.0),
                () -> net.binis.codegen.Test.find().by().sub().subAmount(6.0).and().not().title().in(Collections.emptyList()).and().amount(5.0).and().sub().subAmount(6.0).get());


        checkQuery("select u, sum(j0.subAmount),count(j1.subtitle) from net.binis.codegen.TestModify u join u.subs j0 join u.subs j1 where (j0.subtitle is null)  and  (j1.subAmount is null)  or  (u.amount is not null) group by u  order by sum(j0.subAmount) asc,count(j1.subtitle) desc, u.title", Collections.emptyList(),
                () -> TestModify.find().by().subs()
                        .join(j -> j.sum().subAmount().where().subtitle().isNull().order().subAmount().asc())
                        .and().subs().join(j -> j.cnt().subtitle().where().subAmount().isNull().order().subtitle().desc())
                        .or().amount().isNotNull()
                        .order().title()
                        .get());

        checkQuery("select u, sum(j0.subAmount),count(j0.subtitle) from net.binis.codegen.TestModify u join u.subs j0 where (j0.subtitle is null)  group by u  order by sum(j0.subAmount) asc,count(j0.subtitle) desc, u.title", Collections.emptyList(),
                () -> TestModify.find().by().subs()
                        .join(j -> j.sum().subAmount().and().cnt().subtitle().where().subtitle().isNull().order().subAmount().asc().subtitle().desc())
                        .order().title()
                        .get());

        checkQuery("from net.binis.codegen.TestModify u join u.subs j0 where (j0.subtitle is null)  order by  u.title", Collections.emptyList(),
                () -> TestModify.find().by().subs()
                        .join(j -> j.where().subtitle().isNull())
                        .order().title()
                        .get());

        checkQuery("from net.binis.codegen.TestModify u join u.subs j0 where (j0.subtitle = ?1)  and  (u.amount = ?2) order by  u.title", List.of("test", 5.0),
                () -> TestModify.find().by().subs()
                        .join(j -> j.where().subtitle("test"))
                        .and().amount(5.0)
                        .order().title()
                        .get());


        checkQuery("from net.binis.codegen.TestModify u join fetch u.subs j0  order by  u.title", Collections.emptyList(),
                () -> TestModify.find().by().subs()
                        .joinFetch()
                        .order().title()
                        .get());

        checkQuery("from net.binis.codegen.TestModify u join fetch u.subs j0 where (u.amount is not null)  order by  u.title", Collections.emptyList(),
                () -> TestModify.find().by()
                        .amount().isNotNull().and()
                        .subs().joinFetch()
                        .order().title()
                        .get());

        var sub = new SubModifyImpl();
        checkQuery("from net.binis.codegen.TestModify u where (u.amount is not null) and  (?1 member of u.subs)", List.of(sub),
                () -> TestModify.find().by()
                        .amount().isNotNull().and()
                        .subs().contains(sub)
                        .get());

     }

     private void checkQuery(String expected, List<Object> params, Runnable query) {
         checkQuery(expected, params, null, query);
     }

    private void checkQuery(String expected, List<Object> params, Object result, Runnable query) {
        mockQueryProcessor((q, p) -> {
            assertEquals(expected, q);
            assertEquals(params.size(), p.size());
            for (int i = 0; i < params.size(); i++) {
                assertEquals(params.get(i), p.get(i));
            }
            return result;
        });
        query.run();
    }

}
