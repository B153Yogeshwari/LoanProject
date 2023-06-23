package com.cjc.carloan.serviceI;

import java.util.Optional;

import com.cjc.carloan.model.Cibil;
import com.cjc.carloan.model.EnquiryModel;

public interface EnquiryService 
{

	public void saveData(EnquiryModel em);

	public Iterable<EnquiryModel> getAllData();

	public Iterable<EnquiryModel> getEnquiry(String cibilstatus);
   
	public Optional<EnquiryModel> saveEnquiry(Integer id);

	

	

	

	   
}
