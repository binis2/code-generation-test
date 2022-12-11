package net.binis.codegen.mock;

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

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.metamodel.Metamodel;

import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

import static java.util.Objects.nonNull;
import static net.binis.codegen.tools.Tools.nullCheck;

public class MockEntityManager implements EntityManager {

    private final Map<MockPersistenceOperation, Map<Object, Long>> counts = new EnumMap<>(MockPersistenceOperation.class);
    private final Map<MockPersistenceOperation, Map<Class, Long>> countsClass = new EnumMap<>(MockPersistenceOperation.class);
    private final Map<MockPersistenceOperation, Long> countsOperation = new EnumMap<>(MockPersistenceOperation.class);

    private final Map<MockPersistenceOperation, Map<Object, BiConsumer<MockPersistenceOperation, Object>>> onOperation = new EnumMap<>(MockPersistenceOperation.class);
    private final Map<MockPersistenceOperation, Map<Class, BiConsumer<MockPersistenceOperation, Object>>> onOperationClass = new EnumMap<>(MockPersistenceOperation.class);
    private final Map<MockPersistenceOperation, BiConsumer<MockPersistenceOperation, Object>> onOperationOperation = new EnumMap<>(MockPersistenceOperation.class);
    private Object context;

    @Override
    public void persist(Object o) {
        makeItCount(MockPersistenceOperation.SAVE, o);
    }

    @Override
    public <T> T merge(T t) {
        makeItCount(MockPersistenceOperation.MERGE, t);
        return t;
    }

    @Override
    public void remove(Object o) {
        makeItCount(MockPersistenceOperation.DELETE, o);
    }

    @Override
    public <T> T find(Class<T> aClass, Object o) {
        return null;
    }

    @Override
    public <T> T find(Class<T> aClass, Object o, Map<String, Object> map) {
        return null;
    }

    @Override
    public <T> T find(Class<T> aClass, Object o, LockModeType lockModeType) {
        return null;
    }

    @Override
    public <T> T find(Class<T> aClass, Object o, LockModeType lockModeType, Map<String, Object> map) {
        return null;
    }

    @Override
    public <T> T getReference(Class<T> aClass, Object o) {
        return null;
    }

    @Override
    public void flush() {
        makeItCount(MockPersistenceOperation.FLUSH, context);
    }

    @Override
    public void setFlushMode(FlushModeType flushModeType) {

    }

    @Override
    public FlushModeType getFlushMode() {
        return null;
    }

    @Override
    public void lock(Object o, LockModeType lockModeType) {

    }

    @Override
    public void lock(Object o, LockModeType lockModeType, Map<String, Object> map) {

    }

    @Override
    public void refresh(Object o) {
        makeItCount(MockPersistenceOperation.REFRESH, o);
    }

    @Override
    public void refresh(Object o, Map<String, Object> map) {

    }

    @Override
    public void refresh(Object o, LockModeType lockModeType) {

    }

    @Override
    public void refresh(Object o, LockModeType lockModeType, Map<String, Object> map) {

    }

    @Override
    public void clear() {

    }

