package com.etiya.reCapProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.etiya.reCapProject.business.abstracts.RentAlService;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concrates.RentAl;

@RestController
@RequestMapping("/api/rental")
public class RentAlsController {
	
	private RentAlService rentAlService;
    @Autowired
	public RentAlsController(RentAlService rentAlService) {
		super();
		this.rentAlService = rentAlService;
	}
	
	 @GetMapping("/getallrental")
     public DataResult<List<RentAl>> getAll() {
         return this.rentAlService.getAll();

     }
	 
	 
	 @GetMapping("/getbyıd")
	 public DataResult<RentAl> getById(int carId) {
		 return this.rentAlService.getById(carId);
	 }

     @PostMapping("/addrental")
     public Result add(@RequestBody RentAl rental) {
         return this.rentAlService.add(rental);
     }

     @PostMapping("/updaterental")
     public Result update(@RequestBody RentAl rental) {
         return this.rentAlService.update(rental);
     }

     @DeleteMapping("/deleterental")
     public Result delete(@RequestBody  RentAl rental) {
         return this.rentAlService.delete(rental);
     }
    

}
