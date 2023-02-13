package com.health.vaccineyaybackend.hello;

import java.util.*;
import javax.persistence.*;

@Entity
public class Doctor {
	@Id
	private Integer social_security_number;
	private String first_name;
	private String last_name;
	private ArrayList<Timeslot> tList;
}
