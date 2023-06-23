package com.cjc.carloan.controller;





import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cjc.carloan.enums.CustomerLoanStatus;
import com.cjc.carloan.exception.CustomerNotFound;

import com.cjc.carloan.model.AllPersonalDocuments;
import com.cjc.carloan.model.CustomerDetails;

import com.cjc.carloan.serviceI.CustomerService;
import com.cjc.carloan.serviceImpl.CustomerServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@CrossOrigin("*")
@RestController
@RequestMapping("cust")
public class CustomerController 
{
	   
	 @Autowired
     CustomerService cs;
	 
	 
	
	 
	@PostMapping(value = "/postCustomer")	 //Post All CustomerDetails Data
	public ResponseEntity<String> postCustomer(@RequestParam("allData") String allData,
			@RequestParam("photo") MultipartFile photo, @RequestParam("signature") MultipartFile signature,
			@RequestParam("addressProof") MultipartFile addressproof, @RequestParam("panCard") MultipartFile pancard,
			@RequestParam("adharCard") MultipartFile adharcard, @RequestParam("salarySlip") MultipartFile salaryslip,
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
			return new ResponseEntity<String>("Saved Customer All Details",HttpStatus.CREATED);
	}
	
	                                     
	@GetMapping(value="/getCustomer")	// Get all CustomerDetails
	public ResponseEntity<Iterable<CustomerDetails>> getAllCustomer() 
	{
       Iterable<CustomerDetails> cus = cs.getAllCustomer();
		     if(cus!=null) {
		     return new ResponseEntity<Iterable<CustomerDetails>>(cus,HttpStatus.ACCEPTED);
	     }
		  else {
		    throw new CustomerNotFound("Customer Not Found ");
		     }
		   }   
	
	
		     
   @GetMapping(value="/getSingleCustomer/{customerId}")
	public ResponseEntity<Optional<CustomerDetails>>getSingleCustomer(@PathVariable ("customerId") Integer customerId)
	{ 
		   Optional<CustomerDetails> cd = cs.getSingleCustomer(customerId);
		     if(cd.isPresent()) 
		     {
		    	 
		     return new ResponseEntity<Optional<CustomerDetails>>(cd,HttpStatus.ACCEPTED);
		   }
		     
		     else 
		     {
		    	 throw new CustomerNotFound("Customer Not Found");
		     }
          }
		     
            @GetMapping("/getCustomer/{custloanstatus}")	//get customer by loan status
		  	public ResponseEntity<Iterable<CustomerDetails>> getCustomerByStatus(
		  			@PathVariable("custloanstatus") String custloanstatus) {
		  	
		  		Iterable<CustomerDetails> cst = cs.getCustomerbyStatus(custloanstatus);
		  	    if (cst != null) {
		  		return new ResponseEntity<Iterable<CustomerDetails>>(cst, HttpStatus.OK);
		  	   }
		  	else {
		  		throw new CustomerNotFound("Customer Not Found");
		  	    }
		 }
		
            @GetMapping(value ="/updateCustomer/{customerId}/{custloanstatus}")
       	 public ResponseEntity<String> updateCustomer(@PathVariable ("custloanstatus") String loanStatus,
       	                                              @PathVariable("customerId") Integer customerId) throws IOException {
       	     Optional<CustomerDetails> customerDetails = cs.findById(customerId);

       	     if (customerDetails.isPresent()) {
       	         CustomerDetails customer = customerDetails.get();
       	         
       	         if (loanStatus.equals("documentverfied")) {
       	             customer.setCustomerLoanStatus(String.valueOf(CustomerLoanStatus.DocumentVerified));
       	             cs.updateCustomer(customer);
       	         } else if (loanStatus.equals("documentrejected")) {
       	             customer.setCustomerLoanStatus(String.valueOf(CustomerLoanStatus.DocumentRejected));
       	             cs.updateCustomer(customer);
       	         } else {
       	             return new ResponseEntity<>("Invalid loan status value", HttpStatus.BAD_REQUEST);
       	         }
       	         return new ResponseEntity<>("Customer loan status updated successfully", HttpStatus.OK);
       	     } else {
       	        
       	     }
       		return null;
       	 }



       	
		     
}	

