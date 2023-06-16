package com.cjc.carloan.serviceI;

import com.cjc.carloan.model.EnquiryModel;

public interface EnquiryService 
{

	public void saveData(EnquiryModel em);

	public Iterable<EnquiryModel> getAllData();

	   
}
