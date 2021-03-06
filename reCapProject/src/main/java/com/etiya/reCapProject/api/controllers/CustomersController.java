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
import com.etiya.reCapProject.business.abstracts.CustomerService;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.abstracts.Customer;
import com.etiya.reCapProject.entities.request.AddCustomerRequest;
import com.etiya.reCapProject.entities.request.DeleteCustomerRequest;
import com.etiya.reCapProject.entities.request.UpdateCustomerRequest;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {
	
	private CustomerService customerService;
	
     @Autowired
	public CustomersController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
     
     @GetMapping("/getallcustomer")
     public DataResult<List<Customer>> getAll() {
         return this.customerService.getAll();

     }
     @PostMapping("/addcustomer")
     public Result add(@RequestBody  @Valid AddCustomerRequest addCustomerRequest) {
         return this.customerService.add(addCustomerRequest);
     }

     @PostMapping("/updatecustomer")
     public Result update(@RequestBody @Valid UpdateCustomerRequest updateCustomerRequest) {
         return this.customerService.update(updateCustomerRequest);
     }

     @DeleteMapping("/deletecustomer")
     public Result delete(@RequestBody @Valid DeleteCustomerRequest deleteCustomerRequest) {
         return this.customerService.delete(deleteCustomerRequest);
     }
    

}
