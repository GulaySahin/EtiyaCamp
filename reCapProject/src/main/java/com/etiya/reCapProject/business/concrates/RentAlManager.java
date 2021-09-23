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
import com.etiya.reCapProject.dataAccess.abstracts.CorporateCustomerDao;
import com.etiya.reCapProject.dataAccess.abstracts.IndividualCustomerDao;
import com.etiya.reCapProject.dataAccess.abstracts.RentAlDao;
import com.etiya.reCapProject.entities.concrates.Car;
import com.etiya.reCapProject.entities.concrates.CorporateCustomer;
import com.etiya.reCapProject.entities.concrates.CreditCard;
import com.etiya.reCapProject.entities.concrates.IndividualCustomer;
import com.etiya.reCapProject.entities.concrates.RentAl;
import com.etiya.reCapProject.entities.request.creditCardRequest.AddCreditCardRequest;
import com.etiya.reCapProject.entities.request.rentalRequest.AddRentalRequest;
import com.etiya.reCapProject.entities.request.rentalRequest.UpdateRentalRequest;

@Service
public class RentAlManager implements RentAlService  {
	
	private RentAlDao rentAlDao;
	private CarDao carDao;
	private CorporateCustomerDao corporateCustomerDao;
	private IndividualCustomerDao individualCustomerDao;
	private FindexNumberService checkService;
	private CreditCardService creditCardService;
	
	
	@Autowired
	public RentAlManager(RentAlDao rentAlDao, CarDao carDao,CorporateCustomerDao corporateCustomerDao,
			IndividualCustomerDao individualCustomerDao,
			CreditCardService creditCardService,
			FindexNumberService checkService) {
		super();
		this.rentAlDao = rentAlDao;
		this.carDao=carDao;
		this.corporateCustomerDao=corporateCustomerDao;
		this.individualCustomerDao=individualCustomerDao;
		this.checkService=checkService;
		this.creditCardService=creditCardService;
	}

	@Override
	public DataResult<List<RentAl>> getAll() {
		List<RentAl> rentals= this.rentAlDao.findAll();
		return new SuccessDataResult<List<RentAl>>(rentals,Messages.LIST);
	}
	
	
	@Override
	public Result addRentalForIndividualCustomer(AddRentalRequest addRentalRequest) {
		Car car=new Car();
		car.setCarId(addRentalRequest.getCarId());
		
		IndividualCustomer individualCustomer= new IndividualCustomer();
		individualCustomer.setId(addRentalRequest.getCustomerId());
		
		RentAl rentAl=new RentAl();
		rentAl.setRentDate(addRentalRequest.getRentDate());
		rentAl.setReturnDate(addRentalRequest.getReturnDate());
		
		rentAl.setCar(car);
		rentAl.setCustomer(individualCustomer);
		

		var result= BusinessRules.run(checkCarIsSubmit(rentAl.getCar().getCarId()),checkIndiviualCustomerFindexPoint(
				this.individualCustomerDao.getById(addRentalRequest.getCustomerId()),
				this.carDao.getById(addRentalRequest.getCarId())));

		if (result!=null) {
			return result;
		}
		
		this.rentAlDao.save(rentAl);
		return new SuccessResult(Messages.ADD);
		
	}

	@Override
	public Result updateRentalForIndividualCustomer(UpdateRentalRequest updateRentalRequest) {
		Car car=new Car();
		car.setCarId(updateRentalRequest.getCarId());
		
		IndividualCustomer individualCustomer= new IndividualCustomer();
		individualCustomer.setId(updateRentalRequest.getCustomerId());	
		
		var result = BusinessRules.run(checkIndiviualCustomerFindexPoint(
				this.individualCustomerDao.getById(updateRentalRequest.getCustomerId()),
				this.carDao.getById(updateRentalRequest.getCarId())));
		
		if (result != null) {
			return result;
		}
		
		RentAl rental = this.rentAlDao.getById(updateRentalRequest.getCustomerId());
		RentAl rentAl=new RentAl();
		rentAl.setRentDate(updateRentalRequest.getRentDate());
		rentAl.setReturnDate(updateRentalRequest.getReturnDate());
		
		rental.setCar(car);
		rental.setCustomer(individualCustomer);
		
		this.rentAlDao.save(rental);
		return new SuccessResult(Messages.UPDATE);
	}

