package com.bridgelabs.service;

import java.util.List;

import com.bridgelabs.dto.PatientLogin;
import com.bridgelabs.dto.PatientRegistration;
import com.bridgelabs.exception.UserException;
import com.bridgelabs.model.PatientModel;

public interface PatientService {
	PatientModel addPatient(PatientRegistration PatientRegistration) throws UserException;

	String loginPatient(PatientLogin PatientLogin) throws UserException;

	boolean verify(String token);

	List<PatientModel> getAllPatints();

	PatientModel getPatientById(String token);
	
	PatientModel getPatientByName(String name) throws UserException;

}
