package com.bridgelabs.serviceimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bridgelabs.dto.AppointmentSlots;
import com.bridgelabs.model.AppointmetSlotsModel;
import com.bridgelabs.repository.AppointmentSlotsRepository;
import com.bridgelabs.responses.Responses;
import com.bridgelabs.service.AppointmentSlotService;

@Service
public class AppointmentSlotServicedimp implements AppointmentSlotService 
{
	
	@Autowired
	private RestTemplate resttemplate;

	@Autowired
	private AppointmentSlotsRepository repo;
	
	
	
	
	public boolean getDoctorByname(String name) {
		 resttemplate.getForEntity("http://localhost:8086/doctor/getdoctorbyname/" + name, Responses.class)
				.getBody();
		return true;
	}
	
	public String getDoctorByname1(String name) {
		 String ss=resttemplate.getForEntity("http://localhost:8086/doctor/getdoctorbyname/" + name, String.class)
				.getBody();
		return ss;
	}

	@Override
	public AppointmetSlotsModel createSlotsforDoctor(AppointmentSlots AppointmentSlots,String name) 
	{
		String sss=getDoctorByname1(name);
		boolean res=getDoctorByname(name);
		if(res==true)
		{
		
		AppointmetSlotsModel appslot = new AppointmetSlotsModel();

		
		
		appslot.setAvailabilitydate(AppointmentSlots.getAvailabilitydate());
		appslot.setDoctorName(sss);
		appslot.setSlot1(AppointmentSlots.getSlot1());
		appslot.setSlot2(AppointmentSlots.getSlot2());
		appslot.setSlot3(AppointmentSlots.getSlot3());
		appslot.setSlot1availability(true);
		appslot.setSlot2availability(true);
		appslot.setSlot3availability(true);
		repo.save(appslot);
		return appslot;
		}
		else
		{
			return null;
		}

	}

}
