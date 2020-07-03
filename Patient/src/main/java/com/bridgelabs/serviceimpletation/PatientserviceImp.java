package com.bridgelabs.serviceimpletation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bridgelabs.Utility.JWTutil;
import com.bridgelabs.Utility.MailUtility;
import com.bridgelabs.dto.PatientLogin;
import com.bridgelabs.dto.PatientRegistration;
import com.bridgelabs.model.Patient;
import com.bridgelabs.repository.PatientRepository;
import com.bridgelabs.responses.MailResponse;
import com.bridgelabs.responses.Mailobject;
import com.bridgelabs.service.PatientService;

@Service
public class PatientServiceImp implements PatientService {
	
	@Autowired
	private PatientRepository patientrepo;

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

	@Override
	@Transactional
	public Patient addPatient(PatientRegistration PatientRegistration) {
		Patient patientmod = new Patient();
		Optional<Patient> check = patientrepo.findPatientByemail(PatientRegistration.getEmali());
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
			String maildata = res.response("http://localhost:8084/patientregister/",
					jwt.jwtToken(patientmod.getPatientId()));
			maildto.setResponse(maildata);
			mailutility.sendMail(maildto);
			return patientmod;

		}

		return null;
	}

	@Override
	@Transactional
	public boolean verify(String token) {
		Long verify = (long) jwt.parseJWT(token);
		Patient check = patientrepo.findPatientByid(verify);
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
	public String loginPatient(PatientLogin PatientLogin) {
		Patient check = patientrepo.findPatientByemail(PatientLogin.getEmail()).orElseThrow(null);
		
			if (check.isIsverified() && encryption.matches(PatientLogin.getPassword(), check.getPassword())) 
			{
				String token = jwt.jwtToken(check.getPatientId());
				return token;
			} 
			else
			{
				return null;
			}
		

	}

	@Override
	@Transactional
	public List<Patient> getAllPatints() {
		List<Patient> patients = new ArrayList<>();
		patientrepo.findAll().forEach(patients::add);
		return patients;
	}

	@Override
	@Transactional
	public Patient getPatientById(String token) {
		Long id = (long) jwt.parseJWT(token);
		Patient patient = patientrepo.findPatientByid(id);
		return patient;
	}

}
