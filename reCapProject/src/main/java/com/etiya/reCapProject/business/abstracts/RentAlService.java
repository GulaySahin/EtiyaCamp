package com.etiya.reCapProject.business.abstracts;

import java.util.List;

import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concrates.RentAl;
import com.etiya.reCapProject.entities.request.AddRentalRequest;
import com.etiya.reCapProject.entities.request.DeleteRentalRequest;
import com.etiya.reCapProject.entities.request.UpdateRentalRequest;

public interface RentAlService {
 
	  DataResult<List<RentAl>>getAll();
	  
	  DataResult<RentAl>getById(int carId);
	  
	  Result add(AddRentalRequest addRentalRequest);
	  
	  Result update(UpdateRentalRequest updateRentalRequest);
	  
	  Result delete(DeleteRentalRequest deleteRentalRequest);
	  
}
