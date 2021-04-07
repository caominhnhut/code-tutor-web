package com.gls.gs.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gls.gs.core.dto.RegisteredUser;
import com.gls.gs.core.user.model.User;
import com.gls.gs.core.user.UserService;

@Controller
@RequestMapping(value = "/user/")
public class UserRestService
{
	@Autowired
	private UserService userService;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "all", method = RequestMethod.GET)
	@ResponseBody
	public List<User> findUser()
	{
		return userService.findAll();
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<RegisteredUser> register(@Valid @RequestBody RegisteredUser userDto)
	{
		userDto = userService.create(userDto);
		return new ResponseEntity<>(userDto, HttpStatus.CREATED);
	}
}
