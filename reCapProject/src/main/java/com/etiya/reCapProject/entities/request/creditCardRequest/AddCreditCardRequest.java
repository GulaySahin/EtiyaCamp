package com.etiya.reCapProject.entities.request.creditCardRequest;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class AddCreditCardRequest {

	private int id;
	@NotNull
	private String cardName;
	@NotNull
	private String cardNumber;
	@NotNull
	@Size(min = 1 , max =3)
	private String cvv;
	@NotNull
	private String lastDate;
	@NotNull
	private int customerId;
}
