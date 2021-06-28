/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.collection.EmbeddedCodeSetImpl;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import net.binis.codegen.collection.CodeListImpl;
import net.binis.codegen.collection.CodeList;
import java.util.Set;
import java.util.List;

public class TestModifyImpl implements TestModify, Modifiable<TestModify.Modify> {

    protected double amount;

    protected SubModify extended;

    protected List<Long> items;

    protected SubModify prototype;

    protected Set<SubModify> subs;

    protected String title;

    public TestModifyImpl() {
    }

    public double getAmount() {
        return amount;
    }

    public SubModify getExtended() {
        return extended;
    }

    public List<Long> getItems() {
        return items;
    }

    public SubModify getPrototype() {
        return prototype;
    }

    public Set<SubModify> getSubs() {
        return subs;
    }

    public String getTitle() {
        return title;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setExtended(SubModify extended) {
        this.extended = extended;
    }

    public void setItems(List<Long> items) {
        this.items = items;
    }

    public void setSubs(Set<SubModify> subs) {
        this.subs = subs;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TestModify.Modify with() {
        return new TestModifyModifyImpl();
    }

    protected class TestModifyModifyImpl implements TestModify.Modify {

        public TestModify.Modify amount(double amount) {
            TestModifyImpl.this.amount = amount;
            return this;
        }

        public TestModify done() {
            return TestModifyImpl.this;
        }

        public TestModify.Modify extended(SubModify extended) {
            TestModifyImpl.this.extended = extended;
            return this;
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

        public TestModify.Modify prototype(SubModify prototype) {
            TestModifyImpl.this.prototype = prototype;
            return this;
        }

        public TestModify.Modify subs(Set<SubModify> subs) {
            TestModifyImpl.this.subs = subs;
            return this;
        }

        public EmbeddedCodeCollection<SubModify.EmbeddedModify<SubModify.Modify>, SubModify, TestModify.Modify> subs() {
            if (TestModifyImpl.this.subs == null) {
                TestModifyImpl.this.subs = new java.util.HashSet<>();
            }
            return new EmbeddedCodeSetImpl<>(this, TestModifyImpl.this.subs, SubModify.class);
        }

        public TestModify.Modify title(String title) {
            TestModifyImpl.this.title = title;
            return this;
        }
    }
}
