package com.health.vaccineyaybackend.hello;

import java.util.*;
import javax.persistence.*;

import com.example.demo.hello.Course;

@Entity
public class VaccinationCenter {
	@Id
	private Integer id;
	private String address;
	private List<Timeslot> tList = new ArrayList<Timeslot> ();
	
	public VaccinationCenter() {}
	
	public VaccinationCenter(Integer id, String address) {
		this.id = id;
		this.address = address;
	}
	
	@OneToMany(mappedBy="id", 
		       cascade= CascadeType.ALL,
		       fetch = FetchType.LAZY)
	private List<Appointment> appointments = new ArrayList<Appointment>();
	
	public void addAppointments (Appointment appointment) {
		appointments.add(appointment);
	}

	public Integer getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}

	public List<Timeslot> gettList() {
		return tList;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

}

	
