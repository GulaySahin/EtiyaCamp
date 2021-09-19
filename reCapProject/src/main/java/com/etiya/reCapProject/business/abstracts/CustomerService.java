package com.etiya.reCapProject.business.abstracts;

import java.util.List;

import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.abstracts.Customer;
import com.etiya.reCapProject.entities.request.AddCustomerRequest;
import com.etiya.reCapProject.entities.request.UpdateCustomerRequest;

public interface CustomerService {

	DataResult<List<Customer>>getAll();
	
	Result add(AddCustomerRequest addCustomerRequest);
	
	Result update(UpdateCustomerRequest updateCustomerRequest);
	
	Result delete(int customerId);
	
}
