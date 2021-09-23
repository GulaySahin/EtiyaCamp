package com.etiya.reCapProject.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.reCapProject.business.abstracts.LoginService;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.dtos.UserLoginDto;

@RestController
@RequestMapping("/logincontroller")
public class LoginsController {
	
	LoginService loginService;

	public LoginsController(LoginService loginService) {
		super();
		this.loginService = loginService;
	}
    @GetMapping("/login")
	public Result logIn(UserLoginDto userLoginDto) {
    	return this.loginService.logIn(userLoginDto);
    	
    }
}
