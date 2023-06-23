package com.cjc.carloan.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.carloan.model.CustomerDetails;
import com.cjc.carloan.repository.CustomerRepository;
import com.cjc.carloan.serviceI.LoanDisbursementService;

@Service
public class LoanDisbursementImpl implements LoanDisbursementService
{
	@Autowired
   CustomerRepository cr;

	@Override
	public Optional<CustomerDetails> finddById(Integer customerId)
	{
		   
		return cr.findById(customerId);
	}

	@Override
	public CustomerDetails updateloanDisbursement(CustomerDetails customerdata) {
		     cr.save(customerdata);
		return null;
	}
	
	

	
}
