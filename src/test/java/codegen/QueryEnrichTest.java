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

import codegen.view.TestProjection;
import codegen.view.TestProjectionComplex;
import codegen.view.TestProjectionComplex2;
import lombok.extern.slf4j.Slf4j;
import net.binis.codegen.*;
import net.binis.codegen.generation.core.Helpers;
import net.binis.codegen.mock.CodeGenExtension;
import net.binis.codegen.test.BaseTest;
import org.apache.commons.lang3.tuple.Triple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static net.binis.codegen.mock.CodeGenMatcher.*;
import static net.binis.codegen.mock.CodeGenMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@Slf4j
@ExtendWith(CodeGenExtension.class)
class QueryEnrichTest extends BaseTest {

    @BeforeEach
    public void cleanUp() {
        Helpers.cleanUp();
    }

    @Test
    void enrichQuery() {
        testMulti(List.of(
                Triple.of("enrich/enrichQuerySub.java", "enrich/enrichQuerySub-0.java", "enrich/enrichQuerySub-1.java"),
                Triple.of("enrich/enrichQuery.java", "enrich/enrichQuery-0.java", "enrich/enrichQuery-1.java")
        ), "./src/test/java/net/binis/codegen");
    }

    @Test
    void enrichQueryId() {
        testMulti(List.of(
                Triple.of("enrich/enrichQueryBase.java", "enrich/enrichQueryBase-0.java", "enrich/enrichQueryBase-1.java"),
                Triple.of("enrich/enrichQueryId.java", "enrich/enrichQueryId-0.java", "enrich/enrichQueryId-1.java")
        ));
    }

    @Test
    void enrichQueryReserved() {
        testSingle("enrich/enrichQueryReserved.java", "enrich/enrichQueryReserved-0.java", "enrich/enrichQueryReserved-1.java");
    }

    @Test
    void enrichQueryJoinable() {
        testSingle("enrich/enrichQueryJoinable.java", "enrich/enrichQueryJoinable-0.java", "enrich/enrichQueryJoinable-1.java");
    }

    @Test
    void enrichQueryModifier() {
        testMulti(List.of(
                Triple.of("enrich/enrichQueryModifySub.java", "enrich/enrichQueryModifySub-0.java", "enrich/enrichQueryModifySub-1.java"),
                Triple.of("enrich/enrichQueryModify.java", "enrich/enrichQueryModify-0.java", "enrich/enrichQueryModify-1.java")
        ));
    }

    @Test
    void testPagination() {
        var cnt = new AtomicInteger();

        mockQuery(Sub.find().by(), orderedList(List.of(List.of(mock(Sub.class)), Collections.emptyList()))).called(twice());
        mockCountQuery(Sub.find().by(), 1L).called(never());
        Sub.find().by().paginated(1, s -> cnt.incrementAndGet());

        assertEquals(1, cnt.get());
    }

    @Test
    void testJoin() {
        checkQuery("select distinct u from net.binis.codegen.TestModify u join u.subs j0 where (j0.id = ?1) ", List.of(5L),
                () -> TestModify.find().by().subs().join(s -> s.where().id(5L)).get());
    }

    @Test
    void testSimpleProjection() {
        checkQuery("select u.amount as amount,u.title as title from net.binis.codegen.Test2 u ",
                () -> Test2.find().by(TestProjection.class).get());
    }

    @Test
    void testComplexProjection() {
        checkQuery("select u.parent.amount as parentAmount,u.parent.parent.amount as parentParentAmount,u.sub.subAmount as subSubAmount,u.sub.subtitle as subSubtitle from net.binis.codegen.Test2 u ",
                () -> Test2.find().by(TestProjectionComplex.class).get());
    }

    @Test
    void testComplexProjection2() {
        checkQuery("select u.id as id,u.parent.id as parentId,u.tag as tag,u.type as type from net.binis.codegen.SubModify u ",
                () -> SubModify.find().by(TestProjectionComplex2.class).get());
    }

    @Test
    void testAsync() {
        var job = Test2.find().asyncC(t -> log.info("Testing instantiation of AsyncDispatcher"));
        job.join();
    }

