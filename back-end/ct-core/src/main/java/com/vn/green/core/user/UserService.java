package com.vn.green.core.user;

import java.util.List;

import com.vn.green.core.dto.RegisteredUser;
import com.vn.green.core.user.model.User;

public interface UserService
{
	List<User> findAll();

	RegisteredUser create(RegisteredUser registeredUser);
}
