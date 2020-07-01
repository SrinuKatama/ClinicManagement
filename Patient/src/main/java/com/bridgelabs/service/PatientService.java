package com.bridgelabs.service;

import java.util.List;

import com.bridgelabs.dto.PatientLogin;
import com.bridgelabs.dto.PatientRegistration;
import com.bridgelabs.model.Patientmodel;

public interface PatientService {
	Patientmodel addPatient(PatientRegistration PatientRegistration);

	String login_Patient(PatientLogin PatientLogin);

	boolean verify(String token);

	List<Patientmodel> getallpatints();

	Patientmodel getpatientById(String token);

}
