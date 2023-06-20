package com.cjc.carloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cjc.carloan.model.EmailSender;
import com.cjc.carloan.model.EnquiryModel;
import com.cjc.carloan.serviceI.EmailSendServiceI;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class EmailSenderController 
	{
		// @Autowired
	    // EmailSender emailsend;  //Email model class obj
	
		@Autowired
		EmailSendServiceI esi;      
		
	    @Value ("${spring.mail.username}")    //set email address here
	     String fromEmail;
	    
	    @PostMapping(value = "/sendemail")
		public String sendEmail(@RequestBody EmailSender e)
		{
			e.setFromEmail(fromEmail);
			
			try {
				esi.sendemail(e);
			}
			catch(Exception e2)
			{
				return "email can not send";
			}
			return "Email Send";
		}
		
		
		@PostMapping(value="/sendemailwithattachment")
		public ResponseEntity<EmailSender>sendmailTouser(EnquiryModel enquirymodel,@RequestBody EmailSender emailsend){
			emailsend.setFromEmail(fromEmail);
			emailsend.setToEmail(enquirymodel.getEmailId());
			emailsend.setSubject("Regarding Car Loan For Documentation of Applicant name: "+ enquirymodel.getFirstName() +" "+ enquirymodel.getLastName());
			emailsend.setTextBody("Your cibil is Approved and You are Eligible\n"
		      		+ "For Further Process."
		      		+ "\n We are happy to inform you that your Car Loan request has been approved and is cureently being processed.\n"
		      		+ "Further, we inform you that we have sent an email containing attached documents.\n"
		      		+ "Also we have sent you the terms and conditions of the loans sanctioned. \n"
		      		+ "We would like to schedule your meeting with the finance officer of the company for any further information and clarifications that you might wish to know. \n\n"
		      		+ "We are happy to be doing business with you. \n\n"
		      		+ "List of Documents Required :- \n\n"
		      		+ "1.Aadhar Card \n"
		      		+ "2.Pan Card \n"
		      		+ "3.Income Tax Return \n"
		      		+ "4.Salary Slips of Last Three Months \n"
		      		+ "5.Passport Size Photograph \n"
		      		+ "6.Bank Passbook Copy \n"
		      		+ "\n \n Thanking You. \n"
		      		+ "Mr..........\n"
		      		+ "Branch Manager \n"
		      		+ "AapkaApnaCarLoan Finance Ltd. \n Karvenagar \n"
		      		+ "Pune, Maharashtra \n India-411052\n"
		      		+ "\n"
		      		+ "Thank You For Banking With Us \n\n"
		      		+ "AapkaApnaCarLoan Finance Ltd.....!!!!");
			try {
				esi.sendemail(emailsend);
			} 
			   catch (Exception e2) 
			{
				e2.printStackTrace();
				return new ResponseEntity<EmailSender>(HttpStatus.OK);
			}
		return new ResponseEntity<EmailSender>(HttpStatus.OK);
		
		
		}
		
	}


