package com.health.vaccineyaybackend.hello;

import java.util.*;
import javax.persistence.*;

@Entity
public class Appointment {
	@Id
	private Integer id;
	private Integer citizen_social_security_number;
	private Integer time_slot_id;
	
	 public Appointment(int id, int citizen_ssn, int timeslot_id) {
	        this.id = id;
	        this.citizen_social_security_number = citizen_ssn;
	        this.time_slot_id = timeslot_id;
    }

	public Integer getId() {
		return id;
	}

	public Integer getCitizen_social_security_number() {
		return citizen_social_security_number;
	}


	public Integer getTime_slot_id() {
		return time_slot_id;
	}

	 
}
