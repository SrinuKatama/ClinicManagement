package com.bridgelabs.serviceimpletation;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bridgelabs.Utility.JWTutil;
import com.bridgelabs.Utility.MailUtility;
import com.bridgelabs.dto.PatientLogin;
import com.bridgelabs.dto.PatientRegistration;
import com.bridgelabs.model.Patientmodel;
import com.bridgelabs.repository.Patient_repository;
import com.bridgelabs.responses.MailResponse;
import com.bridgelabs.responses.Mailobject;
import com.bridgelabs.service.PatientService;

@Service
public class PatientserviceImp implements PatientService {
	
	@Autowired
	private Patient_repository patientrepo;

	@Autowired
	private JWTutil jwt;

	@Autowired
	private BCryptPasswordEncoder encryption;

	@Autowired
	private MailResponse res;

	@Autowired
	private Mailobject maildto;

	@Autowired
	private MailUtility mailutility;

	@Transactional
	public Patientmodel addPatient(PatientRegistration PatientRegistration) {
		Patientmodel patientmod = new Patientmodel();
		Patientmodel check = patientrepo.find_patient_byemail(PatientRegistration.getEmali());
		if (check == null) {
			patientmod.setAge(PatientRegistration.getAge());
			patientmod.setDisease(PatientRegistration.getDisease());
			patientmod.setEmali(PatientRegistration.getEmali());
			patientmod.setMobilenumber(PatientRegistration.getMobilenumber());
			patientmod.setIsverified(false);
			patientmod.setPatientName(PatientRegistration.getPatientName());
			String pass = encryption.encode(PatientRegistration.getPassword());
			patientmod.setPassword(pass);
			patientrepo.save(patientmod);

			maildto.setEmail(patientmod.getEmali());
			maildto.setSubject(
					"this mail sent by admin srinivas to check" + patientmod.getPatientName() + "is authorised or not");
			String maildata = res.response("http://localhost:8085/patientregister/",
					jwt.jwtToken(patientmod.getPatientId()));
			maildto.setResponse(maildata);
			mailutility.sendMail(maildto);
			return patientmod;

		}

		return null;
	}

	@Transactional
	public boolean verify(String token) {
		Long verify = (long) jwt.parseJWT(token);
		Patientmodel check = patientrepo.find_patient_byid(verify);
		if (check.isIsverified() != true) {
			check.setIsverified(true);
			patientrepo.save(check);
			return true;
		} else {
			return false;

		}

	}

	@Override
	@Transactional
	public String login_Patient(PatientLogin PatientLogin) {
		Patientmodel check = patientrepo.find_patient_byemail(PatientLogin.getEmail());
		if (check != null) {
			if (check.isIsverified()==true && encryption.matches(PatientLogin.getPassword(), check.getPassword())) {
				String token = jwt.jwtToken(check.getPatientId());
				return token;
			} else {
				return null;
			}
		} else {
			return null;

		}

	}

	@Override
	@Transactional
	public List<Patientmodel> getallpatints() {
		List<Patientmodel> patients = new ArrayList<>();
		patientrepo.findAll().forEach(patients::add);
		return patients;
	}

	@Override
	@Transactional
	public Patientmodel getpatientById(String token) {
		Long id = (long) jwt.parseJWT(token);
		Patientmodel patient = patientrepo.find_patient_byid(id);
		return patient;
	}

}
