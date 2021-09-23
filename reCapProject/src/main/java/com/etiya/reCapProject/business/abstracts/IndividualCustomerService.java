package com.etiya.reCapProject.business.abstracts;

import java.util.List;

import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concrates.IndividualCustomer;
import com.etiya.reCapProject.entities.request.individualCustomerRequest.AddIndividualCustomerRequest;
import com.etiya.reCapProject.entities.request.individualCustomerRequest.DeleteIndividualCustomerRequest;
import com.etiya.reCapProject.entities.request.individualCustomerRequest.UpdateIndividualCustomerRequest;

public interface IndividualCustomerService {

	DataResult<List<IndividualCustomer>> getAll();
	
	Result add(AddIndividualCustomerRequest addIndividualCustomerRequest);
	
	Result delete(DeleteIndividualCustomerRequest deleteIndividualCustomerRequest);
	
	Result update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest);
	
}
