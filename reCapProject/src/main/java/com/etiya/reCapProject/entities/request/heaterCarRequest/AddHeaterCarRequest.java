package com.etiya.reCapProject.entities.request.heaterCarRequest;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddHeaterCarRequest {

	@NotNull
	private int id;
	
	@NotNull
	private int carId;
	
	@NotNull
	private String carName;
	
	
}
