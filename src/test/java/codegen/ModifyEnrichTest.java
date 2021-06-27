package codegen;

import net.binis.codegen.generation.core.Helpers;
import net.binis.codegen.test.BaseTest;
import org.apache.commons.lang3.tuple.Triple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModifyEnrichTest extends BaseTest {

    @BeforeEach
    public void cleanUp() {
        Helpers.cleanUp();
    }

    @Test
    public void enrichModify() {
        testMulti(List.of(
                Triple.of("enrich/enrichModifySub.java", "enrich/enrichModifySub-0.java", "enrich/enrichModifySub-1.java"),
                Triple.of("enrich/enrichModify.java", "enrich/enrichModify-0.java", "enrich/enrichModify-1.java")
        ));
    }

    @Test
    public void enrichModifyWithBase() {
        testMulti(List.of(
                Triple.of("enrich/enrichModifyBase1.java", "enrich/enrichModifyBase1-0.java", "enrich/enrichModifyBase1-1.java"),
                Triple.of("enrich/enrichModifySubWithBase.java", "enrich/enrichModifySubWithBase-0.java", "enrich/enrichModifySubWithBase-1.java"),
                Triple.of("enrich/enrichModifyWithBase.java", "enrich/enrichModifyWithBase-0.java", "enrich/enrichModifyWithBase-1.java")
        ));
    }

    @Test
    public void enrichModifyWithBaseAndMixIn() {
        testMulti(List.of(
                Triple.of("enrich/enrichModifyBase1.java", "enrich/enrichModifyBase1-0.java", "enrich/enrichModifyBase1-1.java"),
                Triple.of("enrich/enrichModifySubWithBase.java", "enrich/enrichModifySubWithBase-0.java", "enrich/enrichModifySubWithBase-1.java"),
                Triple.of("enrich/enrichModifyWithBase.java", "enrich/enrichModifyWithBaseAndMixIn-0.java", "enrich/enrichModifyWithBase-1.java"),
                Triple.of("enrich/enrichModifyMixInWithBase.java", null, "enrich/enrichModifyMixInWithBase-1.java")
        ), "./src/main/java/net/binis/codegen");
    }



}
