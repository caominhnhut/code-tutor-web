package com.vn.green.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vn.green.common.exceptions.NotFoundException;
import com.vn.green.persistent.repository.UserRepository;

@Service
public class UserDetailService implements UserDetailsService
{
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username)
	{
		try
		{
			return userRepository.findByEmail(username);
		}
		catch (NotFoundException e)
		{
			throw new UsernameNotFoundException(e.getMessage());
		}
	}
}
