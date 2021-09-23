package com.etiya.reCapProject.entities.request.CorporateCustomerRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class UpdateCorporateCustomerRequest {
	
	private int id;
	
    private String taxNumber;
	
	private String companyName;
	
	
	private String eMail;
	
	private String password;
	
}
