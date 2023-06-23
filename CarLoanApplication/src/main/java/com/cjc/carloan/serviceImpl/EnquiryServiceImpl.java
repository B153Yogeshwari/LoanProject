package com.cjc.carloan.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.carloan.model.Cibil;
import com.cjc.carloan.model.EnquiryModel;
import com.cjc.carloan.repository.EnquiryRepository;
import com.cjc.carloan.serviceI.EnquiryService;

@Service
public class EnquiryServiceImpl implements EnquiryService
{
	@Autowired
	EnquiryRepository er;

	@Override
	public void saveData(EnquiryModel em)  // save enquiry
	{
		er.save(em);
		
	}

	@Override
	public Iterable<EnquiryModel> getAllData()   // get all enquiry
	{
		
		return er.findAll();
	}

     @Override
	public Iterable<EnquiryModel> getEnquiry(String cibilstatus)  // get enquiry cibilstatus
	{
		    
		return er.findAllByEnquiryStatus(cibilstatus);
	}

	@Override
	public Optional<EnquiryModel> saveEnquiry(Integer id) {
		
		return er.findById(id);
	}

	
	
	
     
     
     
     
     
}
