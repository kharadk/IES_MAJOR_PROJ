package com.ashokit.ies.ar.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.ies.ar.domain.Application;
import com.ashokit.ies.ar.services.ApplicationRegistrationManagementService;

@Controller
public class CreateApplicationController {

	@Autowired
	ApplicationRegistrationManagementService arService;

	@GetMapping(value = { "/appReg" })
	public String displayContactForm(Model model) {

		Application application = new Application();

		model.addAttribute("application", application);

		return "applicationRegistration";
	}

	@PostMapping("/appRegister")
	public String handleRegisterBtn(Application application, RedirectAttributes attributes) throws IOException {

		
		String applicationRegNo = arService.saveApplication(application);

		if (applicationRegNo != null) {
			attributes.addFlashAttribute("success",
					"Application Registered successfull. your Application Registration No Is : " + applicationRegNo);
		} else {
			attributes.addFlashAttribute("failed",
					"Application Registration failed. The applicant is not a Kentucky state citizen");
		}
		return "redirect:appReg";
	}

	@GetMapping("/isValidSSN")
	public @ResponseBody String isValidSSN(@RequestParam("ssn") Long ssn, RedirectAttributes redirectAttributes) {

		String checkValidSSN = arService.checkValidSSN(ssn);

		return checkValidSSN;

	}
}
