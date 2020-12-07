package com.ashokit.ies.dc.sevice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.ies.admin.domain.Plan;
import com.ashokit.ies.admin.services.EmployeeManagementService;
import com.ashokit.ies.ar.entity.ApplicationEntity;
import com.ashokit.ies.dc.domain.DcIncome;
import com.ashokit.ies.dc.domain.Dc_Applicant;
import com.ashokit.ies.dc.domain.Dc_plan;
import com.ashokit.ies.dc.entity.DcIncomeEntity;
import com.ashokit.ies.dc.entity.Dc_ApplicantEntity;
import com.ashokit.ies.dc.entity.Dc_plan_Entity;
import com.ashokit.ies.dc.repository.DCRepo;
import com.ashokit.ies.dc.repository.DcIncomeRepo;
import com.ashokit.ies.dc.repository.DcPlanRepo;

@Service
public class DCManagementServiceImpl implements DCManagementService {

	@Autowired
	private DCRepo dcRepo;
	@Autowired
	DcPlanRepo dcPlanRepo;
	@Autowired
	DcIncomeRepo dcIncomeRepo;

	@Autowired
	EmployeeManagementService employeeManagementService;

	@Override
	public Dc_Applicant getApplicantByAppId(String appId) {

		Optional<ApplicationEntity> findById = dcRepo.findById(appId);
		if (findById.isPresent()) {

			ApplicationEntity applicationEntity = findById.get();
			Dc_Applicant applicant = new Dc_Applicant();

			BeanUtils.copyProperties(applicationEntity, applicant, "lastName");

			return applicant;
		}
		return null;
	}

	public Integer saveApplicantCase(Dc_Applicant applicant) {
		Dc_ApplicantEntity entity = new Dc_ApplicantEntity();

		BeanUtils.copyProperties(applicant, entity, "lastName");
		Dc_ApplicantEntity saveEntity = dcRepo.save(entity);

		return saveEntity.getCaseId();

	}

	@Override
	public Map<String, String> loadPlans() {
		List<Plan> plans = employeeManagementService.viewAllPlans();
		Map<String, String> planMap = new HashMap<String, String>();

		plans.forEach(entity1 -> {
			planMap.put(entity1.getPlanName(), entity1.getPlanName());
		});

		return planMap;
	}

	public Dc_plan_Entity saveDcSectlectedPlan(Dc_plan dc_plan) {
		Dc_plan_Entity dc_plan_Entity = new Dc_plan_Entity();

		BeanUtils.copyProperties(dc_plan, dc_plan_Entity, "applicationRegNo");

		Dc_plan_Entity dcEntity = dcPlanRepo.save(dc_plan_Entity);
		System.out.println(dcEntity);
		return dcEntity;
	}

	public DcIncomeEntity saveDcIncome(DcIncome dcIncome) {
		DcIncomeEntity dcIncomeEntity = new DcIncomeEntity();
		BeanUtils.copyProperties(dcIncome, dcIncomeEntity);

		DcIncomeEntity incomeEntity = dcIncomeRepo.save(dcIncomeEntity);
		return incomeEntity;
	}
     
	
}
