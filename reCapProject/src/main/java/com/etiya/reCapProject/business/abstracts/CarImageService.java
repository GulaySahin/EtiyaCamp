package com.etiya.reCapProject.business.abstracts;

import java.io.IOException;
import java.util.List;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concrates.CarImage;
import com.etiya.reCapProject.entities.request.carImageRequest.AddCarImageRequest;
import com.etiya.reCapProject.entities.request.carImageRequest.DeleteCarImageRequest;
import com.etiya.reCapProject.entities.request.carImageRequest.UpdateCarImageRequest;

public interface CarImageService {
	
    DataResult<List<CarImage>> getAll();

	
	DataResult<List<CarImage>> getCarImageByCarId(int carId);

	
	Result add(AddCarImageRequest addCarImageRequest) throws IOException;
	
	Result update(UpdateCarImageRequest updateCarImageRequest) throws IOException;
	
	Result delete(DeleteCarImageRequest deleteCarImagesRequest);



	

}
