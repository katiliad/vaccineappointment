package com.health.vaccineyaybackend.hello;

import java.util.*;
import javax.persistence.*;

@Entity
public class Citizen {
	@Id
	private Integer social_security_number;
	private Integer tax_number;
	private String first_name;
	private String last_name;
	private String email_address;
	
	public Citizen() {}
	
	public Citizen(Integer ssn, Integer tax, String name, String last_name, String email) {
		this.social_security_number = ssn;
		this.tax_number = tax;
		this.first_name = name;
		this.last_name = last_name;
		this.email_address = email;
	}
	
	@OneToOne (mappedBy = "social_security_number", cascade= CascadeType.ALL,fetch = FetchType.LAZY)
	private Vaccination vac;
	
	public void setVaccination(Vaccination vacc) {
		vac = vacc;
	}

	public Integer getSocial_security_number() {
		return social_security_number;
	}

	public Integer getTax_number() {
		return tax_number;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getEmail_address() {
		return email_address;
	}

}
