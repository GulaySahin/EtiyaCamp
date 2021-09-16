package com.etiya.reCapProject.business.abstracts;

import java.util.List;

import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concrates.RentAl;

public interface RentAlService {
 
	  DataResult<List<RentAl>>getAll();
	  
	  DataResult<RentAl>getById(int carId);
	  
	  Result add(RentAl rental);
	  
	  Result update(RentAl rental);
	  
	  Result delete(RentAl rental);
	  
}
