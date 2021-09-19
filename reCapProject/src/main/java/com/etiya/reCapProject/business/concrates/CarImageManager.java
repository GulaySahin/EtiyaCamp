package com.etiya.reCapProject.business.concrates;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.reCapProject.business.abstracts.CarImageService;
import com.etiya.reCapProject.business.constants.Messages;
import com.etiya.reCapProject.core.utilities.business.BusinessRules;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.ErrorResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.CarImageDao;
import com.etiya.reCapProject.entities.concrates.Car;
import com.etiya.reCapProject.entities.concrates.CarImage;
import com.etiya.reCapProject.entities.request.AddCarImageRequest;
import com.etiya.reCapProject.entities.request.UpdateCarImageRequest;
@Service
public class CarImageManager  implements CarImageService {
	
	private CarImageDao carImageDao;
    @Autowired
	public CarImageManager(CarImageDao carImageDao) {
		super();
		this.carImageDao = carImageDao;
	}

	@Override
	public DataResult<List<CarImage>> getAll() {
		List<CarImage>carsImage=this.carImageDao.findAll();
		return new SuccessDataResult<>(carsImage,Messages.List);
	
	}

	@Override
	public DataResult<CarImage> getById(int id) {
		return new SuccessDataResult<CarImage>(this.carImageDao.getById(id),Messages.List);
	}

	@Override
	public DataResult<List<CarImage>> getByCar_carId(int carId) {
		List<CarImage>carsImage=this.carImageDao.getByCar_carId(carId);
		return new SuccessDataResult<>(carsImage,Messages.List);
	}

	@Override
	public Result add(AddCarImageRequest addCarImageRequest) {
		var result=BusinessRules.run(checkIfCarImageAddController(addCarImageRequest.getCarId(), 5));
		if(result!=null) {
			return result;
		}
        String randomImageName=UUID.randomUUID().toString();
		
		Car car = new Car();
		car.setCarId(addCarImageRequest.getCarId());
		
		CarImage carImage = new CarImage();
		carImage.setImagePath("carImages/"+randomImageName+"jpg");
		carImage.setDate(addCarImageRequest.getDate());
		
		carImage.setCar(car);
		
		this.carImageDao.save(carImage);
		return new SuccessResult( Messages.Add); 
	}

	@Override
	public Result delete(int Id) {
		
		this.carImageDao.deleteById(Id);
		return new SuccessResult(Messages.Delete);
	}

	@Override
	public Result update(UpdateCarImageRequest updateCarImageRequest) {
	
		Car car=new Car();
		car.setCarId(updateCarImageRequest.getCarId());
		
		CarImage carImage=new CarImage();
		carImage.setImagePath(updateCarImageRequest.getImagePath());
		carImage.setDate(updateCarImageRequest.getDate());
		
		carImage.setCar(car);
		
		this.carImageDao.save(carImage);
		return new SuccessResult(Messages.Update);
		
	}
	
	private Result checkIfCarImageAddController(int carId,int limit) {
		
		if(this.carImageDao.countByCar_carId(carId)>limit) {
			return new ErrorResult(Messages.ImageError);
		}
		return new SuccessResult();
	}

}
