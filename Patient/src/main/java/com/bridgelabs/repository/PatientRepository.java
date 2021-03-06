package com.bridgelabs.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bridgelabs.model.PatientModel;

@Repository
public interface PatientRepository extends JpaRepository<PatientModel, Long> 
{
	@Query(value = "select * from patient_model where email=?1",nativeQuery = true)
	Optional<PatientModel> findPatientByemail(String email);

	@Query(value = "select * from patient_model where patient_id=?",nativeQuery = true)
	PatientModel findPatientByid(long id);
	
	@Query(value = "select * from patient_model where patient_name=?1",nativeQuery = true)
	PatientModel getPatientByName(String name);

	List<PatientModel> findAll();
	

}
