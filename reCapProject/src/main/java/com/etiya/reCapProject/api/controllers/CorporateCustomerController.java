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

import com.etiya.reCapProject.business.abstracts.CorporateCustomerService;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concrates.CorporateCustomer;
import com.etiya.reCapProject.entities.request.CorporateCustomerRequest.AddCorporateCustomerRequest;
import com.etiya.reCapProject.entities.request.CorporateCustomerRequest.DeleteCorporateCustomerRequest;
import com.etiya.reCapProject.entities.request.CorporateCustomerRequest.UpdateCorporateCustomerRequest;

@RestController
@RequestMapping("corporatecustomercontrollers")
public class CorporateCustomerController {
	
	CorporateCustomerService corporateCustomerService;
    
	@Autowired
	public CorporateCustomerController(CorporateCustomerService corporateCustomerService) {
		super();
		this.corporateCustomerService = corporateCustomerService;
	}
	
	  @GetMapping("/getallcorporatecustomers")
	     public DataResult<List<CorporateCustomer>> getAll() {
	         return this.corporateCustomerService.getAll();

	     }
	     @PostMapping("/addcorporatecustomers")
	     public Result add(@RequestBody  @Valid AddCorporateCustomerRequest addCorporateCustomerRequest) {
	         return this.corporateCustomerService.add(addCorporateCustomerRequest);
	     }

	     @PostMapping("/updatecorporatecustomers")
	     public Result update(@RequestBody @Valid UpdateCorporateCustomerRequest updateCorporateCustomerRequest) {
	         return this.corporateCustomerService.update(updateCorporateCustomerRequest);
	     }

	     @DeleteMapping("/deletecorporatecustomers")
	     public Result delete(@RequestBody @Valid DeleteCorporateCustomerRequest deleteCorporateCustomerRequest) {
	         return this.corporateCustomerService.delete(deleteCorporateCustomerRequest);
	     }

}
