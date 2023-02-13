package com.health.vaccineyaybackend.hello;

import java.time.LocalDate;
import java.util.*;
import javax.persistence.*;

@Entity
public class Timeslot {
	@Id
	private Integer slot_id;
	private LocalDate date;
	private String start_minutes;
	private String start_hour;
	private String end_minutes;
	private String end_hour;
	private Doctor doc;
}
