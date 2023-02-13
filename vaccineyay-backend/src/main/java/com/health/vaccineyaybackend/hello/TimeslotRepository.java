package com.health.vaccineyaybackend.hello;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;

public interface TimeslotRepository extends JpaRepository<Timeslot, LocalDate> {

}