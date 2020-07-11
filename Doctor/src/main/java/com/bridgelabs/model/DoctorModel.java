package com.bridgelabs.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetTime;
import java.util.Date;
import java.util.Formatter;
import java.util.Timer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Data;

@Entity
@Data
public class DoctorModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long doctorId;
	private String specilization;
	private long mobileNumber;
	private String doctorName;
	
	
	
	
	//private String availabilitydate;
	
	
	/*
	 * private String slot1; private String slot2; private String slot3; private
	 * boolean slot1availability; private boolean slot2availability; private boolean
	 * slot3availability;
	 */

	// private LocalDateTime availabity;

	/*
	 * @JsonFormat(pattern = "YYYY:MM;DD" ,shape = Shape.STRING)
	 * 
	 * @Temporal(value = TemporalType.TIMESTAMP) private Timestamp avilabilityDate;
	 */

}
