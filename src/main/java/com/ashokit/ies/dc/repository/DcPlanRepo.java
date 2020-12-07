package com.ashokit.ies.dc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.ies.dc.entity.Dc_plan_Entity;

public interface DcPlanRepo extends JpaRepository<Dc_plan_Entity, Serializable>{

}
