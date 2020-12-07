package com.ashokit.ies.dc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashokit.ies.dc.domain.DcIncome;
import com.ashokit.ies.dc.domain.Dc_plan;
import com.ashokit.ies.dc.entity.Dc_plan_Entity;
import com.ashokit.ies.dc.sevice.DCManagementService;

@Controller
public class ManagePlansController {
	@Autowired
	DCManagementService dcManagementService;
	private DcIncome dcIncome = null;

	@PostMapping("/saveDcPlan")
	public String saveSelectPlan(Dc_plan dc_plan, Model model) {

		Dc_plan_Entity saveDcSectlectedPlan = dcManagementService.saveDcSectlectedPlan(dc_plan);

		if (saveDcSectlectedPlan.getPlans().equals("SNAP")) {
			dcIncome = new DcIncome();
			dcIncome.setCaseId(dc_plan.getCaseId());
			dcIncome.setName(dc_plan.getFirstName());
			model.addAttribute("DcIncome", dcIncome);
			return "income";
		} /*
			 * else if (saveDcSectlectedPlan.getPlans()=="CCAP") {
			 * 
			 * }else { if(saveDcSectlectedPlan.getPlans()=="Medicare") {
			 * 
			 * } }
			 */
		return null;

	}
}
