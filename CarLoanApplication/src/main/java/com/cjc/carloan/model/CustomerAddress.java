package com.cjc.carloan.model;

import lombok.Data;


     @Data
	public class CustomerAddress 
	{
		private Integer customerAddressId;
		private String localAreaName;
		private String localCityName;
		private String localDistrict;
		private String localState;
		private Long localPincode;
		private String localHouseNumber;
		private String localStreetName;
		private String permanentAreaName;
		private String permanentCityName;
		private String permanentDistrict;
		private String permanentState;
		private Long permanentPincode;
		private String permanentHouseNumber;
		private String permanentStreetName;
		
	
	
}
