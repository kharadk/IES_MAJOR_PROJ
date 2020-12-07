package com.ashokit.ies.admin.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.ies.admin.domain.EmployeeAccount;
import com.ashokit.ies.admin.domain.Plan;
import com.ashokit.ies.admin.entity.EmployAccEnity;
import com.ashokit.ies.admin.entity.PlanEntity;
import com.ashokit.ies.admin.repository.EmployeeRepository;
import com.ashokit.ies.admin.repository.PlanRepository;
import com.ashokit.ies.utils.EmailUtils;

@Service
public class EmployeeManagementServiceImpl implements EmployeeManagementService {
	@Autowired
	EmployeeRepository repo;
	@Autowired
	PlanRepository planRepo;
	@Autowired
	EmailUtils emailUtils;

	public boolean saveEmployee(EmployeeAccount employeeAccount) throws IOException {
		EmployAccEnity entity = new EmployAccEnity();
		BeanUtils.copyProperties(employeeAccount, entity);
		EmployAccEnity enity = repo.save(entity);
		if (enity != null) {
			String to = employeeAccount.getEmail();
			String body = getRegSuccMailBody(employeeAccount);
			String subject = " IES Account Registration";
			System.out.println(to + "," + body + "," + subject);
			sendRegSuccEmail(to, body, subject);

			return true;
		}
		return false;

	}

	@Override
	public boolean isUniqueEmail(String email) {

		EmployAccEnity enity = repo.findByEmail(email);

		return enity != null ? true : false;
	}

	@Override
	public String getRegSuccMailBody(EmployeeAccount employeeAccount) throws IOException {
		String fileName = "REGISTRATION-SUCCESS-EMAIL-BODY-TEMPLATE.txt";
		String mailBody = null; 

		Path path = Paths.get(fileName, "");

		@SuppressWarnings("resource")
		Stream<String> lines = Files.lines(path);

		List<String> replacedLine = lines.map(line -> line.replace("{FNAME}", employeeAccount.getFirstName())
				.replace("{LNAME}", employeeAccount.getLastName()).replace("{Role}", employeeAccount.getRole())
				.replace("{username}", employeeAccount.getFirstName()).replace("{passwd}", employeeAccount.getPasswd()))
				.collect(Collectors.toList());

		mailBody = String.join("", replacedLine);
		return mailBody;
	}

	@Override
	public void sendRegSuccEmail(String email, String body, String subject) {

		emailUtils.sendEmail(email, subject, body);
	}

	@Override
	public List<EmployeeAccount> viewAllAccount() {

		List<EmployAccEnity> accEnities = repo.findAll();

		List<EmployeeAccount> contacts = new ArrayList<>();

		accEnities.forEach(entity -> {
			EmployeeAccount employeeAccount = new EmployeeAccount();

			BeanUtils.copyProperties(entity, employeeAccount);

			contacts.add(employeeAccount);
		});
		return contacts;
	}

	@Override
	public EmployeeAccount getAccountById(int contactId) {
		EmployAccEnity accEnity = null;
		Optional<EmployAccEnity> optional = repo.findById(contactId);
		if (optional.isPresent()) {
			accEnity = optional.get();
		}
		EmployeeAccount employeeAccount = new EmployeeAccount();

		BeanUtils.copyProperties(accEnity, employeeAccount);

		return employeeAccount;
	}

	@Override
	public List<EmployeeAccount> getAccountsByRole(String role) {
		List<EmployAccEnity> accEntities = repo.findByRole(role);
		
		
		System.out.println(accEntities+"==============================================");
		List<EmployeeAccount> contacts = new ArrayList<>();

		accEntities.forEach(entity -> {
			EmployeeAccount employeeAccount = new EmployeeAccount();

			BeanUtils.copyProperties(entity, employeeAccount);

			contacts.add(employeeAccount);
		});
		return contacts;

	}

	@Override
	public boolean deleteAccount(int contactId) {
		repo.deleteById(contactId);
		return true;
	}

	@Override
	public boolean savePlan(Plan plan) {
		PlanEntity planEntity = new PlanEntity();
		BeanUtils.copyProperties(plan, planEntity);
		PlanEntity entity = planRepo.save(planEntity);

		if (entity != null) {
			return true;
		}
		return false;
	}
	@Override
	public List<Plan> viewAllPlans() {
		List<PlanEntity> planEntities = planRepo.findAll();

		List<Plan> plans = new ArrayList<>();

		planEntities.forEach(entity -> {
			Plan plan = new Plan();

			BeanUtils.copyProperties(entity, plan);

			plans.add(plan);
		});
		return plans;
	}


	@Override
	public Plan getPlanById(int pid) {
		Plan plan = null;
		PlanEntity planEntity = null;
		Optional<PlanEntity> optional = planRepo.findById(pid);
		if (optional.isPresent()) {
			planEntity = optional.get();
		}

		plan = new Plan();
		BeanUtils.copyProperties(planEntity, plan);

		Date planStartDate = plan.getPlanStartDate();
		Date planEnDate = plan.getPlanEndDate();

		java.sql.Date startDate = new java.sql.Date(planStartDate.getTime());
		java.sql.Date endDate = new java.sql.Date(planEnDate.getTime());

		plan.setPlanStartDate(startDate);
		plan.setPlanEndDate(endDate);

		System.out.println(plan);
		return plan;
	}

	@Override
	public boolean deletePlan(int pid) {
		planRepo.deleteById(pid);
		return true;
	}

}
