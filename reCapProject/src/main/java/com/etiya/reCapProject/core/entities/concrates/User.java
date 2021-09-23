package com.etiya.reCapProject.core.entities.concrates;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.sun.istack.NotNull;

import lombok.Data;


@Data
@MappedSuperclass
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="id")
	private int id;
	
	@NotNull
	@Column(name="e_mail")
	private String eMail;
	
	@NotNull
	@Column(name="password")
	private String password;
	
	
	
	
}
