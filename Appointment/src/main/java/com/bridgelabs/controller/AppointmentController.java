package com.bridgelabs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabs.dto.AppointmentDetails;
import com.bridgelabs.responses.Responses;
import com.bridgelabs.serviceimplementation.AppointmentServiceImplementation;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "appointment")
public class AppointmentController
{
	@Autowired
	private AppointmentServiceImplementation serve;
	
	@PutMapping(value = "/forfixingappointment")
	@ApiOperation(value = "Appointment api")
	public ResponseEntity<Responses> forFixAppointment(String token,AppointmentDetails AppointmentDetails)
	{
		boolean result=serve.fixAppointment(token, AppointmentDetails.getSpecialization(), AppointmentDetails);
		if(result ==true)
		{
			return ResponseEntity.status(HttpStatus.CREATED).body(new Responses("Appointment done successfully", 200, result));

		}
		else
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Responses("Appointment denied", 400, result));

		}
	}
	

}
