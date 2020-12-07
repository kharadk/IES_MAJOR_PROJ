package com.ashokit.ies.dc.sevice;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.ashokit.ies.dc.domain.DcIncome;
import com.ashokit.ies.dc.domain.Dc_Applicant;
import com.ashokit.ies.dc.domain.Dc_plan;
import com.ashokit.ies.dc.entity.DcIncomeEntity;
import com.ashokit.ies.dc.entity.Dc_plan_Entity;


@Service
public interface DCManagementService {
  
	public Dc_Applicant getApplicantByAppId(String appId);
	public Integer saveApplicantCase(Dc_Applicant applicant);
	public  Map<String, String> loadPlans();
	public Dc_plan_Entity saveDcSectlectedPlan(Dc_plan dc_plan);
	public DcIncomeEntity saveDcIncome(DcIncome dcIncome);
}
