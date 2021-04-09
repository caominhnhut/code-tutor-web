package com.vn.green.core.mapper;

import java.util.function.Function;

import com.vn.green.common.enums.AuthorityName;
import com.vn.green.core.dto.RegisteredUser;
import com.vn.green.core.user.model.User;
import com.vn.green.persistent.entity.Authority;
import com.vn.green.persistent.entity.UserEntity;

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
