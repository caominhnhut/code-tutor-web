package com.gls.gs.core.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.postgresql.util.PSQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gls.gs.core.dto.RegisteredUser;
import com.gls.gs.core.mapper.Mapper;
import com.gls.gs.core.user.UserService;
import com.gls.gs.core.user.model.User;
import com.gls.gs.persistent.entity.Authority;
import com.gls.gs.persistent.entity.UserEntity;
import com.gls.gs.persistent.repository.user.UserRepository;
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

	@Override
	public List<User> findAll()
	{
		List<UserEntity> users = userRepository.findAll();
		return users.stream().map(Mapper::convert).collect(Collectors.toList());
	}

	@Override
	public RegisteredUser create(RegisteredUser registeredUser)
	{
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
