package com.ashokit.ies.dc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "dc_income")
public class DcIncomeEntity {
	@Id
	@Column(name = "case_id")
	protected Integer caseId;
	protected String Name;
	protected String working;
	protected double income;

}
