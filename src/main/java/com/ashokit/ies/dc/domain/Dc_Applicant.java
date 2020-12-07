package com.ashokit.ies.dc.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Dc_Applicant {
    
	protected Integer caseId;
	protected String applicationRegNo;
	protected String firstName;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	protected Date dob;
	protected String gender;
	protected Long ssn;
	protected String phNo;
	protected String email;
}
