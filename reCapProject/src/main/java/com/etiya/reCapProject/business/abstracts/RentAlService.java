package com.etiya.reCapProject.business.abstracts;

import java.util.List;

import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concrates.RentAl;
import com.etiya.reCapProject.entities.request.rentalRequest.AddRentalRequest;
import com.etiya.reCapProject.entities.request.rentalRequest.UpdateRentalRequest;

public interface RentAlService {
 

	Result addRentalForIndividualCustomer(AddRentalRequest addRentalRequest);

	Result updateRentalForIndividualCustomer(UpdateRentalRequest updateRentalRequest);
	
	Result addRentalForCorporateCustomer(AddRentalRequest addRentalRequest);
	
	Result updateRentalForCorporateCustomer(UpdateRentalRequest updateRentalRequest);
	
	DataResult<List<RentAl>> getAll();
	
	

}
