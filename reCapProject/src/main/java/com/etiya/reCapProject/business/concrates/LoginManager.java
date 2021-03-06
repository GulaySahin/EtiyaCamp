package com.etiya.reCapProject.business.concrates;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etiya.reCapProject.business.abstracts.LoginService;
import com.etiya.reCapProject.business.constants.Messages;
import com.etiya.reCapProject.core.utilities.business.BusinessRules;
import com.etiya.reCapProject.core.utilities.results.ErrorResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.ApplicationUserDao;
import com.etiya.reCapProject.entities.dtos.UserLoginDto;

@Service
public class LoginManager implements LoginService {
	
	ApplicationUserDao applicationUserDao;
	
    @Autowired
	public LoginManager(ApplicationUserDao applicationUserDao) {
		super();
		this.applicationUserDao = applicationUserDao;
	}

	@Override
	public Result logIn(UserLoginDto userLoginDto) {
		var result = BusinessRules.run(checkEmailAndPassword(userLoginDto));

        if (result != null) {
            return result;
        }

        return new SuccessResult(Messages.ADD);
    }


    	  private Result checkEmailAndPassword(UserLoginDto userLoginDto) {
    	        if(!this.applicationUserDao.existsByeMail(userLoginDto.getEMail())) {
    	            return new ErrorResult(Messages.EmailError);
    	        }

    	        if (!this.applicationUserDao.getByeMail(userLoginDto.getEMail()).getPassword().equals(userLoginDto.getPassword())) {
    	                return new ErrorResult(Messages.PASSWORDERROR);
    	        }

    	        return new SuccessResult();
    	    }
         

}
