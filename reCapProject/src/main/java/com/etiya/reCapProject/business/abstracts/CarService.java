package com.etiya.reCapProject.business.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concrates.Car;
import com.etiya.reCapProject.entities.dtos.CarDetailDto;
import com.etiya.reCapProject.entities.request.AddCarRequest;
import com.etiya.reCapProject.entities.request.DeleteCarRequest;
import com.etiya.reCapProject.entities.request.UpdateCarRequest;

public interface CarService {

	DataResult<List<Car>> getAll();

	DataResult<Car>getById(int carId);

	Result add(AddCarRequest addCarRequest);

	Result update(UpdateCarRequest updateCarRequest);

	Result delete(DeleteCarRequest deleteCarRequest);
	
	@Query("Select new com.etiya.reCapProject.entities.dtos.CarDetailDto"
            + " (c.carName, b.brandName , cl.colorName, c.dailyPrice) " 
            + " From Brand b Inner Join b.cars c"
            + " Inner Join c.color cl")
	DataResult<List<CarDetailDto>>getCarWithBrandAndColorDetails();
	
	DataResult<List<Car>> getByBrand_brandId(int brandId);

    DataResult<List<Car>> getByColor_colorId(int colorId);
 
    
	/*
	 * @Query("Select new com.etiya.reCapProject.entities.dtos.CarWithCarImageDetailDto"
	 * +
	 * " (c.carId,b.brandName ,cl.colorName, c.dailyPrice, ci.carImage , c.modelYear)"
	 * + "From Car c Inner Join c.brand b Inner Join c.color cl" +
	 * "Inner Join c.carImage ci Where c.carId=:carId ")
	 * 
	 * 
	 * DataResult<List<CarWithCarImageDetailDto>>getCarWithCarImageDetails();
	 */
}
