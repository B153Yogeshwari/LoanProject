package com.cjc.carloan.controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cjc.carloan.model.CustomerDetails;
import com.cjc.carloan.serviceI.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CustomerController 
{
	    @Autowired
       CustomerService cs;
	 
	@PostMapping(value = "/postCustomer", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)	
	public ResponseEntity<String> postCustomer(@RequestBody CustomerDetails cd, @RequestPart("allData") String allData,
			@RequestPart("photo") MultipartFile file1, @RequestPart("signature") MultipartFile file2,
			@RequestPart("addressProof") MultipartFile file3, @RequestPart("panCard") MultipartFile file4,
			@RequestPart("adharCard") MultipartFile file5, @RequestPart("salarySlip") MultipartFile file6,
			@RequestPart("incomeTaxReturn") MultipartFile file7, @RequestPart("bankCheque") MultipartFile file8, 
			@RequestPart("bankStatements") MultipartFile file9) 
	{

		           cs.savedCustomer(cd);
	
		ObjectMapper om = new ObjectMapper();
		
		
			
		
		return new ResponseEntity<String>("Saved",HttpStatus.ACCEPTED);
	}
	
}
