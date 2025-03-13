package com.example.demo.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.DoctorEntryRepository;
import com.example.demo.util.Utils;

/**
 * http://localhost:8080/Psychotherapists shows all content from
 * DoctorEntryRepository as JSon can be extended with POST, GET, PATCH, and
 * DELETE
 */
@RestController
public class BarryRestController {

	@Autowired
	DoctorEntryRepository repository;

	@GetMapping("/Psychotherapists")
	public String showPsychotherapists() {
		return Utils.returnAsJson(repository.findAll());
	}
}
