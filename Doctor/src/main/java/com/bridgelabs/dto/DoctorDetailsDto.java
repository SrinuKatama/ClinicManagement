package com.bridgelabs.dto;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetTime;
import java.util.Date;
import java.util.Timer;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Data;

@Data
public class DoctorDetailsDto {
	
	
	private String specilization;
	private long mobileNumber;
	private String doctorName;
	
	
	/*
	 * String datepattern = "MM-dd-yyyy"; String timepattern = "HH:mm:ss";
	 * 
	 * SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datepattern);
	 * SimpleDateFormat simpleTimeFormat = new SimpleDateFormat(timepattern);
	 * 
	 * 
	 * 
	 * //@Column(name = "availability") private String availabilitydate =
	 * simpleDateFormat.format(new Date());
	 * 
	 * private String slot1=simpleTimeFormat.format(new Date()); private String
	 * slot2=simpleTimeFormat.format(new Date());
	 * 
	 * private String slot3=simpleTimeFormat.format(new Date());
	 * 
	 * 
	 * private boolean slot1availability; private boolean slot2availability; private
	 * boolean slot3availability; public String getSpecilization() { return
	 * specilization; } public void setSpecilization(String specilization) {
	 * this.specilization = specilization; } public long getMobileNumber() { return
	 * mobileNumber; } public void setMobileNumber(long mobileNumber) {
	 * this.mobileNumber = mobileNumber; } public String getDoctorName() { return
	 * doctorName; } public void setDoctorName(String doctorName) { this.doctorName
	 * = doctorName; } public String getAvailabilitydate() { return
	 * availabilitydate; } public void setAvailabilitydate(String availabilitydate)
	 * { this.availabilitydate = availabilitydate; } public String getSlot1() {
	 * return slot1; } public void setSlot1(String slot1) { this.slot1 = slot1; }
	 * public String getSlot2() { return slot2; } public void setSlot2(String slot2)
	 * { this.slot2 = slot2; } public String getSlot3() { return slot3; } public
	 * void setSlot3(String slot3) { this.slot3 = slot3; } public boolean
	 * isSlot1availability() { return slot1availability; } public void
	 * setSlot1availability(boolean slot1availability) { this.slot1availability =
	 * slot1availability; } public boolean isSlot2availability() { return
	 * slot2availability; } public void setSlot2availability(boolean
	 * slot2availability) { this.slot2availability = slot2availability; } public
	 * boolean isSlot3availability() { return slot3availability; } public void
	 * setSlot3availability(boolean slot3availability) { this.slot3availability =
	 * slot3availability; }
	 * 
	 * 
	 */
}
