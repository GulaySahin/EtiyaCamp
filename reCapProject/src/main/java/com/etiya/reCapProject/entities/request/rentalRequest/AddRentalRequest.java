package com.etiya.reCapProject.entities.request.rentalRequest;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Validated
public class AddRentalRequest {
	
	private Date rentDate;

	private Date returnDate;
	
	@NotNull(message = "Boş Geçilemez!")
	private int carId;
	
	@NotNull(message = "Boş Geçilemez!")
	private String takeCity;
	
	@NotNull(message = "Boş Geçilemez!")
	private String returnCity;
	
	private int startKilometer;

	
	@NotNull(message = "Boş Geçilemez!")
	private int customerId;
	
}
