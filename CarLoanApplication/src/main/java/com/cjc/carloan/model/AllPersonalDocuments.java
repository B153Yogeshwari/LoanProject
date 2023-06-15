package com.cjc.carloan.model;

import lombok.Data;

@Data
public class AllPersonalDocuments {
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
