package com.ashokit.ies.dc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashokit.ies.dc.domain.DcIncome;
import com.ashokit.ies.dc.entity.DcIncomeEntity;
import com.ashokit.ies.dc.sevice.DCManagementService;

@Controller
public class DcIncomeController {
	@Autowired
	DCManagementService dcManagementService;

	@PostMapping("saveIncomeDetails")
	public  String saveDcIncome(DcIncome dcIncome, Model model) {
		DcIncomeEntity saveDcIncome = dcManagementService.saveDcIncome(dcIncome);
           model.addAttribute("caseId", saveDcIncome.getCaseId());
		return "EligibilityDetermination";
	}
}
