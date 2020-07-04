package com.bridgelabs.serviceimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bridgelabs.dto.AppointmentDetails;
import com.bridgelabs.model.AppointmentModel;
import com.bridgelabs.repository.AppointmentRepository;
import com.bridgelabs.responses.Responses;
import com.bridgelabs.service.AppointmentService;

@Service
public class AppointmentServiceImplementation implements  AppointmentService
{
	@Autowired
	private RestTemplate resttemplate;
	
	@Autowired
	private AppointmentRepository repo;
	
	/*
	 * @Autowired private Responses response;
	 */
	 
	
	public Responses getPatient(String token)
	{
		Responses patientresponse=resttemplate.getForEntity("http://localhost:8084/getpatientbyid/{token}"+token, Responses.class).getBody();
		return patientresponse;
	}
	
	public Responses getDoctor(String specialization)
	{
		Responses doctorresponse=resttemplate.getForEntity("http://localhost:8086/get doctor by specialization"+specialization,Responses.class).getBody();
		return doctorresponse;
	}

	@Override
	public boolean fixAppointment(String token,String specialization,AppointmentDetails AppointmentDetails) 
	{
		AppointmentModel appompdel=new AppointmentModel();
		
		
			if(getDoctor(specialization)!=null && getPatient(token)!=null)
			{
				appompdel.setAppointmentFixedtime(AppointmentDetails.getAppointmentTime());
				appompdel.setDoctorName(AppointmentDetails.getDoctorName());
				appompdel.setPatientName(AppointmentDetails.getPatientProblem());
				repo.save(appompdel);
				return true;
				
			}
			else
			{
				return false;

			}
		
		

	}
	

}