/*Generated code by Binis' code generator.*/
package net.binis.codegen.test;

import net.binis.codegen.collection.EmbeddedCodeCollection;
import net.binis.codegen.collection.CodeList;
import javax.annotation.processing.Generated;
import java.util.List;

@Generated(value = "TestModifyPrototype", comments = "TestModifyImpl")
public interface TestModify {
    double getAmount();
    List<Long> getItems();
    String getTitle();

    void setAmount(double amount);
    void setItems(List<Long> items);
    void setTitle(String title);

    TestModify.Modify with();

    interface EmbeddedModify<T> extends TestModify.Fields<TestModify.EmbeddedModify<T>> {
        EmbeddedCodeCollection<EmbeddedModify<T>, TestModify, T> and();
        EmbeddedModify<T> items(List<Long> items);
    }

    interface Fields<T> {
        T amount(double amount);
        T title(String title);
    }

    interface Modify extends TestModify.Fields<TestModify.Modify> {
        TestModify done();
        Modify items(List<Long> items);
        CodeList<Long, Modify> items();
    }
}
