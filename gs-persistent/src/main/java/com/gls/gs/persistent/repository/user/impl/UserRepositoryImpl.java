package com.gls.gs.persistent.repository.user.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gls.gs.persistent.entity.Authority;
import com.gls.gs.persistent.entity.UserEntity;
import com.gls.gs.persistent.repository.AbstractGenericDao;
import com.gls.gs.persistent.repository.user.UserRepository;

@Repository("userRepository")
@Transactional
public class UserRepositoryImpl extends AbstractGenericDao<UserEntity> implements UserRepository
{

	@PostConstruct
	public void init()
	{
		super.setClazz(UserEntity.class);
	}

	@Override
	public List<Authority> getAllAuthorities()
	{
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Authority> cq = cb.createQuery(Authority.class);
		Root<Authority> authority = cq.from(Authority.class);
		cq.select(authority);
		TypedQuery<Authority> query = em.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public UserEntity findByEmail(String email)
	{
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
		Root<UserEntity> user = cq.from(UserEntity.class);
		cq.select(user);
		cq.where(cb.equal(user.get("email"), email));
		TypedQuery<UserEntity> query = em.createQuery(cq);

		List<UserEntity> users = query.getResultList();
		if (users == null || users.isEmpty())
		{
			return new UserEntity();
		}

		return users.get(0);
	}
}
