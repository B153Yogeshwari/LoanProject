package com.cjc.carloan.model;

import lombok.Data;

@Data
public class GuarantorDetails 
{
    private Integer guarantorId;
	private String guarantorName;	
	private String guarantorDateOfBirth;
	private String guarantorRelationshipWithCustomer;	
	private Long guarantorMobileNumber;	
	private Long guarantorAdharCardNo;	
	private String guarantorJobDetails;	
	private String guarantorAddress;	

}
