package net.binis.codegen.impl;

/*-
 * #%L
 * code-generation-test
 * %%
 * Copyright (C) 2021 - 2022 Binis Belev
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import net.binis.codegen.creator.EntityCreator;
import net.binis.codegen.enums.TestEnum;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.intf.SubTransaction;
import net.binis.codegen.intf.TransactionDetail;
import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.modifier.impl.BaseModifierImpl;
import net.binis.codegen.spring.query.*;
import net.binis.codegen.spring.query.base.BaseQueryNameImpl;
import net.binis.codegen.spring.query.executor.QueryExecutor;
import net.binis.codegen.spring.query.executor.QueryOrderer;

import javax.annotation.processing.Generated;
import javax.persistence.Transient;
import java.time.OffsetDateTime;
import java.util.function.Consumer;
import java.util.function.Function;

@Generated(value = "TransactionDetailEntityPrototype", comments = "TransactionDetail")
public class TransactionDetailEntity extends BaseEntity implements TransactionDetail, Modifiable<TransactionDetail.Modify> {

    protected SubTransaction parent;

    @Transient()
    protected Object tag;

    // region constructor & initializer
    {
        CodeFactory.registerType(TransactionDetail.class, TransactionDetailEntity::new, null);
        CodeFactory.registerType(TransactionDetail.QueryName.class, TransactionDetailQueryNameImpl::new, null);
        CodeFactory.registerType(TransactionDetail.QuerySelect.class, TransactionDetailSelectQueryExecutorImpl::new, null);
        CodeFactory.registerType(TransactionDetail.QueryOperationFields.class, TransactionDetailFieldsQueryExecutorImpl::new, null);
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

    protected static class TransactionDetailFieldsQueryExecutorImpl extends TransactionDetailQueryExecutorImpl implements TransactionDetail.QueryFieldsStart, EmbeddedFields {

        public SubTransaction.QueryOperationFields parent() {
            var result = EntityCreator.create(SubTransaction.QueryOperationFields.class, "net.binis.codegen.modifier.test.TransactionEntity");
            ((QueryEmbed) result).setParent("parent", this);
            return result;
        }
    }

    protected static abstract class TransactionDetailQueryExecutorImpl extends QueryExecutor implements TransactionDetail.QueryUpdate {

        protected TransactionDetailQueryExecutorImpl() {
            super(TransactionDetail.class, () -> new TransactionDetailQueryNameImpl(), parent -> {
                var result = new TransactionDetailFieldsQueryExecutorImpl();
                result.parent = (QueryExecutor) parent;
                return result;
            });
        }

        public QueryAggregateOperation aggregate() {
            return (QueryAggregateOperation) aggregateStart(new TransactionDetailQueryOrderImpl(this, TransactionDetailQueryExecutorImpl.this::aggregateIdentifier));
        }

        public QuerySelectOperation date(OffsetDateTime date) {
            return identifier("date", date);
        }

        public QueryFunctions date() {
            return identifier("date");
        }

        public QuerySelectOperation id(Long id) {
            return identifier("id", id);
        }

        public QueryFunctions id() {
            return identifier("id");
        }

        public TransactionDetail.QueryOrder order() {
            return (TransactionDetail.QueryOrder) orderStart(new TransactionDetailQueryOrderImpl(this, TransactionDetailQueryExecutorImpl.this::orderIdentifier));
        }

        public QuerySelectOperation parent(SubTransaction parent) {
            return identifier("parent", parent);
        }

        public QuerySelectOperation tag(Object tag) {
            return identifier("tag", tag);
        }

        public QuerySelectOperation type(TestEnum type) {
            return identifier("type", type);
        }

        public QueryFunctions type() {
            return identifier("type");
        }

        protected class TransactionDetailQueryOrderImpl extends QueryOrderer implements TransactionDetail.QueryOrder, TransactionDetail.QueryAggregate {

            protected TransactionDetailQueryOrderImpl(TransactionDetailQueryExecutorImpl executor, Function<String, Object> func) {
                super(executor, func);
            }

            public QueryOrderOperation date() {
                return (QueryOrderOperation) func.apply("date");
            }

            public QueryOrderOperation id() {
                return (QueryOrderOperation) func.apply("id");
            }

            public SubTransaction.QueryOperationFields parent() {
                var result = EntityCreator.create(SubTransaction.QueryOperationFields.class, "net.binis.codegen.modifier.test.TransactionEntity");
                ((QueryEmbed) result).setParent("parent", executor);
                return result;
            }

            public QueryOrderOperation type() {
                return (QueryOrderOperation) func.apply("type");
            }
        }
    }

    protected static class TransactionDetailQueryNameImpl extends BaseQueryNameImpl implements TransactionDetail.QueryName, QueryEmbed {

        public QueryFunctions date() {
            return executor.identifier("date");
        }

        public QuerySelectOperation date(OffsetDateTime date) {
            return executor.identifier("date", date);
        }

        public QueryFunctions id() {
            return executor.identifier("id");
        }

        public QuerySelectOperation id(Long id) {
            return executor.identifier("id", id);
        }

        public QueryFunctions parent() {
            return executor.identifier("parent");
        }

        public QuerySelectOperation parent(SubTransaction parent) {
            return executor.identifier("parent", parent);
        }

        public QuerySelectOperation tag(Object tag) {
            return executor.identifier("tag", tag);
        }

        public QueryFunctions type() {
            return executor.identifier("type");
        }

        public QuerySelectOperation type(TestEnum type) {
            return executor.identifier("type", type);
        }
    }

    protected static class TransactionDetailSelectQueryExecutorImpl extends TransactionDetailQueryExecutorImpl implements TransactionDetail.QuerySelect {
    }
    // endregion
}
