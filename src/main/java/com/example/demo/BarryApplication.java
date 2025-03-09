package com.example.demo;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class BarryApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(BarryApplication.class)
			.headless(false)
			.web(WebApplicationType.NONE)
			.run(args);
	}
}
