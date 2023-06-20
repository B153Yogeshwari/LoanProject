package com.cjc.carloan.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.carloan.model.EnquiryModel;
import com.cjc.carloan.repository.EnquiryRepository;
import com.cjc.carloan.serviceI.EnquiryService;

@Service
public class EnquiryServiceImpl implements EnquiryService
{
	@Autowired
	EnquiryRepository er;

	@Override
	public void saveData(EnquiryModel em) 
	{
		er.save(em);
		
	}

	@Override
	public Iterable<EnquiryModel> getAllData() 
	{
	    	return er.findAll();
	}

	
	
}
