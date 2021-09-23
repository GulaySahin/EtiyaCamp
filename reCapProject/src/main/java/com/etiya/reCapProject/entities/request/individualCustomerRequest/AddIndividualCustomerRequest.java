package com.etiya.reCapProject.entities.request.individualCustomerRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddIndividualCustomerRequest {
	
	private String firstName;
	
	private String lastName;
	
	private String identityNumber;
	
	private String eMail;
	
	private String password;

}
