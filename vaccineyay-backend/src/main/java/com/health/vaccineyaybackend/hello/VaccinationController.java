package com.health.vaccineyaybackend.hello;

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

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
	
	@PostMapping(path="/bookappointment/{name}/{surname}/{ssn}/{tax_number}/{email}/{day}/{month}/{year}/{hour}/{minutes_start}/{minutes_end}")
	public void bookAppointment(@RequestParam(value="name") String name, @RequestParam(value="surname") String surname, 
			@RequestParam(value="ssn") String ssn, @RequestParam(value="tax_number") String tax_number, 
			@RequestParam(value="email") String email, @RequestParam(value="day") String day, 
			@RequestParam(value="month") String month, @RequestParam(value="year") String year, 
			@RequestParam(value="hour") String hour, @RequestParam(value="minutes_start") String minutes_start, 
			@RequestParam(value="minutes_end") String minutes_end)
	{
		vs.bookAppointment(name, surname, ssn, tax_number, email, day, month, year, hour, minutes_start, minutes_end);
	}
	
	@PostMapping(path="/registervaccination/{name}/{surname}/{ssn}/{doctor_ssn}/{Day}/{Month}/{Year}")
	public void registerVaccination(@RequestParam(value="name") String name, @RequestParam(value="surname") String surname, 
			@RequestParam(value="ssn") String ssn, @RequestParam(value="doctor_ssn") String doctor_ssn, 
			@RequestParam(value="Day") String Day, @RequestParam(value="Month") String Month, 
			@RequestParam(value="Year") String Year)
	{
		vs.registerVaccination(name, surname, ssn, doctor_ssn, Day, Month, Year);
	}
	
	@PostMapping(path="/enteravailability/{first_name}/{last_name}/{doc_ssn}/{day}/{month}/{year}/{starting_hour}{starting_min}/{ending_min}")
	public void enterAvailability(@RequestParam(value="first_name") String first_name, @RequestParam(value="last_name") String last_name, 
			@RequestParam(value="doc_ssn") String doc_ssn, @RequestParam(value="day") String day, 
			@RequestParam(value="month") String month, @RequestParam(value="year") String year, 
			@RequestParam(value="starting_hour") String starting_hour, @RequestParam(value="starting_min") String starting_min,
			@RequestParam(value="ending_min") String ending_min)
	{
		vs.enterAvailability(first_name, last_name, doc_ssn, day, month, year, starting_hour, starting_min, ending_min);
	}
	
	@GetMapping(path="/getvaccinationstatus/{citizen_ssn}")
	public Vaccination getVaccinationAppointment(@RequestParam(value="citizen_ssn") String citizen_ssn) {
		return vs.getVaccinationStatus(citizen_ssn).get();
	}
	
	@GetMapping(path="/getnextappointments/{doctor_ssn}")
	public List<Appointment> getNextAppointments(@RequestParam(value="doctor_ssn") String doctor_ssn) {
		return vs.getNextAppointments(doctor_ssn);
	}
	
	@PostMapping(path="/changeappointment/{name}/{surname}/{ssn}/{tax_number}/{email}/{day}/{month}/{year}/{hour}/{minutes_start}/{minutes_end}")
	public boolean changeAppointment(@RequestParam(value="name") String name, @RequestParam(value="surname") String surname, 
			@RequestParam(value="ssn") String ssn, @RequestParam(value="tax_number") String tax_number, 
			@RequestParam(value="email") String email, @RequestParam(value="day") String day, 
			@RequestParam(value="month") String month, @RequestParam(value="year") String year, 
			@RequestParam(value="hour") String hour, @RequestParam(value="minutes_start") String minutes_start, 
			@RequestParam(value="minutes_end") String minutes_end)
	{
		return vs.changeAppointment(name, surname, ssn, tax_number, email, day, month, year, hour, minutes_start, minutes_end);
	}
	
}
