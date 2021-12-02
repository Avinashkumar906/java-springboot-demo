package com.asquare.controller;

import com.asquare.dto.UserDtailsDto;
import com.asquare.model.UserDetailRequest;
import com.asquare.model.UserDetailResponse;
import com.asquare.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class User {

	@Autowired
	private UserService userService;

	@GetMapping
	public String getUser() {
		return "Get user function called!";
	}

	@PostMapping
	public UserDetailResponse postUser(@RequestBody UserDetailRequest user) {

		UserDtailsDto userDtailsDto = new UserDtailsDto();
		BeanUtils.copyProperties(user, userDtailsDto);

		UserDtailsDto savedUser = userService.createUser(userDtailsDto);

		UserDetailResponse userDetailResponse = new UserDetailResponse();
		BeanUtils.copyProperties(savedUser,userDetailResponse);

		return userDetailResponse;
	}

	@PutMapping
	public String putUser() {
		return "Put user function called!";
	}

	@DeleteMapping
	public String deleteUser() {
		System.out.println("in delete function");
		return "Delete user function called!";
	}
	
}
