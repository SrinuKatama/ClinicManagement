package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.PatientLogin;
import com.example.demo.dto.PatientRegistration;
import com.example.demo.model.Patientmodel;

public interface PatientService 
{
	Patientmodel addPatient(PatientRegistration PatientRegistration);
	/*
	 * String login_Patient(PatientLogin PatientLogin); boolean verify(String
	 * token); List<Patientmodel> getallpatints(); Patientmodel
	 * getpatientById(String token);
	 */

}
