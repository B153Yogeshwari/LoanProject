package com.cjc.carloan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class LoanDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