	@Override
	public Result addRentalForCorporateCustomer(AddRentalRequest addRentalRequest) {
		Car car=new Car();
		car.setCarId(addRentalRequest.getCarId());	
		
		CorporateCustomer corporateCustomer=new CorporateCustomer();
		corporateCustomer.setId(addRentalRequest.getCustomerId());
		
		RentAl rentAl=new RentAl();
		rentAl.setRentDate(addRentalRequest.getRentDate());
		rentAl.setReturnDate(addRentalRequest.getReturnDate());
		
		rentAl.setCar(car);
		rentAl.setCustomer(corporateCustomer);
		

		var result= BusinessRules.run(checkCarIsSubmit(rentAl.getCar().getCarId()),checkCorporateCustomerFindexPoint(
				this.corporateCustomerDao.getById(addRentalRequest.getCustomerId()),
				this.carDao.getById(addRentalRequest.getCarId())));

		if (result!=null) {
			return result;
		}
		
		this.rentAlDao.save(rentAl);
		return new SuccessResult(Messages.ADD);
		
		
	}

	@Override
	public Result updateRentalForCorporateCustomer(UpdateRentalRequest updateRentalRequest) {
		Car car=new Car();
		car.setCarId(updateRentalRequest.getCarId());
		
		CorporateCustomer corporateCustomer=new CorporateCustomer();
		corporateCustomer.setId(updateRentalRequest.getCustomerId());
		
		RentAl rentAl=new RentAl();
		rentAl.setRentDate(updateRentalRequest.getRentDate());
		rentAl.setReturnDate(updateRentalRequest.getReturnDate());
		
		rentAl.setCar(car);
		rentAl.setCustomer(corporateCustomer);
		
		var result= BusinessRules.run(checkCarIsSubmit(rentAl.getCar().getCarId()),checkCorporateCustomerFindexPoint(
				this.corporateCustomerDao.getById(updateRentalRequest.getCustomerId()),
				this.carDao.getById(updateRentalRequest.getCarId())));

		if (result!=null) {
			return result;
		}
		
		this.rentAlDao.save(rentAl);
		return new SuccessResult(Messages.UPDATE);
	}
	
	
	public Result checkCarIsSubmit(int carId) {
		for (RentAl rental : this.rentAlDao.getByCar_carId(carId)) {
			if(rental.getReturnDate() == null ) {
				return new ErrorResult(Messages.RENTERROR);
			}
		}
		return new SuccessResult();
	}
	
	private Result checkIndiviualCustomerFindexPoint(IndividualCustomer individualCustomer,Car car) {
		
		if (this.checkService.checkIndividualCustomerFindexPoint(individualCustomer)  <=  car.getFindexNumber()) {
				
			return new ErrorResult(Messages.ERRORSCORE);
		}
		
		return new SuccessResult();
		
		
	}
	
	
	private Result checkCorporateCustomerFindexPoint(CorporateCustomer corporateCustomer,Car car) {
		
		if(this.checkService.checkCorporateCustomerFindexPoint(corporateCustomer) <= car.getFindexNumber()) {
				
			return new ErrorResult(Messages.ERRORSCORE);
		}
		
		return new SuccessResult();
		
	}
	
	private DataResult<List<CreditCard>> checkSaveCreditCard(AddRentalRequest addRentalRequest
			,AddCreditCardRequest addCreditCardRequest){
		
		List<CreditCard> creditCards= creditCardService.getCreditCardByCustomer_CustomerId(addRentalRequest.getCustomerId()).getData();
		this.addRentalForCorporateCustomer(addRentalRequest);
		this.addRentalForIndividualCustomer(addRentalRequest);
		
		if (!creditCards.isEmpty()) {
			return new SuccessDataResult<List<CreditCard>>(creditCards);
		}else {
			this.saveCreditCard(addRentalRequest.isSaveCreditCard(), addCreditCardRequest);
			return new SuccessDataResult<List<CreditCard>>(Messages.ADD);
		}
	}
	
	public void saveCreditCard(boolean isSaveCreditCard, AddCreditCardRequest addCreditCardRequest) {
		if (isSaveCreditCard) {
			this.creditCardService.add(addCreditCardRequest);
		}
	}

	
	
	
}