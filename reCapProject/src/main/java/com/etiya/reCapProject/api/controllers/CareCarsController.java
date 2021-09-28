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

import com.etiya.reCapProject.business.abstracts.CareCarService;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concrates.CareCar;
import com.etiya.reCapProject.entities.request.careCarRequest.AddCareCarRequest;
import com.etiya.reCapProject.entities.request.careCarRequest.DeleteCareCarRequest;
import com.etiya.reCapProject.entities.request.careCarRequest.UpdateCareCarRequest;

@RestController
@RequestMapping("/api/carecarscontroller")
public class CareCarsController {
	
	private CareCarService careCarService;

    @Autowired
    public CareCarsController(CareCarService careCarService) {
        super();
        this.careCarService = careCarService;
    }

    @GetMapping("/getall")
    public DataResult<List<CareCar>> getAll() {
        return this.careCarService.getAll();
    }

    @PostMapping("/careadd")
    public Result add(@Valid @RequestBody AddCareCarRequest addCareCarRequest) {
        return this.careCarService.add(addCareCarRequest);
    }

    @PostMapping("/careupdate")
    public Result update(UpdateCareCarRequest updateCareCarRequest) {
        return this.careCarService.update(updateCareCarRequest);
    }

    @DeleteMapping("/caredelete")
    public Result delete(DeleteCareCarRequest deleteCareCarRequest) { 
        return this.careCarService.delete(deleteCareCarRequest);
    }

}
