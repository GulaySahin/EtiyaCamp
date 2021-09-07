package kodlamaio.Hrms.Business.abstractt;

import java.util.List;

import kodlamaio.Hrms.Core.utilities.DataResult;
import kodlamaio.Hrms.Core.utilities.Result;
import kodlamaio.Hrms.Entities.concretes.Employer;

public interface EmployerService {
	
	DataResult<List<Employer>>getEmployers();
	
	Result addEmployer(Employer employer);
	

}
