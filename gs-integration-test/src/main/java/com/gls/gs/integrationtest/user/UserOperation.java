package com.gls.gs.integrationtest.user;

import java.io.IOException;

import org.junit.Assert;

import com.gls.gs.integrationtest.rest.RestClient;

public class UserOperation
{
//	private AuthenticationResponse response;
//
//	public void register(String email, String password, String confirmedPassword) throws IOException
//	{
//		RegisteredUser registeredUser = new RegisteredUser();
//		registeredUser.setEmail(email);
//		registeredUser.setPassword(password);
//		registeredUser.setConfirmedPassword(confirmedPassword);
//
//		RestClient<RegisteredUser> restClient = new RestClient<>("user/register", RegisteredUser.class);
//		restClient.post(registeredUser);
//	}
//
//	public void login(String username, String password) throws IOException
//	{
//		AuthenticationRequest authenticationRequest = new AuthenticationRequest(username, password);
//		RestClient<AuthenticationResponse> restClient = new RestClient<>("authenticate", AuthenticationResponse.class);
//		this.response = restClient.post(authenticationRequest);
//		System.out.println(response.getToken());
//	}
//
//	public void checkToken()
//	{
//		Assert.assertTrue(response.getToken().length() > 0);
//	}
}
