package com.ashokit.ies.dc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashokit.ies.dc.domain.Dc_Applicant;
import com.ashokit.ies.dc.domain.Dc_plan;
import com.ashokit.ies.dc.sevice.DCManagementService;

@Controller
public class CreateCaseController {

	@Autowired
	private DCManagementService dCManagementService;

	@GetMapping(value = { "/createCase" })
	public String displayCreateCaseForm(Model model) {

		return "createCase";
	}

	@GetMapping("/searchApplication")
	public String SearchApplication(@RequestParam("appId") String applicationNo, Model model) {

		Dc_Applicant applicantByAppId = dCManagementService.getApplicantByAppId(applicationNo);

		if (applicantByAppId != null) {

			model.addAttribute("RegistredApplicant", applicantByAppId);
		} else {
			model.addAttribute("SearchFail", "Wrong Application Number");
		}

		return "createCase";
	}

	@PostMapping("/createCase")
	public String createCase(Dc_Applicant applicant, Model model) {

		Integer caseId = dCManagementService.saveApplicantCase(applicant);
		
		Map<String, String> loadPlans = dCManagementService.loadPlans();
        
		Dc_plan dcPlan=new Dc_plan();
		dcPlan.setApplicationRegNo(applicant.getApplicationRegNo());
		dcPlan.setCaseId(caseId);
		dcPlan.setFirstName(applicant.getFirstName());
		
		
		model.addAttribute("DcPlan", dcPlan);
		model.addAttribute("planMap",loadPlans);
		return "selectPlan";
	}
	
	

}