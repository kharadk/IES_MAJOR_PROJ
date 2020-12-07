package com.ashokit.ies.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.ies.admin.domain.Plan;
import com.ashokit.ies.admin.services.EmployeeManagementService;

@Controller
public class ViewPlanController {

	@Autowired
	private EmployeeManagementService employeeManagementService;

	@GetMapping("/viewPlan")
	public String handleViewAllContactact(Model model, Plan plan) {

		List<Plan> plans = employeeManagementService.viewAllPlans();

		model.addAttribute("plans", plans);

		return "ViewPlans";

	}

	@GetMapping("/editPlan")
	public String handleEditButton(@RequestParam("pid") Integer pid, Model model) {
		Plan plan = employeeManagementService.getPlanById(pid);

		System.out.println(plan);

		model.addAttribute("plan", plan);

		return "createPlan";
	}

	@GetMapping("/deletePlan")
	public String handleDelete(@RequestParam("pid") Integer pid, RedirectAttributes redirectAttributes) {

		boolean deletePlan = employeeManagementService.deletePlan(pid);
		
		

		if (deletePlan) {
			redirectAttributes.addFlashAttribute("delete", "Plan Deleted Successfully..!");
		}
		return "redirect:viewPlan";

	}
}
