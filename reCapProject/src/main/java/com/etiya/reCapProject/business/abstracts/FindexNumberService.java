package com.etiya.reCapProject.business.abstracts;


import com.etiya.reCapProject.entities.concrates.CorporateCustomer;
import com.etiya.reCapProject.entities.concrates.IndividualCustomer;
  
  public interface FindexNumberService {
  
	  int checkIndividualCustomerFindexPoint(IndividualCustomer individualCustomer);
		
	int checkCorporateCustomerFindexPoint(CorporateCustomer corporateCustomer);
  
  }
 