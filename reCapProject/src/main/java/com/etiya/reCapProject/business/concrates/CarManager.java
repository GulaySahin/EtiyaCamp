package com.etiya.reCapProject.business.concrates;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etiya.reCapProject.business.abstracts.CarService;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.CarDao;
import com.etiya.reCapProject.entities.concrates.Car;
import com.etiya.reCapProject.entities.dtos.CarDetailDto;

@Service
public class CarManager implements CarService{

	private CarDao carDao;
	
	@Autowired
	public CarManager(CarDao carDao) {
		super();
		this.carDao = carDao;
	}

	@Override
	public DataResult<List<Car>> getAll() {
		List<Car>cars=this.carDao.findAll();
		return new SuccessDataResult<>(cars,"arabalar listelendi");
	}

	@Override
	public DataResult<List<Car>> getById(int id) {
	
		List<Car>cars=this.carDao.getById(id);
		return new SuccessDataResult<>(cars,"arabalar id'ye göre listelendi");
	}

	@Override
	public Result add(Car car) {
		
	this.carDao.save(car);
	return new SuccessResult(car.getCarName()+" isimli araba başarıyla eklendi");
	}

	@Override
	public Result update(Car car) {
	    this.carDao.save(car);
		return new SuccessResult("araba güncellendi");
	}

	@Override
	public Result delete(Car car) {
		this.carDao.delete(car);
		return new SuccessResult(car.getCarName()+ " isimli araba silindi");
	}

	@Override
	public DataResult<List<CarDetailDto>> getCarWithBrandAndColorDetails() {
		
		List<CarDetailDto>cars=this.carDao.getCarWithBrandAndColorDetails();
		return new SuccessDataResult<>(cars,"arabalar listelendi");
		
		
	}
	


}
