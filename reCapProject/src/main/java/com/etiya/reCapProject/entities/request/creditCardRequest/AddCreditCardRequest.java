package com.etiya.reCapProject.entities.request.creditCardRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class AddCreditCardRequest {

private String cardName;
	

	private String cardNumber;
	
	private String expiration;
	
	private String cvc;
	
	private int customerId;
}
