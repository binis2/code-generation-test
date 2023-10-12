/*Generated code by Binis' code generator.*/
package net.binis.codegen;

/*-
 * #%L
 * code-generation-test
 * %%
 * Copyright (C) 2021 - 2023 Binis Belev
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
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.creator.EntityCreator;
import javax.annotation.processing.Generated;
import java.util.function.Function;
import java.util.Optional;
import java.util.List;

@Generated(value = "net.binis.codegen.SubPrototype", comments = "Sub")
@SuppressWarnings("unchecked")
public class SubImpl implements Sub {

    protected double subAmount;

    protected String subtitle;

    {
        CodeFactory.registerType(Sub.class, SubImpl::new, null);
        CodeFactory.registerType(Sub.QueryName.class, SubQueryNameImpl::new, null);
        CodeFactory.registerType(Sub.QuerySelect.class, SubQueryExecutorImpl::new, null);
        CodeFactory.registerType(Sub.QueryOperationFields.class, SubQueryExecutorImpl::new, null);
    }

    public SubImpl() {
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

    @Generated("QueryEnricher")
    protected static class SubQueryExecutorImpl extends QueryExecutor implements Sub.QueryUpdate, Sub.QuerySelect, Sub.QueryFieldsStart {

        protected SubQueryExecutorImpl() {
            super(Sub.class, () -> new SubQueryNameImpl(), parent -> parent);
        }

        public QueryAggregateOperation aggregate() {
            return (QueryAggregateOperation) aggregateStart(new SubQueryOrderImpl(this, SubQueryExecutorImpl.this::aggregateIdentifier));
        }

        public Sub.QueryOrder order() {
            return (Sub.QueryOrder) orderStart(new SubQueryOrderImpl(this, SubQueryExecutorImpl.this::orderIdentifier));
        }

        public QuerySelectOperation subAmount(double subAmount) {
            return identifier("subAmount", subAmount);
        }

        public QueryFunctions subAmount() {
            return identifier("subAmount");
        }

        public QuerySelectOperation subtitle(String subtitle) {
            return identifier("subtitle", subtitle);
        }

        public QueryFunctions subtitle() {
            return identifier("subtitle");
        }

        @Generated("QueryEnricher")
        protected class SubQueryOrderImpl extends QueryOrderer implements Sub.QueryOrder, Sub.QueryAggregate {

            protected SubQueryOrderImpl(SubQueryExecutorImpl executor, Function<String, Object> func) {
                super(executor, func);
            }

            public QueryOrderOperation subAmount() {
                return (QueryOrderOperation) func.apply("subAmount");
            }

            public QueryOrderOperation subtitle() {
                return (QueryOrderOperation) func.apply("subtitle");
            }
        }
    }

    @Generated("QueryEnricher")
    protected static class SubQueryNameImpl extends BaseQueryNameImpl implements Sub.QueryName, QueryEmbed {

        public QueryFunctions subAmount() {
            return executor.identifier("subAmount");
        }

        public QuerySelectOperation subAmount(double subAmount) {
            return executor.identifier("subAmount", subAmount);
        }

        public QueryFunctions subtitle() {
            return executor.identifier("subtitle");
        }

        public QuerySelectOperation subtitle(String subtitle) {
            return executor.identifier("subtitle", subtitle);
        }
    }
}
