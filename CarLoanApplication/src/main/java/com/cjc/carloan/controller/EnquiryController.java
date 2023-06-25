package com.cjc.carloan.controller;
import java.util.Optional;
import java.util.Random;

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
import org.springframework.web.bind.annotation.RestController;

import com.cjc.carloan.enums.CibilStatus;
import com.cjc.carloan.exception.EnquiryNotFoundException;
import com.cjc.carloan.model.Cibil;
import com.cjc.carloan.model.EnquiryModel;
import com.cjc.carloan.serviceI.EnquiryService;
@CrossOrigin("*")
@RequestMapping("/enquiry")
@RestController
public class EnquiryController 
{
	@Autowired
	
	EnquiryService esi;
 
	
	
	@PostMapping("/savedata")   // post enquiry or save enquiry data
	public ResponseEntity<String>regdata(@RequestBody EnquiryModel em) 
	{
		em.setCibilStatus(String.valueOf(CibilStatus.pending));
		esi.saveData(em);
		return new ResponseEntity<String>("saved",HttpStatus.CREATED);
	}
        
	  
	@GetMapping("/getalldata")  // Get All Enquiry Data
	public ResponseEntity<Iterable<EnquiryModel>> getAllData(){
		
		
		Iterable<EnquiryModel> list=esi.getAllData();
		return new ResponseEntity<Iterable<EnquiryModel>>(list,HttpStatus.ACCEPTED);
		
	}	
	
//	@GetMapping("/singleEnquiry/{enquiryId}")
//	public ResponseEntity<Integer> getSingleEnquiry(@PathVariable int enquiryId)
//	{
//		EnquiryModel enquiry = esi.getSingleEnquiry(enquiryId);
//		return ResponseEntity<Integer>(enquiry,HttpStatus.ACCEPTED);
//		
//	}
	
	
	@GetMapping("/getEnquiry/{CIBILStatus}")
	public ResponseEntity<Iterable<EnquiryModel>> getEnquiry(@PathVariable("CIBILStatus") String CIBILStatus)
	{
		
		 Iterable<EnquiryModel> enq = esi.getEnquiry(CIBILStatus);
		 
		 return new ResponseEntity<Iterable<EnquiryModel>>(enq,HttpStatus.OK) ;
		 
	}
	@PutMapping("/CheckCIBIL/{enquiryId}")
	public ResponseEntity<EnquiryModel> checkCibilScore(@PathVariable("enquiryId") Integer enquiryId,@RequestBody EnquiryModel e)
	{
		Random ramdom=new Random();
		int cibilScore = ramdom.nextInt(600) + 300;
		
		if(cibilScore>=400 && cibilScore<=900) 
		{
			e.setCibilStatus(String.valueOf(CibilStatus.approved));
			e.setCibilScore(cibilScore);
		
		    EnquiryModel enquiry = esi.saveEnquiry(e);

		    
			return new ResponseEntity<EnquiryModel>(enquiry,HttpStatus.OK);
		}
		else
		{
			e.setCibilStatus(String.valueOf(CibilStatus.rejected));
			e.setCibilScore(cibilScore);
			EnquiryModel enquiry = esi.saveEnquiry(e);			
		
		 return new ResponseEntity<EnquiryModel>(enquiry,HttpStatus.OK);
		}
		
	}
	
}



	

