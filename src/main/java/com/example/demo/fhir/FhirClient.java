package com.example.demo.fhir;

import java.util.ArrayList;

import org.apache.http.Header;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.hl7.fhir.instance.model.api.IIdType;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.r5.model.ContactPoint.ContactPointUse;
import org.hl7.fhir.r5.model.Enumerations.ObservationStatus;
import org.hl7.fhir.r5.model.Observation;
import org.hl7.fhir.r5.model.Patient;
import org.hl7.fhir.r5.model.Quantity;
import org.hl7.fhir.r5.model.Reference;
import org.hl7.fhir.r5.model.StringType;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import lombok.extern.java.Log;

@Log
public class FhirClient {

	private static FhirClient INSTANCE;
	private final IGenericClient client;

	public static FhirClient getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new FhirClient();

		}
		return INSTANCE;
	}

	private FhirClient() {
		client = createClient();
	}

	private IGenericClient createClient() {
		// Create a context using FHIR R5
		FhirContext ctx = FhirContext.forR5();

		// create an header containing the api key for the httpClient
		Header header = new BasicHeader("x-api-key", "api-key");
		ArrayList<Header> headers = new ArrayList<Header>();
		headers.add(header);

		// create an httpClient builder and add the header to it
		HttpClientBuilder builder = HttpClientBuilder.create();
		builder.setDefaultHeaders(headers);

		// create an httpClient using the builder
		CloseableHttpClient httpClient = builder.build();

		// Set the httpClient to the context using the factory
		ctx.getRestfulClientFactory().setHttpClient(httpClient);

		// Create a client, we need the url from configuration
		return ctx.newRestfulGenericClient("url");
	}

	/**
	 * the arguments must be in the signature
	 * 
	 * @return patient
	 */
	public Patient createPatient() {
		// Create a patient and add a name to it
		Patient patient = new Patient();
		patient.addName().setFamily("FamilyName").addGiven("GivenName1").addGiven("GivenName2");
		// See also patient.setGender or setBirthDateElement

		// Create a contact for patient
		patient.addTelecom().setSystem(ContactPointSystem.PHONE).setUse(ContactPointUse.HOME).setValue("555-555-5555");

		// Create the resource patient on the server
		MethodOutcome outcome = client.create().resource(patient).execute();

		// Log the ID that the server assigned
		IIdType id = outcome.getId();
		log.info("Created patient, got ID: " + id);

		return patient;
	}

	public Patient searchPatient() {
		// Search for a single patient with the exact family name "FamilyName" and the
		// exact given name "GivenName1"
		Patient patient = (Patient) client.search().forResource(Patient.class)
				.where(Patient.FAMILY.matchesExactly().value("FamilyName"))
				.and(Patient.GIVEN.matchesExactly().value("GivenName1")).returnBundle(Bundle.class).execute()
				.getEntryFirstRep().getResource();

		return patient;
	}

	public void updatePatient(Patient patient) {
		// Change the patient given name to another
		patient.getName().get(0).getGiven().set(0, new StringType("AnotherGivenName"));

		// Update the resource patient on the server
		client.update().resource(patient).execute();
	}

	public Observation createObservation(Patient patient) {
		// Create a CodeableConcept and fill it
		CodeableConcept codeableConcept = new CodeableConcept();
		codeableConcept.addCoding().setSystem("http://snomed.info/sct").setCode("1234")
				.setDisplay("CodeableConceptDisplay");

		// Create a Quantity and fill it
		Quantity quantity = new Quantity();
		quantity.setValue(1.0);
		quantity.setUnit("kg");

		// Create a Category and fill it
		CodeableConcept category = new CodeableConcept();
		category.addCoding().setSystem("http://snomed.info/sct").setCode("1234").setDisplay("CategoryDisplay");

		// Create a list of CodeableConcepts and put category into it
		ArrayList<CodeableConcept> codeableConcepts = new ArrayList<CodeableConcept>();
		codeableConcepts.add(category);

		// Create an Observation
		Observation observation = new Observation();
		observation.setStatus(ObservationStatus.FINAL);
		observation.setCode(codeableConcept);
		observation
				.setSubject(new Reference().setReference("Patient/" + ((IIdType) patient.getIdElement()).getIdPart()));
		observation.setCategory(codeableConcepts);
		observation.setValue(quantity);
		log.info("Created observation, reference : " + observation.getSubject().getReference());

		// Create the resource observation on the server
		MethodOutcome result = client.create().resource(observation).execute();
		log.info("Created observation, got ID: " + result.getId());

		return observation;
	}

}
