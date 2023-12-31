package com.cjc.carloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.carloan.model.EmailSender;
import com.cjc.carloan.model.EnquiryModel;
import com.cjc.carloan.serviceI.EmailSendServiceI;
@CrossOrigin("*")
@RestController
@RequestMapping("/mail")
public class EmailSenderController 
	{
//		 @Autowired
//	     EmailSender emailsend;  //Email model class obj
	
		@Autowired
		EmailSendServiceI esi;      
		
	    @Value ("${spring.mail.username}")    //set email address here
	     String fromEmail;
	    
//	    @PostMapping(value = "/sendemail")
//		public String sendEmail(@RequestBody EmailSender e)
//		{
//			e.setFromEmail(fromEmail);
//			
//			try {
//				esi.sendemail(e);
//			}
//			catch(Exception e2)
//			{
//				return "email can not send";
//			}
//			return "Email Send";
//		}
//		
		
		@PostMapping(value="/sendemail")
		public ResponseEntity<EmailSender>sendmailTouser(@RequestBody EnquiryModel enquirymodel,@RequestBody EmailSender emailsend)
		{
			System.out.println("cibil status "+enquirymodel.getCibilStatus());
			if(enquirymodel.getCibilStatus().equals("approved"))
			{
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
		      		+ "ApnaCarLoan Finance Ltd. \n Karvenagar \n"
		      		+ "Pune, Maharashtra \n India-411052\n"
		      		+ "\n"
		      		+ "Thank You For Banking With Us \n\n"
		      		+ "ApnaCarLoan Finance Ltd.....!!!!");
		
				     esi.sendemail(emailsend);
		
				return new ResponseEntity<EmailSender>(HttpStatus.OK);
			
			}
			else 
			{
				emailsend.setFromEmail(fromEmail);
				emailsend.setToEmail(enquirymodel.getEmailId());
				emailsend.setSubject("Regarding Your Car Loan Application Rejected" +enquirymodel.getFirstName()+" "+enquirymodel.getLastName());
				emailsend.setTextBody("We regret to inform you that your recent application for a car loan has been rejected."
						+ "We understand that this news may be disappointing, but we wanted to inform you promptly and provide "
						+ "You with a brief explanation regarding the decision."
						+ "After carefully reviewing your application and considering various factors, including your credit history and cibilScore"
						+ "We have determined that we are unable to approve your car loan request at this time."
						+ "If you have any questions or would like further clarification regarding our decision,"
						+ "Please feel free to contact our customer service department at [phone number] or [email address]."
						+ "Our team will be more than happy to assist you and provide any guidance or support you may need during this process."
						+ "\n\nThank you"
						+ "Mr.........."
						+ "Branch Manager \\n\"\r\n"
						+ "\nApnaCarLoan Finance Ltd. \\n Karvenagar \\n\"\r\n"
						+ "\nPune, Maharashtra \\n India-411052\\n\"\r\n"
						+ "\r\n"
						+ "Thank You For Banking With Us \\n\\n\"\r\n"
						+ "\nApnaCarLoan Finance Ltd.....!!!! ");
			}
		      return new ResponseEntity<EmailSender>(HttpStatus.OK);
		     
		   
		   }
		
		}

	

