package com.etiya.reCapProject.business.abstracts;

import java.util.List;

import com.etiya.reCapProject.core.entities.concrates.User;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;

public interface UserService {
	
	DataResult<List<User>>getAll();
	
	Result add(User user);
	
	Result update(User user);
	
	Result delete(User user);

}
