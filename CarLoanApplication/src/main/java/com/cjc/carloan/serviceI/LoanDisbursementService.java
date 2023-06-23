package com.cjc.carloan.serviceI;

import java.util.Optional;

import com.cjc.carloan.model.CustomerDetails;

public interface LoanDisbursementService
{

	Optional<CustomerDetails> finddById(Integer customerId);

	CustomerDetails updateloanDisbursement(CustomerDetails customerdata);

}
