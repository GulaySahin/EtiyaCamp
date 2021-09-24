package com.etiya.reCapProject.business.concrates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.etiya.reCapProject.business.abstracts.HeaterCarService;
import com.etiya.reCapProject.business.constants.Messages;
import com.etiya.reCapProject.core.utilities.business.BusinessRules;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.ErrorResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.CarDao;
import com.etiya.reCapProject.dataAccess.abstracts.HeaterCarDao;
import com.etiya.reCapProject.dataAccess.abstracts.RentAlDao;
import com.etiya.reCapProject.entities.concrates.HeaterCar;
import com.etiya.reCapProject.entities.concrates.IndividualCustomer;
import com.etiya.reCapProject.entities.concrates.RentAl;
import com.etiya.reCapProject.entities.request.heaterCarRequest.AddHeaterCarRequest;
import com.etiya.reCapProject.entities.request.heaterCarRequest.DeleteHeaterCarRequest;

public class HeaterCarManager implements HeaterCarService {
	
	HeaterCarDao heaterCarDao;
	RentAlDao rentAlDao;
	
    @Autowired
	public HeaterCarManager(HeaterCarDao heaterCarDao, RentAlDao rentAlDao) {
		super();
		this.heaterCarDao = heaterCarDao;
		this.rentAlDao = rentAlDao;
	}

	@Override
	public DataResult<List<HeaterCar>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(AddHeaterCarRequest addHeaterCarRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Override public Result add(AddHeaterCarRequest addHeaterCarRequest) {
	 * 
	 * var
	 * result=BusinessRules.run(checkCarİsRental(addHeaterCarRequest.getCarId()));
	 * if(result != null) { return result; }
	 * 
	 * HeaterCar heaterCar=new HeaterCar();
	 * heaterCar.setCareId(addHeaterCarRequest.getId());
	 * 
	 * this.heaterCarDao.save(heaterCar); return new SuccessResult(Messages.ADD); }
	 */
}
	/*
	 * @Override public Result delete(DeleteHeaterCarRequest deleteHeaterCarRequest)
	 * { HeaterCar heaterCar=new HeaterCar();
	 * 
	 * heaterCar.se
	 * 
	 * this.heaterCarDao.delete(heaterCar); return new
	 * SuccessResult(Messages.DELETE);
	 * 
	 * 
	 * }
	 */

	/*
	 * public Result checkCarİsRental(int carId) { for (RentAl rental :
	 * this.rentAlDao.getByCar_carId(carId)) {
	 * if(rental.getCar()==heaterCarDao.getById(carId)) { return new
	 * ErrorResult(Messages.DEFAULTMESSAGE); }
	 * 
	 * } return new SuccessResult(); } }
	 */









