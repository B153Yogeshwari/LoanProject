package com.cjc.carloan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class EnquiryModel 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	private String firstName;
	private String lastName;
	private Integer age;
	private String emailId;
	private long mobileNumber;
	private long adharNumber;
	private String panCardNumber;
	
}
