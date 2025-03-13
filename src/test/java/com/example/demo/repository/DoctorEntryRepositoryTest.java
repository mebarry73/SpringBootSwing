package com.example.demo.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.model.DoctorEntry;

@DataJpaTest
class DoctorEntryRepositoryTest {

	@Autowired
	private DoctorEntryRepository repository;

	@Test
	public void testFindById() {
		DoctorEntry doctorEntry1 = DoctorEntry.builder().name("Barry").license("007").build();
		DoctorEntry saved = repository.save(doctorEntry1);
		DoctorEntry doctorEntry2 = DoctorEntry.builder().name("Max").license("007").build();
		repository.save(doctorEntry2);

		Optional<DoctorEntry> result = repository.findById(saved.getId());

		assertTrue(result.isPresent());
		assertNotNull(result.get());
		assertEquals("Barry", result.get().getName());
	}
}
