package com.etiya.reCapProject.entities.concrates;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.etiya.reCapProject.core.entities.concrates.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="customers")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" ,"rentals"})
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customer_id")
	private int customerId;
	
	
	@Column(name="company_name")
	private String companyName;

	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User users;
	
	@JsonIgnore 
	@OneToOne(mappedBy = "customer")
	private RentAl rental;
}
