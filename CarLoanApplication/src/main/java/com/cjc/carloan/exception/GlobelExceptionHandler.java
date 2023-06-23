package com.cjc.carloan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobelExceptionHandler 
{
	@ExceptionHandler(CustomerNotFound.class)
	public ResponseEntity<String> CustomerNotFoundException(CustomerNotFound e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
}
	
	@ExceptionHandler(EnquiryNotFoundException.class)
	public ResponseEntity<String> EnquiryNotFoundException(EnquiryNotFoundException e)
	{
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	   @ExceptionHandler(PdfNotGenerated.class)
	  public ResponseEntity<String> PdfNotFoundException(PdfNotGenerated e)
	  {
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		   
	}
}