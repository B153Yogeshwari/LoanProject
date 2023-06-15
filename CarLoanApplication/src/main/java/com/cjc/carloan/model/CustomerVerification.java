package com.cjc.carloan.model;

import lombok.Data;

@Data
public class CustomerVerification 
{

	private int verificationId;
	private String verificationDate;
	private String status;
	private String remarks;

}
