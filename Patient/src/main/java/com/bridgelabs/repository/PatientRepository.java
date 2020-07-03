package com.bridgelabs.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bridgelabs.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> 
{
	@Query(value = "select * from patient_model where email=?",nativeQuery = true)
	Optional<Patient> findPatientByemail(String email);

	@Query(value = "select * from patient_model where patient_id=?",nativeQuery = true)
	Patient findPatientByid(long id);

	List<Patient> findAll();

}