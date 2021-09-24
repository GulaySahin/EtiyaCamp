package com.etiya.reCapProject.business.abstracts;

import java.util.List;

import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concrates.HeaterCar;
import com.etiya.reCapProject.entities.request.heaterCarRequest.AddHeaterCarRequest;
import com.etiya.reCapProject.entities.request.heaterCarRequest.DeleteHeaterCarRequest;

public interface HeaterCarService {

	DataResult<List<HeaterCar>> getAll();
	
	Result add(AddHeaterCarRequest addHeaterCarRequest);
	
	//Result delete(DeleteHeaterCarRequest deleteHeaterCarRequest);
}
