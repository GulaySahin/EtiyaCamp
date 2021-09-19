package com.etiya.reCapProject.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.reCapProject.business.abstracts.CarImageService;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concrates.CarImage;
import com.etiya.reCapProject.entities.request.AddCarImageRequest;
import com.etiya.reCapProject.entities.request.UpdateCarImageRequest;

@RestController
@RequestMapping("/api/images")
public class CarImagesController {
	
private CarImageService carImageService;
	
	@Autowired
	public CarImagesController(CarImageService carImageService) {
		super();
		this.carImageService = carImageService;
	}
	
	
	@GetMapping("/getall")
	public DataResult<List<CarImage>> getAll() {
		return this.carImageService.getAll();
	}
	
	@GetMapping("/getbycarid")
	public DataResult<List<CarImage>> getByCar_CarId(int carId){
		return this.carImageService.getByCar_carId(carId);
	}
	@GetMapping("/getcarimagesbyid")
	public DataResult<CarImage> getById(int id) {
		return this.carImageService.getById(id);
	}
	
	@PostMapping("/addcarimages")
	public ResponseEntity<?> add(@Valid @RequestBody   AddCarImageRequest addCarImageRequest) {
		return ResponseEntity.ok(this.carImageService.add(addCarImageRequest));
	}
	
	@PostMapping("/updatecarimages")
	public ResponseEntity<?> update(@Valid @RequestBody   UpdateCarImageRequest updateCarImageRequest) {
		return ResponseEntity.ok(this.carImageService.update(updateCarImageRequest));
	}
	
	
	@DeleteMapping("/deletecarimages")
	public Result delete(int carImage) {
		return this.carImageService.delete(carImage);
	}
	

}