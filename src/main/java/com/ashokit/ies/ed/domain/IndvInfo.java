package com.ashokit.ies.ed.domain;

import lombok.Data;

@Data
public class IndvInfo {

	private String indvFirstName;
	private String indvLastName;
	private String indvDob;
	private String planName;
	private String isEmployed;
	private PlanInfo planInfo;

}