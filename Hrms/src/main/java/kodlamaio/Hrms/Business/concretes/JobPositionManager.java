package kodlamaio.Hrms.Business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.Business.abstractt.JobPositionService;
import kodlamaio.Hrms.Core.utilities.DataResult;
import kodlamaio.Hrms.Core.utilities.Result;
import kodlamaio.Hrms.Core.utilities.SuccessDataResult;
import kodlamaio.Hrms.DataAccess.abstractt.JobPositionDao;
import kodlamaio.Hrms.Entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {
    
	JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}


	@Override
	public Result addJobPosition(JobPosition jobPosition) {
		jobPositionDao.save(jobPosition);
		return new SuccessDataResult("iş pozisyonu eklendi");
	}


	@Override
	public DataResult<List<JobPosition>>getJobPosition() {
		return new SuccessDataResult<>(jobPositionDao.findAll(),"listelendi");
	}





}
