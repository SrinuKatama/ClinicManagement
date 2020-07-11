package com.bridgelabs.service;

import java.util.List;

import com.bridgelabs.dto.AppointmentDetails;
import com.bridgelabs.dto.AppointmentSlots;
import com.bridgelabs.model.AppointmentModel;

public interface AppointmentService 
{
	public boolean fixAppointment(String token,String specialization,AppointmentDetails AppointmentDetails);
	List<AppointmentModel> getAllAppointments();

}
