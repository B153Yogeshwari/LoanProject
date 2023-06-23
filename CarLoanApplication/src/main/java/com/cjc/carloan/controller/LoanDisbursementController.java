package com.cjc.carloan.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.carloan.enums.CustomerLoanStatus;
import com.cjc.carloan.exception.CustomerNotFound;
import com.cjc.carloan.model.CustomerDetails;
import com.cjc.carloan.model.LoanDisbursement;
import com.cjc.carloan.serviceI.LoanDisbursementService;

@RestController
public class LoanDisbursementController
{
	@Autowired
	LoanDisbursementService ldm;
	
	@PutMapping("/loanDisbursementupdate/{customerId}")
	public ResponseEntity<CustomerDetails> updateLoan(@RequestBody LoanDisbursement loandisbursement,
			@PathVariable("customerId") Integer customerId) throws IOException {
		
	Optional<CustomerDetails> op = ldm.finddById(customerId);
	
		CustomerDetails customerdata= op.get();
		if(op.isPresent()) {
		 customerdata.setCustomerLoanStatus(String.valueOf(CustomerLoanStatus.LoanDisbursed));
		 		 
		 customerdata.getLoanDisbursement().setAgreementId(loandisbursement.getAgreementId());
		 customerdata.getLoanDisbursement().setTotalLoanSanctionedAmount(loandisbursement.getTotalLoanSanctionedAmount());
		customerdata.getLoanDisbursement().setTransferedAmount(loandisbursement.getTransferedAmount());
		customerdata.getLoanDisbursement().setAmountPaidDate(loandisbursement.getAmountPaidDate());
		customerdata.getLoanDisbursement().setPaymentStatus(loandisbursement.getPaymentStatus());
		customerdata.getLoanDisbursement().setDealerBankAccountNumber(loandisbursement.getDealerBankAccountNumber());
		customerdata.getLoanDisbursement().setDealerBankName(loandisbursement.getDealerBankName());
		customerdata.getLoanDisbursement().setDealerBankIfscNumber(loandisbursement.getDealerBankIfscNumber());
		
		CustomerDetails customerdetails = ldm.updateloanDisbursement(customerdata);
		
		return ResponseEntity.ok(customerdata);
		}
		else {
			throw new CustomerNotFound("Customer Not Found");
		}
	
	}
}
