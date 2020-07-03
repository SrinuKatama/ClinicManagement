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
import com.bridgelabs.model.Patient;
import com.bridgelabs.responses.Responses;
import com.bridgelabs.serviceimpletation.PatientServiceImp;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/patient")
public class PatientController
{
	@Autowired
	private PatientServiceImp patientService;
	
	//API  for registration
	
	@PostMapping("/PatientRegistration")
	@ApiOperation(value = "Patient registration api")
	public ResponseEntity<Responses> patientRegistration(@RequestBody PatientRegistration PatientRegistration) {
		Patient result = patientService.addPatient(PatientRegistration);
		if (result == null) {
			return ResponseEntity.status(HttpStatus.ACCEPTED)
					.body(new Responses("Successfully registerd", 200, result));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Responses("Registration failed", 400, result));

		}
		/*
		 * public ResponseEntity<Response> addpatient(@Valid @RequestBody PatientDto
		 * patientDto, BindingResult bindingResult) throws Exception {
		 * 
		 * if (bindingResult.hasErrors()) { return
		 * ResponseEntity.status(HttpStatus.BAD_REQUEST) .body(new
		 * Response(bindingResult.getAllErrors().get(0).getDefaultMessage())); } else {
		 * PatientModel patient = service.addpatient(patientDto); return patient != null
		 * ? ResponseEntity.status(HttpStatus.CREATED).body(new
		 * Response("registration successfull", 200)) :
		 * ResponseEntity.status(HttpStatus.ALREADY_REPORTED) .body(new
		 * Response("patient already exist", 400)); } }
		 */
	}
	
	// API for login
	@PostMapping("/PatientLogin")
	@ApiOperation(value = "Patient login api")
	public ResponseEntity<Responses> patientLogin(@RequestBody PatientLogin patientLogin)
	{
		String result=patientService.loginPatient(patientLogin);
		if(result!=null)
		{
			return ResponseEntity.status(HttpStatus.ACCEPTED)
					.body(new Responses("Successfully login", 200, result));
		}
		else
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Responses("Login failed", 400, result));

		}
		
	}
	// API for verification purpose
	
	@GetMapping(value = "/verify/{token}")
	@ApiOperation(value = "token verification")
	public ResponseEntity<Responses> verify(@PathVariable String token)
	{
		boolean result=patientService.verify(token);
		
		return (result) ? ResponseEntity.status(HttpStatus.ACCEPTED).body(new Responses("verified successfully", 200)) 
				: ResponseEntity.status(HttpStatus.ACCEPTED).body(new Responses("verified unsuccessfully", 400));
		
	}
	
	// API for getting all 
	@GetMapping(value = "/getAll")
	@ApiOperation(value = "Getting all patiets")
	public List<Patient> getAllPatients()
	{
		return  patientService.getAllPatints();
		
		
	}
	
	// Getting patient by id
	
	@GetMapping(value = "/getpatientbyid/{token}")
	@ApiOperation(value = "Getting patient  by its id")
	public ResponseEntity<Responses> gettingPatientbyid(@PathVariable String token)
	{
		Patient patient=patientService.getPatientById(token);
		if(patient!=null)
		{
			return ResponseEntity.status(HttpStatus.ACCEPTED)
					.body(new Responses("Patient fecthed uccessfully", 200, patient));
		}
		else
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Responses("Unable to fetch patient data", 400, patient));
		}
		
	}

}
