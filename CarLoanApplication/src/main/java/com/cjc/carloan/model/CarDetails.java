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
	private Integer CarId;
	private String CarModel;
	private String CarChassisNumber;
	private Double CarPrice;
    private String CarNumber;
	private String CarRcBookNumber; 
}
