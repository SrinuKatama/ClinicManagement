package com.bridgelabs.service;

import com.bridgelabs.dto.AppointmentSlots;
import com.bridgelabs.model.AppointmetSlotsModel;

public interface AppointmentSlotService 
{
	AppointmetSlotsModel createSlotsforDoctor(AppointmentSlots AppointmentSlots,String name);


}
