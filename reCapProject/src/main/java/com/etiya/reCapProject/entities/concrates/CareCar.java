package com.etiya.reCapProject.entities.concrates;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
@Entity
@Table(name="care_cars")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class CareCar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="care_car_id")
	private int careCarId;
	
	@Column(name="location")
	private String location;
	
	@Column(name="start_date")
	private String startDate;
	
	@Column(name="finish_date")
	private String finishDate;
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id")
	private Car car;
   
	
	

}
