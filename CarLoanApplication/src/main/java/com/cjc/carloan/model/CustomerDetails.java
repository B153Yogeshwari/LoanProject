
package com.cjc.carloan.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;



@Data
@Entity
public class CustomerDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	private String customerFirstName;
	private String customerMiddleName;
	private String customerLastName;
	private String customerDateOfBirth;
	private Long customerMobileNumber;
	private Long customerAdditionalMobileNumber;
	private String customerPanCard;
	private Long customerAdharNumber;
	private String gender;
	private String customerQualification;
	private String customerEmailId;
	private Double customerTotalLoanRequired;
	@OneToOne(cascade = CascadeType.ALL)
	private Cibil customerCibilScore;
	@OneToOne(cascade = CascadeType.ALL)
	private AllPersonalDocuments documents;
	private String customerLoanStatus;
	@OneToOne(cascade = CascadeType.ALL)
	private CarDetails carDetails;
	@OneToOne(cascade = CascadeType.ALL)
	private AccountDetails accountDetails;
	@OneToOne(cascade = CascadeType.ALL)
	private GuarantorDetails gurantorDetails;
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerAddress customerAddress;
	@OneToOne(cascade = CascadeType.ALL)
	private LoanDisbursement loanDisbursement;
	@OneToOne(cascade = CascadeType.ALL)
	private Ledger ledger;
	@OneToOne(cascade = CascadeType.ALL)
	private SanctionLetter sanctionletter;
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerVerification customerVerification;
	
	
	
	

}
