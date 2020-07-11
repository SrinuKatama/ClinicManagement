package com.bridgelabs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabs.dto.AppointmentDetails;
import com.bridgelabs.dto.AppointmentSlots;
import com.bridgelabs.model.AppointmentModel;
import com.bridgelabs.responses.Responses;
import com.bridgelabs.serviceimplementation.AppointmentServiceImplementation;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "appointment")
public class AppointmentController
{
	@Autowired
	private AppointmentServiceImplementation serve;
	
	@PutMapping(value = "/forfixingappointment/{name}/{specialization}")
	@ApiOperation(value = "Appointment api")
	public ResponseEntity<Responses> forFixAppointment(@PathVariable String name,@PathVariable String specialization,
			@RequestBody AppointmentDetails AppointmentDetails)
	{
		boolean result=serve.fixAppointment(name, specialization, AppointmentDetails);
		if(result == true)
		{
			return ResponseEntity.status(HttpStatus.CREATED).body(new Responses("Appointment done successfully", 200, result));

		}
		else
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Responses("Appointment denied", 400, result));

		}
	}
	
	//API for all appointments
	
	@GetMapping(value = "/forgettingallappointments")
	@ApiOperation(value = "All appointment api")
	public ResponseEntity<Responses> forGettigAllAppointments()
	{
		List<AppointmentModel> result=serve.getAllAppointments();
		if(result!=null)
		{
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Responses("Fetching successfull", 200, result));

		}
		else
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Responses("Fetching failed", 400, result));

		}
	}

}
