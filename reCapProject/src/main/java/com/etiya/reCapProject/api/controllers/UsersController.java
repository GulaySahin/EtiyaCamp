package com.etiya.reCapProject.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.etiya.reCapProject.business.abstracts.ApplicationUserService;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concrates.ApplicationUser;
import com.etiya.reCapProject.entities.request.AddApplicationUserRequest;
import com.etiya.reCapProject.entities.request.DeleteApplicationUserRequest;
import com.etiya.reCapProject.entities.request.UpdateApplicationUserRequest;

@RestController
@RequestMapping("/api/applicationuser")
public class UsersController {
	
	private ApplicationUserService applicationUserService;

	@Autowired
	public UsersController(ApplicationUserService applicationUserService) {
		super();
		this.applicationUserService = applicationUserService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<ApplicationUser>> getAll() {
		return this.applicationUserService.getAll();
	}

	
	@PostMapping("/adduser")
	public Result add(@RequestBody @Valid  AddApplicationUserRequest addApplicationUserRequest) {
		return this.applicationUserService.add(addApplicationUserRequest);
	}
	
	@PostMapping("/updateuser")
	public Result update(@RequestBody @Valid  UpdateApplicationUserRequest updateApplicationUserRequest) {
		return this.applicationUserService.update(updateApplicationUserRequest);
	}
	
	@PostMapping("/deleteuser")
	public Result delete(@RequestBody @Valid DeleteApplicationUserRequest deleteApplicationUserRequest) {
		return this.applicationUserService.delete(deleteApplicationUserRequest);
	}

}
