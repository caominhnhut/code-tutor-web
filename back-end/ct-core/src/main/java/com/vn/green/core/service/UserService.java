package com.vn.green.core.service;

import java.util.List;

import com.vn.green.core.dto.RegisteredUser;
import com.vn.green.core.model.User;

public interface UserService
{
	List<User> findAll();

	RegisteredUser create(RegisteredUser registeredUser);
}
