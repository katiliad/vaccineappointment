package com.health.vaccineyaybackend.hello;

import java.time.LocalDate;
import java.util.*;
import javax.persistence.*;

@Entity
public class Vaccination {
	@Id
	private Citizen citizen;
	private Doctor doctor;
	private LocalDate vaccination_date;
	private LocalDate expiration_date;
}
