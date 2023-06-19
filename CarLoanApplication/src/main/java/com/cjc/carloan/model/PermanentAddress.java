package com.cjc.carloan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class PermanentAddress 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer permanentAddressId;
	private String permanentAreaName;
	private String permanentCityName;
	private String permanentDistrict;
	private String permanentState;
	private Long permanentPincode;
	private Integer permanentHouseNumber;
	private String permanentStreetName;

}
