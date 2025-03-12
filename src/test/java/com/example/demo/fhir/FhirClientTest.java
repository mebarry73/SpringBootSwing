package com.example.demo.fhir;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.sql.Date;

import org.hl7.fhir.r5.model.Observation;
import org.hl7.fhir.r5.model.Patient;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import lombok.extern.java.Log;

/**
 * example unit test
 * @Disabled because we have no server
 */
@Log
@RunWith(JUnit4.class)
@Disabled
public class FhirClientTest {

	private FhirClient instance;

	@Before
	public void init() {
		instance = FhirClient.getInstance();
		assertNotNull(instance);
		assertInstanceOf(FhirClient.class, instance);
	}

	@Test
	public void testGetInstance() {
		FhirClient instance = FhirClient.getInstance();
		assertNotNull(instance);
		assertInstanceOf(FhirClient.class, instance);
	}

	@Test
	public void testCreatePatient() {
		Patient patient = instance.createPatient();
		assertNotNull(patient);
		assertInstanceOf(Patient.class, instance);
	}

	@Test
	public void testSearchPatient() {
		Patient patient = instance.searchPatient();
		assertNotNull(patient);
		assertInstanceOf(Patient.class, patient);
		assertEquals(Date.valueOf("yyyy-[m]m-[d]d"), patient.getBirthDate());
	}

	@Test
	public void testUpdatePatient() {
		Patient patient = instance.searchPatient();
		assertNotNull(patient);
		assertInstanceOf(Patient.class, patient);
		assertEquals(Date.valueOf("updated name"), patient.getName());
	}

	@Test
	public void testCreateObservation() {
		Patient patient = instance.createPatient();
		assertNotNull(patient);
		assertInstanceOf(Patient.class, instance);

		Observation observation = instance.createObservation(patient);
		assertNotNull(observation);
		assertInstanceOf(Observation.class, patient);
	}
}