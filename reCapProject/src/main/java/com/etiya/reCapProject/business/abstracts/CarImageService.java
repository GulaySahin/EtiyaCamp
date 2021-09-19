package com.etiya.reCapProject.business.abstracts;

import java.util.List;

import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concrates.CarImage;
import com.etiya.reCapProject.entities.request.AddCarImageRequest;
import com.etiya.reCapProject.entities.request.UpdateCarImageRequest;

public interface CarImageService {
	
	DataResult<List<CarImage>> getAll();
	
    DataResult<CarImage>getById(int id);
	
	DataResult<List<CarImage>>getByCar_carId(int carId);
	
	Result add(AddCarImageRequest addCarImageRequest);
	
	Result delete(int Id);
	
	Result update(UpdateCarImageRequest updateCarImageRequest);

}
