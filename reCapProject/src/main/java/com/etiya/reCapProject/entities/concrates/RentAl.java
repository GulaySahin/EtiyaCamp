package com.etiya.reCapProject.entities.concrates;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.etiya.reCapProject.entities.abstracts.Customer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="rentals")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class RentAl {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="rental_id")
	private int rentalId;
	
	@Column(name="rent_date")
	private Date rentDate;
	
	@Column(name="return_date")
	private Date returnDate;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="car_id")
	private Car car;
	
	
}
