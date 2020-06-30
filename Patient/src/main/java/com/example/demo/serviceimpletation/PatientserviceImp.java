package com.example.demo.serviceimpletation;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Utility.JWTutil;
import com.example.demo.Utility.MailUtility;
import com.example.demo.dto.PatientLogin;
import com.example.demo.dto.PatientRegistration;
import com.example.demo.model.Patientmodel;
import com.example.demo.repository.Patient_repository;
import com.example.demo.responses.MailResponse;
import com.example.demo.responses.Mailobject;
import com.example.demo.service.PatientService;

@Service
public class PatientserviceImp implements PatientService
{
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
	public Patientmodel addPatient(PatientRegistration PatientRegistration)
	{
		Patientmodel patientmod=new Patientmodel();
		Optional<Patientmodel> check=patientrepo.find_patient_byemail(PatientRegistration.getEmali());
		if(check == null)
		{
			patientmod.setAge(PatientRegistration.getAge());
			patientmod.setDisease(PatientRegistration.getDisease());
			patientmod.setEmali(PatientRegistration.getEmali());
			patientmod.setMobilenumber(PatientRegistration.getMobilenumber());
			patientmod.setIsverified(false);
			patientmod.setPatientName(PatientRegistration.getPatientName());
			String pass=encryption.encode(PatientRegistration.getPassword());
			patientmod.setPassword(pass);
			patientrepo.save(patientmod);
			
			maildto.setEmail(patientmod.getEmali());
			maildto.setSubject("this mail sent by admin srinivas to check"+ patientmod.getPatientName()+"is authorised or not");
			String maildata = res.response("http://localhost:8082/patientregister/",
					jwt.jwtToken(patientmod.getPatientId()));
			maildto.setResponse(maildata);
			mailutility.sendMail(maildto);
			return patientmod;
			
		}
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
