package com.etiya.reCapProject.entities.request;


import javax.validation.constraints.Email;
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
public class DeleteApplicationUserRequest {

	
private String firstName;
	@NotNull
	@NotBlank
	private String lastName;
	@NotNull
	@NotBlank
	@Email
	private String eMail;
	@NotNull
	@NotBlank
	private String password;
	

}
