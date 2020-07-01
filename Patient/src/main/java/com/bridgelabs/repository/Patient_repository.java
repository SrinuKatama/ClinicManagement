package com.bridgelabs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabs.model.Patientmodel;

@Repository
public interface Patient_repository extends JpaRepository<Patientmodel, Long> 
{
	Patientmodel find_patient_byemail(String email);
	Patientmodel find_patient_byid(long id);
	List<Patientmodel> findAll();

}