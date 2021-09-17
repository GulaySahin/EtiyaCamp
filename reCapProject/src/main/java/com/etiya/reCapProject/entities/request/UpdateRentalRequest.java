package com.etiya.reCapProject.entities.request;

import java.util.Date;

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
public class UpdateRentalRequest {
	@NotNull
	@NotBlank
	private Date rentDate;
	@NotNull
	@NotBlank
    private Date returnDate;
	@NotNull
	@NotBlank
    private int carId;
	@NotNull
	@NotBlank
    private int customerId;

}
