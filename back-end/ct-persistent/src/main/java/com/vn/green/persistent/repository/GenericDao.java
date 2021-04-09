package com.vn.green.persistent.repository;

import java.util.List;

public interface GenericDao<T>
{
	T findOne(long id);

	List<T> findAll();

	T create(T entity);

	T update(T entity);

	void delete(T entity);

	void deleteById(long entityId);
}
