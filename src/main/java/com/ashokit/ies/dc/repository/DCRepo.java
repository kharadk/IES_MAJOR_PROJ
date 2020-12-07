package com.ashokit.ies.dc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.ies.ar.entity.ApplicationEntity;
import com.ashokit.ies.dc.entity.Dc_ApplicantEntity;
import com.ashokit.ies.dc.entity.Dc_plan_Entity;



public interface DCRepo extends JpaRepository<ApplicationEntity, Serializable> {

	Dc_ApplicantEntity save(Dc_ApplicantEntity entity);

	Dc_plan_Entity save(Dc_plan_Entity dc_plan_Entity);
    
}
 