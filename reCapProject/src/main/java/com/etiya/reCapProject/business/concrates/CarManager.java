package com.etiya.reCapProject.business.concrates;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etiya.reCapProject.business.abstracts.CarService;
import com.etiya.reCapProject.business.constants.Messages;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.ErrorDataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.CarDao;
import com.etiya.reCapProject.entities.concrates.Brand;
import com.etiya.reCapProject.entities.concrates.Car;
import com.etiya.reCapProject.entities.concrates.CarImage;
import com.etiya.reCapProject.entities.concrates.Color;
import com.etiya.reCapProject.entities.dtos.CarDetailDto;
import com.etiya.reCapProject.entities.dtos.CarWithCarImageDetailDto;
import com.etiya.reCapProject.entities.request.AddCarRequest;
import com.etiya.reCapProject.entities.request.UpdateCarRequest;

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
		return new SuccessDataResult<List<Car>>(
				returnCarsWithDefaultImageWhereCarImageIsNull(this.carDao.findAll()).getData()+ Messages.List);
				
		
	}

	@Override
	public DataResult<Car> getById(int carId) {
		
		if (this.returnCarWithDefaultImageIfCarImageIsNull(carId).isSuccess()) {
			return new SuccessDataResult<Car>(this.returnCarWithDefaultImageIfCarImageIsNull(carId).getData(),
					Messages.List);
		}

		return new SuccessDataResult<Car>(this.carDao.getById(carId) + Messages.List);
		
	}

	@Override
	public Result add(AddCarRequest addCarRequest) {
		Brand brand=new Brand();
		brand.setBrandId(addCarRequest.getBrandId());
		
		Color color=new Color();
		color.setColorId(addCarRequest.getColorId());
		
		
		Car car=new Car();
		car.setCarName(addCarRequest.getCarName());	
		car.setModelYear(addCarRequest.getModelYear());
	    car.setDailyPrice(addCarRequest.getDailyPrice());
		car.setDescription(addCarRequest.getDescription());
		
		car.setBrand(brand);
		car.setColor(color);
		
		
		
		this.carDao.save(car);
	  return new SuccessResult(Messages.Add);
	}

	@Override
	public Result update(UpdateCarRequest updateCarRequest) {
		Brand brand=new Brand();
		brand.setBrandId(updateCarRequest.getBrandId());
		
		Color color=new Color();
		color.setColorId(updateCarRequest.getColorId());
		
		
		
		Car car=new Car();
		car.setCarName(updateCarRequest.getCarName());	
		car.setModelYear(updateCarRequest.getModelYear());
	    car.setDailyPrice(updateCarRequest.getDailyPrice());
		car.setDescription(updateCarRequest.getDescription());
		
		car.setBrand(brand);
		car.setColor(color);
		
	    this.carDao.save(car);
		return new SuccessResult("araba güncellendi");
	}

	@Override
	public Result delete(int carId) {
		
		this.carDao.deleteById(carId);
		return new SuccessResult(Messages.Delete);
	}

	@Override
	public DataResult<List<CarDetailDto>> getCarWithBrandAndColorDetails() {
		
		List<CarDetailDto>cars=this.carDao.getCarWithBrandAndColorDetails();
		return new SuccessDataResult<>(cars,Messages.DetailList);
		
		
	}
	
	private DataResult<Car> returnCarWithDefaultImageIfCarImageIsNull(int carId) {

        if (!this.carDao.existsByCarImageIsNullAndCarId(carId)) {
            return new ErrorDataResult<Car>();
        }

        CarImage carImage = new CarImage();
        carImage.setImagePath("carImages/default.jpg");

        List<CarImage> carImages = new ArrayList<CarImage>();
        carImages.add(carImage);

        Car car = this.carDao.getById(carId);
        car.setCarImage(carImages);

        return new SuccessDataResult<Car>(car, "Resimi olmayan Araba Default resim ile listelendi");

    }

    private DataResult<List<Car>> returnCarsWithDefaultImageWhereCarImageIsNull(List<Car> cars) {

        CarImage carImage = new CarImage();
        carImage.setImagePath("carImages/default.jpg");

        List<CarImage> carImages = new ArrayList<CarImage>();
        carImages.add(carImage);

        if (this.carDao.existsByCarImageIsNull()) {
            for (Car car : cars) {
                if (this.carDao.existsByCarImageIsNullAndCarId(car.getCarId())) {
                    car.setCarImage(carImages);
                }
            }
        }

        return new SuccessDataResult<List<Car>>(cars, "Resimleri olmayan arabalar Default resim ile listelendi");

    }


	@Override
	public DataResult<List<Car>> getByBrand_brandId(int brandId) {
		List<Car>cars=this.carDao.getByBrand_brandId(brandId);
		return new SuccessDataResult<>(cars,Messages.List);
		
	}

	@Override
	public DataResult<List<Car>> getByColor_colorId(int colorId) {
		List<Car>cars=this.carDao.getByColor_colorId(colorId);
		return new SuccessDataResult<>(cars,Messages.List);
	}

	@Override
	public DataResult<List<CarWithCarImageDetailDto>> getCarWithCarImageDetails(int carId) {
		List<CarWithCarImageDetailDto>cars=this.carDao.getCarWithCarImageDetails(carId);
		return new SuccessDataResult<>(cars,Messages.List);
	}
}
