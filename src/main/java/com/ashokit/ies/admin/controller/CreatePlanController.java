package com.ashokit.ies.admin.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.ies.admin.domain.Plan;
import com.ashokit.ies.admin.services.EmployeeManagementService;

@Controller
public class CreatePlanController {

	@Autowired
	EmployeeManagementService service;

	@GetMapping(value = { "/plans" })
	public String displayContactForm(Model model) {

		Plan plan = new Plan();

		model.addAttribute("plan", plan);

		return "createPlan";
	}

	@PostMapping("/createPlan")
	public String handleRegisterBtn(Plan plan, RedirectAttributes attributes) throws IOException {
		boolean isSave = service.savePlan(plan);

		if (isSave) {
			attributes.addFlashAttribute("success", "Plan created successfull");
		} else {
			attributes.addFlashAttribute("failed", "Failed to create plan");
		}
		return "redirect:plans";
	}
}
