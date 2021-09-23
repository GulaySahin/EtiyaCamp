package com.etiya.reCapProject.business.concrates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.reCapProject.business.abstracts.CreditCardService;
import com.etiya.reCapProject.business.constants.Messages;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.CreditCardDao;
import com.etiya.reCapProject.entities.concrates.CreditCard;
import com.etiya.reCapProject.entities.concrates.Customer;
import com.etiya.reCapProject.entities.request.creditCardRequest.AddCreditCardRequest;
import com.etiya.reCapProject.entities.request.creditCardRequest.DeleteCreditCardRequest;
import com.etiya.reCapProject.entities.request.creditCardRequest.UpdateCreditCardRequest;

@Service
public class CreditCardManager implements CreditCardService {

	CreditCardDao creditCardDao;
	@Autowired
	public CreditCardManager(CreditCardDao creditCardDao) {
		super();
		this.creditCardDao = creditCardDao;
	}

	@Override
	public Result add(AddCreditCardRequest addCreditCardRequest) {
		CreditCard creditCard = new CreditCard();

		creditCard.setCardName(addCreditCardRequest.getCardName()); 
		creditCard.setCardNumber(addCreditCardRequest.getCardNumber());
		creditCard.setCvv(addCreditCardRequest.getCvv());
		creditCard.setLastDate(addCreditCardRequest.getLastDate());

		Customer customer = new Customer();
		customer.setId(addCreditCardRequest.getCustomerId());

		this.creditCardDao.save(creditCard);

		return new SuccessResult(Messages.ADD);
	}

	@Override
	public Result update(UpdateCreditCardRequest updateCreditCardRequest) {
		Customer customer = new Customer();
		customer.setId(updateCreditCardRequest.getCustomerId());

		CreditCard creditCard = this.creditCardDao.getById(updateCreditCardRequest.getId());
		creditCard.setCardName(updateCreditCardRequest.getCardName());
		creditCard.setCardNumber(updateCreditCardRequest.getCardNumber());
		creditCard.setCvv(updateCreditCardRequest.getCvv());
		creditCard.setLastDate(updateCreditCardRequest.getLastDate());
		
		
		creditCard.setCustomer(customer);

		this.creditCardDao.save(creditCard);

		return new SuccessResult(Messages.UPDATE);
	}

	@Override
	public Result delete(DeleteCreditCardRequest deleteCreditCardRequest) {
		CreditCard creditCard = new CreditCard();
		creditCard.setId(deleteCreditCardRequest.getId());

		this.creditCardDao.delete(creditCard);
		
		return new SuccessResult(Messages.DELETE);
	}

	@Override
	public DataResult<List<CreditCard>> getAll() {
		
		List<CreditCard>creditCards=this.creditCardDao.findAll();
		return new SuccessDataResult<List<CreditCard>>(creditCards,Messages.LIST);
	}

	@Override
	public DataResult<CreditCard> getById(int id) {
		return new SuccessDataResult<CreditCard>(this.creditCardDao.getById(id),Messages.LIST);
	}

	@Override
	public DataResult<List<CreditCard>> getCreditCardByCustomer_CustomerId(int customerId) {
		this.creditCardDao.getByCustomer_Id(customerId);
		return new SuccessDataResult<List<CreditCard>>(Messages.LIST);
		
	}

	
}
