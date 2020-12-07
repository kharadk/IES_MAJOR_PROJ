package com.ashokit.ies.admin.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Plan {

	protected int pid;
	protected String planName;
	protected String description;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	protected Date planStartDate;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	protected Date planEndDate;
}
