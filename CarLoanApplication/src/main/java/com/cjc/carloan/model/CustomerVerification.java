package com.cjc.carloan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class CustomerVerification 
{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int verificationId;
	private String verificationDate;
	private String status;
	private String remarks;

}
