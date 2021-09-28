package com.etiya.reCapProject.entities.request.careCarRequest;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateCareCarRequest {


	@NotNull
	private int careCarId;

	
	private String location;
	
	@NotNull
	private String startDate;
	
	@NotNull
	private String finishDate;
	
	
	@NotNull
	private int carId;
	
}
