package com.bridgelabs.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Data
public class DoctorModel
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long doctorId;
	
	
	private String doctorName;
	
	private String specilization;
	
	private long mobileNumber;
	
	private LocalDateTime availabity;
	

}