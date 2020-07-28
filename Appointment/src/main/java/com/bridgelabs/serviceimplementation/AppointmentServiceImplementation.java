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
		resttemplate.getForEntity("http://localhost:8084/patient/gettigbyname/" + name, Responses.class).getBody();
		return true;
	}

	public boolean getDoctor(String specialization) {
		resttemplate.getForEntity("http://localhost:8086/doctor/getdoctorbyspecialization/" + specialization,
				Responses.class).getBody();
		return true;
	}

     // this method is for getting the doctor name form doctortable

	public String getDoctorByname1(String name) {
		String ss = resttemplate.getForEntity("http://localhost:8086/doctor/getdoctorbyname/" + name, String.class)
				.getBody();
		return ss;
	} 

	@Override
	public boolean fixAppointment(String name, String docname, String specialization,
			AppointmentDetails AppointmentDetails) {
		AppointmentModel appompdel = new AppointmentModel();
		boolean docSpecialization = getDoctor(specialization); // for doctor specialization
		boolean patiet = getPatient(name); // for patient verification

		String docrepores = getDoctorByname1(docname); // checking the doctor in slots

		String as1 = apposlotrepo.slot1(docrepores); // slots timing
		String as2 = apposlotrepo.slot2(docrepores);
		String as3 = apposlotrepo.slot3(docrepores);

		if (docSpecialization == true && patiet == true) {
			System.out.println("*...........1............*");
			boolean result1 = apposlotrepo.slolt1availability(docrepores);
			boolean result2 = apposlotrepo.slolt2availability(docrepores);
			boolean result3 = apposlotrepo.slolt1availability(docrepores);

			if (result1 == true) {
				System.out.println("*...........2............*");

				appompdel.setDoctorName(AppointmentDetails.getDoctorName());
				appompdel.setPatientName(AppointmentDetails.getPatientName());
				appompdel.setSlot(as1);
				appompdel.setIsbook(false);
				repo.save(appompdel);
				apposlotrepo.afterslot1(docrepores);

				return true;

			}

			else if (result2 == true) {
				System.out.println("*...........3............*");

				appompdel.setDoctorName(AppointmentDetails.getDoctorName());
				appompdel.setPatientName(AppointmentDetails.getPatientName());
				appompdel.setSlot(as2);
				appompdel.setIsbook(false);
				repo.save(appompdel);
				apposlotrepo.afterslot2(docrepores);
				return true;
			} else if (result3 == true) {
				System.out.println("*...........4............*");

				appompdel.setDoctorName(AppointmentDetails.getDoctorName());
				appompdel.setPatientName(AppointmentDetails.getPatientName());
				appompdel.setSlot(as3);
				appompdel.setIsbook(false);
				repo.save(appompdel);
				apposlotrepo.afterslot2(docrepores);
				return true;
			} else {
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

}
