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
public class UpdateCarImageRequest {
	

	@NotNull(message = "Boş Geçilemez!")
	private int id;
	
	
	@NotNull(message = "Boş Geçilemez!")
	private int carId;
	
	@NotNull
	MultipartFile file;

}
