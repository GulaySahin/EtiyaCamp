package com.etiya.reCapProject.entities.request.carRequest;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateCarRequest {
	
	private int carId;
	
	@NotNull(message = "Boş Geçilemez!")
	@NotBlank
	private int brandId;
	
	
	@NotNull(message = "Boş Geçilemez!")
	@NotBlank
	private int colorId;
	
	@Min(0)
	@Max(1900)
	@NotNull
	private int findexPoint;

	
	private String carName;

	private int modelYear;

	private double dailyPrice;
	
	private String description;
}
