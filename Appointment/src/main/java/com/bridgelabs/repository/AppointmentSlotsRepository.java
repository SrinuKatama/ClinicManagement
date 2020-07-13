package com.bridgelabs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bridgelabs.model.AppointmetSlotsModel;

@Repository
public interface AppointmentSlotsRepository extends JpaRepository<AppointmetSlotsModel, Long> {

	// @Query(value = "select * for appointmet_slots_model", nativeQuery = true)
	// List<AppointmetSlotsModel> findAll() ;

	@Query(value = "select slot1availability from appointmet_slots_model where doctor_name =?", nativeQuery = true)
	boolean slolt1availability(String doctorName);

	@Query(value = "select slot2availability from appointmet_slots_model where doctor_name =?", nativeQuery = true)
	boolean slolt2availability(String doctorName);

	@Query(value = "select slot3availability from appointmet_slots_model where doctor_name=? ", nativeQuery = true)
	boolean slolt3availability(String doctorName);

	@Query(value = "select slot1 from appointmet_slots_model where doctor_name =?", nativeQuery = true)
	public String slot1(String doctorName);

	@Query(value = "select slot2 from appointmet_slots_model where doctor_name =?", nativeQuery = true)
	public String slot2(String doctorName);

	@Query(value = "select slot3 from appointmet_slots_model where doctor_name =?", nativeQuery = true)
	public String slot3(String doctorName);
	
	@Query(value = "UPDATE appointmet_slots_model SET slot1availability = false WHERE  doctor_name=?")
	public boolean afterslot1(String doctorName);
	
	@Query(value = "UPDATE appointmet_slots_model SET slot2availability = false WHERE  doctor_name=?")
	public boolean afterslot2(String doctorName);
	
	@Query(value = "UPDATE appointmet_slots_model SET slot3availability = false WHERE  doctor_name=?")
	public boolean afterslot3(String doctorName);
	
	

}
