package com.bridgelabs.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class DoctorDetailsDto
{
	private String doctorName;
	private String specilization;
	private long mobileNumber;
	private LocalDateTime availabity;
	
}
