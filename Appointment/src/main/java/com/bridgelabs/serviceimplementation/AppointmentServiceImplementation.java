package com.bridgelabs.serviceimplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bridgelabs.dto.AppointmentDetails;
import com.bridgelabs.model.AppointmentModel;
import com.bridgelabs.repository.AppointmentRepository;
import com.bridgelabs.responses.Responses;
import com.bridgelabs.service.AppointmentService;

@Service
public class AppointmentServiceImplementation implements AppointmentService {
	@Autowired
	private RestTemplate resttemplate;

	@Autowired
	private AppointmentRepository repo;

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
	
	public Responses getDoctor1(String specialization) {
		System.out.println("in getDoctor1");
		Responses data= resttemplate.getForEntity("http://localhost:8086/doctor/getdoctorbyspecialization/" + specialization, Responses.class)
				.getBody();
		System.out.println(data);
		return data;
		
	}
	
	

	@Override
	public boolean fixAppointment(String name, String specialization, AppointmentDetails AppointmentDetails) {
		AppointmentModel appompdel = new AppointmentModel();
		Responses sri3=getDoctor1(specialization);
		boolean sri=getDoctor(specialization);
		boolean sri2= getPatient(name);
		if (sri == true && sri2==true) {
			appompdel.setAppointmentFixedtime(AppointmentDetails.getAppointmentTime());
			appompdel.setDoctorName(AppointmentDetails.getDoctorName());
			appompdel.setPatientName(AppointmentDetails.getPatientName());
			repo.save(appompdel);
			return true;

		} else {
			return false;

		}

	}

	@Override
	public List<AppointmentModel> getAllAppointments() {
		List<AppointmentModel> allAppointments = new ArrayList<>();
		repo.findAll().forEach(allAppointments::add);
		return allAppointments;
	}

}
