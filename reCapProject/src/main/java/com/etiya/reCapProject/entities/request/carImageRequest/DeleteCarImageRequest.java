package com.etiya.reCapProject.entities.request.carImageRequest;

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
public class DeleteCarImageRequest {

	@NotBlank
	@NotNull(message = "Boş Geçilemez!")
	private int id;
	
	
	@NotBlank
	@NotNull(message = "Boş Geçilemez!")
	private int carId;

}
