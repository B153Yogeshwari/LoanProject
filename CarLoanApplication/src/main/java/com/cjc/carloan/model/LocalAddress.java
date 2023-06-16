package com.cjc.carloan.model;

import lombok.Data;

@Data
public class LocalAddress {
	private Integer localAddressId;
	private String localAreaName;
	private String localCityName;
	private String localDistrict;
	private String localState;
	private Long localPincode;
	private Integer localHouseNumber;
	private String localStreetName;

}
