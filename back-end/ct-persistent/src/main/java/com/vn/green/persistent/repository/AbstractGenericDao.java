package com.vn.green.persistent.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractGenericDao<T> implements GenericDao<T>
{
	@PersistenceContext
	protected EntityManager em;

	private Class<T> clazz;

	public void setClazz(Class<T> clazz)
	{
		this.clazz = clazz;
	}

	public T findOne(long id)
	{
		return em.find(clazz, id);
	}

	public List<T> findAll()
	{
		return em.createQuery("from " + clazz.getName()).getResultList();
	}

	@Transactional
	public T create(T entity)
	{
		em.persist(entity);
		return entity;
	}

	@Transactional
	public T update(T entity)
	{
		return (T) em.merge(entity);
	}

	@Transactional
	public void delete(T entity)
	{
		em.remove(entity);
	}

	@Transactional
	public void deleteById(long entityId)
	{
		T entity = findOne(entityId);
		delete(entity);
	}
}
