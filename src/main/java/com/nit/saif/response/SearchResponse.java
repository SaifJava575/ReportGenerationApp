package com.nit.saif.response;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SearchResponse {
	private String planName;
	private String planStatus;
	private String holderName;
	private String holderSsn;
	private Double benifitAmt;
	private String denialReason;
	private LocalDate startDate;
	private LocalDate endDate;
	
	
}
