package kodlamaio.Hrms.Business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.Business.abstractt.EmployerService;
import kodlamaio.Hrms.Core.MailValidatorService;
import kodlamaio.Hrms.Core.utilities.DataResult;
import kodlamaio.Hrms.Core.utilities.ErrorResult;
import kodlamaio.Hrms.Core.utilities.Result;
import kodlamaio.Hrms.Core.utilities.SuccessDataResult;
import kodlamaio.Hrms.Core.utilities.SuccessResult;
import kodlamaio.Hrms.DataAccess.abstractt.EmployerDao;
import kodlamaio.Hrms.Entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {
	
	private EmployerDao employerDao;
	private MailValidatorService mailValidatorService;
	
	
     @Autowired
	public EmployerManager(EmployerDao employerDao, MailValidatorService mailValidatorService) {
		super();
		this.employerDao = employerDao;
		this.mailValidatorService = mailValidatorService;
	}

	@Override
	public DataResult<List<Employer>> getEmployers() {
		
		return new SuccessDataResult<>(employerDao.findAll(),"İşverenler");
	}

	@Override
	public Result addEmployer(Employer employer) {
    if(mailValidatorService.isMailTrue(employer.eMail)) {
    	   employerDao.save(employer);
    	   return new SuccessResult("işveren eklendi");
    	   
       }
       else {
    	   return new ErrorResult("Mail doğrulanmadı");
       }
		
	}

}
