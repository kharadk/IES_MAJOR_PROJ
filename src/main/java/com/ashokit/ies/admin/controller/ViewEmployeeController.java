package com.ashokit.ies.admin.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.ies.admin.domain.EmployeeAccount;
import com.ashokit.ies.admin.services.EmployeeManagementService;

@Controller
public class ViewEmployeeController {

	@Autowired
	private EmployeeManagementService employeeManagementService;

	@GetMapping("/viewAccounts")
	public String handleViewAllContactact(Model model, EmployeeAccount account) {

		List<EmployeeAccount> employeeAccounts = employeeManagementService.viewAllAccount();

		model.addAttribute("accounts", employeeAccounts);

		return "viewAccounts";

	}

	@GetMapping("/accountsByRole")
	public String accountByRole(@RequestParam("role") String role, Model model) {

		List<EmployeeAccount> accounts = employeeManagementService.getAccountsByRole(role);
		
		System.out.println(role);
		
		System.out.println(accounts+"{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{");

		model.addAttribute("accounts", accounts);
		return "viewAccounts";
	}

	@GetMapping("/editAccount")
	public String handleEditButton(@RequestParam("empId") Integer empId, Model model) {
		EmployeeAccount employeeAccount = employeeManagementService.getAccountById(empId);

		Date dob = employeeAccount.getDob();
		java.sql.Date sdate = new java.sql.Date(dob.getTime());

		employeeAccount.setDob(sdate);

		model.addAttribute("userAcc", employeeAccount);

		return "registration";
	}

	@GetMapping("/deleteAccount")
	public String handleDelete(@RequestParam("empId") int empId, RedirectAttributes redirectAttributes) {

		boolean deleteContact = employeeManagementService.deleteAccount(empId);
		if (deleteContact) {
			redirectAttributes.addFlashAttribute("delete", "Contact Deleted Successfully..!");
		}
		return "redirect:viewAccounts";

	}
}
