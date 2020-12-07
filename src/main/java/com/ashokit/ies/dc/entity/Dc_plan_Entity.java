package com.ashokit.ies.dc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name = "dc_plan")
public class Dc_plan_Entity {
	@Id
	@Column(name = "case_id")
	protected Integer caseId;
	@Column(name = "first_name")
	protected String firstName;
	protected String plans;
}
