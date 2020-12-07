package com.ashokit.ies.ed.service;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ashokit.ies.ed.domain.IndvInfo;
import com.ashokit.ies.ed.domain.PlanInfo;
import com.ashokit.ies.ed.entity.PlanInfoEntity;

@Service
public class EDServiceImpl implements EligibilityDeterminationService {

	private static final String BASE_URI = "http://localhost:7070/determineElig/";

	@Override
	public PlanInfo checkEligibility(String caseId) {
		RestTemplate restTemplate = new RestTemplate();
		PlanInfoEntity PlanInfoEntity = null;
		PlanInfo planInfo = null;
		IndvInfo indvInfo = null;

		ResponseEntity<PlanInfoEntity> postForEntity = restTemplate.postForEntity(BASE_URI, indvInfo,
				PlanInfoEntity.class);

		if (postForEntity.getStatusCode().equals(200)) {
			PlanInfoEntity = postForEntity.getBody();

		}
		planInfo = new PlanInfo();
		BeanUtils.copyProperties(PlanInfoEntity, planInfo);
		return planInfo;
	}

}
