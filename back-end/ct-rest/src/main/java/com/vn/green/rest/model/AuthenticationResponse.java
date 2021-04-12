package com.vn.green.rest.model;

public class AuthenticationResponse
{
	private String token;
	private long expiresIn;

	public AuthenticationResponse(String token, long expiresIn)
	{
		this.token = token;
		this.expiresIn = expiresIn;
	}

	public long getExpiresIn()
	{
		return expiresIn;
	}

	public void setExpiresIn(long expiresIn)
	{
		this.expiresIn = expiresIn;
	}

	public void setToken(String token)
	{
		this.token = token;
	}

	public String getToken()
	{
		return this.token;
	}
}
