package com.ashokit.ies.admin.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "plans")
@Data
public class PlanEntity {
	@Id
	@GeneratedValue
	protected int pid;
	@Column(name = "plan_name")
	protected String planName;
	protected String description;
	@Column(name = "plan_start_date")
	protected Date planStartDate;
	@Column(name = "plan_end_date")
	protected Date planEndDate;
}
