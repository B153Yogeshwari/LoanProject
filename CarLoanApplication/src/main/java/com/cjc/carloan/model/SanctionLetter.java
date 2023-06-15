package com.cjc.carloan.model;

import lombok.Data;

@Data
public class SanctionLetter 
{

	private Integer sanctionId;
	private String sanctionDate;
	private String applicantName;
	private Double loanAmountSanctioned;
	private Double rateOfInterest;
	private Integer loanTenure;
	private Double monthlyEmiAmount;
	private String termsAndCondition;
	private byte[] sanctionLetter;


}
