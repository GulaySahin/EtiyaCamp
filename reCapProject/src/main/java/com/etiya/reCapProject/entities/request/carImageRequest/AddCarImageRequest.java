package com.etiya.reCapProject.entities.request.carImageRequest;


import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

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
	
	 
	MultipartFile file;
	
}
