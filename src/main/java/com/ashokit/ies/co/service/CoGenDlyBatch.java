package com.ashokit.ies.co.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.ashokit.ies.co.entities.CoTriggers;
import com.ashokit.ies.co.repo.BatchDtlsRepo;
import com.ashokit.ies.co.repo.CoPdfRepo;
import com.ashokit.ies.co.repo.CoTriggerRepo;
import com.ashokit.ies.co.repo.EDRepo;

public class CoGenDlyBatch {
	@Autowired
	BatchDtlsRepo batchDtlsRepo;
	@Autowired
	CoPdfRepo coPdfRepo;
	@Autowired
	CoTriggerRepo coTriggerRepo;
	@Autowired
	EDRepo edRepo;

	public String PreProceesor(Date batchStartDate, Date batchStartTime,String caseId) {
		return null;
	}

	public CoTriggers start(String status) {
		return null;

	}

	public String postProccessor(Date batchEndDate, Date batchEndTime) {
		return null;

	}
}
