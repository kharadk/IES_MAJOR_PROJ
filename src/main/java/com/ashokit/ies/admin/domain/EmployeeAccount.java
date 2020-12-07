package com.ashokit.ies.admin.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EmployeeAccount {
	protected int empId;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String passwd;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    protected Date dob;
    protected String gender;
    protected String ssn;
    protected String phoneNo;
    protected String role;	
}
