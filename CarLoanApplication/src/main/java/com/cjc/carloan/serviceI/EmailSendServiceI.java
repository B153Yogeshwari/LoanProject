package com.cjc.carloan.serviceI;

import org.springframework.web.multipart.MultipartFile;

import com.cjc.carloan.model.EmailSender;

public interface EmailSendServiceI 
{
	public void sendemail(EmailSender e);

	public void sendEmailwithattachment(EmailSender e, MultipartFile file);

}
