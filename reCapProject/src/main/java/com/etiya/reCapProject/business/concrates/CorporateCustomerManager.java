package com.etiya.reCapProject.business.concrates;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etiya.reCapProject.business.abstracts.CorporateCustomerService;
import com.etiya.reCapProject.business.constants.Messages;
import com.etiya.reCapProject.core.utilities.business.BusinessRules;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.ErrorResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.CorporateCustomerDao;
import com.etiya.reCapProject.dataAccess.abstracts.CustomerDao;
import com.etiya.reCapProject.entities.concrates.CorporateCustomer;
import com.etiya.reCapProject.entities.request.CorporateCustomerRequest.AddCorporateCustomerRequest;
import com.etiya.reCapProject.entities.request.CorporateCustomerRequest.DeleteCorporateCustomerRequest;
import com.etiya.reCapProject.entities.request.CorporateCustomerRequest.UpdateCorporateCustomerRequest;


@Service
public class CorporateCustomerManager implements CorporateCustomerService {
	
	private CorporateCustomerDao corporateCustomerDao;
	private CustomerDao customerDao;
	
	@Autowired
	public CorporateCustomerManager(CorporateCustomerDao corporateCustomerDao,CustomerDao customerDao) {
		super();
		this.corporateCustomerDao=corporateCustomerDao;
		this.customerDao = customerDao;
	}

	@Override
	public Result add(AddCorporateCustomerRequest addCorporateCustomerRequest) {
		
		var result = BusinessRules.run(checkEmail(addCorporateCustomerRequest.getEMail()));
				
		if (result != null) {
			return result;
		}
		
		
		CorporateCustomer corporateCustomer= new CorporateCustomer();
		corporateCustomer.setCompanyName(addCorporateCustomerRequest.getCompanyName());
		corporateCustomer.setTaxNumber(addCorporateCustomerRequest.getTaxNumber());
		corporateCustomer.setEMail(addCorporateCustomerRequest.getEMail());
		corporateCustomer.setPassword(addCorporateCustomerRequest.getPassword());
		
		this.corporateCustomerDao.save(corporateCustomer);
		return new SuccessResult(Messages.ADD);
	}

	@Override
	public Result update(UpdateCorporateCustomerRequest updateCorporateCustomerRequest) {
		
		CorporateCustomer corporateCustomer= this.corporateCustomerDao.getByTaxNumber
				(updateCorporateCustomerRequest.getTaxNumber());
		corporateCustomer.setId(updateCorporateCustomerRequest.getId());
		corporateCustomer.setCompanyName(updateCorporateCustomerRequest.getCompanyName());
		corporateCustomer.setTaxNumber(updateCorporateCustomerRequest.getTaxNumber());
		corporateCustomer.setEMail(updateCorporateCustomerRequest.getEMail());
		corporateCustomer.setPassword(updateCorporateCustomerRequest.getPassword());
		
		this.corporateCustomerDao.save(corporateCustomer);
		return new SuccessResult(Messages.UPDATE);
		
	}

	@Override
	public Result delete(DeleteCorporateCustomerRequest deleteCorporateCustomerRequest) {
		CorporateCustomer corporateCustomer= new CorporateCustomer();
		
		corporateCustomer.setId(this.corporateCustomerDao.getByTaxNumber(deleteCorporateCustomerRequest.getTaxNumber()).getId());
		this.corporateCustomerDao.deleteById(corporateCustomer.getId());
		return new SuccessResult(Messages.DELETE);
	}

	@Override
	public DataResult<List<CorporateCustomer>> getAll() {
		return new SuccessDataResult<List<CorporateCustomer>>(this.corporateCustomerDao.findAll(),Messages.LIST);
	}
	
	
	private Result checkEmail(String eMail) {
		if(this.customerDao.existsCustomerByeMail(eMail)) {
			return new ErrorResult(Messages.EmailError);
		}
		return new SuccessResult();
	}
}