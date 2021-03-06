package kodlamaio.Hrms.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.Business.abstractt.JobPositionService;
import kodlamaio.Hrms.Core.utilities.DataResult;
import kodlamaio.Hrms.Core.utilities.Result;
import kodlamaio.Hrms.Entities.concretes.Employer;
import kodlamaio.Hrms.Entities.concretes.JobPosition;
import kodlamaio.Hrms.Entities.concretes.JobSeeker;


@RestController
@RequestMapping("/api/jobposition")
public class JobPositionController {
	
	private JobPositionService jobPositionService;

	@Autowired
	public JobPositionController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}
	
	@GetMapping("/getjobPositions")
	public DataResult<List<JobPosition>>getJobPositions() {
		
		return jobPositionService.getJobPosition();
		
	}
	@PostMapping("/addjobPosition")
	public Result add(@RequestBody JobPosition jobPosition) {
		return jobPositionService.addJobPosition(jobPosition);
	}
	


}
