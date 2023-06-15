package com.cjc.carloan.model;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import lombok.Data;


     @Data
	public class CustomerAddress 
	{
    	 private Integer customerAddressId;
    	 @OneToOne(cascade = CascadeType.ALL)
		private PermanentAddress permanentAddress;
    	 @OneToOne(cascade = CascadeType.ALL)
    	 private LocalAddress localAddress;
		
		
	
	
}
