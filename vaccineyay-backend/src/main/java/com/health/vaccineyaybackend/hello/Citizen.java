package com.health.vaccineyaybackend.hello;

import java.util.*;
import javax.persistence.*;

@Entity
public class Citizen {
	@Id
	private Integer social_security_number;
	private Integer tax_number;
	private String first_name;
	private String last_name;
	private String email_address;
}
