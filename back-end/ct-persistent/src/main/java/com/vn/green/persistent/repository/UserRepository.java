package com.vn.green.persistent.repository;

import java.util.List;

import com.vn.green.common.exceptions.NotFoundException;
import com.vn.green.persistent.entity.Authority;
import com.vn.green.persistent.entity.UserEntity;

public interface UserRepository extends GenericDao<UserEntity>
{
	List<Authority> getAllAuthorities();

	UserEntity findByEmail(String email) throws NotFoundException;
}
