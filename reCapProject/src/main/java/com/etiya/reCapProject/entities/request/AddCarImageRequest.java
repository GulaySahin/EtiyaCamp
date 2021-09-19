package com.etiya.reCapProject.entities.request;



import java.util.Date;

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

	@NotNull
	private String imagePath;
	
   
    private Date date;
   
    @NotNull
    private int carId;
}