package com.health.vaccineyaybackend.hello;

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.health.vaccineyaybackend.hello.HelloService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class HelloController {
	
	@Autowired
	private HelloService hs;
	
	@GetMapping
	public String helloworld() {
		return "Welcome to the vaccination page";
	}
	
	
}
