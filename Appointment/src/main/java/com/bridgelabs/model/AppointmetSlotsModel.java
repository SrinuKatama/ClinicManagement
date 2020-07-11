package com.bridgelabs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class AppointmetSlotsModel 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String doctorName;
	//private String specialization;
	private String availabilitydate;
	private String slot1;
	private String slot2;
	private String slot3;
	private boolean slot1availability;
	private boolean slot2availability;
	private boolean slot3availability;

	

}
