package com.asquare.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class User {

	@GetMapping
	public String getUser() {
		return "Get user function called!";
	}

	@PostMapping
	public String postUser() {
		return "Post user function called!";
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
