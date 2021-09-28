package com.etiya.reCapProject.business.concrates;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.reCapProject.business.abstracts.CreditCardService;
import com.etiya.reCapProject.business.abstracts.FindexNumberService;
import com.etiya.reCapProject.business.abstracts.RentAlService;
import com.etiya.reCapProject.business.constants.Messages;
import com.etiya.reCapProject.core.utilities.business.BusinessRules;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.ErrorResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.CarDao;
import com.etiya.reCapProject.dataAccess.abstracts.CareCarDao;
import com.etiya.reCapProject.dataAccess.abstracts.CorporateCustomerDao;
import com.etiya.reCapProject.dataAccess.abstracts.IndividualCustomerDao;
import com.etiya.reCapProject.dataAccess.abstracts.RentAlDao;
import com.etiya.reCapProject.entities.concrates.Car;
import com.etiya.reCapProject.entities.concrates.CareCar;
import com.etiya.reCapProject.entities.concrates.CorporateCustomer;
import com.etiya.reCapProject.entities.concrates.IndividualCustomer;
import com.etiya.reCapProject.entities.concrates.RentAl;
import com.etiya.reCapProject.entities.request.rentalRequest.AddRentalRequest;
import com.etiya.reCapProject.entities.request.rentalRequest.DeleteRentalRequest;
import com.etiya.reCapProject.entities.request.rentalRequest.UpdateRentalRequest;

@Service
public class RentAlManager implements RentAlService  {
	
	private RentAlDao rentAlDao;
	private CarDao carDao;
	private CorporateCustomerDao corporateCustomerDao;
	private IndividualCustomerDao individualCustomerDao;
	private FindexNumberService findexNumberService;
	private CareCarDao careCarDao;
	
	
	
	@Autowired
	public RentAlManager(RentAlDao rentAlDao, CarDao carDao,CorporateCustomerDao corporateCustomerDao,
			IndividualCustomerDao individualCustomerDao,
			CreditCardService creditCardService,
			CareCarDao careCarDao,
			FindexNumberService findexNumberService) {
		super();
		this.rentAlDao = rentAlDao;
		this.carDao=carDao;
		this.corporateCustomerDao=corporateCustomerDao;
		this.individualCustomerDao=individualCustomerDao;
		this.findexNumberService=findexNumberService;
		this.careCarDao=careCarDao;
	}

	@Override
	public DataResult<List<RentAl>> getAll() {
		List<RentAl> rentals= this.rentAlDao.findAll();
		return new SuccessDataResult<List<RentAl>>(rentals,Messages.LIST);
	}
	
	
	@Override
	public Result addRentalForIndividualCustomer(AddRentalRequest addRentalRequest) {
		Car car=this.carDao.getById(addRentalRequest.getCarId());
		
		//teslim ettikten sonraki teslim edilen il
		car.setCity(addRentalRequest.getReturnCity());
		this.carDao.save(car);

		
		IndividualCustomer individualCustomer= new IndividualCustomer();
		individualCustomer.setId(addRentalRequest.getCustomerId());
		
		RentAl rentAl=new RentAl();
		rentAl.setRentDate(addRentalRequest.getRentDate());
		rentAl.setReturnDate(addRentalRequest.getReturnDate());
		
		//kiralamadan önceki başlangıç şehiri.
		rentAl.setTakeCity(car.getCity());
		rentAl.setStartKilometer(addRentalRequest.getStartKilometer());
		rentAl.setReturnCity(addRentalRequest.getReturnCity());
		
		car.setKilometer(addRentalRequest.getStartKilometer()+car.getKilometer());
		
		rentAl.setCar(car);
		rentAl.setCustomers(individualCustomer);
		

		var result= BusinessRules.run(checkCarIsSubmit(rentAl.getCar().getCarId()),checkIndiviualCustomerFindexPoint(
				this.individualCustomerDao.getById(addRentalRequest.getCustomerId()),
				this.carDao.getById(addRentalRequest.getCarId())),checkIsCarCare(addRentalRequest.getCarId()),checkIsCarCare(addRentalRequest.getCarId()));

		if (result!=null) {
			return result;
		}
		
		this.rentAlDao.save(rentAl);
		return new SuccessResult(Messages.ADD);
		
	}

	@Override
	public Result updateRentalForIndividualCustomer(UpdateRentalRequest updateRentalRequest) {
		Car car=this.carDao.getById(updateRentalRequest.getCarId());
		car.setCity(updateRentalRequest.getReturnCity());
		this.carDao.save(car);
	
		
		IndividualCustomer individualCustomer= new IndividualCustomer();
		individualCustomer.setId(updateRentalRequest.getCustomerId());	
		
		var result = BusinessRules.run(checkIndiviualCustomerFindexPoint(
				this.individualCustomerDao.getById(updateRentalRequest.getCustomerId()),
				this.carDao.getById(updateRentalRequest.getCarId())),checkIsCarCare(updateRentalRequest.getCarId()));
		
		if (result != null) {
			return result;
		}
		
		RentAl rental = this.rentAlDao.getById(updateRentalRequest.getCustomerId());
		RentAl rentAl=new RentAl();
		rentAl.setRentDate(updateRentalRequest.getRentDate());
		rentAl.setReturnDate(updateRentalRequest.getReturnDate());
		rental.setStartKilometer(updateRentalRequest.getStartKilometer());
		rentAl.setTakeCity(car.getCity());
		car.setKilometer(updateRentalRequest.getStartKilometer()+car.getKilometer());

		
		rental.setCar(car);
		rental.setCustomers(individualCustomer);
		
		this.rentAlDao.save(rental);
		return new SuccessResult(Messages.UPDATE);
	}

