package com.example.demo;

import java.awt.EventQueue;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.controller.BarryController;

@Component
public class SpringBootSwingCommandLineRunner implements CommandLineRunner {
	private final BarryController controller;

	public SpringBootSwingCommandLineRunner(BarryController controller) {
		this.controller = controller;
	}

	@Override
	public void run(String ... args) {
		EventQueue.invokeLater(() -> controller.setVisible(true));
	}
}
