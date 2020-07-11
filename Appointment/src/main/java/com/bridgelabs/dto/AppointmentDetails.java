
package com.bridgelabs.dto;


import lombok.Data;

@Data
public class AppointmentDetails {
	//private LocalDateTime appointmentTime;
	
	private String patientProblem;
	private String specialization;
	private String doctorName;
	private String patientName;
	private boolean isbook;
	
	

	
}
