package com.etiya.reCapProject.entities.request.carRequest;

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
public class DeleteCarRequest {

	@NotBlank
	@NotNull(message = "Boş Geçilemez!")
	private int brandId;
	
	@NotBlank
	@NotNull(message = "Boş Geçilemez!")
	private int colorId;
	
	@NotBlank
	@NotNull(message = "Boş Geçilemez!")
	private int carId;
}
