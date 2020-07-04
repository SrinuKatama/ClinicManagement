package com.bridgelabs.serviceImplementation;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabs.dto.DoctorDetailsDto;
import com.bridgelabs.model.DoctorModel;
import com.bridgelabs.repository.DoctorRepository;
import com.bridgelabs.service.DoctorService;

@Service
public class DoctorServiceImp implements DoctorService
{

	@Autowired
	private DoctorRepository doctorRepo; 
	
	
	
	@Override
	public DoctorModel cerateDoctor(DoctorDetailsDto DoctorDetailsDto) 
	{
		DoctorModel doc=new DoctorModel();
		DoctorModel details=doctorRepo.findByDoctorName(DoctorDetailsDto.getDoctorName());
		if(details==null)
		{
			doc.setAvailabity(DoctorDetailsDto.getAvailabity());
			doc.setDoctorName(DoctorDetailsDto.getDoctorName());
			doc.setMobileNumber(DoctorDetailsDto.getMobileNumber());
			doc.setSpecilization(DoctorDetailsDto.getSpecilization());
			doctorRepo.save(doc);
			return doc;
		}else
		{
			return null;

		}
		
		
	}

	@Override
	@Transactional
	public List<DoctorModel> getAllDoctor() 
	{
		List<DoctorModel> allDoctors=new ArrayList<>();
		doctorRepo.findAll().forEach(allDoctors :: add);
		return allDoctors;
	}

	

}
