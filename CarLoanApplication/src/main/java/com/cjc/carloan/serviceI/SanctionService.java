package com.cjc.carloan.serviceI;

import java.io.ByteArrayInputStream;

import com.cjc.carloan.model.CustomerDetails;
import com.cjc.carloan.model.SanctionLetter;

public interface SanctionService
{

	Iterable<CustomerDetails> getCustomerbyStatus(String customerLoanStatus);
	
	ByteArrayInputStream generateSactionId(Integer customerId, SanctionLetter sanctionLetter);
   
}
