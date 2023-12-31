package com.cjc.carloan.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

import lombok.Data;

@Data
@Entity
public class EnquiryModel 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer enquiryId; 
	private String firstName;
	private String lastName;
	private Integer age;
	private String emailId;
	private long mobileNumber;
	private long adharNumber;
	private String panCardNumber;
	private String cibilStatus;
	
	private Integer cibilScore;
	

	
	
	
}
