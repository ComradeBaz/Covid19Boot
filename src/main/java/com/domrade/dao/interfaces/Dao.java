package com.domrade.dao.interfaces;

import org.springframework.stereotype.Service;

@Service
public interface Dao<K, E> {

	public void persist(E entity);

	public void remove(E entity);

	public E findById(K id);

}
