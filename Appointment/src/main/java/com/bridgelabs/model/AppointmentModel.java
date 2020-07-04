package com.bridgelabs.model;

import java.time.LocalDateTime;

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

	private LocalDateTime appointmentFixedtime;

	private String patientName;

	private String doctorName;

}
