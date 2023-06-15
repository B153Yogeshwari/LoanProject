package com.cjc.carloan.model;

import lombok.Data;

@Data
public class PermanentAddress {
	private Integer permanentAddressId;
	private String permanentAreaName;
	private String permanentCityName;
	private String permanentDistrict;
	private String permanentState;
	private Long permanentPincode;
	private String permanentHouseNumber;
	private String permanentStreetName;

}
