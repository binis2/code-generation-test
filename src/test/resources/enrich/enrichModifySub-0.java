/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.collection.EmbeddedCodeCollection;

public class SubModifyImpl implements SubModify, Modifiable<SubModify.Modify> {

    protected double subAmount;

    protected String subtitle;

    public SubModifyImpl() {
    }

    public double getSubAmount() {
        return subAmount;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubAmount(double subAmount) {
        this.subAmount = subAmount;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public SubModify.Modify with() {
        return new SubModifyModifyImpl();
    }

    protected static class EmbeddedSubModifyModifyImpl<T> implements SubModify.EmbeddedModify<T> {

        protected SubModifyImpl entity;

        protected T parent;

        protected EmbeddedSubModifyModifyImpl(T parent, SubModifyImpl entity) {
            this.parent = parent;
            this.entity = entity;
        }

        public EmbeddedCodeCollection<SubModify.EmbeddedModify<T>, SubModify, T> and() {
            return (EmbeddedCodeCollection) parent;
        }

        public SubModify.EmbeddedModify<T> subAmount(double subAmount) {
            entity.subAmount = subAmount;
            return this;
        }

        public SubModify.EmbeddedModify<T> subtitle(String subtitle) {
            entity.subtitle = subtitle;
            return this;
        }
    }

    protected class SubModifyModifyImpl implements SubModify.Modify {

        public SubModify done() {
            return SubModifyImpl.this;
        }

        public SubModify.Modify subAmount(double subAmount) {
            SubModifyImpl.this.subAmount = subAmount;
            return this;
        }

        public SubModify.Modify subtitle(String subtitle) {
            SubModifyImpl.this.subtitle = subtitle;
            return this;
        }
    }
}
