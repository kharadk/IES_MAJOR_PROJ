package com.ashokit.ies.admin.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.ies.admin.entity.EmployAccEnity;

public interface EmployeeRepository extends JpaRepository<EmployAccEnity, Serializable>{

	public EmployAccEnity findByEmail(String email);
	
	public List<EmployAccEnity> findByRole(String role);
}
