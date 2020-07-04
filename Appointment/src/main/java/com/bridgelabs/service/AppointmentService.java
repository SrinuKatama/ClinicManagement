package com.bridgelabs.service;

import com.bridgelabs.dto.AppointmentDetails;

public interface AppointmentService 
{
	public boolean fixAppointment(String token,String specialization,AppointmentDetails AppointmentDetails);

}
