/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.collection.EmbeddedCodeCollection;
import net.binis.codegen.collection.CodeList;
import java.util.Set;
import java.util.List;

public interface TestModify {

    double getAmount();

    List<Long> getItems();

    Set<SubModify> getSubs();

    String getTitle();

    void setAmount(double amount);

    void setItems(List<Long> items);

    void setSubs(Set<SubModify> subs);

    void setTitle(String title);

    TestModify.Modify with();

    interface Fields<T> {

        T amount(double amount);

        T title(String title);
    }

    interface Modify extends TestModify.Fields<TestModify.Modify> {

        TestModify done();

        Modify items(List<Long> items);

        CodeList<Long, Modify> items();

        Modify subs(Set<SubModify> subs);

        EmbeddedCodeCollection<SubModify.EmbeddedModify<SubModify.Modify>, SubModify, Modify> subs();
    }
}
