package com.etiya.reCapProject.entities.concrates;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="car_damages")
public class CarDamage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="damage_id")
	private int damageId;
	
	@Column(name="damage_info")
	private String damageInfo;
	

	@ManyToOne
	@JoinColumn(name="id")
	private Car car;
}
