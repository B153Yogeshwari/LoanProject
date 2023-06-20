package com.cjc.carloan.serviceI;

import java.util.List;

import com.cjc.carloan.model.CustomerDetails;

public interface CustomerService {

	 

	public void savedCustomer(CustomerDetails cd);

	public Iterable<CustomerDetails> getCustomer();

	public CustomerDetails getSingleCustomer(Integer customerId);

	
	

	
	

	
	

}
