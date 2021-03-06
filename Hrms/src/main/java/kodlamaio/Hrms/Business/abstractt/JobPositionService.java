package kodlamaio.Hrms.Business.abstractt;

import java.util.List;

import kodlamaio.Hrms.Core.utilities.DataResult;
import kodlamaio.Hrms.Core.utilities.Result;
import kodlamaio.Hrms.Entities.concretes.JobPosition;
import kodlamaio.Hrms.Entities.concretes.JobSeeker;

public interface JobPositionService {
	
	  DataResult<List<JobPosition>>getJobPosition();
   
	   Result addJobPosition(JobPosition jobPosition);
}
