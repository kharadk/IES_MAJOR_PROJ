package com.ashokit.ies.ed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ashokit.ies.ed.domain.IndvInfo;
import com.ashokit.ies.ed.domain.PlanInfo;
import com.ashokit.ies.ed.service.EligibilityDeterminationService;

@Controller
public class EligibilityManagerController {
	@Autowired
	EligibilityDeterminationService edService;

	@GetMapping("/dermineEligibility")
	public @ResponseBody String checkApplicantEligibility(String caseId) {
       
		PlanInfo planInfo = edService.checkEligibility(caseId);

		String planStatus = planInfo.getPlanStatus();
		return planStatus;

	}
}
