package com.etiya.reCapProject.entities.abstracts;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.etiya.reCapProject.entities.concrates.ApplicationUser;
import com.etiya.reCapProject.entities.concrates.RentAl;
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
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" ,"rental"})
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customer_id")
	private int customerId;
	
	
	@Column(name="company_name")
	private String companyName;

	
	@OneToOne
	@JoinColumn(name="user_id")
	private ApplicationUser applicationUser;
	
	@JsonIgnore 
	@OneToMany(mappedBy = "customer")
	private List<RentAl> rental;
}
