package com.etiya.reCapProject.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concrates.CarImage;
import com.etiya.reCapProject.entities.request.AddCarImageRequest;
import com.etiya.reCapProject.entities.request.DeleteCarImageRequest;
import com.etiya.reCapProject.entities.request.UpdateCarImageRequest;

public interface CarImageService {
	
DataResult<List<CarImage>> getAll();

	
	DataResult<List<CarImage>> getCarImageByCarId(int carId);

	
	Result add(AddCarImageRequest addCarImagesRequest, MultipartFile file) throws IOException;
	
	Result update(UpdateCarImageRequest updateCarImagesRequest,MultipartFile file) throws IOException;
	
	Result delete(DeleteCarImageRequest deleteCarImagesRequest);



	

}
