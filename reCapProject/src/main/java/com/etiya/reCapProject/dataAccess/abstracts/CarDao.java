package com.etiya.reCapProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.etiya.reCapProject.entities.concrates.Car;
import com.etiya.reCapProject.entities.dtos.CarDetailDto;
@Repository
public interface CarDao extends JpaRepository<Car, Integer> {


	@Query("Select new com.etiya.reCapProject.entities.dtos.CarDetailDto"
			+ " (c.carName, b.brandName , cl.colorName, c.dailyPrice) " 
			+ " From Brand b Inner Join b.cars c"
			+ " Inner Join c.color cl")
	List<CarDetailDto> getCarWithDetails();
	
	List<Car> getByCity(String city);

	List<Car> getByBrand_brandId(int brandId);
	
	List<Car> getByColor_colorId(int colorId);
	
	
	@Query("From Car c Where c.isCarCare=true")
	List<Car> IsCarCareIsTrue();
	

	@Query("From Car c Where c.isCarCare=false")
	List<Car> IsCarCareIsFalse();
	
	

	
  
}
