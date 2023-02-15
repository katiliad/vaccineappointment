package com.health.vaccineyaybackend.hello;

import java.util.*;
import javax.persistence.*;

@Entity
public class Appointment {
	@Id
	private Integer citizen_social_security_number;
	private Integer time_slot_id;
	
	public Appointment() {}
	
	 public Appointment(int citizen_ssn, int timeslot_id) {
	        this.citizen_social_security_number = citizen_ssn;
	        this.time_slot_id = timeslot_id;
    }
	 
	 @ManyToOne
	 @JoinColumn (name = "doctor_social_security_number")
	 private Doctor doc;
	 
	 public void setDoctor (Doctor d) {
		 doc=d;
	 }
	 
	@ManyToOne
	@JoinColumn(name="vaccinationcenter_id")
	private VaccinationCenter vaxcenter;
	
	public void setVaccinationCenter (VaccinationCenter vaxc) {
		vaxcenter = vaxc;
	}

	public Integer getCitizen_social_security_number() {
		return citizen_social_security_number;
	}I

	public Integer getTime_slot_id() {
		return time_slot_id;
	}
	 
}
