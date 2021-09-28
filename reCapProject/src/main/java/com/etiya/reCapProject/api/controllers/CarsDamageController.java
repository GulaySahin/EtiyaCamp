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

import com.etiya.reCapProject.business.abstracts.CarDamageService;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concrates.CarDamage;
import com.etiya.reCapProject.entities.request.carDamageRequest.AddCarDamageRequest;
import com.etiya.reCapProject.entities.request.carDamageRequest.DeleteCarDamageRequest;
import com.etiya.reCapProject.entities.request.carDamageRequest.UpdateCarDamageRequest;

@RestController
@RequestMapping("/api/carsdamage")
public class CarsDamageController {

	private CarDamageService carDamageService;
    @Autowired
	public CarsDamageController(CarDamageService carDamageService) {
		super();
		this.carDamageService = carDamageService;
	}
    
    @GetMapping("/getall")
    public DataResult<List<CarDamage>> getAll() {
        return this.carDamageService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid AddCarDamageRequest addCarDamageRequest) {

        return this.carDamageService.add(addCarDamageRequest);

    }

    @PostMapping("/update")
    public Result update(@RequestBody @Valid UpdateCarDamageRequest updateCarDamageRequest) {
        return this.carDamageService.update(updateCarDamageRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(@Valid DeleteCarDamageRequest deleteCarDamageRequest) {
        return this.carDamageService.delete(deleteCarDamageRequest);
    }
}
