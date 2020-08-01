package com.bridgelabs.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "patient_model")
@Data
public class PatientModel
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "patient_id")
	private long patientId;

	private String patientName;

	private int age;

	private int mobilenumber;

	private String disease;

	@Column(name = "email")
	private String emali;

	private String password;

	private boolean isverified;

	private LocalDateTime registrationtime;
	
	

	/*
	 * @Override public String toString() { return "Patient [patientId=" + patientId
	 * + ", patientName=" + patientName + ", age=" + age + ", mobilenumber=" +
	 * mobilenumber + ", disease=" + disease + ", emali=" + emali + ", password=" +
	 * password + ", isverified=" + isverified + ", registrationtime=" +
	 * registrationtime + ", getPatientId()=" + getPatientId() +
	 * ", getPatientName()=" + getPatientName() + ", getAge()=" + getAge() +
	 * ", getMobilenumber()=" + getMobilenumber() + ", getDisease()=" + getDisease()
	 * + ", getEmali()=" + getEmali() + ", getPassword()=" + getPassword() +
	 * ", isIsverified()=" + isIsverified() + ", getRegistrationtime()=" +
	 * getRegistrationtime() + ", hashCode()=" + hashCode() + ", getClass()=" +
	 * getClass() + ", toString()=" + super.toString() + "]"; }
	 */



	/*
	 * public Patient(long patientId, String patientName, int age, int mobilenumber,
	 * String disease, String emali, String password, boolean isverified,
	 * LocalDateTime registrationtime) { super(); this.patientId = patientId;
	 * this.patientName = patientName; this.age = age; this.mobilenumber =
	 * mobilenumber; this.disease = disease; this.emali = emali; this.password =
	 * password; this.isverified = isverified; this.registrationtime =
	 * registrationtime; }
	 * 
	 * 
	 * 
	 * public Patient() { super(); }
	 * 
	 */
		
}
