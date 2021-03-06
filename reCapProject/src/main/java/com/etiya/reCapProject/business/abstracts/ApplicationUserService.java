package com.etiya.reCapProject.business.abstracts;

import java.util.List;

import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.entities.concrates.ApplicationUser;

public interface ApplicationUserService {
	
	DataResult<List<ApplicationUser>> getAll();

}
