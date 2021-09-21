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
	List<CarDetailDto> getCarWithBrandAndColorDetails();
	

	boolean existsByCarImageIsNullAndCarId(int carId);
	
	boolean existsByCarImageIsNull();
	
	List<Car> getByBrand_brandId(int brandId);

    List<Car> getByColor_colorId(int colorId);
    
    
	/*
	 * @Query("Select new com.etiya.reCapProject.entities.dtos.CarWithCarImageDetailDto"
	 * +
	 * " (c.carId,b.brandName ,cl.colorName, c.dailyPrice, ci.carImage , c.modelYear)"
	 * + "From Car c Inner Join c.brand b Inner Join c.color cl" +
	 * "Inner Join c.carImage ci Where c.carId=:carId ")
	 * 
	 * 
	 * List<CarWithCarImageDetailDto>getCarWithCarImageDetails();
	 */
    
	  
}
