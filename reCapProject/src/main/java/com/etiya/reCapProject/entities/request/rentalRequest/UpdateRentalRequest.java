package com.etiya.reCapProject.entities.request.rentalRequest;

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
public class UpdateRentalRequest {
	
	@NotNull(message = "Boş Geçilemez!")
	private int rentAlId;

	@NotNull(message = "Boş Geçilemez!")	
	private int carId;
	
	@NotNull(message = "Boş Geçilemez!")
	private int customerId;
	
	private Date rentDate;
	
	private Date returnDate;
	
	private String takeCity;
	
	private String returnCity;
	
	private int startKilometer;
}
