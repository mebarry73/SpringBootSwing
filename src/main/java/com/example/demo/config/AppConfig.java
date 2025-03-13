package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.service.UserService;

@Configuration
public class AppConfig {

	// Configuring a basic UserService bean example
	@Bean
	UserService userService() {
		return new UserService();
	}
}
