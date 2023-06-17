package com.cjc.carloan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class GuarantorDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer guarantorId;
	private String guarantorName;	
	private String guarantorDateOfBirth;
	private String guarantorRelationshipWithCustomer;	
	private Long guarantorMobileNumber;	
	private Long guarantorAdharCardNo;	
	private String guarantorMortageDetails;	
	private String guarantorJobDetails;	
	private String guarantorLoaclAddress;	
	private String guarantorPermanentAddress;	

}
