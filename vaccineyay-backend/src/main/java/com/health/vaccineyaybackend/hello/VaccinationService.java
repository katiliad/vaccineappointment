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
	@Autowired
	private DoctorRepository docRepository;
	
	public List<Timeslot> getAvailableTimeSlots(String date) throws Exception{
		return timeSlotRepository.findByDate(date);
	}
	{
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
	
	public void enterAvailability(String first_name, String last_name, String doc_ssn, 
			String day, String month, String year, String starting_hour,
			String starting_min, String ending_min)
	{
		Doctor doc = new Doctor(Integer.valueOf(doc_ssn), first_name, last_name);
		Timeslot t_slot = new Timeslot(Integer.valueOf(year), Integer.valueOf(month),
				Integer.valueOf(day), Integer.valueOf(starting_min), 
				Integer.valueOf(starting_hour), Integer.valueOf(ending_min),
				Integer.valueOf(starting_hour));
		//doc.addTimeslot(t_slot);
		t_slot.setDoctor(doc);
//		Optional<Doctor> doc_byId = docRepository.findById(Integer.valueOf(doc_ssn));
//		if(!doc_byId.isPresent()) {
//			docRepository.save(doc);
//		} 
		
		 String time_slot_id = Timeslot.idGenerator(Integer.valueOf(year), Integer.valueOf(month), 
				  Integer.valueOf(day), Integer.valueOf(starting_hour), Integer.valueOf(starting_min),
				  Integer.valueOf(starting_hour), Integer.valueOf(ending_min));
		 
		Optional<Timeslot> tslot_byId = timeSlotRepository.findById(time_slot_id);
		if(!tslot_byId.isPresent()) {
			timeSlotRepository.save(t_slot);
		} 
	}
	
	public Optional<Vaccination> getVaccinationStatus(String citizen_ssn) {
		return vaxRepository.findById(Integer.valueOf(citizen_ssn));
	}
	
	public List<Appointment> getNextAppointments(String doctor_ssn) {
		  Optional<Doctor> byId = docRepository.findById(Integer.valueOf(doctor_ssn));
		  if(byId.isPresent()) {
			  return byId.get().getAppointments();
		  } else {
			  return new ArrayList<Appointment>();
		  }
	}
	
	public boolean changeAppointment(String name, String surname, String ssn, String tax_number, String email,
			String day, String month, String year, String hour, String minutes_start, String minutes_end)
	{
		  Optional<Citizen> byId = citizenRepository.findById(Integer.valueOf(ssn));
		  if(!byId.isPresent()) {
			  return false;			  
		  }
		  
		  Citizen citizen = byId.get();
		  if(citizen.getChangedAppointments()>2) {
			  return false;
		  }
		  
		  Optional<Appointment> appnt = appointmentRepository.findById(Integer.valueOf(ssn));
		  if(appnt.isPresent()) {
			  appointmentRepository.delete(appnt.get());
		  }
		  
		  String time_slot_id = Timeslot.idGenerator(Integer.valueOf(year), Integer.valueOf(month), 
				  Integer.valueOf(day), Integer.valueOf(hour), Integer.valueOf(minutes_start),
				  Integer.valueOf(hour), Integer.valueOf(minutes_end));
		  
		  Optional<Timeslot> slot_byId = timeSlotRepository.findById(time_slot_id);
		  if(slot_byId.isPresent()) {
			  Optional<Appointment> appt_byId = appointmentRepository.findById(Integer.valueOf(ssn));
			  if(!appt_byId.isPresent()) {
				  appointmentRepository.save(new Appointment(Integer.valueOf(ssn), Integer.valueOf(time_slot_id)));
				  citizen.increaseChangedAppointments();
				  return true;
			  }
		  }	  
		  return false;
	}
}
