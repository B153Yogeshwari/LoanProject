package com.cjc.carloan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class CarDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer carId;
	private String carModel;
	private String carChassisNumber;
	private Double carPrice;
//    private String CarNumber;
//	private String CarRcBookNumber; 
}
