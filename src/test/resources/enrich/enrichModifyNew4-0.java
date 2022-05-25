/*Generated code by Binis' code generator.*/
package net.binis.codegen.modifier.test;

import net.binis.codegen.modifier.impl.BaseModifierImpl;
import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.enums.TestEnum;
import javax.persistence.Transient;
import javax.annotation.processing.Generated;
import java.util.function.Consumer;
import java.time.OffsetDateTime;

@Generated(value = "TransactionDetailEntityPrototype", comments = "TransactionDetail")
public class TransactionDetailEntity extends BaseImpl implements TransactionDetail, Modifiable<TransactionDetail.Modify> {

    protected SubTransaction parent;

    @Transient()
    protected Object tag;

    // region constructor & initializer
    {
        CodeFactory.registerType(TransactionDetail.class, TransactionDetailEntity::new, null);
    }

    public TransactionDetailEntity() {
        super();
    }
    // endregion

    // region getters
    public SubTransaction getParent() {
        return parent;
    }

    public Object getTag() {
        return tag;
    }

    public TransactionDetail.Modify with() {
        return new TransactionDetailEntityModifyImpl(this);
    }
    // endregion

    // region inner classes
    protected class TransactionDetailEntityModifyImpl extends BaseModifierImpl<TransactionDetail.Modify, TransactionDetail> implements TransactionDetail.Modify {

        protected TransactionDetailEntityModifyImpl(TransactionDetail parent) {
            super(parent);
        }

        public TransactionDetail.Modify date(OffsetDateTime date) {
            TransactionDetailEntity.this.date = date;
            return this;
        }

        public TransactionDetail done() {
            return TransactionDetailEntity.this;
        }

        public TransactionDetail.Modify id(Long id) {
            TransactionDetailEntity.this.id = id;
            return this;
        }

        public TransactionDetail.Modify parent(SubTransaction parent) {
            TransactionDetailEntity.this.parent = parent;
            return this;
        }

        public SubTransaction.EmbeddedSoloModify<TransactionDetail.Modify> parent() {
            if (TransactionDetailEntity.this.parent == null) {
                TransactionDetailEntity.this.parent = CodeFactory.create(SubTransaction.class);
            }
            return CodeFactory.modify(this, TransactionDetailEntity.this.parent, SubTransaction.class);
        }

        public TransactionDetail.Modify parent(Consumer<SubTransaction.Modify> init) {
            if (TransactionDetailEntity.this.parent == null) {
                TransactionDetailEntity.this.parent = CodeFactory.create(SubTransaction.class);
            }
            init.accept(TransactionDetailEntity.this.parent.asSubTransaction());
            return this;
        }

        public TransactionDetail.Modify tag(Object tag) {
            TransactionDetailEntity.this.tag = tag;
            return this;
        }

        public TransactionDetail.Modify type(TestEnum type) {
            TransactionDetailEntity.this.type = type;
            return this;
        }
    }
    // endregion
}
