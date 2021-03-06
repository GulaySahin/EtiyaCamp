package com.etiya.reCapProject.business.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concrates.Car;
import com.etiya.reCapProject.entities.dtos.CarDetailDto;
import com.etiya.reCapProject.entities.request.carRequest.AddCarRequest;
import com.etiya.reCapProject.entities.request.carRequest.DeleteCarRequest;
import com.etiya.reCapProject.entities.request.carRequest.UpdateCarRequest;

public interface CarService {


	@Query("Select new com.etiya.reCapProject.entities.dtos.CarDetailsDto"
			+ " (c.carName, b.brandName , cl.colorName, c.dailyPrice) " 
			+ " From Brand b Inner Join b.cars c"
			+ " Inner Join c.color cl")
	DataResult<List<CarDetailDto>> getCarWithDetails();
	

	DataResult<List<Car>> getAll();

	DataResult<Car> getById(int carId);
	
	DataResult<List<Car>> getByCarCity(String city);
	
	DataResult<List<Car>> IsCarCareIsTrue();
	
	DataResult<List<Car>> IsCarCareIsFalse();
	

	DataResult<List<Car>> getByBrand_brandId(int brandId);
	
	DataResult<List<Car>> getByColor_colorId(int colorId);

	Result add(AddCarRequest addCarRequest);
																		
	Result update(UpdateCarRequest updateCarRequest);

	Result delete(DeleteCarRequest deleteCarRequest);
}
