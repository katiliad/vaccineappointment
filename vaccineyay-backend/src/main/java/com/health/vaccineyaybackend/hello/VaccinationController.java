package com.health.vaccineyaybackend.hello;

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.health.vaccineyaybackend.hello.VaccinationService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class VaccinationController {
	
	@Autowired
	private VaccinationService vs;
	
	@GetMapping
	public String helloworld() {
		return "Welcome to the vaccination page";
	}
	
	@GetMapping(path="/timeslots/{date}")
	public List<Timeslot> getTimeSlots(@RequestParam(value="date") String date)  throws Exception{
		return vs.getAvailableTimeSlots(date);
	}
	
	@GetMapping(path="/bookAppointment/{name}/{surname}/{ssn}/{tax_number}/{email}/{day}/{month}/{year}/{hour}/{minutes_start}/{minutes_end}")
	public void bookAppointment(@RequestParam(value="name") String name, @RequestParam(value="surname") String surname, 
			@RequestParam(value="ssn") String ssn, @RequestParam(value="tax_number") String tax_number, 
			@RequestParam(value="email") String email, @RequestParam(value="day") String day, 
			@RequestParam(value="month") String month, @RequestParam(value="year") String year, 
			@RequestParam(value="hour") String hour, @RequestParam(value="minutes_start") String minutes_start, 
			@RequestParam(value="minutes_end") String minutes_end)
	{
		vs.bookAppointment(name, surname, ssn, tax_number, email, day, month, year, hour, minutes_start, minutes_end);
	}


	
}
