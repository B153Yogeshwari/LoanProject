package com.cjc.carloan.model;

import lombok.Data;

@Data
public class AccountDetails {
	private Integer accountId;
	private Long accountNumber;
	private String accountHolderName;
	private String accountType;
	private String iFSCCode;
	private String bankName;

}
