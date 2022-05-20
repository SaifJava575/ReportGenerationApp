package com.nit.saif.entity;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="ELIGIBILITY_DTLS")
@Data
public class EligibilityDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="PLAN_ID")
	private Integer planId;
	
	@Column(name="CASE_NUM")
	private Integer caseNum;
	
	@Column(name="PLAN_NAME")
	private String planName;
	
	@Column(name="PLAN_STATUS")
	private String planStatus;
	
	@Column(name="HOLDER_NAME")
	private String holderName;
	
	@Column(name="HOLDER_SSN")
	private String holderSsn;
	
	@Column(name="BENEFIT_AMT")
	private Integer benefitAmt;
	
	@Column(name="DENIAL_REASN")
	private String denialReason;
	
	@Column(name="START_DATE")
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;
	
	@Column(name="END_DATE")
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate endDate;

}
