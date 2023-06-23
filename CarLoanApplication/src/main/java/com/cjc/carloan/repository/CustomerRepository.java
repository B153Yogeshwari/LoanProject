package com.cjc.carloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.carloan.model.CustomerDetails;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDetails, Integer>
{
	
	
	public Iterable<CustomerDetails> findAllByCustomerLoanStatus(String custloanstatus);
}
