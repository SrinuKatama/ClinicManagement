package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Patientmodel;

@Repository
public interface Patient_repository extends JpaRepository<Patientmodel, Long> 
{
	Optional<Patientmodel> find_patient_byemail(String email);
	Patientmodel find_patient_byid(long id);
	List<Patientmodel> findAll();

}
