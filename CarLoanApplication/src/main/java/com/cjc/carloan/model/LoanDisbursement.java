package com.cjc.carloan.model;

import lombok.Data;

@Data
public class LoanDisbursement {
	private Integer agreementId;
	private Double totalLoanSanctionedAmount;
	private Double transferedAmount;
	private String amountPaidDate;
	private String paymentStatus;
	private Long dealerBankAccountNumber;
	private String dealerBankName;
	private String dealerBankIfscNumber;

}
