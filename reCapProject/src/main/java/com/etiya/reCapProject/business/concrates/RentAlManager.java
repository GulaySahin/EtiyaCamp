package com.etiya.reCapProject.business.concrates;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etiya.reCapProject.business.abstracts.RentAlService;
import com.etiya.reCapProject.business.constants.Messages;
import com.etiya.reCapProject.core.utilities.business.BusinessRules;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.ErrorResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.RentAlDao;
import com.etiya.reCapProject.entities.abstracts.Customer;
import com.etiya.reCapProject.entities.concrates.Car;
import com.etiya.reCapProject.entities.concrates.RentAl;
import com.etiya.reCapProject.entities.request.AddRentalRequest;
import com.etiya.reCapProject.entities.request.DeleteRentalRequest;
import com.etiya.reCapProject.entities.request.UpdateRentalRequest;

@Service
public class RentAlManager implements RentAlService  {
	
	private RentAlDao rentAlDao;
	
    @Autowired
	public RentAlManager(RentAlDao rentAlDao) {
		super();
		this.rentAlDao = rentAlDao;
	}

	@Override
	public DataResult<List<RentAl>> getAll() {
		List<RentAl>rental=this.rentAlDao.findAll();
		return new SuccessDataResult<>(rental,Messages.LIST);
	}

	@Override
	public DataResult<RentAl> getById(int carId) {
		RentAl rental=this.rentAlDao.getById(carId);
		return new SuccessDataResult<RentAl>(rental,Messages.IDLIST);
		
	}

	@Override
	public Result add(AddRentalRequest addRentalRequest) {
		RentAl rental=new RentAl();
		rental.setRentDate(addRentalRequest.getRentDate());
		rental.setReturnDate(addRentalRequest.getReturnDate());
		
		Car car=new Car();
		car.setCarId(addRentalRequest.getCarId());
		
	
		
		Customer customer=new Customer();
		customer.setCustomerId(addRentalRequest.getCustomerId());
		 rental.setCustomer(customer);
		 rental.setCar(car);
	
	 var result=BusinessRules.run(checkCarIsSubmit(rental.getCar().getCarId()));
	if(result!=null) {
		return result;
	}
	this.rentAlDao.save(rental);
	
	return new SuccessResult(Messages.ADD);
		
	}

	@Override
	public Result update(UpdateRentalRequest updateRentalRequest) {
		RentAl rental=new RentAl();
		rental.setRentDate(updateRentalRequest.getRentDate());
		rental.setReturnDate(updateRentalRequest.getReturnDate());
		
		
		Customer customer=new Customer();
		customer.setCustomerId(updateRentalRequest.getCustomerId());
		
		Car car=new Car();
		car.setCarId(updateRentalRequest.getCarId());
		
		 rental.setCustomer(customer);
		 rental.setCar(car);
		
		this.rentAlDao.save(rental);
		return new SuccessResult(Messages.UPDATE);
	}

	@Override
	public Result delete(DeleteRentalRequest deleteRentalRequest) {
		RentAl rental=new RentAl();
		rental.setRentalId(deleteRentalRequest.getRentalId());
		
	
		this.rentAlDao.delete(rental);
		return new SuccessResult(Messages.DELETE);
	}
    
    public Result checkCarIsSubmit(int carId) {
    	for (RentAl rental : this.rentAlDao.getByCar_carId(carId)) {
            if(rental.getReturnDate() == null ) {
                
                return new ErrorResult(Messages.RENTERROR);
            }
        }
        return new SuccessResult();
    }
}
