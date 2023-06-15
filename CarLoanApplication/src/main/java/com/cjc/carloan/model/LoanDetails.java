package com.cjc.carloan.model;

import lombok.Data;

@Data
public class LoanDetails {
	private Integer loanId;
	private Double loanAmount;
	private Float rateOfInterest;
	private Integer tenure;
	private Double totalAmountToBePaid;
	private Double processFees;
	private Double toatalInterest;
	private String sanctionDate;
	private String remark;
	private String status;

}
