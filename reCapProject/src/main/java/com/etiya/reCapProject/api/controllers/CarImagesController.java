package com.etiya.reCapProject.api.controllers;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.etiya.reCapProject.business.abstracts.CarImageService;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concrates.CarImage;
import com.etiya.reCapProject.entities.request.carImageRequest.AddCarImageRequest;
import com.etiya.reCapProject.entities.request.carImageRequest.DeleteCarImageRequest;
import com.etiya.reCapProject.entities.request.carImageRequest.UpdateCarImageRequest;

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
		return this.carImageService.getCarImageByCarId(carId);
	}

	@PostMapping("/addcarimages")
    public Result  add(@RequestParam("carId")   int carId, MultipartFile file) throws IOException {
        AddCarImageRequest addCarImageRequest= new AddCarImageRequest();
        addCarImageRequest.setCarId(carId);
        addCarImageRequest.setFile(file);
        return this.carImageService.add(addCarImageRequest);
    }
	
	@PostMapping("/updatecarimages")
	public Result update(@Valid UpdateCarImageRequest carImage, MultipartFile file) throws IOException {
		carImage.setFile(file);
		return this.carImageService.update(carImage);
	}
	
	
	@DeleteMapping("/deletecarimages")
	public Result delete(@Valid @RequestBody DeleteCarImageRequest deleteCarImageRequest) {
		return this.carImageService.delete(deleteCarImageRequest);
	}
	

}