package com.ashokit.ies.admin.services;

import java.io.IOException;
import java.util.List;

import com.ashokit.ies.admin.domain.EmployeeAccount;
import com.ashokit.ies.admin.domain.Plan;

public interface EmployeeManagementService {

	public boolean saveEmployee(EmployeeAccount employeeAccount) throws IOException;

	public boolean isUniqueEmail(String email);

	public String getRegSuccMailBody(EmployeeAccount employeeAccount) throws IOException;

	public void sendRegSuccEmail(String mobileNo, String body, String subject);

	public List<EmployeeAccount> viewAllAccount();
	public List<EmployeeAccount> getAccountsByRole(String role);

	public EmployeeAccount getAccountById(int empId);

	public boolean deleteAccount(int empIdId);
   
	public boolean savePlan(Plan plan);
	public List<Plan> viewAllPlans();
	public Plan getPlanById(int pid);

	public boolean deletePlan(int pid);
}
