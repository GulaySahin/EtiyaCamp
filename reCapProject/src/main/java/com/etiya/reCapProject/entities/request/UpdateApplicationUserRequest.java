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

public class UpdateApplicationUserRequest {
	@NotBlank
	@NotNull
    private String firstName;
	@NotBlank
	@NotNull
	private String lastName;
	@NotBlank
	@NotNull
	@Email
	private String eMail;
	@NotBlank
	@NotNull
	private String password;
	

}
