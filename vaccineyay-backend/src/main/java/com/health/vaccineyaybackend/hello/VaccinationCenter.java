package com.health.vaccineyaybackend.hello;

import java.util.*;
import javax.persistence.*;

@Entity
public class VaccinationCenter {
	@Id
	private Integer id;
	private String address;
	private List<Timeslot> tList = new ArrayList<Timeslot> ();
	
}
