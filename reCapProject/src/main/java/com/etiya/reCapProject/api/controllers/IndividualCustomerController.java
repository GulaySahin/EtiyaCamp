package com.etiya.reCapProject.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.reCapProject.business.abstracts.IndividualCustomerService;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concrates.IndividualCustomer;
import com.etiya.reCapProject.entities.request.individualCustomerRequest.AddIndividualCustomerRequest;
import com.etiya.reCapProject.entities.request.individualCustomerRequest.DeleteIndividualCustomerRequest;
import com.etiya.reCapProject.entities.request.individualCustomerRequest.UpdateIndividualCustomerRequest;

@RestController
@RequestMapping("/individualcustomercontrollers")
public class IndividualCustomerController {
	
	IndividualCustomerService individualCustomerService;

	public IndividualCustomerController(IndividualCustomerService individualCustomerService) {
		super();
		this.individualCustomerService = individualCustomerService;
	}
	
	 @GetMapping("/getallindividualcustomers")
     public DataResult<List<IndividualCustomer>> getAll() {
         return this.individualCustomerService.getAll();

     }
     @PostMapping("/addindividualcustomers")
     public Result add(@RequestBody  @Valid AddIndividualCustomerRequest addIndividualCustomerRequest ) {
         return this.individualCustomerService.add(addIndividualCustomerRequest);
     }

     @PostMapping("/updateindividualcustomers")
     public Result update(@RequestBody @Valid UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {
         return this.individualCustomerService.update(updateIndividualCustomerRequest);
     }

     @DeleteMapping("/deleteindividualcustomers")
     public Result delete(@RequestBody @Valid DeleteIndividualCustomerRequest deleteIndividualCustomerRequest) {
         return this.individualCustomerService.delete(deleteIndividualCustomerRequest);
     }


}
