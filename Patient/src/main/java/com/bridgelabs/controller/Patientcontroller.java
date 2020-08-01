package com.bridgelabs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabs.dto.PatientLogin;
import com.bridgelabs.dto.PatientRegistration;
import com.bridgelabs.exception.UserException;
import com.bridgelabs.model.PatientModel;
import com.bridgelabs.responses.Responses;
import com.bridgelabs.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {
	@Autowired
	private PatientService patientService;

	// API for registration

	@PostMapping("/patientRegistration")
	public ResponseEntity<Responses> patientRegistration(@RequestBody PatientRegistration PatientRegistration) throws UserException {
		PatientModel result = patientService.addPatient(PatientRegistration);
		if (result != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(new Responses("Successfully registerd", 200, result));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Responses("Registration failed", 400, result));

		}

	}

	// API for login
	@PostMapping("/patientLogin")
	public ResponseEntity<Responses> patientLogin(@RequestBody PatientLogin patientLogin) throws UserException {
		String result = patientService.loginPatient(patientLogin);
		if (result != null) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Responses("Successfully login", 200, result));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Responses("Login failed", 400, result));

		} 

	}
	// API for verification purpose

	@GetMapping(value = "/verify/{token}")
	public ResponseEntity<Responses> verify(@PathVariable String token) {
		boolean result = patientService.verify(token);

		return (result) ? ResponseEntity.status(HttpStatus.ACCEPTED).body(new Responses("verified successfully", 200))
				: ResponseEntity.status(HttpStatus.ACCEPTED).body(new Responses("verified unsuccessfully", 400));

	}

	// API for getting all
	@GetMapping(value = "/allPatient")
	public List<PatientModel> getAllPatients() {
		return patientService.getAllPatints();

	}

	// Getting patient by id

	@GetMapping(value = "/patientbyId/{token}")
	public ResponseEntity<Responses> gettingPatientbyid(@PathVariable String token) {
		PatientModel patient = patientService.getPatientById(token);
		if (patient != null) {
			return ResponseEntity.status(HttpStatus.ACCEPTED)
					.body(new Responses("Patient fecthed uccessfully", 200, patient));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Responses("Unable to fetch patient data", 400, patient));
		}

	}

	// Getting patient by name

	@GetMapping(value = "/patietByName/{name}")
	public ResponseEntity<Responses> gettingPatientbyname(@PathVariable String name) throws UserException {
		PatientModel patient = patientService.getPatientByName(name);
		if (patient != null) {
			return ResponseEntity.status(HttpStatus.ACCEPTED)
					.body(new Responses("Patient fecthed uccessfully", 200, patient));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new Responses("Unable to fetch patient data", 400, patient));

	}

}
