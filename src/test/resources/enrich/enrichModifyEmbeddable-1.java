/*Generated code by Binis' code generator.*/
package net.binis.codegen.test;

import net.binis.codegen.modifier.BaseModifier;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import net.binis.codegen.collection.CodeList;
import javax.annotation.processing.Generated;
import java.util.List;

@Generated(value = "net.binis.codegen.test.TestModifyPrototype", comments = "TestModifyImpl")
public interface TestModify {
    double getAmount();
    List<Long> getItems();
    String getTitle();

    void setAmount(double amount);
    void setItems(List<Long> items);
    void setTitle(String title);

    TestModify.Modify with();

    interface EmbeddedCollectionModify<R> extends TestModify.EmbeddedModify<TestModify.EmbeddedCollectionModify<R>, R> {
        EmbeddedCodeCollection<TestModify.EmbeddedCollectionModify<R>, TestModify, R> _and();
    }

    interface EmbeddedModify<T, R> extends BaseModifier<T, R>, TestModify.Fields<T> {
        T items(List<Long> items);
        CodeList<Long, T> items();
    }

    interface EmbeddedSoloModify<R> extends TestModify.EmbeddedModify<TestModify.EmbeddedSoloModify<R>, R> {
    }

    interface Fields<T> {
        T amount(double amount);
        T title(String title);
    }

    interface Modify extends EmbeddedModify<TestModify.Modify, TestModify> {
    }
}
