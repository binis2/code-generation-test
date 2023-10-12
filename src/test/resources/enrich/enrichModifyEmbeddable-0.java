/*Generated code by Binis' code generator.*/
package net.binis.codegen.test;

import net.binis.codegen.modifier.impl.BaseModifierImpl;
import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import net.binis.codegen.collection.CodeListImpl;
import net.binis.codegen.collection.CodeList;
import javax.annotation.processing.Generated;
import java.util.List;

@Generated(value = "net.binis.codegen.test.TestModifyPrototype", comments = "TestModify")
public class TestModifyImpl implements TestModify, Modifiable<TestModify.Modify> {

    protected double amount;

    protected List<Long> items;

    protected String title;

    public TestModifyImpl() {
    }

    public double getAmount() {
        return amount;
    }

    public List<Long> getItems() {
        return items;
    }

    public String getTitle() {
        return title;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setItems(List<Long> items) {
        this.items = items;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TestModify.Modify with() {
        return new TestModifyModifyImpl(this);
    }

    @SuppressWarnings("unchecked")
    @Generated("ModifierEnricher")
    protected class TestModifyImplCollectionModifyImpl extends TestModifyImplEmbeddedModifyImpl implements TestModify.EmbeddedCollectionModify {

        protected TestModifyImplCollectionModifyImpl(Object parent) {
            super(parent);
        }

        public EmbeddedCodeCollection _and() {
            return (EmbeddedCodeCollection) parent;
        }
    }

    @SuppressWarnings("unchecked")
    @Generated("ModifierEnricher")
    protected class TestModifyImplEmbeddedModifyImpl<T, R> extends BaseModifierImpl<T, R> implements TestModify.EmbeddedModify<T, R> {

        protected TestModifyImplEmbeddedModifyImpl(R parent) {
            super(parent);
        }

        public T amount(double amount) {
            TestModifyImpl.this.amount = amount;
            return (T) this;
        }

        public T items(List<Long> items) {
            TestModifyImpl.this.items = items;
            return (T) this;
        }

        public CodeList items() {
            if (TestModifyImpl.this.items == null) {
                TestModifyImpl.this.items = new java.util.ArrayList<>();
            }
            return new CodeListImpl<>(this, TestModifyImpl.this.items);
        }

        public T title(String title) {
            TestModifyImpl.this.title = title;
            return (T) this;
        }
    }

    @SuppressWarnings("unchecked")
    @Generated("ModifierEnricher")
    protected class TestModifyImplSoloModifyImpl extends TestModifyImplEmbeddedModifyImpl implements TestModify.EmbeddedSoloModify {

        protected TestModifyImplSoloModifyImpl(Object parent) {
            super(parent);
        }
    }

    @Generated("ModifierEnricher")
    @SuppressWarnings("unchecked")
    protected class TestModifyModifyImpl extends TestModifyImplEmbeddedModifyImpl<TestModify.Modify, TestModify> implements TestModify.Modify {

        protected TestModifyModifyImpl(TestModify parent) {
            super(parent);
        }
    }
}
