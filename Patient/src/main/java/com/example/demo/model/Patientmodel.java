package com.example.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Patienttable")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patientmodel
{
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long patientId;

	@Column
	private String patientName;

	@Column
	private int age;

	@Column
	private int mobilenumber;

	@Column
	private String disease;

	@Column
	private String emali;

	@Column
	private String password;

	@Column
	private boolean isverified;

	@Column
	private LocalDateTime registrationtime;

		
}
