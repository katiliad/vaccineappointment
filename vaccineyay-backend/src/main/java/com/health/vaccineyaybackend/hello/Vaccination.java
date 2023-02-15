package com.health.vaccineyaybackend.hello;

import java.util.*;
import javax.persistence.*;

@Entity
public class Vaccination {

	@Id
	private Integer citizen_ssn;
	private Integer doctor_ssn;
	private String vaccination_date;
	private String expiration_date;
	
	public Vaccination() {}
	
	public Vaccination(Integer citizen_ssn, Integer doctor_ssn, String vaccination_date, String expiration_date) {
		this.citizen_ssn = citizen_ssn;
		this.doctor_ssn = doctor_ssn;
		this.vaccination_date = vaccination_date;
		this.expiration_date = expiration_date;
	}

	public Integer getCitizen_ssn() {
		return citizen_ssn;
	}

	public Integer getDoctor_ssn() {
		return doctor_ssn;
	}

	public String getVaccination_date() {
		return vaccination_date;
	}

	public String getExpiration_date() {
		return expiration_date;
	}
	
}
