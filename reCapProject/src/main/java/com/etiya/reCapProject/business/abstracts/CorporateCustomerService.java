package com.etiya.reCapProject.business.abstracts;

import java.util.List;

import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concrates.CorporateCustomer;
import com.etiya.reCapProject.entities.request.CorporateCustomerRequest.AddCorporateCustomerRequest;
import com.etiya.reCapProject.entities.request.CorporateCustomerRequest.DeleteCorporateCustomerRequest;
import com.etiya.reCapProject.entities.request.CorporateCustomerRequest.UpdateCorporateCustomerRequest;

public interface CorporateCustomerService {

	DataResult<List<CorporateCustomer>> getAll();
	
	Result add(AddCorporateCustomerRequest corporateCustomerRequest);
	
	Result delete(DeleteCorporateCustomerRequest deleteCorporateCustomerRequest);

	Result update(UpdateCorporateCustomerRequest updateCorporateCustomerRequest);
}
