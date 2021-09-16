package com.etiya.reCapProject.api.controllers;

import java.util.List;

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
import com.etiya.reCapProject.entities.concrates.Customer;

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
     public Result add(@RequestBody Customer customer) {
         return this.customerService.add(customer);
     }

     @PostMapping("/updatecustomer")
     public Result update(@RequestBody Customer customer) {
         return this.customerService.update(customer);
     }

     @DeleteMapping("/deletecustomer")
     public Result delete(@RequestBody  Customer customer) {
         return this.customerService.delete(customer);
     }
    

}
