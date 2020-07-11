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

import com.bridgelabs.dto.DoctorDetailsDto;
import com.bridgelabs.model.DoctorModel;
import com.bridgelabs.responces.Responses;
import com.bridgelabs.serviceImplementation.DoctorServiceImp;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/doctor")
public class DoctorController 
{
	@Autowired
	private DoctorServiceImp docterserv;
	
	
	//API for Adding the doctors
	@PutMapping(value = "/createDoctor")
	public ResponseEntity<Responses> addDoctors(@RequestBody DoctorDetailsDto DoctorDetailsDto)
	{ 
		DoctorModel result=docterserv.cerateDoctor(DoctorDetailsDto);
		if(result!=null)
		{
			return ResponseEntity.status(HttpStatus.OK).body(new Responses("Docter added Successfully", 200, result));
		}
		else
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Responses(" Unable to add Docter", 400, result));

		}
		
	}
	
	
	// API for Get all the doctors
	@GetMapping(value = "/getallDoctors")
	public ResponseEntity<Responses> getAllDoctors()
	{
		List<DoctorModel> all=docterserv.getAllDoctor();
		if(all!=null)
		{
			return ResponseEntity.status(HttpStatus.OK).body(new Responses("all doctors fecthed", 200, all));

		}
		else
		{
			return ResponseEntity.status(HttpStatus.OK).body(new Responses("Unable to fectch", 400, all));

		}
		
	}
	
	//API for get the doctor by his specialization
	
	@GetMapping(value = "/getdoctorbyspecialization/{name}")
	@ApiOperation(value = "get doctor by his spetialization")
	public ResponseEntity<Responses> getTheDOctorBySpeciallization(@PathVariable String name)
	{
		List<DoctorModel> all =docterserv.findDoctorBySpetilization(name);
		if(all!=null)
		{
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Responses("all doctors fecthed based on specialiation", 200, all));

		}
		else
		{
			return ResponseEntity.status(HttpStatus.OK).body(new Responses("Unable to fectch", 400, all));

		}
	}
	
	@GetMapping(value =  "/getdoctorbyname/{name}")
	@ApiOperation(value = "get doctor by his name")
	public ResponseEntity<Responses> getDoctorByName(@PathVariable String name)
	{
		String result=docterserv.getDoctorbyname(name);
		if(result!=null)
		{
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Responses("doctor fecthed by his name", 200, result));

		}
		else
		{
			return ResponseEntity.status(HttpStatus.OK).body(new Responses("Unable to fectch", 400, result));

		}
		
	}
	
	
	

}
