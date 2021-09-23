package com.etiya.reCapProject.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.etiya.reCapProject.business.abstracts.RentAlService;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concrates.RentAl;
import com.etiya.reCapProject.entities.request.rentalRequest.AddRentalRequest;
import com.etiya.reCapProject.entities.request.rentalRequest.UpdateRentalRequest;

@RestController
@RequestMapping("/api/rentals")
public class RentAlsController {
	
	private RentAlService rentAlService;
	
	@Autowired
	public RentAlsController(RentAlService rentAlService) {
		super();
		this.rentAlService = rentAlService;
	}
	
	@PostMapping("/addrentalforindividualcustomer")
	public Result addRentalForIndividualCustomer(@Valid @RequestBody AddRentalRequest addRentalRequest) {
		return this.rentAlService.addRentalForIndividualCustomer(addRentalRequest);
	}
	
	@PostMapping("/updaterentalforindividualcustomer")
	public Result updateRentalForIndividualCustomer(@Valid @RequestBody UpdateRentalRequest updateRentalRequest) {
		return this.rentAlService.updateRentalForIndividualCustomer(updateRentalRequest);
	}
	
	@PostMapping("/addrentalforcorporatecustomer")
	public Result addRentalForCorporateCustomer(@Valid @RequestBody AddRentalRequest addRentalRequest) {
		return this.rentAlService.addRentalForCorporateCustomer(addRentalRequest);
	}
	
	@PostMapping("/updaterentalforcopporatecustomer")
	public Result updateRentalForCorporateCustomer(@Valid @RequestBody UpdateRentalRequest updateRentalRequest) {
		return this.rentAlService.updateRentalForCorporateCustomer(updateRentalRequest);
	}
	
	@GetMapping("/getall")
	public DataResult<List<RentAl>> getAll() {
		return this.rentAlService.getAll();
	}
	
	

}
