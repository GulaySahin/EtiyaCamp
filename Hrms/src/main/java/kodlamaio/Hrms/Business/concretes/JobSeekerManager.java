package kodlamaio.Hrms.Business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.Business.abstractt.JobSeekerService;
import kodlamaio.Hrms.Core.MailValidatorService;
import kodlamaio.Hrms.Core.ValidatorService;
import kodlamaio.Hrms.Core.utilities.DataResult;
import kodlamaio.Hrms.Core.utilities.ErrorResult;
import kodlamaio.Hrms.Core.utilities.Result;
import kodlamaio.Hrms.Core.utilities.SuccessDataResult;
import kodlamaio.Hrms.Core.utilities.SuccessResult;
import kodlamaio.Hrms.DataAccess.abstractt.JobSeekersDao;
import kodlamaio.Hrms.Entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{
	
    private JobSeekersDao jobSeekerDao;
    private MailValidatorService mailValidatorService;
    private ValidatorService validatorService;
   
    @Autowired
	public JobSeekerManager(JobSeekersDao jobSeekerDao, MailValidatorService mailValidatorService,ValidatorService validatorService) {
		this.jobSeekerDao = jobSeekerDao;
		this.mailValidatorService = mailValidatorService;
		this.validatorService=validatorService;
	
	}

	@Override
	public DataResult<List<JobSeeker>> getJobSeekers() {
	
		return new SuccessDataResult<>(jobSeekerDao.findAll(),"iş arayanlar listelendi");
	}

	@Override
	public Result addJobSeeker(JobSeeker jobSeeker) {
		if(validatorService.isJobSeekerTrue(jobSeeker) && mailValidatorService.isMailTrue(jobSeeker.geteMail())) {
			jobSeekerDao.save(jobSeeker);
			return new SuccessResult("iş arayan eklendi");
		}
		else {
			return new ErrorResult("Kullanıcı doğrulanmadı");
		}
	
	}

}
