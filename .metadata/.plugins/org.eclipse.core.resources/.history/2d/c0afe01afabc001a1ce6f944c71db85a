package com.bridgelabs.service;

import java.util.List;

import com.bridgelabs.dto.PatientLogin;
import com.bridgelabs.dto.PatientRegistration;
import com.bridgelabs.model.Patient;

public interface PatientService {
	Patient addPatient(PatientRegistration PatientRegistration);

	String loginPatient(PatientLogin PatientLogin);

	boolean verify(String token);

	List<Patient> getAllPatints();

	Patient getPatientById(String token);

}
