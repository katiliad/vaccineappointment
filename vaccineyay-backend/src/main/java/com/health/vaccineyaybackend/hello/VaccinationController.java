package com.health.vaccineyaybackend.hello;

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.health.vaccineyaybackend.hello.VaccinationService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class VaccinationController {
	
	@Autowired
	private VaccinationService hs;
	
	@GetMapping
	public String helloworld() {
		return "Welcome to the vaccination page";
	}
	
	
}
