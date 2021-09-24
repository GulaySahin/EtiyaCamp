package com.etiya.reCapProject.entities.concrates;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
@Entity
@Table(name="heater_cars")
public class HeaterCar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="care_id")
	private int careId;
	
	@JsonIgnore
	@OneToMany(mappedBy="heaterCar")
	private List <Car> cars;

	
	@OneToMany(mappedBy = "heaterCar")
	private List <RentAl> rentals;

}
