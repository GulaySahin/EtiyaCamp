package com.etiya.reCapProject.entities.request.carDamageRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateCarDamageRequest {
	
    private int damageId;
	
	private String damageInfo;
	
	private int carId;
	

}
