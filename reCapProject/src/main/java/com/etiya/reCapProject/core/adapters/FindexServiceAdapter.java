package com.etiya.reCapProject.core.adapters;

import org.springframework.stereotype.Service;

import com.etiya.reCapProject.business.abstracts.FindexNumberService;
import com.etiya.reCapProject.core.services.FindexService;
import com.etiya.reCapProject.entities.concrates.CorporateCustomer;
import com.etiya.reCapProject.entities.concrates.IndividualCustomer;

@Service
public class FindexServiceAdapter implements FindexNumberService {

	@Override
	public int checkIndividualCustomerFindexPoint(IndividualCustomer individualCustomer) {
		FindexService findexService= new FindexService();
		return findexService.individualCustomerFindexPoint(individualCustomer.getIdentityNumber());
	}

	@Override
	public int checkCorporateCustomerFindexPoint(CorporateCustomer corporateCustomer) {
		FindexService findexService= new FindexService();
		return findexService.corporateCustomerFindexPoint(corporateCustomer.getTaxNumber());
	}

}