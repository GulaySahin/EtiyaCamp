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
import com.etiya.reCapProject.business.paths.Paths;
import com.etiya.reCapProject.core.utilities.business.BusinessRules;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.ErrorDataResult;
import com.etiya.reCapProject.core.utilities.results.ErrorResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.CarDao;
import com.etiya.reCapProject.dataAccess.abstracts.CarImageDao;
import com.etiya.reCapProject.entities.concrates.Car;
import com.etiya.reCapProject.entities.concrates.CarImage;
import com.etiya.reCapProject.entities.request.carImageRequest.AddCarImageRequest;
import com.etiya.reCapProject.entities.request.carImageRequest.DeleteCarImageRequest;
import com.etiya.reCapProject.entities.request.carImageRequest.UpdateCarImageRequest;



@Service
public class CarImageManager implements CarImageService{
	
	private CarImageDao carImageDao;
	private CarDao carDao;
	
	@Autowired
	public CarImageManager(CarImageDao carImageDao,CarDao carDao) {
		super();
		this.carImageDao = carImageDao;
		this.carDao=carDao;
	}
	
	
	
	@Override
	public DataResult<List<CarImage>> getAll() {
		return new SuccessDataResult<List<CarImage>>(this.carImageDao.findAll(),Messages.LIST);
	}

	

	@Override
	public Result add(AddCarImageRequest addCarImageRequest) throws IOException {
		
		var result= BusinessRules.run(checkImageIsNull(addCarImageRequest.getFile()),checkIfCarImagesAddController(addCarImageRequest.getCarId(), 5),checkImageType(addCarImageRequest.getFile()));
		if (result!=null) {
			return result;
		}
		
		Date dateNow= new java.sql.Date(new java.util.Date().getTime());
		String randomImageName=UUID.randomUUID().toString();
		
		File myFiles= new File(Paths.CAR_IMAGE_PATH+randomImageName+"."+addCarImageRequest.getFile().getContentType().substring(addCarImageRequest.getFile().getContentType().indexOf("/")+1));
		myFiles.createNewFile();
		FileOutputStream fileoutputstream=new FileOutputStream(myFiles);
		fileoutputstream.write(addCarImageRequest.getFile().getBytes());
		fileoutputstream.close();
		
		Car car = this.carDao.getById(addCarImageRequest.getCarId());
	
		
		CarImage carImage = new CarImage();
		carImage.setImagePath(myFiles.toString());
		carImage.setDate(dateNow);
		carImage.setCar(car);
		
		this.carImageDao.save(carImage);
		return new SuccessResult( Messages.ADD);
	}

	@Override
	public Result update(UpdateCarImageRequest updateCarImageRequest) throws IOException{
		var result= BusinessRules.run(checkImageIsNull(updateCarImageRequest.getFile()),checkIfCarImagesAddController(updateCarImageRequest.getCarId(), 5),checkImageType(updateCarImageRequest.getFile()));
		if (result!=null) {
			return result;
		}
		
		@SuppressWarnings("unused")
		Date dateNow= new java.sql.Date(new java.util.Date().getTime());
		String randomImageName=UUID.randomUUID().toString();
		
		File myFiles= new File(Paths.CAR_IMAGE_PATH+randomImageName+"."+updateCarImageRequest.getFile().getContentType().substring(updateCarImageRequest.getFile().getContentType().indexOf("/")+1));
		myFiles.createNewFile();
		FileOutputStream fileoutputstream=new FileOutputStream(myFiles);
		fileoutputstream.write(updateCarImageRequest.getFile().getBytes());
		fileoutputstream.close();
		
		Car car = new Car();
		
		CarImage carImages = new CarImage();
		carImages.setId(updateCarImageRequest.getId());
		
		carImages.setCar(car);
		
		this.carImageDao.save(carImages);
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
	
	
	private Result checkIfCarImagesAddController(int carId, int limit) {
		
		if (this.carImageDao.countByCar_carId(carId) >limit) {
			return new ErrorResult(Messages.IMAGEERROR);
		}
		
		return new SuccessResult();
	}
	

	
	private Result checkImageIsNull(MultipartFile file) {
		if (file == null) {
			return new ErrorResult(Messages.IMAGEERROR);
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

		List<CarImage> carImage = new ArrayList<CarImage>();
		CarImage carImages = new CarImage();
		carImages.setImagePath(Paths.CAR_IMAGE_DEFAULT_PATH);

		carImage.add(carImages);

		return new SuccessDataResult<List<CarImage>>(carImage, Messages.DEFAULTMESSAGE);

	}
	
	private Result checkImageType(MultipartFile file) {
		if(checkImageIsNull(file).isSuccess()) {
			if(!file.getContentType().substring(file.getContentType().indexOf("/")+1).equals("jpeg")
					&& !file.getContentType().toString().substring(file.getContentType().indexOf("/") + 1).equals("jpg")
					&& !file.getContentType().toString().substring(file.getContentType().indexOf("/") + 1).equals("png")) {
				System.out.println(file.getContentType());
				return new ErrorResult(Messages.IMAGEERROR);
				}
		
	}
		return new SuccessResult();

	}
}

