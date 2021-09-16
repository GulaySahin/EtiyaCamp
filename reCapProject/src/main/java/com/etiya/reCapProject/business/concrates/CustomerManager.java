package com.etiya.reCapProject.business.concrates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.reCapProject.business.abstracts.CustomerService;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.CustomerDao;
import com.etiya.reCapProject.entities.concrates.Customer;

@Service
public class CustomerManager implements CustomerService {
	
	private CustomerDao customerDao;
 
	@Autowired
	public CustomerManager(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}

	@Override
	public DataResult<List<Customer>> getAll() {
		List<Customer>customers=this.customerDao.findAll();
		return new  SuccessDataResult<List<Customer>>(customers,"müşteriler listelendi");
	}

	@Override
	public Result add(Customer customer) {
		this.customerDao.save(customer);
	return new SuccessResult("müşteriler eklendi");
	}

	@Override
	public Result update(Customer customer) {
		this.customerDao.save(customer);
		return new SuccessResult("Müşteri güncdelllendi");
	}

	@Override
	public Result delete(Customer customer) {
		this.customerDao.delete(customer);
		return new SuccessResult("müşteri silindi");
	}

}