	@Override
	public Result addRentalForCorporateCustomer(AddRentalRequest addRentalRequest) {
		Car car=this.carDao.getById(addRentalRequest.getCarId());
		//teslim ettikten sonraki teslim edilen il
		car.setCity(addRentalRequest.getReturnCity());	
		this.carDao.save(car);
		
		
		CorporateCustomer corporateCustomer=new CorporateCustomer();
		corporateCustomer.setId(addRentalRequest.getCustomerId());
		

		var result= BusinessRules.run(checkCarIsSubmit(addRentalRequest.getCarId()),checkCorporateCustomerFindexPoint(
				this.corporateCustomerDao.getById(addRentalRequest.getCustomerId()),
				this.carDao.getById(addRentalRequest.getCarId())),checkIsCarCare(addRentalRequest.getCarId()));

		if (result!=null) {
			return result;
		}
		
		RentAl rentAl=new RentAl();
		rentAl.setRentDate(addRentalRequest.getRentDate());
		rentAl.setReturnDate(addRentalRequest.getReturnDate());
		rentAl.setStartKilometer(addRentalRequest.getStartKilometer());
		
		//kiralamadan önceki başlangıç şehiri.
		rentAl.setTakeCity(car.getCity());
		rentAl.setReturnCity(addRentalRequest.getReturnCity());
		
		car.setKilometer(addRentalRequest.getStartKilometer()+car.getKilometer());

		rentAl.setCar(car);
		rentAl.setCustomers(corporateCustomer);
		

		
		this.rentAlDao.save(rentAl);
		return new SuccessResult(Messages.ADD);
		
		
	}

	@Override
	public Result updateRentalForCorporateCustomer(UpdateRentalRequest updateRentalRequest) {
		Car car=this.carDao.getById(updateRentalRequest.getCarId());
		//teslim ettikten sonraki teslim edilen il
		car.setCity(updateRentalRequest.getReturnCity());	
		this.carDao.save(car);

		
		CorporateCustomer corporateCustomer=new CorporateCustomer();
		corporateCustomer.setId(updateRentalRequest.getCustomerId());
		
		RentAl rentAl=new RentAl();
		rentAl.setRentAlId(updateRentalRequest.getRentAlId());
		rentAl.setRentDate(updateRentalRequest.getRentDate());
		rentAl.setReturnDate(updateRentalRequest.getReturnDate());
		rentAl.setTakeCity(updateRentalRequest.getTakeCity());
		rentAl.setStartKilometer(updateRentalRequest.getStartKilometer());
		car.setKilometer(updateRentalRequest.getStartKilometer()+car.getKilometer());


		
		//kiralamadan önceki başlangıç şehiri.
		rentAl.setTakeCity(car.getCity());
		
		rentAl.setCar(car);
		rentAl.setCustomers(corporateCustomer);
		
		var result= BusinessRules.run(checkCarIsSubmit(rentAl.getCar().getCarId()),checkCorporateCustomerFindexPoint(
				this.corporateCustomerDao.getById(updateRentalRequest.getCustomerId()),
				this.carDao.getById(updateRentalRequest.getCarId())),checkIsCarCare(updateRentalRequest.getCarId()));

		if (result!=null) {
			return result;
		}
		
		this.rentAlDao.save(rentAl);
		return new SuccessResult(Messages.UPDATE);
	}
	
	
	
	@Override
	public Result delete(DeleteRentalRequest deleteRentalRequest) {
		RentAl rentAl= this.rentAlDao.getById(deleteRentalRequest.getRentAlId());
		
		this.rentAlDao.save(rentAl);
		return new SuccessResult(Messages.DELETE);
	}
	
	
	
	
	public Result checkCarIsSubmit(int carId) {
		for (RentAl rental : this.rentAlDao.getByCar_CarId(carId)) {
			if(rental.getReturnDate() == null ) {
				return new ErrorResult(Messages.RENTERROR);
			}
		}
		return new SuccessResult();
	}
	
	private Result checkIndiviualCustomerFindexPoint(IndividualCustomer individualCustomer,Car car) {
		
		if (this.findexNumberService.checkIndividualCustomerFindexPoint(individualCustomer) <=
				car.getFindexPoint()) {
			return new ErrorResult(Messages.ERRORSCORE);
		}
		
		return new SuccessResult();
		
		
	}
	
	
	private Result checkCorporateCustomerFindexPoint(CorporateCustomer corporateCustomer,Car car) {
		
		if(this.findexNumberService.checkCorporateCustomerFindexPoint(corporateCustomer) <= car
				.getFindexPoint()) {
			return new ErrorResult(Messages.ERRORSCORE);
		}
		
		return new SuccessResult();
		
	}
	
	
	private Result checkIsCarCare(int carId) {
		if (this.careCarDao.getByCar_CarId(carId).size() != 0) {
			CareCar careCar= this.careCarDao.getByCar_CarId(carId)
					.get(this.careCarDao.getByCar_CarId(carId).size()-1);
			
			
			if (careCar.getFinishDate()==null) {
				return new ErrorResult(Messages.RENTERROR);
		}
		
		}
		return new SuccessResult();
	}


	
		}