package com.itakademija.event.ejb;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaQuery;

import java.util.List;

public abstract class AbstractService<E> {

    private Class<E> entityClass;

    public AbstractService(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    public abstract EntityManager getEntityManager();

    public void create(E entity) {
        getEntityManager().persist(entity);
    }

    public E find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<E> findAll() {
        CriteriaQuery<E> criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery(entityClass);
        criteriaQuery.select(criteriaQuery.from(entityClass));
        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }

    public void edit(E entity) {
        getEntityManager().merge(entity);
    }

    public void remove(E entity) {
        if (!getEntityManager().contains(entity)) {
            entity = getEntityManager().merge(entity);
        }
        getEntityManager().remove(entity);
    }
}
