package com.etiya.reCapProject.business.concrates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.reCapProject.business.abstracts.CustomerService;
import com.etiya.reCapProject.business.constants.Messages;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.CustomerDao;
import com.etiya.reCapProject.entities.abstracts.Customer;
import com.etiya.reCapProject.entities.concrates.ApplicationUser;
import com.etiya.reCapProject.entities.request.AddCustomerRequest;
import com.etiya.reCapProject.entities.request.UpdateCustomerRequest;

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
		List<Customer> customers = this.customerDao.findAll();
		return new SuccessDataResult<List<Customer>>(customers, Messages.List);
	}

	@Override
	public Result add(AddCustomerRequest addCustomerRequest) {
		Customer customer = new Customer();
		customer.setCompanyName(addCustomerRequest.getCompanyName());

		ApplicationUser applicationUser = new ApplicationUser();
		applicationUser.setId(addCustomerRequest.getId());

		customer.setApplicationUser(applicationUser);
		this.customerDao.save(customer);
		return new SuccessResult(Messages.Add);
	}

	@Override
	public Result update(UpdateCustomerRequest updateCustomerRequest) {
		Customer customer = new Customer();
		customer.setCompanyName(updateCustomerRequest.getCompanyName());

		ApplicationUser applicationUser = new ApplicationUser();
		applicationUser.setId(updateCustomerRequest.getId());
		customer.setApplicationUser(applicationUser);

		this.customerDao.save(customer);
		return new SuccessResult(Messages.Update);
	}

	@Override
	public Result delete(int customerId) {
		
		this.customerDao.deleteById(customerId);
		return new SuccessResult(Messages.Delete);
	}

}
