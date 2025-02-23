/*Generated code by Binis' code generator.*/
package net.binis.codegen;

/*-
 * #%L
 * code-generation-test
 * %%
 * Copyright (C) 2021 - 2025 Binis Belev
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

import net.binis.codegen.spring.query.executor.QueryOrderer;
import net.binis.codegen.spring.query.executor.QueryExecutor;
import net.binis.codegen.spring.query.base.BaseQueryNameImpl;
import net.binis.codegen.spring.query.*;
import net.binis.codegen.modifier.impl.BaseModifierImpl;
import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.enums.TestEnum;
import net.binis.codegen.creator.EntityCreator;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import javax.annotation.processing.Generated;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.Optional;
import java.util.List;
import java.time.OffsetDateTime;
import jakarta.persistence.Transient;

@Generated(value = "net.binis.codegen.SubModifyPrototype", comments = "SubModify")
@SuppressWarnings("unchecked")
public class SubModifyImpl extends BaseImpl implements SubModify, Modifiable<SubModify.Modify> {

    protected SubModify parent;

    protected double subAmount;

    protected String subtitle;

    @Transient
    protected Object tag;

    // region constructor & initializer
    static {
        CodeFactory.registerType(SubModify.class, SubModifyImpl::new, (p, v, r) -> p instanceof EmbeddedCodeCollection ? ((SubModifyImpl) v).new SubModifyImplCollectionModifyImpl(p) : ((SubModifyImpl) v).new SubModifyImplSoloModifyImpl(p));
        CodeFactory.registerType(SubModify.QueryName.class, SubModifyQueryNameImpl::new, null);
        CodeFactory.registerType(SubModify.QuerySelect.class, SubModifySelectQueryExecutorImpl::new, null);
        CodeFactory.registerType(SubModify.QueryOperationFields.class, SubModifyFieldsQueryExecutorImpl::new, null);
        CodeFactory.registerType(SubModify.QueryOrder.class, () -> SubModify.find().aggregate(), null);
    }

    public SubModifyImpl() {
        super();
    }
    // endregion

    // region getters
    public SubModify getParent() {
        return parent;
    }

    public double getSubAmount() {
        return subAmount;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public Object getTag() {
        return tag;
    }
    // endregion

    // region setters
    public void setParent(SubModify parent) {
        this.parent = parent;
    }

    public void setSubAmount(double subAmount) {
        this.subAmount = subAmount;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setTag(Object tag) {
        this.tag = tag;
    }

    public SubModify.Modify with() {
        return new SubModifyModifyImpl(this);
    }
    // endregion

    // region inner classes
    @Generated("QueryEnricher")
    protected static class SubModifyFieldsQueryExecutorImpl extends SubModifyQueryExecutorImpl implements SubModify.QueryFieldsStart, EmbeddedFields {

        public SubModify.QueryOperationFields parent() {
            var result = EntityCreator.create(SubModify.QueryOperationFields.class, "net.binis.codegen.SubModifyImpl");
            ((QueryEmbed) result).setParent("parent", this);
            return result;
        }
    }

    @SuppressWarnings("unchecked")
    @Generated("ModifierEnricher")
    protected class SubModifyImplCollectionModifyImpl extends SubModifyImplEmbeddedModifyImpl implements SubModify.EmbeddedCollectionModify {

        protected SubModifyImplCollectionModifyImpl(Object parent) {
            super(parent);
        }

        public EmbeddedCodeCollection _and() {
            return (EmbeddedCodeCollection) parent;
        }
    }

    @SuppressWarnings("unchecked")
    @Generated("ModifierEnricher")
    protected class SubModifyImplEmbeddedModifyImpl<T, R> extends BaseModifierImpl<T, R> implements SubModify.EmbeddedModify<T, R> {

        protected SubModifyImplEmbeddedModifyImpl(R parent) {
            super(parent);
        }

        public T date(OffsetDateTime date) {
            SubModifyImpl.this.date = date;
            return (T) this;
        }

        public T id(Long id) {
            SubModifyImpl.this.id = id;
            return (T) this;
        }

        public SubModify.EmbeddedSoloModify<SubModify.EmbeddedModify<T, R>> parent() {
            if (SubModifyImpl.this.parent == null) {
                SubModifyImpl.this.parent = CodeFactory.create(SubModify.class);
            }
            return CodeFactory.modify(this, SubModifyImpl.this.parent, SubModify.class);
        }

        public T parent(SubModify parent) {
            SubModifyImpl.this.parent = parent;
            return (T) this;
        }

        public T subAmount(double subAmount) {
            SubModifyImpl.this.subAmount = subAmount;
            return (T) this;
        }

        public T subtitle(String subtitle) {
            SubModifyImpl.this.subtitle = subtitle;
            return (T) this;
        }

        public T tag(Object tag) {
            SubModifyImpl.this.tag = tag;
            return (T) this;
        }

        public T type(TestEnum type) {
            SubModifyImpl.this.type = type;
            return (T) this;
        }
    }

    @SuppressWarnings("unchecked")
    @Generated("ModifierEnricher")
    protected class SubModifyImplSoloModifyImpl extends SubModifyImplEmbeddedModifyImpl implements SubModify.EmbeddedSoloModify {

        protected SubModifyImplSoloModifyImpl(Object parent) {
            super(parent);
        }
    }

    @Generated("ModifierEnricher")
    @SuppressWarnings("unchecked")
    protected class SubModifyModifyImpl extends SubModifyImplEmbeddedModifyImpl<SubModify.Modify, SubModify> implements SubModify.Modify {

        protected SubModifyModifyImpl(SubModify parent) {
            super(parent);
        }

        public SubModify.Modify parent$(Consumer<SubModify.Modify> init) {
            if (SubModifyImpl.this.parent == null) {
                SubModifyImpl.this.parent = CodeFactory.create(SubModify.class);
            }
            init.accept(SubModifyImpl.this.parent.with());
            return this;
        }
    }

    @Generated("QueryEnricher")
    protected static abstract class SubModifyQueryExecutorImpl extends QueryExecutor implements SubModify.QueryUpdate {

        protected SubModifyQueryExecutorImpl() {
            super(SubModify.class, () -> new SubModifyQueryNameImpl(), parent -> {
                var result = new SubModifyFieldsQueryExecutorImpl();
                result.parent = (QueryExecutor) parent;
                return result;
            });
        }

        public QueryAggregateOperation aggregate() {
            return (QueryAggregateOperation) _aggregateStart(new SubModifyQueryOrderImpl(this, SubModifyQueryExecutorImpl.this::_aggregateIdentifier));
        }

        public QueryFunctions date() {
            return $identifier("date");
        }

        public QuerySelectOperation date(OffsetDateTime date) {
            return $identifier("date", date);
        }

        public QueryFunctions id() {
            return $identifier("id");
        }

        public QuerySelectOperation id(Long id) {
            return $identifier("id", id);
        }

        public SubModify.QueryOrder order() {
            return (SubModify.QueryOrder) _orderStart(new SubModifyQueryOrderImpl(this, SubModifyQueryExecutorImpl.this::_orderIdentifier));
        }

        public QuerySelectOperation parent(SubModify parent) {
            return $identifier("parent", parent);
        }

        public QueryFunctions subAmount() {
            return $identifier("subAmount");
        }

        public QuerySelectOperation subAmount(double subAmount) {
            return $identifier("subAmount", subAmount);
        }

        public QueryFunctions subtitle() {
            return $identifier("subtitle");
        }

        public QuerySelectOperation subtitle(String subtitle) {
            return $identifier("subtitle", subtitle);
        }

        public QuerySelectOperation tag(Object tag) {
            return $identifier("tag", tag);
        }

        public QueryFunctions type() {
            return $identifier("type");
        }

        public QuerySelectOperation type(TestEnum type) {
            return $identifier("type", type);
        }

        @Generated("QueryEnricher")
        protected class SubModifyQueryOrderImpl extends QueryOrderer implements SubModify.QueryOrder, SubModify.QueryAggregate {

            protected SubModifyQueryOrderImpl(SubModifyQueryExecutorImpl executor, Function<String, Object> func) {
                super(executor, func);
            }

            public QueryOrderOperation date() {
                return (QueryOrderOperation) func.apply("date");
            }

            public QueryOrderOperation id() {
                return (QueryOrderOperation) func.apply("id");
            }

            public SubModify.QueryOperationFields parent() {
                var result = EntityCreator.create(SubModify.QueryOperationFields.class, "net.binis.codegen.SubModifyImpl");
                ((QueryEmbed) result).setParent("parent", executor);
                return result;
            }

            public QueryOrderOperation subAmount() {
                return (QueryOrderOperation) func.apply("subAmount");
            }

            public QueryOrderOperation subtitle() {
                return (QueryOrderOperation) func.apply("subtitle");
            }

            public QueryOrderOperation type() {
                return (QueryOrderOperation) func.apply("type");
            }
        }
    }

    @Generated("QueryEnricher")
    protected static class SubModifyQueryNameImpl extends BaseQueryNameImpl implements SubModify.QueryName, QueryEmbed {

        public QueryFunctions date() {
            return executor.$identifier("date");
        }

        public QuerySelectOperation date(OffsetDateTime date) {
            return executor.$identifier("date", date);
        }

        public QueryFunctions id() {
            return executor.$identifier("id");
        }

        public QuerySelectOperation id(Long id) {
            return executor.$identifier("id", id);
        }

        public SubModify.QueryName parent() {
            var result = EntityCreator.create(SubModify.QueryName.class, "net.binis.codegen.SubModifyImpl");
            ((QueryEmbed) result).setParent("parent", executor);
            return result;
        }

        public QuerySelectOperation parent(SubModify parent) {
            return executor.$identifier("parent", parent);
        }

        public QueryFunctions subAmount() {
            return executor.$identifier("subAmount");
        }

        public QuerySelectOperation subAmount(double subAmount) {
            return executor.$identifier("subAmount", subAmount);
        }

        public QueryFunctions subtitle() {
            return executor.$identifier("subtitle");
        }

        public QuerySelectOperation subtitle(String subtitle) {
            return executor.$identifier("subtitle", subtitle);
        }

        public QuerySelectOperation tag(Object tag) {
            return executor.$identifier("tag", tag);
        }

        public QueryFunctions type() {
            return executor.$identifier("type");
        }

        public QuerySelectOperation type(TestEnum type) {
            return executor.$identifier("type", type);
        }
    }

    @Generated("QueryEnricher")
    protected static class SubModifySelectQueryExecutorImpl extends SubModifyQueryExecutorImpl implements SubModify.QuerySelect {

        public SubModify.QueryName parent() {
            var result = EntityCreator.create(SubModify.QueryName.class, "net.binis.codegen.SubModifyImpl");
            ((QueryEmbed) result).setParent("parent", this);
            return result;
        }
    }
    // endregion
}
