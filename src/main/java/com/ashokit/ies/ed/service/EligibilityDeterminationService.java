package com.ashokit.ies.ed.service;

import org.springframework.stereotype.Service;

import com.ashokit.ies.ed.domain.PlanInfo;

@Service
public interface EligibilityDeterminationService {

	PlanInfo checkEligibility(String caseId);
}
