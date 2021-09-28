package com.etiya.reCapProject.entities.request.carDamageRequest;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddCarDamageRequest {
	
	@NotNull(message = "Boş Geçilemez!")
	private int damageId;
	
	private String damageInfo;
	
	@NotNull(message = "Boş Geçilemez!")
	private int carId;
	
}
