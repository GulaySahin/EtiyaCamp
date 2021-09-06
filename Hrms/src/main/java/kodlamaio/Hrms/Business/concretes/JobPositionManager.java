package kodlamaio.Hrms.Business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.Business.abstractt.JobPositionService;
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
	public List<JobPosition> getAll() {
		// TODO Auto-generated method stub
		return this.jobPositionDao.findAll();
	}

}
