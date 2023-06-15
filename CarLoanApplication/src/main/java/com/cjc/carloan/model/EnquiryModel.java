package com.cjc.carloan.model;

import lombok.Data;

@Data
public class EnquiryModel {
	private Integer customerId;
	private String firstName;
	private String lastName;
	private Integer age;
	private String emailId;
	private long mobileNumber;
	private long adharNumber;
	private String panCardNumber;
	private String abc;
}
