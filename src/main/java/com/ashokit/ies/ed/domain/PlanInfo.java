package com.ashokit.ies.ed.domain;

import lombok.Data;

@Data
public class PlanInfo {
	private String planName;
	private String planStatus;
	private String planStartDate;
	private String planEndDate;
	private String benefitAmt;
	private String denialReason;

}