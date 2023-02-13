package com.health.vaccineyaybackend.hello;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter, Integer> {

}