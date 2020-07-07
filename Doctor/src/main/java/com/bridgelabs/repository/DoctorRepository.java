package com.bridgelabs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bridgelabs.model.DoctorModel;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorModel, Long>
{
	@Query(value = "select * from doctor_model where doctor_name =? ",nativeQuery = true)
	DoctorModel findByDoctorName(String name);

	@Query(value = "select * from doctor_model " ,nativeQuery = true)
	List<DoctorModel> findAll();
	
	@Query(value = "select * from doctor_model where specilization=?",nativeQuery = true)
	List<DoctorModel> findDoctorBySpecialization(String name);

	
}
