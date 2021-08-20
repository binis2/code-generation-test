/*Generated code by Binis' code generator.*/
package net.binis.codegen;

/*-
 * #%L
 * code-generation-test
 * %%
 * Copyright (C) 2021 Binis Belev
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

@Generated(value = "SubPrototype", comments = "Sub")
public class SubImpl implements Sub {

    protected double subAmount;

    protected String subtitle;

    {
        CodeFactory.registerType(Sub.QuerySelect.class, SubQueryExecutorImpl::new, null);
        CodeFactory.registerType(Sub.class, SubImpl::new, null);
        CodeFactory.registerType(Sub.QueryName.class, SubQueryNameImpl::new, null);
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

    protected static class SubQueryExecutorImpl extends QueryExecutor implements Sub.QuerySelect {

        protected SubQueryExecutorImpl() {
            super(Sub.class);
        }

        public QueryAggregateOperation aggregate() {
            return (QueryAggregateOperation) aggregateStart(new SubQueryOrderImpl(this, SubQueryExecutorImpl.this::aggregateIdentifier));
        }

        public Sub.QueryName lower() {
            doLower();
            var result = new SubQueryNameImpl();
            result.setParent(alias, this);
            return result;
        }

        public Sub.QueryName not() {
            doNot();
            var result = new SubQueryNameImpl();
            result.setParent(alias, this);
            return result;
        }

        public Sub.QueryOrder order() {
            return (Sub.QueryOrder) orderStart(new SubQueryOrderImpl(this, SubQueryExecutorImpl.this::orderIdentifier));
        }

        public Sub.QueryName replace(String what, String withWhat) {
            doReplace(what, withWhat);
            var result = new SubQueryNameImpl();
            result.setParent(alias, this);
            return result;
        }

        public QuerySelectOperation subAmount(double subAmount) {
            return identifier("subAmount", subAmount);
        }

        public QueryFunctions subAmount() {
            return identifier("subAmount");
        }

        public Sub.QueryName substring(int start) {
            doSubstring(start);
            var result = new SubQueryNameImpl();
            result.setParent(alias, this);
            return result;
        }

        public Sub.QueryName substring(int start, int len) {
            doSubstring(start, len);
            var result = new SubQueryNameImpl();
            result.setParent(alias, this);
            return result;
        }

        public QuerySelectOperation subtitle(String subtitle) {
            return identifier("subtitle", subtitle);
        }

        public QueryFunctions subtitle() {
            return identifier("subtitle");
        }

        public Sub.QueryName trim() {
            doTrim();
            var result = new SubQueryNameImpl();
            result.setParent(alias, this);
            return result;
        }

        public Sub.QueryName upper() {
            doUpper();
            var result = new SubQueryNameImpl();
            result.setParent(alias, this);
            return result;
        }

        protected class SubQueryOrderImpl extends QueryOrderer implements Sub.QueryOrder, Sub.QueryAggregate {

            protected SubQueryOrderImpl(SubQueryExecutorImpl executor, Function<String, Object> func) {
                super(executor, func);
            }

            public QueryOrderOperation script(String script) {
                return (QueryOrderOperation) SubQueryExecutorImpl.this.script(script);
            }

            public QueryOrderOperation subAmount() {
                return (QueryOrderOperation) func.apply("subAmount");
            }

            public QueryOrderOperation subtitle() {
                return (QueryOrderOperation) func.apply("subtitle");
            }
        }
    }

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
