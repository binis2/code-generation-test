/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.modifier.BaseModifier;
import net.binis.codegen.intf.Prototypable;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import net.binis.codegen.collection.CodeList;
import net.binis.codegen.base.Extended;
import javax.annotation.processing.Generated;
import java.util.function.Consumer;
import java.util.Set;
import java.util.List;

@Generated(value = "net.binis.codegen.prototype.TestModifyPrototype", comments = "TestModifyImpl")
public interface TestModify extends Prototypable<SubModify>, Extended {
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
        T extended(SubModify extended);
        T prototype(SubModify prototype);
        T title(String title);
    }

    interface Modify extends TestModify.Fields<TestModify.Modify>, BaseModifier<TestModify.Modify, TestModify> {
        SubModify.EmbeddedSoloModify<Modify> extended();
        Modify extended$(Consumer<SubModify.Modify> init);
        CodeList<Long, TestModify.Modify> items();
        Modify items(List<Long> items);
        SubModify.EmbeddedSoloModify<Modify> prototype();
        Modify prototype$(Consumer<SubModify.Modify> init);
        EmbeddedCodeCollection<SubModify.EmbeddedCollectionModify<TestModify.Modify>, SubModify, TestModify.Modify> subs();
        Modify subs(Set<SubModify> subs);
    }
}
