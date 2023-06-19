package com.cjc.carloan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

     @Data
     @Entity
    public class Ledger 
    {
    	 @Id
    	 @GeneratedValue(strategy = GenerationType.IDENTITY)
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
