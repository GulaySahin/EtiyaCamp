package com.etiya.reCapProject.business.concrates;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etiya.reCapProject.business.abstracts.CarService;
import com.etiya.reCapProject.business.constants.Messages;
import com.etiya.reCapProject.core.utilities.results.DataResult;

import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.CarDao;
import com.etiya.reCapProject.entities.concrates.Brand;
import com.etiya.reCapProject.entities.concrates.Car;
import com.etiya.reCapProject.entities.concrates.Color;
import com.etiya.reCapProject.entities.dtos.CarDetailDto;
import com.etiya.reCapProject.entities.request.carRequest.AddCarRequest;
import com.etiya.reCapProject.entities.request.carRequest.DeleteCarRequest;
import com.etiya.reCapProject.entities.request.carRequest.UpdateCarRequest;

@Service
public class CarManager implements CarService{

	
	private CarDao carDao;
	
	@Autowired
	public CarManager(CarDao carDao) {
		super();
		this.carDao = carDao;
	}
	

	@Override
	public DataResult<List<CarDetailDto>> getCarWithDetails() {
		return new SuccessDataResult<List<CarDetailDto>>(this.carDao.getCarWithDetails()+ Messages.LIST);
	}

	



	@Override
	public DataResult<List<Car>> getAll() {
		return new SuccessDataResult<List<Car>>(this.carDao.findAll());
				
		
	}

	@Override
	public DataResult<Car> getById(int carId) {
		return new SuccessDataResult<Car>(this.carDao.getById(carId),Messages.LIST);
		
		
	}
	

	@Override
	public DataResult<List<Car>> getByCarCity(String city) {
		List<Car> cars=this.carDao.getByCity(city);
		return new SuccessDataResult<List<Car>>(cars, Messages.LIST);
	}
	
	
	
	@Override
	public DataResult<List<Car>> getByBrand_brandId(int brandId) {
		List<Car> cars= this.carDao.getByBrand_brandId(brandId);
		return new SuccessDataResult<List<Car>>(cars, Messages.LIST);
	}


	@Override
	public DataResult<List<Car>> getByColor_colorId(int colorId) {
		List<Car> cars= this.carDao.getByColor_colorId(colorId);
		return new SuccessDataResult<List<Car>>(cars, Messages.LIST);
	}

	@Override
	public Result add(AddCarRequest addCarRequest) {
		
		Brand brand = new Brand();
		brand.setBrandId(addCarRequest.getBrandId());
		
		Color color= new Color();
		color.setColorId(addCarRequest.getColorId());
		
		Car car= new Car();
		car.setCarName(addCarRequest.getCarName());
		car.setCarCare(addCarRequest.isCarCare());
		car.setModelYear(addCarRequest.getModelYear());
		car.setDailyPrice(addCarRequest.getDailyPrice());
		car.setDescription(addCarRequest.getDescription());
		car.setFindexPoint(addCarRequest.getFindexPoint());
		car.setCity(addCarRequest.getCity());
		

		car.setBrand(brand);
		car.setColor(color);
		
		this.carDao.save(car);
		return new SuccessResult(Messages.ADD);
	}

	@Override
	public Result update(UpdateCarRequest updateCarRequest) {
		
		Brand brand = new Brand();
		brand.setBrandId(updateCarRequest.getBrandId());
		
		Color color= new Color();
		color.setColorId(updateCarRequest.getColorId());
		
		Car car= this.carDao.getById(updateCarRequest.getCarId());
		car.setCarId(updateCarRequest.getCarId());
		car.setCarName(updateCarRequest.getCarName());
		car.setCarCare(updateCarRequest.isCarCare());
		car.setModelYear(updateCarRequest.getModelYear());
		car.setDailyPrice(updateCarRequest.getDailyPrice());
		car.setDescription(updateCarRequest.getDescription());
		car.setFindexPoint(updateCarRequest.getFindexPoint());
		car.setCity(updateCarRequest.getCity());


		

		car.setBrand(brand);
		car.setColor(color);
		
		this.carDao.save(car);
		return new SuccessResult(Messages.UPDATE);

		
	}

	@Override
	public Result delete(DeleteCarRequest deleteCarRequest) {
		
		Brand brand = new Brand();
		brand.setBrandId(deleteCarRequest.getBrandId());
		
		Color color= new Color();
		color.setColorId(deleteCarRequest.getColorId());
		

		Car car= new Car();
		car.setCarId(deleteCarRequest.getCarId());

		car.setBrand(brand);
		car.setColor(color);
		
		this.carDao.delete(car);
		return new SuccessResult(Messages.DELETE);

		
	}


	@Override
	public DataResult<List<Car>> IsCarCareIsTrue() {
		return new SuccessDataResult<List<Car>>(this.carDao.IsCarCareIsTrue());
	}


	@Override
	public DataResult<List<Car>> IsCarCareIsFalse() {
		return new SuccessDataResult<List<Car>>(this.carDao.IsCarCareIsFalse());
	}

}
