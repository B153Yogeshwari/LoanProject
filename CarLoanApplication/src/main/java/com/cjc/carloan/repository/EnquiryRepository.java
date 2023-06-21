package com.cjc.carloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cjc.carloan.model.EnquiryModel;

@Repository
public interface EnquiryRepository extends JpaRepository<EnquiryModel, Integer>
{

	Iterable<EnquiryModel> findAllByEnquiryStatus(String cibilstatus);

	 
 
	
	
}
