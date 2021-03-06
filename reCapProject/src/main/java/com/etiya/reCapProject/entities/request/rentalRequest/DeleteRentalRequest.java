package com.etiya.reCapProject.entities.request.rentalRequest;

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
public class DeleteRentalRequest {


	@NotBlank
	@NotNull(message = "Boş Geçilemez!")
	private int rentAlId;


	@NotNull(message = "Boş Geçilemez!")
	private int customerId;
	
	@NotBlank
	@NotNull(message = "Boş Geçilemez!")
	private int carId;
}
