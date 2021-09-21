package com.etiya.reCapProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.reCapProject.entities.concrates.CarImage;


public interface CarImageDao extends JpaRepository<CarImage, Integer>{

	
	int countByCar_carId(int carId);
	
	List<CarImage>getByCar_carId(int carId);
	
	boolean existsByCar_CarId(int carId);
}
