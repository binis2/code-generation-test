/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import net.binis.codegen.collection.CodeListImpl;
import net.binis.codegen.collection.CodeList;
import javax.annotation.processing.Generated;
import java.util.List;

@Generated(value = "TestModifyPrototype", comments = "TestModify")
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
        return new TestModifyModifyImpl();
    }

    protected static class EmbeddedTestModifyModifyImpl<T> implements TestModify.EmbeddedModify<T> {

        protected TestModifyImpl entity;

        protected T parent;

        protected EmbeddedTestModifyModifyImpl(T parent, TestModifyImpl entity) {
            this.parent = parent;
            this.entity = entity;
        }

        public TestModify.EmbeddedModify<T> amount(double amount) {
            entity.amount = amount;
            return this;
        }

        public EmbeddedCodeCollection<TestModify.EmbeddedModify<T>, TestModify, T> and() {
            return (EmbeddedCodeCollection) parent;
        }

        public TestModify.EmbeddedModify<T> items(List<Long> items) {
            entity.items = items;
            return this;
        }

        public TestModify.EmbeddedModify<T> title(String title) {
            entity.title = title;
            return this;
        }
    }

    protected class TestModifyModifyImpl implements TestModify.Modify {

        public TestModify.Modify amount(double amount) {
            TestModifyImpl.this.amount = amount;
            return this;
        }

        public TestModify done() {
            return TestModifyImpl.this;
        }

        public TestModify.Modify items(List<Long> items) {
            TestModifyImpl.this.items = items;
            return this;
        }

        public CodeList<Long, TestModify.Modify> items() {
            if (TestModifyImpl.this.items == null) {
                TestModifyImpl.this.items = new java.util.ArrayList<>();
            }
            return new CodeListImpl<>(this, TestModifyImpl.this.items);
        }

        public TestModify.Modify title(String title) {
            TestModifyImpl.this.title = title;
            return this;
        }
    }
}
