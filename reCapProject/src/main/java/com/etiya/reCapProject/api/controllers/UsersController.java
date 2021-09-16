package com.etiya.reCapProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.reCapProject.business.abstracts.UserService;
import com.etiya.reCapProject.core.entities.concrates.User;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;

@RestController
@RequestMapping("/api/user")
public class UsersController {
	
	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<User>> getAll() {
		return this.userService.getAll();
	}

	
	@PostMapping("/adduser")
	public Result add(@RequestBody User user) {
		return this.userService.add(user);
	}
	
	@PostMapping("/updateuser")
	public Result update(@RequestBody User user) {
		return this.userService.update(user);
	}
	
	@PostMapping("/deleteuser")
	public Result delete(@RequestBody User user) {
		return this.userService.delete(user);
	}

}
