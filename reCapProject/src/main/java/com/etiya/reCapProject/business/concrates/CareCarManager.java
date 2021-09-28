package com.etiya.reCapProject.business.concrates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etiya.reCapProject.business.abstracts.CareCarService;
import com.etiya.reCapProject.business.constants.Messages;
import com.etiya.reCapProject.core.utilities.business.BusinessRules;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.ErrorResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.CarDao;
import com.etiya.reCapProject.dataAccess.abstracts.CareCarDao;
import com.etiya.reCapProject.dataAccess.abstracts.RentAlDao;
import com.etiya.reCapProject.entities.concrates.Car;
import com.etiya.reCapProject.entities.concrates.CareCar;
import com.etiya.reCapProject.entities.request.careCarRequest.AddCareCarRequest;
import com.etiya.reCapProject.entities.request.careCarRequest.DeleteCareCarRequest;
import com.etiya.reCapProject.entities.request.careCarRequest.UpdateCareCarRequest;

@Service
public class CareCarManager implements CareCarService {
	
	CareCarDao careCarDao;
	RentAlDao rentAlDao;
	CarDao carDao;
	
	
    @Autowired
	public CareCarManager(CareCarDao careCarDao, RentAlDao rentAlDao,CarDao carDao ) {
		super();
		this.careCarDao = careCarDao;
		this.rentAlDao = rentAlDao;
		this.carDao=carDao;
		
	}

	@Override
	public Result add(AddCareCarRequest addCareCarRequest) {
		

		var result=BusinessRules.run(checkCarIsRental(addCareCarRequest.getCarId()));
		
		if(result != null)
		return result;
		
        Car car = this.carDao.getById(addCareCarRequest.getCarId());

        CareCar careCar= new CareCar();
        careCar.setCareCarId(addCareCarRequest.getCareCarid() );
        careCar.setLocation(addCareCarRequest.getLocation());
        careCar.setStartDate(addCareCarRequest.getStartDate());
        careCar.setFinishDate(addCareCarRequest.getFinishDate());

        careCar.setCar(car);
        
        this.carDao.save(car);
        this.careCarDao.save(careCar);
       
        return new SuccessResult(Messages.ADD);
      
	}
	@Override
	public Result delete(DeleteCareCarRequest deleteCareCarRequest) {
		Car car = new Car();
		car.setCarId(deleteCareCarRequest.getCarId());
		
		CareCar careCar=new CareCar();
		careCar.setCareCarId(deleteCareCarRequest.getCareCarId());
		
		careCar.setCar(car);
		this.careCarDao.delete(careCar);
		return new SuccessResult( Messages.DELETE);
	}

	@Override
	public Result update(UpdateCareCarRequest updateCareCarRequest) {
		
		CareCar careCar=this.careCarDao.getById(updateCareCarRequest.getCareCarId());
		
		
		careCar.setLocation(updateCareCarRequest.getLocation());
		careCar.setStartDate(updateCareCarRequest.getStartDate());
		careCar.setFinishDate(updateCareCarRequest.getFinishDate());
		
		
		
		Car car = new Car();
		car.setCarId(updateCareCarRequest.getCarId());
		
		careCar.setCar(car);
		this.careCarDao.save(careCar);
		return new SuccessResult( Messages.UPDATE);
	}
		

	@Override
	public DataResult<List<CareCar>> getAll() {
		List<CareCar>careCar=this.careCarDao.findAll();
		
		return new SuccessDataResult<>(careCar,Messages.LIST);
	}

	private Result checkCarIsRental(int carId) {
		if(!this.rentAlDao.getByCar_CarId(carId).isEmpty()) {
			return new ErrorResult(Messages.RENTERROR);
		}
	return new SuccessResult();
}

}







