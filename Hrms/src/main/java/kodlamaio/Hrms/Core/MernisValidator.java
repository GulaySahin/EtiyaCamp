package kodlamaio.Hrms.Core;

import kodlamaio.Hrms.Entities.concretes.JobSeeker;

public class MernisValidator implements ValidatorService {

	@Override
	public boolean isJobSeekerTrue(JobSeeker jobSeeker) {
		
		return true;
	}

}
