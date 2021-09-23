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
public class AddRentalRequest {
	@NotNull
	@NotBlank
	private String rentDate;
	@NotNull
	@NotBlank
    private String returnDate;
	@NotNull
	@NotBlank
    private int carId;
	
	@NotNull(message = "Boş Geçilemez!")
	@NotBlank
	private String carName;
	
	@NotNull(message = "Boş Geçilemez!")
	private int customerId;
	
	@NotNull(message = "Boş Geçilemez!")
	private boolean saveCreditCard;
	
	
}
