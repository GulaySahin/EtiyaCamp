package com.etiya.reCapProject.business.abstracts;

import java.util.List;

import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concrates.CareCar;
import com.etiya.reCapProject.entities.request.careCarRequest.AddCareCarRequest;
import com.etiya.reCapProject.entities.request.careCarRequest.DeleteCareCarRequest;
import com.etiya.reCapProject.entities.request.careCarRequest.UpdateCareCarRequest;

public interface CareCarService {

	DataResult<List<CareCar>> getAll();
	
	Result add(AddCareCarRequest addcareCarRequest);
	
	Result delete(DeleteCareCarRequest deletecareCarRequest);
	
	Result update(UpdateCareCarRequest updateCareCarRequest);

	
}
