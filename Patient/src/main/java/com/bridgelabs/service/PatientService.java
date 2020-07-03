package com.bridgelabs.service;

import java.util.List;

import com.bridgelabs.dto.PatientLogin;
import com.bridgelabs.dto.PatientRegistration;
import com.bridgelabs.model.PatientModel;

public interface PatientService {
	PatientModel addPatient(PatientRegistration PatientRegistration);

	String loginPatient(PatientLogin PatientLogin);

	boolean verify(String token);

	List<PatientModel> getAllPatints();

	PatientModel getPatientById(String token);

}
