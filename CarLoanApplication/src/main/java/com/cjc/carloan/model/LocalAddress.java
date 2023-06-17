package com.cjc.carloan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class LocalAddress 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer localAddressId;
	private String localAreaName;
	private String localCityName;
	private String localDistrict;
	private String localState;
	private Long localPincode;
	private Integer localHouseNumber;
	private String localStreetName;

}
