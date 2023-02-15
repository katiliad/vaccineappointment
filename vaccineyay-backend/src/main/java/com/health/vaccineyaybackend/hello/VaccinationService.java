package com.health.vaccineyaybackend.hello;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.persistence.*;

@Service
public class VaccinationService {
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	@Autowired
	private CitizenRepository citizenRepository;
	@Autowired
	private TimeslotRepository timeSlotRepository;
	@Autowired
	private VaccinationRepository vaxRepository;
	
	public List<Timeslot> getAvailableTimeSlots(String date) throws Exception{
		return timeSlotRepository.findByDate(date);
	}
	
	public void bookAppointment(String name, String surname, String ssn, String tax_number, String email,
			String day, String month, String year, String hour, String minutes_start, String minutes_end)
	{
		  Citizen s = new Citizen(Integer.valueOf(ssn), Integer.valueOf(tax_number), name, surname, email);
		  Optional<Citizen> byId = citizenRepository.findById(s.getSocial_security_number());
		  if(!byId.isPresent()) {
			  citizenRepository.save(s);			  
		  }
		  
		  String time_slot_id = Timeslot.idGenerator(Integer.valueOf(year), Integer.valueOf(month), 
				  Integer.valueOf(day), Integer.valueOf(hour), Integer.valueOf(minutes_start),
				  Integer.valueOf(hour), Integer.valueOf(minutes_end));
		  
		  Optional<Timeslot> slot_byId = timeSlotRepository.findById(time_slot_id);
		  if(slot_byId.isPresent()) {
			  Optional<Appointment> appt_byId = appointmentRepository.findById(Integer.valueOf(ssn));
			  if(!appt_byId.isPresent()) {
				  appointmentRepository.save(new Appointment(Integer.valueOf(ssn), Integer.valueOf(time_slot_id)));
			  }
		  }	  
	}
	
	public void registerVaccination(String name, String surname, String ssn, String doctor_ssn, String Day, String Month, String Year) {
		  Optional<Citizen> byId = citizenRepository.findById(Integer.valueOf(ssn));
		  if(byId.isPresent()) {
			  Optional<Vaccination> vaxbyId = vaxRepository.findById(Integer.valueOf(ssn));
			  if(!vaxbyId.isPresent()) {
				  LocalDate date = LocalDate.now();
				  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM");
				  String vaccination_date = date.format(formatter);
				  
				  LocalDate datePlus6Months = date.plusMonths(6);
				  String expirationDate =  datePlus6Months.format(formatter);
				  vaxRepository.save(new Vaccination(Integer.valueOf(ssn), Integer.valueOf(doctor_ssn), 
						  vaccination_date, expirationDate));
			  }  
		  }
	}

}
