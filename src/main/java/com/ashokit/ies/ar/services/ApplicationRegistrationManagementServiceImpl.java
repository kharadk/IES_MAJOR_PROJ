package com.ashokit.ies.ar.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.ashokit.ies.ar.domain.Application;
import com.ashokit.ies.ar.entity.ApplicationEntity;
import com.ashokit.ies.ar.repository.AppRegistrationRepo;
import com.ashokit.ies.ar.services.bo.CitizenResponse;

@Service
public class ApplicationRegistrationManagementServiceImpl implements ApplicationRegistrationManagementService {
	private static final String VERIFY_SSN_URI = "http://localhost:9090/verify/";
	@Autowired
	AppRegistrationRepo appRegistrationRepo = null;

	@Override
	public String saveApplication(Application application) {
		ApplicationEntity applicationEntity = new ApplicationEntity();
		BeanUtils.copyProperties(application, applicationEntity);

		String CitizenStateStatus = checkValidSSN(application.getSsn());
		if (CitizenStateStatus.equals("VALID")) {
			ApplicationEntity entity = appRegistrationRepo.save(applicationEntity);

			if (entity != null) {
				return entity.getApplicationRegNo();

			}
		}
		return null;
	}

	@Override
	public String checkValidSSN(Long ssn) {

		String message = null;
		ResponseEntity<CitizenResponse> responseEntity = null;
		try {

			RestTemplate restTemplate = new RestTemplate();
			responseEntity = restTemplate.getForEntity(VERIFY_SSN_URI + ssn, CitizenResponse.class);
 
			if (responseEntity.getStatusCodeValue() == 200) {
				CitizenResponse response = responseEntity.getBody();

				if (response.getStateName().equals("kentucky")) {
					message = "VALID";
				} else {

					message = "InvalidCitizen";
				}
			}
		} catch (HttpClientErrorException e) {

			message = "INVALID";

		}

		return message;

	}

	@Override
	public List<Application> viewAllApplicants() {

		List<ApplicationEntity> accEnities = appRegistrationRepo.findAll();

		List<Application> applications = new ArrayList<>();

		accEnities.forEach(entity -> {
			Application application = new Application();

			BeanUtils.copyProperties(entity, application);

			applications.add(application);
		});
		return applications;
	}

	@Override
	public Application getApplicationById(String applicationRegNo) {
		ApplicationEntity appEnity = null;
		Optional<ApplicationEntity> optional = appRegistrationRepo.findById(applicationRegNo);
		if (optional.isPresent()) {
			appEnity = optional.get();
		}
		Application application = new Application();

		BeanUtils.copyProperties(appEnity, application);

		return application;
	}

}
