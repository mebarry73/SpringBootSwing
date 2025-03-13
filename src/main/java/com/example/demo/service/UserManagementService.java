package com.example.demo.service;

import org.springframework.stereotype.Service;

import lombok.Getter;

@Service
@Getter
public class UserManagementService {
	private final UserService userService;

	// constructor injection
	public UserManagementService(UserService userService) {
		this.userService = userService;
	}
}