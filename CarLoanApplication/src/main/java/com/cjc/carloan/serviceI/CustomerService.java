package com.cjc.carloan.serviceI;

import java.util.List;
import java.util.Optional;

import com.cjc.carloan.model.CustomerDetails;

public interface CustomerService 
{

	 

	public void savedCustomer(CustomerDetails cd);  // post All Data Of Customer

	public Iterable<CustomerDetails> getAllCustomer();  // get All Data Of Customer

	public Optional<CustomerDetails> getSingleCustomer(Integer customerId);  //get single customer

	public Iterable<CustomerDetails> getCustomerbyStatus(String custloanstatus); // get customer loan status

	
	
      
	
	

	
	

	
	

}
