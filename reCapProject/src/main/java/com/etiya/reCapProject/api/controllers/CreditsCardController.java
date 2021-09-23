package com.etiya.reCapProject.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.reCapProject.business.abstracts.CreditCardService;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concrates.CreditCard;
import com.etiya.reCapProject.entities.request.creditCardRequest.AddCreditCardRequest;
import com.etiya.reCapProject.entities.request.creditCardRequest.DeleteCreditCardRequest;
import com.etiya.reCapProject.entities.request.creditCardRequest.UpdateCreditCardRequest;

@RestController
@RequestMapping("/api/creditcardscontroller")
public class CreditsCardController {
	
	private CreditCardService creditCardService;

    @Autowired
	public CreditsCardController(CreditCardService creditCardService) {
		super();
		this.creditCardService = creditCardService;
	}


    @GetMapping("/getall")
	public DataResult<List<CreditCard>> getAll() {
		return this.creditCardService.getAll();
	}
	
	@GetMapping("/getcreditcardbyıd")
	public DataResult<CreditCard> getById(int id) {
		return this.creditCardService.getById(id);
	}
	
	@PostMapping("/addcreditcard")
	public Result add(@Valid @RequestBody  AddCreditCardRequest addCreditCardRequest) {
		return this.creditCardService.add(addCreditCardRequest);
	}
	
	@PostMapping("/updatecreditcard")
	public Result update( @Valid @RequestBody UpdateCreditCardRequest updateCreditCardRequest) {
		return this.creditCardService.update(updateCreditCardRequest);
	}
	
	@DeleteMapping("/deletecreditcard")
	public Result delete(DeleteCreditCardRequest deleteCreditCardRequest) {
		return this.creditCardService.delete(deleteCreditCardRequest);
	}
	
	@GetMapping("/getcreditcardbycustomerıd")
	public DataResult<List<CreditCard>> getCreditCardByCustomers_CustomerId(int customerId) {
		return this.creditCardService.getCreditCardByCustomer_CustomerId(customerId);
	}


}
