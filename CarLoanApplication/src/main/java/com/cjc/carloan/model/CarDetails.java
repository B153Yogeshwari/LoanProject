package com.cjc.carloan.model;

import lombok.Data;

@Data
public class CarDetails 
{
	private Integer CarId;
	private String CarModel;
	private String CarChassisNumber;
	private Double CarPrice;
    private String CarNumber;
	private String CarRcBookNumber; 
}
