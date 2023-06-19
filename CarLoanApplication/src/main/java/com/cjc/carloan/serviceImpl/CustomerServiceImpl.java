package com.cjc.carloan.serviceImpl;

import java.util.List;

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
	public void savedCustomer(CustomerDetails cd)
	{
	     cr.save(cd);	
		
	}

	@Override
	public Iterable<CustomerDetails> getCustomer()
	{
		    
		return cr.findAll();
	}

	
	
	

	

}
