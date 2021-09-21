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
import com.etiya.reCapProject.entities.dtos.UserLoginDto;
import com.etiya.reCapProject.entities.dtos.UserRegisterDto;
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
		return new SuccessDataResult<>(applicationUser,Messages.LIST);
	}

	@Override
	public Result add(AddApplicationUserRequest addApplicationUserRequest) {
		ApplicationUser applicationUser=new ApplicationUser();
		applicationUser.setFirstName(addApplicationUserRequest.getFirstName());
		applicationUser.setLastName(addApplicationUserRequest.getLastName());
		applicationUser.setEMail(addApplicationUserRequest.getEMail());
		applicationUser.setPassword(addApplicationUserRequest.getPassword());
		this.userDao.save(applicationUser);
		return new SuccessResult(Messages.ADD);
	}

	@Override
	public Result update(UpdateApplicationUserRequest updateApplicationUserRequest) {
		ApplicationUser applicationUser=new ApplicationUser();
		applicationUser.setFirstName(updateApplicationUserRequest.getFirstName());
		applicationUser.setLastName(updateApplicationUserRequest.getLastName());
		applicationUser.setEMail(updateApplicationUserRequest.getEMail());
		applicationUser.setPassword(updateApplicationUserRequest.getPassword());
		
		this.userDao.save(applicationUser);
		return new SuccessResult(Messages.UPDATE);
	}

	
	@Override
	public Result delete(DeleteApplicationUserRequest deleteApplicationUserRequest) {
	ApplicationUser applicationUser=new ApplicationUser();
	applicationUser.setId(deleteApplicationUserRequest.getId());
	
		this.userDao.delete(applicationUser);
		return new SuccessResult(Messages.DELETE);
	}

	@Override
	public Result userLogin(UserLoginDto userLoginDto) {
	ApplicationUser applicationUser=new ApplicationUser();
	applicationUser.setEMail(userLoginDto.getEMail());
	applicationUser.setPassword(userLoginDto.getPassword());
			
		this.userDao.save(applicationUser);

		return new SuccessResult(Messages.USERLOGIN);
	}

	@Override
	public Result userRegister(UserRegisterDto userRegisterDto) {
		ApplicationUser applicationUser=new ApplicationUser();
		applicationUser.setFirstName(userRegisterDto.getFirstName());
		applicationUser.setLastName(userRegisterDto.getLastName());
		applicationUser.setEMail(userRegisterDto.getEMail());
		applicationUser.setPassword(userRegisterDto.getPassword());
		
		this.userDao.save(applicationUser);
		return new SuccessResult(Messages.ADD);
	}

}
