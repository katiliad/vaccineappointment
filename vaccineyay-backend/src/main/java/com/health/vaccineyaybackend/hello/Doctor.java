package com.health.vaccineyaybackend.hello;

import java.util.*;
import javax.persistence.*;

@Entity
public class Doctor {
	@Id
	private Integer doctor_social_security_number;
	private String first_name;
	private String last_name;
	private List<Timeslot> tList = new ArrayList<Timeslot> ();
	
	public Doctor() {}
	
	public Doctor(Integer doctor_social_security_number, String first_name, String last_name, ArrayList<Timeslot> tList) {
		this.doctor_social_security_number = doctor_social_security_number;
		this.first_name = first_name;
		this.last_name = last_name;
		this.tList = tList;
	}
	
	@OneToMany (mappedBy = "doctor_social_security_number", cascade= CascadeType.ALL,fetch = FetchType.LAZY)
	private List <Appointment> appointments=  new ArrayList <Appointment>();
	
	public void addAppointment (Appointment apmnt) {
		appointments.add(apmnt);
	}
	@OneToOne (mappedBy = "doctor_social_security_number", cascade= CascadeType.ALL,fetch = FetchType.LAZY)
	private Vaccination vac;
	
	public void setVaccination(Vaccination vacc) {
		vac = vacc;
	}

	public Integer getSocial_security_number() {
		return doctor_social_security_number;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public List<Timeslot> gettList() {
		return tList;
	}

	
}


