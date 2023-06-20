package com.cjc.carloan.serviceImpl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cjc.carloan.model.EmailSender;
import com.cjc.carloan.serviceI.EmailSendServiceI;

@Service
public class EmailSenderImpl implements EmailSendServiceI
{
     @Autowired
	 JavaMailSender jms;
	
	@Override
	public void sendemail(EmailSender e) 
	{
		SimpleMailMessage message = new SimpleMailMessage();
		  message.setTo(e.getToEmail());
		  message.setFrom(e.getFromEmail());
		  message.setSubject(e.getSubject());
		  message.setText(e.getTextBody());
		  
		  jms.send(message);
		    
		
	}

	@Override
	public void sendEmailwithattachment(EmailSender e, MultipartFile file) 
	{
		 MimeMessage message = jms.createMimeMessage();

	     try {
			MimeMessageHelper helper = new MimeMessageHelper(message,true) ;
			helper.setTo(e.getToEmail());
			helper.setFrom(e.getFromEmail());
			helper.setSubject(e.getSubject());
			helper.setText(e.getTextBody());
			
			jms.send(message);
			
		} catch (MessagingException e1) {
			
			e1.printStackTrace();
		}	
		
	}

}
