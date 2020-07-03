package com.bridgelabs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabs.dto.DoctorDetailsDto;
import com.bridgelabs.model.DoctorModel;
import com.bridgelabs.responces.Responses;
import com.bridgelabs.serviceImplementation.DoctorServiceImp;

@RestController
@RequestMapping(value = "/doctor")
public class DoctorController 
{
	@Autowired
	private DoctorServiceImp docterserv;
	
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
	
	
	

}