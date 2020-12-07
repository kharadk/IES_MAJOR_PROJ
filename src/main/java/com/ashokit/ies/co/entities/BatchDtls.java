package com.ashokit.ies.co.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name = "BATCH_RUN_DTLS")
public class BatchDtls {
	@Id
	@GeneratedValue
	 @Column(name = "BATCH_RUN_SEQ")
	protected int batchRunSeq;
	@Column(name = "BATCH_NAME")
	protected String batchName;  
	@Column(name = "BATCH_RUN_STATUS")
	protected String batchRunStatus  ;
	@Column(name = "END_DATE")
	protected Date endDate;   
	@Column(name = "INSTANCE_NUM")
	protected int instanceNum; 
	@Column(name = "START_DATE")
	@CreationTimestamp
	protected Date startDate; 
	}
