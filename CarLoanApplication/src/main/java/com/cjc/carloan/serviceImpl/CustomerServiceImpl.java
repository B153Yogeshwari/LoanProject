package com.cjc.carloan.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.carloan.model.CustomerDetails;
import com.cjc.carloan.repository.CustomerRepository;
import com.cjc.carloan.serviceI.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService
{
     @Autowired
	CustomerRepository cr;

	@Override
	public void savedCustomer(CustomerDetails cd)  //save customer
	{
	     cr.save(cd);	
	}

	 @Override
	public Optional<CustomerDetails> getSingleCustomer(Integer customerId) //get single customer
	 {
		Optional<CustomerDetails> cd =cr.findById(customerId);
		return cd;
	}

	@Override
	public Iterable<CustomerDetails> getAllCustomer()  // get All Customer
	{
		return cr.findAll();
	}

	@Override    
	public Iterable<CustomerDetails> getCustomerbyStatus(String custloanstatus) // get Customer loan Status
	{
		return cr.findAllByCustomerLoanStatus(custloanstatus);
	}

	@Override
	public Optional<CustomerDetails> findById(Integer customerId) {
		   
		return cr.findById(customerId);
	}

	@Override
	public CustomerDetails updateCustomer(CustomerDetails customer) // update customer loan status
	{
		return cr.save(customer);
		
	}

	
	
}
