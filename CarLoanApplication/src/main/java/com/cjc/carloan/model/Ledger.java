package com.cjc.carloan.model;

import lombok.Data;

     @Data
    public class Ledger 
    {
		private Integer ledgerId;
		private String ledgerCreatedDate;
		private Double totalPrincipalAmount;
		private Double payableAmountwithInterest;
		private Integer tenure;
		private Double monthlyEMI;
		private Double amountPaidtillDate;
		private Double remainingAmount;
		private String nextEmiStartDate;
		private String nextEmiEndDate;
		private String previousEmiStatus;
		private String currentMonthEmiStatus;
		private String loanEndDate;
		private String loanStatus;

}
