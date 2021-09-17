package com.etiya.reCapProject.business.concrates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.reCapProject.business.abstracts.ApplicationUserService;
import com.etiya.reCapProject.business.constants.Messages;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.ApplicationUserDao;
import com.etiya.reCapProject.entities.concrates.ApplicationUser;
import com.etiya.reCapProject.entities.request.AddApplicationUserRequest;
import com.etiya.reCapProject.entities.request.DeleteApplicationUserRequest;
import com.etiya.reCapProject.entities.request.UpdateApplicationUserRequest;

@Service
public class ApplicationUserManager implements ApplicationUserService {
private ApplicationUserDao userDao;
	@Autowired
	public ApplicationUserManager(ApplicationUserDao userDao) {
	super();
	this.userDao = userDao;
}

	@Override
	public DataResult<List<ApplicationUser>> getAll() {
		List<ApplicationUser>applicationUser=this.userDao.findAll();
		return new SuccessDataResult<>(applicationUser,Messages.List);
	}

	@Override
	public Result add(AddApplicationUserRequest addApplicationUserRequest) {
		ApplicationUser applicationUser=new ApplicationUser();
		applicationUser.setFirstName(addApplicationUserRequest.getFirstName());
		applicationUser.setLastName(addApplicationUserRequest.getLastName());
		applicationUser.setEMail(addApplicationUserRequest.getEMail());
		applicationUser.setPassword(addApplicationUserRequest.getPassword());
		this.userDao.save(applicationUser);
		return new SuccessResult(Messages.Add);
	}

	@Override
	public Result update(UpdateApplicationUserRequest updateApplicationUserRequest) {
		ApplicationUser applicationUser=new ApplicationUser();
		applicationUser.setFirstName(updateApplicationUserRequest.getFirstName());
		applicationUser.setLastName(updateApplicationUserRequest.getLastName());
		applicationUser.setEMail(updateApplicationUserRequest.getEMail());
		applicationUser.setPassword(updateApplicationUserRequest.getPassword());
		
		this.userDao.save(applicationUser);
		return new SuccessResult(Messages.Update);
	}

	@Override
	public Result delete(DeleteApplicationUserRequest deleteApplicationUserRequest) {
		ApplicationUser applicationUser=new ApplicationUser();
		
		applicationUser.setFirstName(deleteApplicationUserRequest.getFirstName());
		applicationUser.setLastName(deleteApplicationUserRequest.getLastName());
		applicationUser.setEMail(deleteApplicationUserRequest.getEMail());
		applicationUser.setPassword(deleteApplicationUserRequest.getPassword());
		applicationUser.setFirstName(deleteApplicationUserRequest.getFirstName());
		this.userDao.delete(applicationUser);
		return new SuccessResult(Messages.Delete);
	}

}
