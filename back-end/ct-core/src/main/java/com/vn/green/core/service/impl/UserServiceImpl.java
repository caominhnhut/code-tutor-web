package com.vn.green.core.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.postgresql.util.PSQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vn.green.core.dto.RegisteredUser;
import com.vn.green.core.mapper.Mapper;
import com.vn.green.core.model.User;
import com.vn.green.core.service.UserService;
import com.vn.green.core.validation.ValidationException;
import com.vn.green.core.validation.ValidationRequest;
import com.vn.green.core.validation.Validator;
import com.vn.green.persistent.entity.Authority;
import com.vn.green.persistent.entity.UserEntity;
import com.vn.green.persistent.repository.UserRepository;
import com.google.common.base.Throwables;

@Service
public class UserServiceImpl implements UserService
{
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	@Lazy
	private PasswordEncoder passwordEncoder;

	@Autowired
	private List<Validator<?>> validators;

	@Override
	public List<User> findAll()
	{
		List<UserEntity> users = userRepository.findAll();
		return users.stream().map(Mapper::convert).collect(Collectors.toList());
	}

	@Override
	public RegisteredUser create(RegisteredUser registeredUser)
	{
		for (Validator validator : validators)
		{
			try
			{
				validator.validate(new ValidationRequest());
			}
			catch (ValidationException e)
			{
				throw new UsernameNotFoundException(e.getMessage());
			}
		}

		UserEntity user = Mapper.from(registeredUser);
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		List<Authority> authorities = userRepository.getAllAuthorities();

		try
		{
			if (user.getRoles().isEmpty())
			{
				user.setAuthorities(authorities.stream().filter(authority -> "ROLE_USER".equals(authority.getName().name())).collect(Collectors.toList()));
			}
			else
			{
				List<Authority> matchedAuthorities = findMatchedAuthorities(user.getRoles(), authorities);
				user.getAuthorities().clear();
				user.setAuthorities(matchedAuthorities);
			}
			user = userRepository.create(user);
		}
		catch (RuntimeException e)
		{
			Throwable rootCause = Throwables.getRootCause(e);
			if (rootCause instanceof PSQLException)
			{
				throw new IllegalStateException(rootCause.getMessage());
			}
			logger.error(e.getMessage());
		}
		return Mapper.from(user);
	}

	private List<Authority> findMatchedAuthorities(List<Authority> firstAuthorities, List<Authority> secondAuthorities)
	{
		List<Authority> currentAuthorities = new ArrayList<>();
		for (Authority authority : firstAuthorities)
		{
			Authority existedAuthority = findAuthorityByName(secondAuthorities, authority.getName().name());
			if (existedAuthority != null)
			{
				currentAuthorities.add(existedAuthority);
			}
		}
		return currentAuthorities;
	}

	private Authority findAuthorityByName(List<Authority> authorities, String name)
	{
		for (Authority authority : authorities)
		{
			if (name.equals(authority.getName().name()))
			{
				return authority;
			}
		}
		return null;
	}
}
