package com.etiya.reCapProject.entities.request.carDamageRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeleteCarDamageRequest {

	private int damageId;
	
	private int carId;
}
