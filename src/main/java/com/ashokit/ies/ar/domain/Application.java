package com.ashokit.ies.ar.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Application {
	protected String applicationRegNo;
	protected String firstName;
	protected String lastName;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	protected Date dob;
	protected String gender;
	protected Long ssn;
	protected String phNo;
	protected String email;
}
