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


import com.etiya.reCapProject.business.abstracts.CarService;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concrates.Car;
import com.etiya.reCapProject.entities.dtos.CarDetailDto;
import com.etiya.reCapProject.entities.dtos.CarWithCarImageDetailDto;
import com.etiya.reCapProject.entities.request.carRequest.AddCarRequest;
import com.etiya.reCapProject.entities.request.carRequest.DeleteCarRequest;
import com.etiya.reCapProject.entities.request.carRequest.UpdateCarRequest;

@RestController
@RequestMapping("/api/cars")
public class CarsController {
	
private CarService carService;
	
	@Autowired
	public CarsController(CarService carService) {
		super();
		this.carService = carService;
	}
	@GetMapping("/getcarıd")
    public DataResult<Car>getById(int carId) {
        return this.carService.getById(carId);

    }

    @GetMapping("/getallcar")
    public DataResult<List<Car>> getAll() {
        return this.carService.getAll();

    }

    @GetMapping("/getcarwithdetail")
    public DataResult<List<CarDetailDto>> getCarWithBrandAndColorDetail() {
        return this.carService.getCarWithBrandAndColorDetails();
    }


    @PostMapping("/addcar")
    public Result add(@RequestBody  @Valid   AddCarRequest addCarRequest) {
        return this.carService.add(addCarRequest);
    }

    @PostMapping("/updatecar")
    public Result update(@RequestBody @Valid     UpdateCarRequest updateCarRequest) {
        return this.carService.update(updateCarRequest);
    }

    @DeleteMapping("/deletecar")
    public Result delete(@RequestBody @Valid DeleteCarRequest deleteCarRequest) {
        return this.carService.delete(deleteCarRequest);
    }
    
    @GetMapping("/getbybrand")
    public DataResult<List<Car>> getByBrand_brandId(int brandId)  {
    	return this.carService.getByBrand_brandId(brandId);
    }
   @GetMapping("/getbycolor")
  public DataResult<List<Car>> getByColor_colorId(int colorId) {
	   return this.carService.getByColor_colorId(colorId);
   }
	@GetMapping("/getcarwithcarimagedetaildto")
   public DataResult<List<CarWithCarImageDetailDto>> getCarWithCarImageDetails(int carId) {
	return this.getCarWithCarImageDetails(carId);
}
}