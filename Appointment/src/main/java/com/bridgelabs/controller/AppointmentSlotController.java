package com.bridgelabs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabs.dto.AppointmentSlots;
import com.bridgelabs.model.AppointmetSlotsModel;
import com.bridgelabs.responses.Responses;
import com.bridgelabs.serviceimplementation.AppointmentSlotServicedimp;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/slot")
public class AppointmentSlotController
{
	@Autowired
	private AppointmentSlotServicedimp seve;
	
	
	// API for creation of doctorsslots
	@PutMapping(value = "/slotcreation/{docname}")
	@ApiOperation(value = "Doctors slot creation")
	public ResponseEntity<Responses> createSlotsForDoctor( @PathVariable String docname,@RequestBody AppointmentSlots AppointmentSlots)
	{
		AppointmetSlotsModel result=seve.createSlotsforDoctor(AppointmentSlots,docname );
		
		if(result !=null)
		{
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Responses("Successfully slots created", 200, result));

		}
		else
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Responses("Unable to create the slots", 400, result));

		}
		
	}

}
