package com.etiya.reCapProject.business.abstracts;

import java.util.List;

import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concrates.CarDamage;
import com.etiya.reCapProject.entities.request.carDamageRequest.AddCarDamageRequest;
import com.etiya.reCapProject.entities.request.carDamageRequest.DeleteCarDamageRequest;
import com.etiya.reCapProject.entities.request.carDamageRequest.UpdateCarDamageRequest;

public interface CarDamageService {

	DataResult<List<CarDamage>> getAll();

    Result add(AddCarDamageRequest addCarDamageRequest);

    Result update(UpdateCarDamageRequest updateCarDamageRequest);

    Result delete(DeleteCarDamageRequest deleteCarDamageRequest);
}
