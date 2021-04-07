package com.gls.gs.core.mapper;

import java.util.function.Function;

import com.gls.gs.common.enums.AuthorityName;
import com.gls.gs.core.dto.RegisteredUser;
import com.gls.gs.core.user.model.User;
import com.gls.gs.persistent.entity.Authority;
import com.gls.gs.persistent.entity.UserEntity;

public class Mapper
{
	private static Function<RegisteredUser, UserEntity> registeredUserToUserEntity = registeredUser -> {
		UserEntity user = new UserEntity();
		user.setEmail(registeredUser.getEmail());
		user.setPassword(registeredUser.getPassword());
		registeredUser.getAuthorities().forEach(name -> {
			Authority authority = new Authority();
			authority.setName(AuthorityName.valueOf(name));
			user.getRoles().add(authority);
		});
		return user;
	};

	private static Function<UserEntity, RegisteredUser> userEntityToRegisteredUser = userEntity -> {
		RegisteredUser registeredUser = new RegisteredUser();
		registeredUser.setId(userEntity.getId());
		registeredUser.setEmail(userEntity.getEmail());
		return registeredUser;
	};

	private static Function<UserEntity, User> userEntityToUser = userEntity -> {
		return new User(userEntity.getId(), userEntity.getEmail());
	};

	public static UserEntity from(RegisteredUser userRequest)
	{
		return registeredUserToUserEntity.apply(userRequest);
	}

	public static RegisteredUser from(UserEntity user)
	{
		return userEntityToRegisteredUser.apply(user);
	}

	public static User convert(UserEntity user)
	{
		return userEntityToUser.apply(user);
	}
}
