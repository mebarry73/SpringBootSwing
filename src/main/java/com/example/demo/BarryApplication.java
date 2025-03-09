package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class BarryApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(BarryApplication.class)
			.headless(false)
			//.web(WebApplicationType.NONE)
			.run(args);
	}
}
