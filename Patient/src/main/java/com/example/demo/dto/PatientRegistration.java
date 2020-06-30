package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientRegistration
{
	private String patientName;
	private int age;
	private int mobilenumber;
	private String disease;
	private String emali;
	private String password;
	

}
