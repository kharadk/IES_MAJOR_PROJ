package com.ashokit.ies.co.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name = "co_triggers")
@Data
public class CoTriggers {
  
    @Id
    @Column(name = "trg_id")
	protected int trgId ;
    @Column(name = "case_num")
	protected int caseNum;
	@CreationTimestamp
	 @Column(name = "create_dt")
	protected Date createDt ;
	 @Column(name = "trg_status")
	protected String trgStatus ;
	@UpdateTimestamp
	 @Column(name = "updateDt")
	protected Date update_dt ;
}
