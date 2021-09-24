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

public class DeleteHeaterCarRequest {

	@NotNull
	private int id;
	
	private int carId;
	
}
