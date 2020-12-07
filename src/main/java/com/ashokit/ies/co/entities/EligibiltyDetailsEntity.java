package com.ashokit.ies.co.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name = "eligibility_details")
@Data

public class EligibiltyDetailsEntity {
	@Id
	@Column(name = "ed_trace_id")
	protected int edTraceId;
	@Column(name = "benefit_amt")
	protected String benefitAmt;
	@Column(name = "case_num")
	protected int caseNum;
	@Column(name = "create_dt")
	@CreationTimestamp
	protected Date createDt;
	@Column(name = "denial_reason")
	protected String denialReason;
	@Column(name = "plan_end_dt")
	protected Date planEndDt;
	@Column(name = "plan_name")
	protected String planName;
	@Column(name = "plan_start_dt")
	protected Date planStartDt;
	@Column(name = "plan_status")
	protected String planStatus;
	@UpdateTimestamp
	@Column(name = "update_dt")
	protected Date updateDt;

}
