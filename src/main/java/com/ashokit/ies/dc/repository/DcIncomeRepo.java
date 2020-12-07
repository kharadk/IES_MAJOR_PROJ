package com.ashokit.ies.dc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.ies.dc.entity.DcIncomeEntity;

public interface DcIncomeRepo extends JpaRepository<DcIncomeEntity, Serializable>{

}
