package com.etiya.reCapProject.business.concrates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.reCapProject.business.abstracts.CarDamageService;
import com.etiya.reCapProject.business.constants.Messages;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.CarDamageDao;
import com.etiya.reCapProject.dataAccess.abstracts.CarDao;
import com.etiya.reCapProject.entities.concrates.Car;
import com.etiya.reCapProject.entities.concrates.CarDamage;
import com.etiya.reCapProject.entities.request.carDamageRequest.AddCarDamageRequest;
import com.etiya.reCapProject.entities.request.carDamageRequest.DeleteCarDamageRequest;
import com.etiya.reCapProject.entities.request.carDamageRequest.UpdateCarDamageRequest;

@Service
public class CarDamageManager implements CarDamageService {
	
	CarDamageDao carDamageDao;
	CarDao carDao;
	
   @Autowired
	public CarDamageManager(CarDamageDao carDamageDao, CarDao carDao) {
		super();
		this.carDamageDao = carDamageDao;
		this.carDao = carDao;
	}

	@Override
	public DataResult<List<CarDamage>> getAll() {
		List<CarDamage>carDamage=this.carDamageDao.findAll();
		
		return new SuccessDataResult<>(carDamage,Messages.LIST);

	}

	@Override
	public Result add(AddCarDamageRequest addCarDamageRequest) {
		
		CarDamage carDamage=new CarDamage();
		carDamage.setDamageId(addCarDamageRequest.getDamageId());
		carDamage.setDamageInfo(addCarDamageRequest.getDamageInfo());
		
		Car car=new Car();
		car.setCarId(addCarDamageRequest.getCarId());
		
		carDamage.setCar(car);
		
		this.carDamageDao.save(carDamage);
		return new SuccessResult(Messages.ADD);
	}

	@Override
	public Result update(UpdateCarDamageRequest updateCarDamageRequest) {
		Car car = new Car();
        car.setCarId(updateCarDamageRequest.getCarId());


        CarDamage carDamage = this.carDamageDao.getById(updateCarDamageRequest.getDamageId());
        carDamage.setDamageId(updateCarDamageRequest.getDamageId());
        carDamage.setDamageInfo(updateCarDamageRequest.getDamageInfo());

        carDamage.setCar(car);

        this.carDamageDao.save(carDamage);
        return new SuccessResult(Messages.UPDATE);
	}

	@Override
	public Result delete(DeleteCarDamageRequest deleteCarDamageRequest) {
		Car car = new Car();
        car.setCarId(deleteCarDamageRequest.getCarId());

        CarDamage carDamage = this.carDamageDao.getById(deleteCarDamageRequest.getDamageId());
        carDamage.setDamageId(deleteCarDamageRequest.getDamageId());

        this.carDamageDao.delete(carDamage);
        return new SuccessResult(Messages.DELETE);
	}

}
