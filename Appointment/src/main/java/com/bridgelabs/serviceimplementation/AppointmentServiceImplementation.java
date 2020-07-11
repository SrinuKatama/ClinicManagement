package com.bridgelabs.serviceimplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bridgelabs.dto.AppointmentDetails;
import com.bridgelabs.model.AppointmentModel;
import com.bridgelabs.repository.AppointmentRepository;
import com.bridgelabs.repository.AppointmentSlotsRepository;
import com.bridgelabs.responses.Responses;
import com.bridgelabs.service.AppointmentService;

@Service
public class AppointmentServiceImplementation implements AppointmentService {
	@Autowired
	private RestTemplate resttemplate;

	@Autowired
	private AppointmentRepository repo;
	
	@Autowired
	private AppointmentSlotsRepository apposlotrepo;

	/*
	 * @Autowired private Responses response;
	 */

	public boolean getPatient(String name) {
		resttemplate.getForEntity("http://localhost:8084/patient/gettigbyname/" +name, Responses.class).getBody();
		return true;
	}

	public boolean getDoctor(String specialization) {
		 resttemplate.getForEntity("http://localhost:8086/doctor/getdoctorbyspecialization/" + specialization, Responses.class)
				.getBody();
		return true;
	}
	
	
	
	
	// this method is for getting the doctor name for slots table
	public String getDoctorByname1(String name) {
		 String ss=resttemplate.getForEntity("http://localhost:8086/doctor/getdoctorbyname/" + name, String.class)
				.getBody();
		return ss;
	}

	
	
	@Override
	public boolean fixAppointment(String name, String specialization, AppointmentDetails AppointmentDetails) 
	{
		AppointmentModel appompdel = new AppointmentModel();
		boolean sri=getDoctor(specialization);    //for doctor specialization
		boolean sri2= getPatient(name);           // for patient verification
		
		String docrepores=getDoctorByname1(name);    // checking the doctor in slots
		
		
		String as1=isslot1booking(name);
		String as2=isslot2booking(name);
		String as3=isslot3booking(name);
		
		if (sri == true && sri2==true) 
		{
			boolean result1=apposlotrepo.slolt1availability(docrepores);
			boolean result2=apposlotrepo.slolt2availability(docrepores);
			boolean result3=apposlotrepo.slolt1availability(docrepores);


			if(result1==true)
			{
				appompdel.setDoctorName(AppointmentDetails.getDoctorName());
				appompdel.setPatientName(AppointmentDetails.getPatientName());
				appompdel.setSlot(as1);
				appompdel.setIsbook(true);
				repo.save(appompdel);
				return true;
				
			}

			else if(result2==true)
			{
				appompdel.setDoctorName(AppointmentDetails.getDoctorName());
				appompdel.setPatientName(AppointmentDetails.getPatientName());
				appompdel.setSlot(as2);
				appompdel.setIsbook(true);
				repo.save(appompdel);
				return true;
			}
			else if(result3==true)
			{
				appompdel.setDoctorName(AppointmentDetails.getDoctorName());
				appompdel.setPatientName(AppointmentDetails.getPatientName());
				appompdel.setSlot(as3);
				appompdel.setIsbook(true);
				repo.save(appompdel);
				return true;
			}
			else
			{
				return false;
			}
		}

	
		return false;
	}

	@Override
	public List<AppointmentModel> getAllAppointments() {
		List<AppointmentModel> allAppointments = new ArrayList<>();
		repo.findAll().forEach(allAppointments::add);
		return allAppointments;
	}
	
	public String isslot1booking(String name)
	{
		String aa=apposlotrepo.slot1(name);
		
		return aa;
		
	}
	
	public String isslot2booking(String name)
	{
		String bb=apposlotrepo.slot2(name);
		
		return bb;
		
	}
	public String isslot3booking(String name)
	{
		String cc=apposlotrepo.slot3(name);
		
		return cc;
		
	}
	

}
