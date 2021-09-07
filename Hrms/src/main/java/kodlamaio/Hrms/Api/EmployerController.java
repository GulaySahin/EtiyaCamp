package kodlamaio.Hrms.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.Business.abstractt.EmployerService;
import kodlamaio.Hrms.Business.abstractt.JobPositionService;
import kodlamaio.Hrms.Core.utilities.DataResult;
import kodlamaio.Hrms.Core.utilities.Result;
import kodlamaio.Hrms.Entities.concretes.Employer;
import kodlamaio.Hrms.Entities.concretes.JobPosition;

@RestController 
@RequestMapping("api/employers")
public class EmployerController {

	 private EmployerService employerService;

	
		@GetMapping("/getemployers")
		public DataResult<List<Employer>>getEmployers() {
			
			return employerService.getEmployers();
			
		}
		@PostMapping("/addemployer")
		public Result add(@RequestBody Employer employer) {
			return employerService.addEmployer(employer);
		}
	 
}
