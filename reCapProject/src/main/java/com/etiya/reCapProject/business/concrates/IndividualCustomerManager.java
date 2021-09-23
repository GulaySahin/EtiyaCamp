package com.etiya.reCapProject.business.concrates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.reCapProject.business.abstracts.IndividualCustomerService;
import com.etiya.reCapProject.business.constants.Messages;
import com.etiya.reCapProject.core.utilities.business.BusinessRules;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.ErrorResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.CustomerDao;
import com.etiya.reCapProject.dataAccess.abstracts.IndividualCustomerDao;
import com.etiya.reCapProject.entities.concrates.IndividualCustomer;
import com.etiya.reCapProject.entities.request.individualCustomerRequest.AddIndividualCustomerRequest;
import com.etiya.reCapProject.entities.request.individualCustomerRequest.DeleteIndividualCustomerRequest;
import com.etiya.reCapProject.entities.request.individualCustomerRequest.UpdateIndividualCustomerRequest;

@Service
public class IndividualCustomerManager implements IndividualCustomerService {
	
	IndividualCustomerDao individualCustomerDao;
	CustomerDao customerDao;
	
    @Autowired
	public IndividualCustomerManager(IndividualCustomerDao individualCustomerDao , CustomerDao customerDao) {
		super();
		this.individualCustomerDao = individualCustomerDao;
		this.customerDao=customerDao;
	}

	@Override
	public DataResult<List<IndividualCustomer>> getAll() {
    List<IndividualCustomer>individualCustomers=this.individualCustomerDao.findAll();
    
    return new SuccessDataResult<>(individualCustomers,Messages.LIST);
	}

	@Override
	public Result add(AddIndividualCustomerRequest addIndividualCustomerRequest) {

		var result = BusinessRules.run(checkEmail(addIndividualCustomerRequest.getEMail()));
				
		if (result != null) {
			return result;
		}
		IndividualCustomer individualCustomer=new IndividualCustomer();
		individualCustomer.setFirstName(addIndividualCustomerRequest.getFirstName());
		individualCustomer.setLastName(addIndividualCustomerRequest.getLastName());
		individualCustomer.setIdentityNumber(addIndividualCustomerRequest.getIdentityNumber());
		individualCustomer.setEMail(addIndividualCustomerRequest.getEMail());
		individualCustomer.setPassword(addIndividualCustomerRequest.getPassword());
	
		
		this.individualCustomerDao.save(individualCustomer);
		return new SuccessResult(Messages.ADD);
	}

	@Override
	public Result delete(DeleteIndividualCustomerRequest deleteIndividualCustomerRequest) {
	
		IndividualCustomer individualCustomer=new IndividualCustomer();
		individualCustomer.setId(this.individualCustomerDao.getByIdentityNumber(deleteIndividualCustomerRequest.getIdentityNumber()).getId());
		this.individualCustomerDao.delete(individualCustomer);
		return new SuccessResult(Messages.DELETE);
		
	
	}

	@Override
	public Result update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {
		
		
		IndividualCustomer individualCustomer=new IndividualCustomer();
		individualCustomer.setId(updateIndividualCustomerRequest.getId());
		individualCustomer.setFirstName(updateIndividualCustomerRequest.getFirstName());
		individualCustomer.setLastName(updateIndividualCustomerRequest.getLastName());
		individualCustomer.setIdentityNumber(updateIndividualCustomerRequest.getIdentityNumber());
		individualCustomer.setEMail(updateIndividualCustomerRequest.getEMail());
		individualCustomer.setPassword(updateIndividualCustomerRequest.getPassword());
		
		this.individualCustomerDao.save(individualCustomer);
		return new SuccessResult(Messages.UPDATE);
	
		
		
	}
	private Result checkEmail(String eMail) {
		if(this.customerDao.existsCustomerByeMail(eMail)) {
			return new ErrorResult(Messages.EmailError);
		}
		return new SuccessResult();
	}

}
