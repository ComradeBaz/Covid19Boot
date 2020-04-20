package com.domrade.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.domrade.dao.interfaces.Dao;

public abstract class JpaDao<K, E> implements Dao<K, E> {

	protected Class<E> entityClass;

	@PersistenceContext
	protected EntityManager entityManager;

	public JpaDao(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

        @Override
	public void persist(E entity) {
		entityManager.persist(entity);
	}

        @Override
	public void remove(E entity) {
		entityManager.remove(entity);
	}

        @Override
	public E findById(K id) {
		return entityManager.find(entityClass, id);
	}

}
