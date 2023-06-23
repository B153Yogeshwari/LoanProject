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
		em.getCibil().setCibilstatus(String.valueOf(CibilStatus.pending));
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
	
	
	@GetMapping("/getEnquiry/{enquiryId}")  // get cibilStatus
	public ResponseEntity<Iterable<EnquiryModel>> getEnquiry(@PathVariable("enquiryId") String cibilstatus)
	{
		EnquiryModel eq=null;
		
		 Iterable<EnquiryModel> enq = esi.getEnquiry(cibilstatus);
		 for(EnquiryModel enq1:enq) 
		 {
			 if(enq1 !=null)
			 {
				 eq=enq1;
			 }
		 }
		 if(eq !=null) 
		 {
		 
		 return new ResponseEntity<Iterable<EnquiryModel>>(enq,HttpStatus.OK) ;
		 }
		 else
		 {
		 throw new EnquiryNotFoundException("Not Found");
		 }		
	}
	
	
	@PutMapping("/CheckCIBIL/{enquiryId}")
	public ResponseEntity<EnquiryModel> checkCibilScore(@PathVariable("enquiryId") Integer Id,@RequestBody Cibil cibil)
	{
		Random ramdom=new Random();
		int cibilScore = ramdom.nextInt(600) + 300;
		
		if(cibilScore>=600 && cibilScore<=900) 
		{
			cibil.setCibilstatus(String.valueOf(CibilStatus.approved));
			cibil.setCibilScore(cibilScore);
		
		    EnquiryModel enquiry = esi.saveEnquiry(Id);

		    
			return new ResponseEntity<EnquiryModel>(enquiry,HttpStatus.OK);
		}
		else
		{
			cibil.setCibilstatus(String.valueOf(CibilStatus.rejected));
			cibil.setCibilScore(cibilScore);
			EnquiryModel enquiry = esi.saveEnquiry(Id);			
		}
		return null;

		
	}
	
}



	

