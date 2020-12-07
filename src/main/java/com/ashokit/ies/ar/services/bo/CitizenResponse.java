package com.ashokit.ies.ar.services.bo;

import lombok.Data;

@Data
public class CitizenResponse {

	protected Long ssnNo;
	protected String firstName;
	protected String lastName;
	protected String gender;
	protected String dob;
	protected String stateName;
}