    @Test
    void enrichQueryTest() {

        checkQuery("select u as self from net.binis.codegen.Sub u ",
                () -> Sub.find().select()._self().get());

        checkQuery("select u as self from net.binis.codegen.Sub u  order by u desc",
                () -> Sub.find().select()._self().where().order()._self().desc().get());

        checkQuery("select u.parent.parent.parent as parent from net.binis.codegen.Test2 u  order by u.parent.parent.parent desc",
                () -> Test2.find().select().parent().parent().parent()._self().where().order().parent().parent().parent()._self().desc().get());

        checkQuery("select u.subAmount as subAmount from net.binis.codegen.Sub u ",
                () -> Sub.find().select().subAmount().get());

        checkQuery("select u.subAmount as subAmount,u.subtitle as subtitle from net.binis.codegen.Sub u where (u.subAmount > ?1)", List.of(5.0),
                () -> Sub.find().select().subAmount().subtitle().where().subAmount().greater(5.0).get());

        checkQuery("select u.subAmount as subAmount,u.subtitle as subtitle from net.binis.codegen.Sub u where (u.subtitle = ?1) and  (u.subAmount in (select s0.amount as amount from net.binis.codegen.Test2 s0 where (s0.title = ?2))) ", List.of("test", "asd"),
                () -> Sub.find().select().subAmount().subtitle().where().subtitle("test").and().subAmount().in(Test2.find().select().amount().where().title("asd")).get());

        checkQuery("from net.binis.codegen.Sub u where (u.subAmount = ?1)", List.of(5.9),
                () -> Sub.find().by().subAmount(5.9).get());

        checkQuery("from net.binis.codegen.Test2 u where (u.parent.parent.parent.title = ?1)", List.of("asd"),
                () -> Test2.find().by().parent().parent().parent().title().equal("asd").get());

        checkQuery("from net.binis.codegen.Test2 u where (u.title = ?1)", List.of("asd"),
                () -> Test2.find().by().title("asd").get());

        checkQuery("from net.binis.codegen.Test2 u where (u.title = ?1) order by  u.title", List.of("asd"),
                () -> Test2.find().by().title("asd").order().title().get());

        checkQuery("from net.binis.codegen.Test2 u where (u.title = ?1) order by  u.title asc", List.of("asd"),
                () -> Test2.find().by().title("asd").order().title().asc().get());

        checkQuery("from net.binis.codegen.Test2 u where (u.title = ?1) order by  u.title asc, u.title desc", List.of("asd"),
                () -> Test2.find().by().title("asd").order().title().asc().title().desc().get());

        checkQuery("from net.binis.codegen.Test2 u  order by  u.title", Collections.emptyList(),
                () -> Test2.find().by().order().title().get());

        checkQuery("from net.binis.codegen.Test2 u  order by  u.title asc, u.amount desc", Collections.emptyList(),
                () -> Test2.find().by().order().title().asc().amount().desc().get());

        checkQuery("from net.binis.codegen.Test2 u where not  (u.title like ?1)", List.of("%asd"),
                () -> Test2.find().by().not().title().like("%asd").get());

        checkQuery("select count(*) from net.binis.codegen.Test2 u ", Collections.emptyList(), 0L,
                () -> Test2.find().by().count());

        checkQuery("from net.binis.codegen.Test2 u where (u.parent.title = ?1)", List.of("asd"),
                () -> Test2.find().by().parent().title("asd").get());

        checkQuery("from net.binis.codegen.Test2 u where (u.parent.title = ?1) or  (u.title = ?2)", List.of("asd", "asd"),
                () -> Test2.find().by().parent().title("asd").or().title().equal("asd").get());

        checkQuery("from net.binis.codegen.Test2 u where (u.sub.subtitle = ?1)", List.of("asd"),
                () -> Test2.find().by().sub().subtitle("asd").get());

        checkQuery("from net.binis.codegen.Test2 u where (u.parent.sub.subtitle = ?1)", List.of("asd"),
                () -> Test2.find().by().parent().sub().subtitle("asd").get());

        checkQuery("from net.binis.codegen.Test2 u where (u.parent.parent.sub.subtitle = ?1)", List.of("asd"),
                () -> Test2.find().by().parent().parent().sub().subtitle().equal("asd").get());

        checkQuery("from net.binis.codegen.Test2 u where (u.parent is null)", Collections.emptyList(),
                () -> Test2.find().by().parent(null).get());

        checkQuery("from net.binis.codegen.Test2 u where (lower(u.title) like ?1)", List.of("%asd"),
                () -> Test2.find().by().lower().title().like("%asd").get());

        checkQuery("from net.binis.codegen.Test2 u where (lower(u.title) = ?1)", List.of("asd"),
                () -> Test2.find().by().lower().title("asd").get());

        checkQuery("from net.binis.codegen.Test2 u where (lower(u.parent.parent.title) = ?1)", List.of("asd"),
                () -> Test2.find().by().lower().parent().parent().title("asd").get());

        checkQuery("from net.binis.codegen.Test2 u where (substr(u.parent.parent.title, ?1) = ?2)", List.of(5, "asd"),
                () -> Test2.find().by().substring(5).parent().parent().title("asd").get());

        checkQuery("from net.binis.codegen.Test2 u where (substr(u.parent.parent.title, ?1, ?2) = ?3)", List.of(5, 10, "asd"),
                () -> Test2.find().by().substring(5, 10).parent().parent().title("asd").get());

        checkQuery("from net.binis.codegen.Test2 u where (trim(u.parent.parent.title) = ?1)", List.of("asd"),
                () -> Test2.find().by().trim().parent().parent().title("asd").get());

        checkQuery("from net.binis.codegen.Test2 u where (replace(u.parent.parent.title, ?1, ?2) = ?3)", List.of("some", "someother", "asd"),
                () -> Test2.find().by().replace("some", "someother").parent().parent().title("asd").get());

        checkQuery("from net.binis.codegen.Test2 u where (length(u.parent.parent.title) > ?1)", List.of(5L),
                () -> Test2.find().by().parent().parent().title().length().greater(5L).get());

        checkQuery("delete from net.binis.codegen.Test2 u where (length(u.parent.parent.title) > ?1)", List.of(5L),
                () -> Test2.find().by().parent().parent().title().length().greater(5L).delete());

        checkQuery("from net.binis.codegen.Test2 u where (title = ?1)", List.of("asd"),
                () -> Test2.find().query("from net.binis.codegen.Test2 u where (title = ?1)").params(List.of("asd")).get());

        checkQuery("from net.binis.codegen.Test2 u where (title = ?1)", List.of("asd"),
                () -> Test2.find().query("from net.binis.codegen.Test2 u where (title = ?1)").param("asd").get());

        checkQuery("from net.binis.codegen.Test2 u  order by  title ", Collections.emptyList(),
                () -> Test2.find().by().order().script("title").get());

        checkQuery("from net.binis.codegen.Test2 u where length(title) > 5  and  (u.amount > 10)  order by  title ", Collections.emptyList(),
                () -> Test2.find().by().script("length(title) > 5").and().amount().script("> 10").order().script("title").get());

        checkQuery("from net.binis.codegen.Test2 u where (u.amount = ?1) and  length(title) > 5  order by  title ", List.of(5.0),
                () -> Test2.find().by().amount(5.0).and().script("length(title) > 5").order().script("title").get());

        checkQuery("from net.binis.codegen.Test2 u where (u.amount between ?1 and ?2)", List.of(5.0, 6.0),
                () -> Test2.find().by().amount().between(5.0, 6.0).get());

        checkQuery("from net.binis.codegen.Test2 u where (u.amount = ?1) and  (length(u.parent.parent.title) > ?2)", List.of(5.0, 5L),
                () -> Test2.find().by(true, query -> query.amount(5).and()).parent().parent().title().length().greater(5L).get());

        checkQuery("from net.binis.codegen.Test2 u where (length(u.parent.parent.title) > ?1)", List.of(5L),
                () -> Test2.find().by(false, query -> query.amount(5).and()).parent().parent().title().length().greater(5L).get());

        checkQuery("from net.binis.codegen.Test2 u where (length(u.parent.parent.title) > ?1) and  (u.amount = ?2)", List.of(5L, 5.0),
                () -> Test2.find().by().parent().parent().title().length().greater(5L)
                        ._if(true, query -> query.and().amount(5))
                        ._else(query -> query.and().amount(6))
                        .get());

        checkQuery("from net.binis.codegen.Test2 u where (length(u.parent.parent.title) > ?1) and  (u.amount = ?2)", List.of(5L, 6.0),
                () -> Test2.find().by().parent().parent().title().length().greater(5L)._if(false, query -> query.and().amount(5))._else(query -> query.and().amount(6)).get());

        checkQuery("select avg(u.subAmount) from net.binis.codegen.Sub u where (u.subAmount = ?1)", List.of(5.0),
                () -> Sub.find().aggregate().avg().subAmount().where().subAmount(5).get());

        checkQuery("from net.binis.codegen.Test2 u where (?1 member of u.items) and  (?2 not member of u.items) and  (u.items is not empty) and  (u.items is empty)", List.of(5L, 6L),
                () -> Test2.find().by().items().contains(5L).and().items().notContains(6L).and().items().isNotEmpty().and().items().isEmpty().get());

        checkQuery("from net.binis.codegen.Test2 u where (?1 member of u.items)", List.of(5L),
                () -> Test2.find().by().items().contains(5L).get());

        checkQuery("from net.binis.codegen.Test2 u where (0 <> 0) ", Collections.emptyList(),
                () -> Test2.find().by().title().in(Collections.emptyList()).get());

        checkQuery("from net.binis.codegen.Test2 u where (u.amount = ?1) and  (0 <> 0) ", List.of(5.0),
                () -> Test2.find().by().amount(5.0).and().title().in(Collections.emptyList()).get());

        checkQuery("from net.binis.codegen.Test2 u where (0 <> 0)  and  (u.amount = ?1)", List.of(5.0),
                () -> Test2.find().by().title().in(Collections.emptyList()).and().amount(5.0).get());

        checkQuery("from net.binis.codegen.Test2 u where not  (0 <> 0)  and  (u.amount = ?1) and  (u.sub.subAmount = ?2)", List.of(5.0, 6.0),
                () -> Test2.find().by().not().title().in(Collections.emptyList()).and().amount(5.0).and().sub().subAmount(6.0).get());

        checkQuery("from net.binis.codegen.Test2 u where (0 <> 0)  and  (u.amount = ?1) and  (u.sub.subAmount = ?2)", List.of(5.0, 6.0),
                () -> Test2.find().by().title().in(Collections.emptyList()).and().amount(5.0).and().sub().subAmount(6.0).get());

        checkQuery("from net.binis.codegen.Test2 u where (u.sub.subAmount = ?1) and  not  (0 <> 0)  or  (u.amount = ?2) and  (u.sub.subAmount = ?3)", List.of(6.0, 5.0, 6.0),
                () -> Test2.find().by().sub().subAmount(6.0).and().not().title().in(Collections.emptyList()).or().amount(5.0).and().sub().subAmount(6.0).get());

        checkQuery("from net.binis.codegen.Test2 u where (u.sub.subAmount = ?1) and  (0 <> 0)  or  (u.amount = ?2) and  (u.sub.subAmount = ?3)", List.of(6.0, 5.0, 6.0),
                () -> Test2.find().by().sub().subAmount(6.0).and().title().in(Collections.emptyList()).or().amount(5.0).and().sub().subAmount(6.0).get());

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

        checkQuery("select distinct u from net.binis.codegen.TestModify u join u.subs j0 where (j0.subtitle is null)  order by  u.title", Collections.emptyList(),
                () -> TestModify.find().by().subs()
                        .join(j -> j.where().subtitle().isNull())
                        .order().title()
                        .get());

        checkQuery("select distinct u from net.binis.codegen.TestModify u left join u.subs j0 where (j0.subtitle is null)  order by  u.title", Collections.emptyList(),
                () -> TestModify.find().by().subs()
                        .leftJoin(j -> j.where().subtitle().isNull())
                        .order().title()
                        .get());

        checkQuery("select distinct u from net.binis.codegen.TestModify u join u.subs j0 where (j0.subtitle = ?1)  and  (u.amount = ?2) order by  u.title", List.of("test", 5.0),
                () -> TestModify.find().by().subs()
                        .join(j -> j.where().subtitle("test"))
                        .and().amount(5.0)
                        .order().title()
                        .get());


        checkQuery("select u from net.binis.codegen.TestModify u join fetch u.subs j0  order by  u.title", Collections.emptyList(),
                () -> TestModify.find().by().subs()
                        .joinFetch()
                        .order().title()
                        .get());

        checkQuery("select u from net.binis.codegen.TestModify u join fetch u.subs j0 where (u.amount is not null)  order by  u.title", Collections.emptyList(),
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

        var query = Test2.find().by().items().contains(5L).prepare();
        checkQuery("from net.binis.codegen.Test2 u where (?1 member of u.items)", List.of(5L), query::get);

        checkQuery("from net.binis.codegen.Test2 u where (?1 member of u.items)", List.of(6L),
                () -> query.param(0, 6L));

        checkQuery("select distinct u from net.binis.codegen.TestModify u join u.subs j0 join fetch u.subs j1 where (u.amount = ?1) and  (0 <> 0)   ", List.of(5.0),
                () -> TestModify.find().by().amount(5.0).and().subs().join(s -> s.where().id().in(Collections.emptyList())).and().subs().joinFetch().get());

        checkQuery("select u from net.binis.codegen.TestModify u join fetch u.items j0 where (u.amount = ?1) ", List.of(5.0),
                () -> TestModify.find().by().amount(5.0).and().items().joinFetch().get());

        checkQuery("select u from net.binis.codegen.TestModify u join fetch u.items j0 where ( (u.amount = ?1) ) ", List.of(5.0),
                () -> TestModify.find().by()._open().amount(5.0).and().items().joinFetch()._close().get());

        checkQuery("select u from net.binis.codegen.TestModify u join fetch u.items j0 where ( (u.amount = ?1) and  (lower(u.title) = ?2))  ", List.of(5.0, "ad"),
                () -> TestModify.find().by()._open()
                        .amount(5.0).and().lower().title("ad")._close()
                        .and().items().joinFetch().get());

        checkQuery("from net.binis.codegen.TestModify u where (u.amount = ?1) and  (?2 member of u.items and ?3 member of u.items and ?4 member of u.items) and  (u.id = ?5)", List.of(5.0, 6L, 7L, 8L, 9L),
                () -> TestModify.find().by().amount(5.0).and().items().containsAll(List.of(6L, 7L, 8L)).and().id(9L).get());

        checkQuery("from net.binis.codegen.TestModify u where (u.amount = ?1) and  (?2 member of u.items or ?3 member of u.items or ?4 member of u.items) and  (u.id = ?5)", List.of(5.0, 6L, 7L, 8L, 9L),
                () -> TestModify.find().by().amount(5.0).and().items().containsOne(List.of(6L, 7L, 8L)).and().id(9L).get());

        checkQuery("from net.binis.codegen.TestModify u where (u.amount = ?1) and  (?2 not member of u.items and ?3 not member of u.items and ?4 not member of u.items) and  (u.id = ?5)", List.of(5.0, 6L, 7L, 8L, 9L),
                () -> TestModify.find().by().amount(5.0).and().items().containsNone(List.of(6L, 7L, 8L)).and().id(9L).get());

        checkQuery("from net.binis.codegen.TestModify u where (u.amount = ?1) and  (0 = 0) and  (u.id = ?2)", List.of(5.0, 9L),
                () -> TestModify.find().by().amount(5.0).and().items().containsAll(Collections.emptyList()).and().id(9L).get());

        checkQuery("from net.binis.codegen.TestModify u where (u.amount = ?1) and  (0 = 0) and  (u.id = ?2)", List.of(5.0, 9L),
                () -> TestModify.find().by().amount(5.0).and().items().containsOne(Collections.emptyList()).and().id(9L).get());

        checkQuery("from net.binis.codegen.TestModify u where (u.amount = ?1) and  (0 = 0) and  (u.id = ?2)", List.of(5.0, 9L),
                () -> TestModify.find().by().amount(5.0).and().items().containsNone(Collections.emptyList()).and().id(9L).get());

        checkQuery("from net.binis.codegen.TestModify u where (u.amount = ?1) and  (0 = 0) and  (u.id = ?2)", List.of(5.0, 9L),
                () -> TestModify.find().by().amount(5.0).and().items().containsNone(null).and().id(9L).get());

        checkQuery("select distinct u.subAmount  from net.binis.codegen.Sub u ",
                () -> Sub.find().aggregate().distinct().subAmount().get());

        checkQuery("select u from net.binis.codegen.Test2 u join fetch u.sub j0 ",
                () -> Test2.find().by().sub().fetch().get());

        checkQuery("select u from net.binis.codegen.Test2 u left join fetch u.sub j0 ",
                () -> Test2.find().by().sub().leftFetch().get());

        var dummy = new SubImpl();
        checkQuery("from net.binis.codegen.Test2 u where (u.sub in ?1)", List.of(List.of(dummy)),
                () -> Test2.find().by().sub().in(List.of(dummy)).get());

        checkQuery("from net.binis.codegen.Test2 u where (u.sub in (select s0 from net.binis.codegen.Sub s0 )) ",
                () -> Test2.find().by().sub().in(Sub.find().by()).get());

        checkQuery("from net.binis.codegen.Test2 u where (u.sub is null)",
                () -> Test2.find().by().sub().isNull().get());

        checkQuery("from net.binis.codegen.Test2 u where (u.sub is not null)",
                () -> Test2.find().by().sub().isNotNull().get());

    }

    @Test
    void enrichQuerySelfTest() {
        checkQuery("select u.sub as sub,u.amount as amount,u.sub.subAmount as subAmount from net.binis.codegen.Test2 u where (u.sub.subAmount is not null) order by u.sub desc,u.sub.subAmount asc",
                () -> Test2.find()
                        .select()
                        .sub()._self()
                        .amount()
                        .sub().subAmount()
                        .where()
                        .sub().subAmount().isNotNull()
                        .order()
                        .sub()._self().desc()
                        .sub().subAmount().asc()
                        .get());

        checkQuery("select distinct u.sub from net.binis.codegen.Test2 u join u.sub j0 join fetch u.parent.parent j1 ",
                () -> Test2.find().aggregate()
                        .distinct().sub()._self().where().sub().join().and().parent().parent().fetch().get());
    }
    @Test
    void enrichQueryUpdateTest() {
        checkQuery("update net.binis.codegen.Test2 u set u.amount = ?1,u.title = ?2 ", List.of(5.0, "asd"), 0,
                () -> Test2.find().update().amount(5.0).title("asd").run());

        checkQuery("update net.binis.codegen.Test2 u set u.amount = ?1,u.title = ?2 where (u.parent is null)", List.of(5.0, "asd"), 0,
                () -> Test2.find().update().amount(5.0).title("asd").where().parent(null).run());

    }

    private void checkQuery(String expected, List<Object> params, Runnable query) {
        checkQuery(expected, params, null, query);
    }

    private void checkQuery(String expected, Runnable query) {
        checkQuery(expected, Collections.emptyList(), null, query);
    }

    private void checkQuery(String expected, List<Object> params, Object result, Runnable query) {
        mockQueryProcessor((q, p) -> {
            assertEquals(expected, q);
            assertEquals(params.size(), p.size(), "Parameters count don't match!");
            for (int i = 0; i < params.size(); i++) {
                assertEquals(params.get(i), p.get(i));
            }
            return result;
        });
        query.run();
    }

}