    @Override
    public void detach(Object o) {
        makeItCount(MockPersistenceOperation.DETACH, o);
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public LockModeType getLockMode(Object o) {
        return null;
    }

    @Override
    public void setProperty(String s, Object o) {

    }

    @Override
    public Map<String, Object> getProperties() {
        return null;
    }

    @Override
    public Query createQuery(String s) {
        return null;
    }

    @Override
    public <T> TypedQuery<T> createQuery(CriteriaQuery<T> criteriaQuery) {
        return null;
    }

    @Override
    public Query createQuery(CriteriaUpdate criteriaUpdate) {
        return null;
    }

    @Override
    public Query createQuery(CriteriaDelete criteriaDelete) {
        return null;
    }

    @Override
    public <T> TypedQuery<T> createQuery(String s, Class<T> aClass) {
        return null;
    }

    @Override
    public Query createNamedQuery(String s) {
        return null;
    }

    @Override
    public <T> TypedQuery<T> createNamedQuery(String s, Class<T> aClass) {
        return null;
    }

    @Override
    public Query createNativeQuery(String s) {
        return null;
    }

    @Override
    public Query createNativeQuery(String s, Class aClass) {
        return null;
    }

    @Override
    public Query createNativeQuery(String s, String s1) {
        return null;
    }

    @Override
    public StoredProcedureQuery createNamedStoredProcedureQuery(String s) {
        return null;
    }

    @Override
    public StoredProcedureQuery createStoredProcedureQuery(String s) {
        return null;
    }

    @Override
    public StoredProcedureQuery createStoredProcedureQuery(String s, Class... classes) {
        return null;
    }

    @Override
    public StoredProcedureQuery createStoredProcedureQuery(String s, String... strings) {
        return null;
    }

    @Override
    public void joinTransaction() {

    }

    @Override
    public boolean isJoinedToTransaction() {
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> aClass) {
        return null;
    }

    @Override
    public Object getDelegate() {
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public boolean isOpen() {
        return false;
    }

    @Override
    public EntityTransaction getTransaction() {
        return null;
    }

    @Override
    public EntityManagerFactory getEntityManagerFactory() {
        return null;
    }

    @Override
    public CriteriaBuilder getCriteriaBuilder() {
        return null;
    }

    @Override
    public Metamodel getMetamodel() {
        return null;
    }

    @Override
    public <T> EntityGraph<T> createEntityGraph(Class<T> aClass) {
        return null;
    }

    @Override
    public EntityGraph<?> createEntityGraph(String s) {
        return null;
    }

    @Override
    public EntityGraph<?> getEntityGraph(String s) {
        return null;
    }

    @Override
    public <T> List<EntityGraph<? super T>> getEntityGraphs(Class<T> aClass) {
        return null;
    }

    public long calls(MockPersistenceOperation operation, Object obj) {
        var result = 0L;
        var cnt = obj instanceof Class ? countsClass.get(operation) : counts.get(operation);
        if (nonNull(cnt)) {
            var l = cnt.get(obj);
            if (nonNull(l)) {
                result = l;
            }
        }
        return result;
    }

    public long calls(MockPersistenceOperation operation) {
        var result = 0L;
        var cnt = countsOperation.get(operation);
        if (nonNull(cnt)) {
            result = cnt;
        }
        return result;
    }


    public void onOperation(MockPersistenceOperation operation, Object obj, BiConsumer<MockPersistenceOperation, Object> consumer) {
        onOperation.computeIfAbsent(operation, o -> new IdentityHashMap<>())
                .compute(obj, (o, v) -> consumer);
    }

    private void makeItCount(MockPersistenceOperation operation, Object obj) {
        context = obj;
        counts.computeIfAbsent(operation, o -> new IdentityHashMap<>())
                .compute(obj, this::applyCount);

        countsClass.computeIfAbsent(operation, o -> new IdentityHashMap<>())
                .compute(obj.getClass(), this::applyCount);

        for (var i : obj.getClass().getInterfaces()) {
            countsClass.computeIfAbsent(operation, o -> new IdentityHashMap<>())
                    .compute(i, this::applyCount);
        }

        countsOperation.compute(operation, this::applyCount);

        var consumer = onOperation.computeIfAbsent(operation, o -> new IdentityHashMap<>()).get(obj);
        if (nonNull(consumer)) {
            consumer.accept(operation, obj);
        }

        var consumerClass = onOperationClass.computeIfAbsent(operation, o -> new IdentityHashMap<>()).get(obj.getClass());
        if (nonNull(consumerClass)) {
            consumerClass.accept(operation, obj);
        }

        var consumerOperation = onOperationOperation.get(operation);
        if (nonNull(consumerOperation)) {
            consumerOperation.accept(operation, obj);
        }

    }

    private Long applyCount(Object k, Long v) {
        return nullCheck(v, vv -> vv + 1, 1L);
    }


}
