package com.ashokit.ies.ar.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "application_registration_db")
public class ApplicationEntity {
	@Id
	@GenericGenerator(name = "ar_no_generator", strategy = "com.ashokit.ies.ar.generator.ApplicationRegNoGenerator")
	@GeneratedValue(generator = "ar_no_generator")
	@Column(name = "application_reg_no")
	protected String applicationRegNo;
	@Column(name = "first_name")
	protected String firstName;
	@Column(name = "last_name")
	protected String lastName;
	protected Date dob;
	protected String gender;
	protected Long ssn;
	protected String phNo;
	protected String email;
}
