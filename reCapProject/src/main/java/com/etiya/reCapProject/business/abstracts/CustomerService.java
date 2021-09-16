package com.etiya.reCapProject.business.abstracts;

import java.util.List;

import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concrates.Customer;

public interface CustomerService {

	DataResult<List<Customer>>getAll();
	
	Result add(Customer customer);
	
	Result update(Customer customer);
	
	Result delete(Customer customer);
	
}
