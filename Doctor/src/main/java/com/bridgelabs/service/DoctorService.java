package com.bridgelabs.service;

import java.util.List;

import com.bridgelabs.dto.DoctorDetailsDto;
import com.bridgelabs.model.DoctorModel;

public interface DoctorService 
{
	DoctorModel cerateDoctor(DoctorDetailsDto DoctorDetailsDto);
	List<DoctorModel> getAllDoctor();
	List<DoctorModel> findDoctorBySpetilization( String diesease);
	String getDoctorbyname(String name);
	

}
