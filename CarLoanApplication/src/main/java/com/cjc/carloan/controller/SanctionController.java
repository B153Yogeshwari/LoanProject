package com.cjc.carloan.controller;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.carloan.model.CustomerDetails;
import com.cjc.carloan.model.SanctionLetter;
import com.cjc.carloan.serviceI.SanctionService;

@RestController
public class SanctionController 
{
	@Autowired
	SanctionService ss;
	@GetMapping("/getCustomer/{customerLoanStatus}")	//get customer by loan status
	public ResponseEntity<Iterable<CustomerDetails>> getCustomerByStatus(
			@PathVariable("customerLoanStatus") String customerLoanStatus) {
		CustomerDetails cstd = null;
		Iterable<CustomerDetails> cst = ss.getCustomerbyStatus(customerLoanStatus);
		for (CustomerDetails cstds : cst) {
			if (cstds != null) {
				cstd = cstds;
			}
		}
		if (cstd != null) {
			
			return new ResponseEntity<Iterable<CustomerDetails>>(cst,HttpStatus.OK);
		} else {
			throw new NullPointerException();
		}
	}
	
	
	@PutMapping("/generatePdf/{customerId}")
	public ResponseEntity<InputStreamResource> updateSactionLetter(@PathVariable("customerId") Integer customerId, @RequestBody SanctionLetter sanctionLetter) {
	
		CustomerDetails customerdetail = new CustomerDetails();
		
		ByteArrayInputStream customerdetails = ss.generateSactionId(customerId, sanctionLetter);
		 HttpHeaders headers=new HttpHeaders();
	      headers.add("Content-Disposition", "inline; filename=ApnaCarloanFinance_sanctionLatter.pdf");		
	
		return  ResponseEntity.ok().headers(headers)
				.contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(customerdetails));

	}
	
}
