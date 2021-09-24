package com.etiya.reCapProject.entities.concrates;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="invoice")
public class Invoice {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="invoice_number")
	private int invoiceNumber;
	
	@Column(name="creation_date")
	private String creationDate;
	
	@Column(name="rental_date")
	private String rentalDate;
	
	@Column(name="rental_date_number")
	private int rentalDateNumber;
	
	@Column(name="rentalPrice")
	private int rentalPrice;
	

	
}
