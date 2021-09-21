package com.etiya.reCapProject.business.concrates;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.etiya.reCapProject.business.abstracts.CarImageService;
import com.etiya.reCapProject.business.constants.Messages;
import com.etiya.reCapProject.core.utilities.business.BusinessRules;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.ErrorDataResult;
import com.etiya.reCapProject.core.utilities.results.ErrorResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.CarImageDao;
import com.etiya.reCapProject.entities.concrates.Car;
import com.etiya.reCapProject.entities.concrates.CarImage;
import com.etiya.reCapProject.entities.request.AddCarImageRequest;
import com.etiya.reCapProject.entities.request.DeleteCarImageRequest;
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
		return new SuccessDataResult<>(carsImage,Messages.LIST);
	
	}

	@Override
     public Result add(AddCarImageRequest addCarImageRequest, MultipartFile file) throws IOException {
		
		var result= BusinessRules.run(checkImageIsNull(file),checkIfCarImageAddController(addCarImageRequest.getCarId(), 5));
		if (result!=null) {
			return result;
		}
		
		Date dateNow= new java.sql.Date(new java.util.Date().getTime());
		String randomImageName=UUID.randomUUID().toString();
		
		File myFiles= new File("C:\\Users\\gulay.sahin\\Desktop\\car_image"+randomImageName+".");
		myFiles.createNewFile();
		FileOutputStream fls=new FileOutputStream(myFiles);
		//byte olarak yazıyor içini yazıyor.
		fls.write(file.getBytes());
		fls.close();
		
		Car car = new Car();
		car.setCarId(addCarImageRequest.getCarId());
		
		CarImage carImage = new CarImage();
		carImage.setImagePath(myFiles.toString());
		carImage.setDate(dateNow);
		carImage.setCar(car);
		
		this.carImageDao.save(carImage);
		return new SuccessResult( Messages.ADD);
	}
	

	@Override
	public Result update(UpdateCarImageRequest updateCarImagesRequest, MultipartFile file) throws IOException {
		
			var result= BusinessRules.run(checkImageIsNull(file),checkIfCarImageAddController(updateCarImagesRequest.getCarId(), 5));
			if (result!=null) {
				return result;
			}
			
			Date dateNow= new java.sql.Date(new java.util.Date().getTime());
			String randomImageName=UUID.randomUUID().toString();
			
			File myFiles= new File("C:\\Users\\gulay.sahin\\Desktop\\car_image"+randomImageName+".");
			myFiles.createNewFile();
			FileOutputStream fls=new FileOutputStream(myFiles);
			//byte olarak yazıyor içini yazıyor.
			fls.write(file.getBytes());
			fls.close();
			
			Car car = new Car();
			car.setCarId(updateCarImagesRequest.getCarId());
			
			CarImage carImage = new CarImage();
			carImage.setId(updateCarImagesRequest.getId());
			
			carImage.setCar(car);
			
			this.carImageDao.save(carImage);
			return new SuccessResult(Messages.UPDATE);
		}
	
	@Override
	public Result delete(DeleteCarImageRequest deleteCarImageRequest) {
		Car car = new Car();
		car.setCarId(deleteCarImageRequest.getCarId());
		
		CarImage carImage = new CarImage();
		carImage.setId(deleteCarImageRequest.getId());
		
		carImage.setCar(car);

		
		this.carImageDao.delete(carImage);
		return new SuccessResult(Messages.DELETE);
	}


	
	private Result checkIfCarImageAddController(int carId,int limit) {
		
		if(this.carImageDao.countByCar_carId(carId)>limit) {
			return new ErrorResult(Messages.IMAGEERROR);
		}
		return new SuccessResult();
	}
	
	private Result checkImageIsNull(MultipartFile file) {
		if (file == null) {
			return new ErrorResult(Messages.IMAGENULLERROR);
		}
		return new SuccessResult();
	}



	@Override
	public DataResult<List<CarImage>> getCarImageByCarId(int carId) {
		return new SuccessDataResult<List<CarImage>>(returnCarImageWithDefaultImageIfCarImageIsNull(carId).getData(),
				Messages.LIST);
	}
	
	
	private DataResult<List<CarImage>> returnCarImageWithDefaultImageIfCarImageIsNull(int carId) {

		if (this.carImageDao.existsByCar_CarId(carId)) {
			return new ErrorDataResult<List<CarImage>>(this.carImageDao.getByCar_carId(carId));
		}

		List<CarImage> carImages = new ArrayList<CarImage>();
		CarImage carImage = new CarImage();
		carImage.setImagePath("C:\\\\Users\\\\gulay.sahin\\\\Desktop\\\\car_image");

		carImages.add(carImage);

		return new SuccessDataResult<List<CarImage>>(carImages, Messages.DEFAULTMESSAGE);

	}


}
