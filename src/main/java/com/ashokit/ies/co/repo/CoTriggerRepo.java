package com.ashokit.ies.co.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.ies.co.entities.CoTriggers;

public interface CoTriggerRepo extends JpaRepository<CoTriggers, Serializable>{
  public List<CoTriggers> findByTrgStatus(String status);

}
