package com.cjc.carloan.controller;





import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cjc.carloan.model.AllPersonalDocuments;
import com.cjc.carloan.model.CustomerDetails;

import com.cjc.carloan.serviceI.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@CrossOrigin("*")
@RestController
public class CustomerController 
{
	   
	 @Autowired
     CustomerService cs;
	 
	 
	 //Post All CustomerDetails Data
	 
	@PostMapping(value = "/postCustomer")	
	public ResponseEntity<String> postCustomer(@RequestParam("allData") String allData,
			@RequestParam("photo") MultipartFile photo, @RequestParam("signature") MultipartFile signature,
			@RequestParam("addressProof") MultipartFile addressproof, @RequestParam("panCard") MultipartFile pancard,
			@RequestParam("adharCard") MultipartFile adharcard, @RequestPart("salarySlip") MultipartFile salaryslip,
			@RequestParam("incomeTaxReturn") MultipartFile incometaxreturn) throws JsonMappingException, JsonProcessingException 
	{

		         
	
		     ObjectMapper om = new ObjectMapper();
		
		     CustomerDetails cd=om.readValue(allData, CustomerDetails.class);
		
			try 
			{
				AllPersonalDocuments apd=new AllPersonalDocuments();
				apd.setPhoto(photo.getBytes());
				apd.setSignature(signature.getBytes());
				apd.setAddressProof(addressproof.getBytes());
				apd.setPanCard(pancard.getBytes());
				apd.setAdharCard(addressproof.getBytes());
				apd.setSalarySlip(salaryslip.getBytes());
				apd.setIncomeTaxReturn(incometaxreturn.getBytes());
				//apd.setBankCheque(bankcheque.getBytes());
				//apd.setBankStatements(bankstatement.getBytes());
				
				  cd.setDocuments(apd);
				  
				  cs.savedCustomer(cd);
				
			} catch (IOException e) 
			{
				
				e.printStackTrace();
			}
			
		
		return new ResponseEntity<String>("Saved",HttpStatus.CREATED);
	}
	
	// Get all CustomerDetails
	@GetMapping(value="/getCustomer")	
	public ResponseEntity<Iterable<CustomerDetails>> getCustomer() 
	{

		
		Iterable<CustomerDetails> cus = cs.getCustomer();
			return new ResponseEntity<Iterable<CustomerDetails>>(cus,HttpStatus.ACCEPTED);
		
	}
	
}
