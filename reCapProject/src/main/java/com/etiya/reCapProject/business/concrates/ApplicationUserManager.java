package com.etiya.reCapProject.business.concrates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etiya.reCapProject.business.abstracts.ApplicationUserService;
import com.etiya.reCapProject.business.constants.Messages;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.dataAccess.abstracts.ApplicationUserDao;
import com.etiya.reCapProject.entities.concrates.ApplicationUser;


@Service
public class ApplicationUserManager implements ApplicationUserService {

	ApplicationUserDao applicationUserDao;
	
	@Autowired
	public ApplicationUserManager(ApplicationUserDao applicationUserDao) {
		super();
		this.applicationUserDao = applicationUserDao;
	}


	@Override
	public DataResult<List<ApplicationUser>> getAll() {
		
	List<ApplicationUser>applicationUsers=this.applicationUserDao.findAll();
	
	return new SuccessDataResult<>(applicationUsers,Messages.LIST);
		
	}

}