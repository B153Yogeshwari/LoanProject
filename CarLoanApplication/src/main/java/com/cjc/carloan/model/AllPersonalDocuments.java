package com.cjc.carloan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class AllPersonalDocuments 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer documentId;
	private byte[] photo;
	private byte[] signature;
	private byte[] addressProof;
	private byte[] panCard;
	private byte[] adharCard;
	private byte[] salarySlip;
	private byte[] incomeTaxReturn;
	private byte[] bankCheque;
	private byte[] bankStatements;
	

}
