package com.ashokit.ies.admin.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.ies.admin.domain.EmployeeAccount;
import com.ashokit.ies.admin.services.EmployeeManagementService;

@Controller
public class RegistrationController {
	@Autowired
	EmployeeManagementService service;

	@GetMapping("/")
	public String adminmodule(Model model) {
		EmployeeAccount userAccount = new EmployeeAccount();
		model.addAttribute("userAcc", userAccount);
		return "index";
	}

	@GetMapping("/reg")
	public String loadRegistrationScreen(Model model) {
		EmployeeAccount userAccount = new EmployeeAccount();
		model.addAttribute("userAcc", userAccount);
		return "registration";
	}

	@GetMapping("/isUniqueEmail")
	public @ResponseBody String isUniqueEmail(@RequestParam("email") String email) {

		return service.isUniqueEmail(email) ? "DUPLICATE" : "UNIQUE";

	}

	@PostMapping("/userRegistration")
	public String handleRegisterBtn(EmployeeAccount employeeAccount, RedirectAttributes attributes) throws IOException {
		boolean isSave = service.saveEmployee(employeeAccount);

		if (isSave) {
			attributes.addFlashAttribute("success", "Registration successfull");
		} else {
			attributes.addFlashAttribute("failed", "Failed to Register");
		}
		return "redirect:/reg";
	}
}
