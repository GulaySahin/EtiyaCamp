package com.etiya.reCapProject.entities.request;

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

	@NotNull
	@NotBlank
	private String carName;
	@NotNull
	@NotBlank
	private int modelYear;
	@NotNull
	@NotBlank
	private double dailyPrice;
	@NotNull
	@NotBlank
	private String description;
	@NotNull
	@NotBlank
    private int colorId;
	@NotNull
	@NotBlank
	private int brandId;
}
