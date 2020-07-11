package com.bridgelabs.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class AppointmentModel 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long appoinmentId;

	private String patientName;

	private String doctorName;
	
	private String slot;
	
	private boolean isbook;

//	private LocalDateTime appointmentFixedtime;
	
	
    
    


}
