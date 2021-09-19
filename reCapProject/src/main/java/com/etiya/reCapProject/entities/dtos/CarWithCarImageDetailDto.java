package com.etiya.reCapProject.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CarWithCarImageDetailDto {
	
	private int carId;
	
	private String brandName;
	
	private String colorName;
	
	private double dailyPrice;
	
	private String carImage;
	
	private int modelYear;
	
	
	


}
