package com.etiya.reCapProject.entities.request;


import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddCarImageRequest {

	@NotNull(message="boş geçilemez")
	private int carId;
}
