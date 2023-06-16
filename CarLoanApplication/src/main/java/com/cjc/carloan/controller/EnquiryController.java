package com.cjc.carloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.carloan.model.EnquiryModel;
import com.cjc.carloan.serviceI.EnquiryService;
@CrossOrigin("*")
@RequestMapping("/enquiry")
@RestController
public class EnquiryController 
{
	@Autowired
	
	EnquiryService esi;
 
	@PostMapping("/savedata")
	public ResponseEntity<String>regdata(@RequestBody EnquiryModel em) 
	{
		
		esi.saveData(em);
		return new ResponseEntity<String>("saved",HttpStatus.CREATED);
	}

	@GetMapping("/getalldata")
	public ResponseEntity<Iterable<EnquiryModel>> getAllData(){
		
		Iterable<EnquiryModel> list=esi.getAllData();
		return new ResponseEntity<Iterable<EnquiryModel>>(list,HttpStatus.ACCEPTED);
		
	}	
}
