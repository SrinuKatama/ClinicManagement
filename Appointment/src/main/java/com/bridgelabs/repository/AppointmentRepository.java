package com.bridgelabs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bridgelabs.model.AppointmentModel;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentModel, Long>
{
	@Query(value = "select * from appointment_model ", nativeQuery = true)
	AppointmentModel getALLAppointmets();

}