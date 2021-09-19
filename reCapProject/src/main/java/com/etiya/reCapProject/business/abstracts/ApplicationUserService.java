package com.etiya.reCapProject.business.abstracts;

import java.util.List;

import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concrates.ApplicationUser;
import com.etiya.reCapProject.entities.request.AddApplicationUserRequest;
import com.etiya.reCapProject.entities.request.UpdateApplicationUserRequest;

public interface ApplicationUserService {
	
	DataResult<List<ApplicationUser>>getAll();
	
	Result add(AddApplicationUserRequest addApplicationUserRequest);
	
	Result update(UpdateApplicationUserRequest updateApplicationUserRequest);
	
	Result delete(int id);

}
