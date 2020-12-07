package com.ashokit.ies.dc.entity;

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
@Table(name = "dc_cases")
public class Dc_ApplicantEntity {
	@Id
	@GenericGenerator(name = "case_id_generator", strategy = "com.ashokit.ies.dc.generator.CaseIdGenerator")
	@GeneratedValue(generator = "case_id_generator")
	@Column(name = "case_id")
	protected Integer caseId;
	@Column(name = "application_reg_no")
	protected String applicationRegNo;
	@Column(name = "first_name")
	protected String firstName;
	protected Date dob;
	protected String gender;
	protected Long ssn;
	protected String phNo;
	protected String email;
	
}
