package com.ashokit.ies.co.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.ies.co.entities.EligibiltyDetailsEntity;

public interface EDRepo extends JpaRepository<EligibiltyDetailsEntity, Serializable> {

}
