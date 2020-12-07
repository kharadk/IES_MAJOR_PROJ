package com.ashokit.ies.ar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashokit.ies.admin.domain.Plan;
import com.ashokit.ies.ar.domain.Application;
import com.ashokit.ies.ar.services.ApplicationRegistrationManagementService;

@Controller
public class ViewCitizenController {

	@Autowired
	ApplicationRegistrationManagementService arService;

	@GetMapping("/viewCitizen")
	public String handleViewAllContactact(Model model, Plan plan) {

		List<Application> applications = arService.viewAllApplicants();

		System.out.println(applications);

		model.addAttribute("applicants", applications);

		return "ViewRegisterCitizen";

	}

	@GetMapping("/editCitizen")
	public String handleEditButton(@RequestParam("applicationRegNo") String applicationRegNo, Model model) {

		System.out.println(applicationRegNo);
		Application application = arService.getApplicationById(applicationRegNo);

		System.out.println(application);
		model.addAttribute("application", application);

		return "applicationRegistration";
	}

}
