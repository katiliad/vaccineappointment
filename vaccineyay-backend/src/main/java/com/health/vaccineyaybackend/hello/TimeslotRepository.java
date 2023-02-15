package com.health.vaccineyaybackend.hello;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface TimeslotRepository extends JpaRepository<Timeslot, String> {

	List<Timeslot> findByDate(String date);

}