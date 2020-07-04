package com.bridgelabs.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class AppointmentDetails 
{
	private LocalDateTime appointmentTime;
	private String patientProblem;
	private String specialization;
	private String doctorName;
	private String patientName;

	
}
