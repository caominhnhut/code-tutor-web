package com.vn.green.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vn.green.persistent.entity.UserEntity;
import com.vn.green.rest.factory.jwt.TokenHelper;
import com.vn.green.rest.model.AuthenticationRequest;
import com.vn.green.rest.model.AuthenticationResponse;

@Controller
public class AuthenticationRestService
{
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenHelper tokenHelper;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) throws Exception
	{
		Authentication authentication;
		try
		{
			authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		}
		catch (Exception e)
		{
			throw new Exception("Authentication failed: ", e);
		}

		// Inject into security context
		SecurityContextHolder.getContext().setAuthentication(authentication);

		UserEntity user = (UserEntity) authentication.getPrincipal();

		final String token = tokenHelper.generateToken(user.getUsername());

		return ResponseEntity.ok(new AuthenticationResponse(token, tokenHelper.getExpiresIn()));
	}
}
