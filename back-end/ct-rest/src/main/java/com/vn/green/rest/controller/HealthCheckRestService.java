package com.vn.green.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HealthCheckRestService
{
	@GetMapping("/no-auth/health-check")
	@ResponseBody
	public String healthCheck()
	{
		return "Hello, nice to meet you!";
	}
}
