package com.gls.gs.persistent.repository.user;

import java.util.List;

import com.gls.gs.persistent.entity.Authority;
import com.gls.gs.persistent.entity.UserEntity;
import com.gls.gs.persistent.repository.GenericDao;

public interface UserRepository extends GenericDao<UserEntity>
{
	List<Authority> getAllAuthorities();

	UserEntity findByEmail(String email);
}
