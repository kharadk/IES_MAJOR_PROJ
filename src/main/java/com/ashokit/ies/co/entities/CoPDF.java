package com.ashokit.ies.co.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "CO_PDF")
public class CoPDF {
	@Id
	@GeneratedValue
	@Column(name = "CO_PDF_ID")
	protected int coId;
	@Column(name = "PLAN_STATUS")
	protected String planStatus;
	@Column(name = "CASE_NUMBER")
	protected String caseNumber;
	@Lob
	@Column(name = "PDF_DOCUMENT")
	protected Byte[] pdfDocument;
	@Column(name = "PLAN_NAME")
	protected String planName;
}
