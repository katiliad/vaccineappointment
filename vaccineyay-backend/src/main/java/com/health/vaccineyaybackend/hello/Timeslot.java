package com.health.vaccineyaybackend.hello;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.persistence.*;

@Entity
public class Timeslot {

	@Id
	private String slot_id;
	private String formatted_date;
	private Integer year;
	private Integer month;
	private Integer day;
	private Integer start_minutes;
	private Integer start_hour;
	private Integer end_minutes;
	private Integer end_hour;
	private Doctor doc;
	
	public Timeslot() {}
	
	public Timeslot(Integer year, Integer month, Integer day, Integer start_minutes,
			Integer start_hour, Integer end_minutes, Integer end_hour) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.start_minutes = start_minutes;
		this.start_hour = start_hour;
		this.end_minutes = end_minutes;
		this.end_hour = end_hour;
		
	  LocalDate date = LocalDate.of(year, month, day);
	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM");
	  formatted_date = date.format(formatter);
	  
	  slot_id = idGenerator(year, month, day, start_hour, start_minutes, end_hour, end_minutes);
	}

	public String getSlot_id() {
		return slot_id;
	}

	public String getDate() {
		return formatted_date;
	}

	public Integer getYear() {
		return year;
	}

	public Integer getMonth() {
		return month;
	}

	public Integer getDay() {
		return day;
	}

	public Integer getStart_minutes() {
		return start_minutes;
	}

	public Integer getStart_hour() {
		return start_hour;
	}

	public Integer getEnd_minutes() {
		return end_minutes;
	}

	public Integer getEnd_hour() {
		return end_hour;
	}

	public Doctor getDoc() {
		return doc;
	}
	
	public static String idGenerator(Integer year, Integer month, Integer day, Integer start_hour, Integer start_minutes, Integer end_hour, Integer end_minutes) {
		return String.format("%04d%02d%02d%02d%02d-%02d%02d-%02d%02d", year, month, day, start_hour, start_minutes, end_hour, end_minutes, day, month);
	}
	
	

}
