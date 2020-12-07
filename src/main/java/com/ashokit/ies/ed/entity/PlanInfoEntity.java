package com.ashokit.ies.ed.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PlanInfoEntity {

	private String planName;
	private String planStatus;
	
	private String planStartDate;
	private String planEndDate;
	private String benefitAmt;
	
	private String denialReason;

}