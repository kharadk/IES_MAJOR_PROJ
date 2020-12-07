package com.ashokit.ies.admin.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "IES_USER")
public class EmployAccEnity {
	@Id
	@GeneratedValue
	@Column(name = "emp_id")
	protected int empId;
	@Column(name = "first_name")
	protected String firstName;
	@Column(name = "last_name")
	protected String lastName;
	protected String email;
	protected String passwd;
	protected Date dob;
	protected String gender;
	protected String ssn;
	@Column(name = "phoneNo")
	protected String phoneNo;
	protected String role;
}
