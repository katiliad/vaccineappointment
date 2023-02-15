package com.health.vaccineyaybackend.hello;

import java.util.*;
import javax.persistence.*;

@Entity
public class Doctor {
	@Id
	private Integer social_security_number;
	private String first_name;
	private String last_name;
	private List<Timeslot> tList = new ArrayList<Timeslot> ();
	
	public Doctor() {}
	
	public Doctor(Integer social_security_number, String first_name, String last_name, ArrayList<Timeslot> tList) {
		this.social_security_number = social_security_number;
		this.first_name = first_name;
		this.last_name = last_name;
		this.tList = tList;
	}

	public Integer getSocial_security_number() {
		return social_security_number;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public ArrayList<Timeslot> gettList() {
		return tList;
	}

	
}


