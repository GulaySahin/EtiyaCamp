package com.etiya.reCapProject.entities.request.rentalRequest;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateRentalRequest {
	
	private int id;
	
	@NotNull
	private String rentDate;
	
	@NotNull
    private String returnDate;
	
	@NotNull
    private int carId;
	
	@NotNull
    private int customerId;

}
