package com.gls.gs.core.user;

import java.util.List;

import com.gls.gs.core.dto.RegisteredUser;
import com.gls.gs.core.user.model.User;

public interface UserService
{
	List<User> findAll();

	RegisteredUser create(RegisteredUser registeredUser);
}
