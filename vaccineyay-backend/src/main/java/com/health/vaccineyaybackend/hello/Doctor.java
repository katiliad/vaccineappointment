package com.health.vaccineyaybackend.hello;

import java.util.*;
import javax.persistence.*;

@Entity
public class Doctor {
	@Id
	private Integer doctor_social_security_number;
	private String first_name;
	private String last_name;
	
	public Doctor() {}
	
	public Doctor(Integer doctor_social_security_number, String first_name, String last_name) {
		this.doctor_social_security_number = doctor_social_security_number;
		this.first_name = first_name;
		this.last_name = last_name;
	}
	
	@OneToMany (mappedBy = "doctor_social_security_number", cascade= CascadeType.ALL,fetch = FetchType.LAZY)
	private List <Appointment> appointments=  new ArrayList <Appointment>();
	
	public void addAppointment (Appointment apmnt) {
		appointments.add(apmnt);
	}
	@OneToMany (mappedBy = "doctor_social_security_number", cascade= CascadeType.ALL,fetch = FetchType.LAZY)
	private List <Vaccination> vacList = new ArrayList <Vaccination>();
	
	public void addVaccination(Vaccination vacc) {
		vacList.add(vacc);
	}
	
	@OneToMany (mappedBy = "doctor_social_security_number", cascade= CascadeType.ALL,fetch = FetchType.LAZY)
	private List <Timeslot> timeslots = new ArrayList <Timeslot>();
	
	public void addTimeslot (Timeslot time_slot) {
		timeslots.add(time_slot);
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

	public List<Timeslot> getTimeSlotsList() {
		return timeslots;
	}
	
	public List<Appointment> getAppointments(){
		return appointments;
	}
	
	public List<Vaccination> getVaccinations(){
		return vacList;
	}

	
}


