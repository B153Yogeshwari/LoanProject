package com.cjc.carloan.model;

import lombok.Data;

@Data
public class EmiDetails {
	private Integer emiId;
	private Double emiAmountMonthly;
	private String nextEmiDueDate;
	private String previousEmiStatus;

}
