package com.ashokit.ies.ar.services;

import java.util.List;

import com.ashokit.ies.ar.domain.Application;

public interface ApplicationRegistrationManagementService {
	public String saveApplication(Application application);
	public String checkValidSSN(Long ssn);
	public List<Application> viewAllApplicants();
	public Application getApplicationById(String applicationRegNo);
}
