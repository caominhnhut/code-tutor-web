package com.vn.green.persistent.repository.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vn.green.common.exceptions.NotFoundException;
import com.vn.green.persistent.entity.Authority;
import com.vn.green.persistent.entity.UserEntity;
import com.vn.green.persistent.entity.UserEntity_;
import com.vn.green.persistent.repository.AbstractGenericDao;
import com.vn.green.persistent.repository.UserRepository;

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
	public UserEntity findByEmail(String email) throws NotFoundException
	{
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
		Root<UserEntity> user = cq.from(UserEntity.class);
		cq.select(user);
		cq.where(cb.equal(user.get(UserEntity_.EMAIL), email));
		TypedQuery<UserEntity> query = em.createQuery(cq);

		List<UserEntity> users = query.getResultList();
		if (users == null || users.isEmpty())
		{
			throw new NotFoundException("The user with user name [%s] not found");
		}

		return users.get(0);
	}
}
