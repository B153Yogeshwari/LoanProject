package com.cjc.carloan.model;

import lombok.Data;

@Data
public class CustomerDetails {
	private Integer customerId;
	private String customerFirstName;
	private String customerMiddleName;
	private String customerLastName;
	private String customerDateOfBirth;
	private Long customerMobileNumber;
	private Long customerAdditionalMobileNumber;
	private String customerPanCard;
	private Long customerAdharNumber;
	private String gender;
	private String customerQualification;
	private String customerEmailId;
	private Double customerTotalLoanRequired;
	
	//private Integer customerCibilScore;
	private String customerLoanStatus;
	//private CarDetails 
	
	
	

}
